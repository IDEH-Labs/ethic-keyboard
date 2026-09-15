#!/usr/bin/env bash
# SPDX-License-Identifier: GPL-3.0-or-later
# Copyright (C) 2026 jpi59

set -euo pipefail

repo_root="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")/.." && pwd)"
sdk_root="${ANDROID_SDK_ROOT:-${ANDROID_HOME:-}}"
build_tools="${BUILD_TOOLS_VERSION:-}"
unsigned_apk="${UNSIGNED_APK:-$repo_root/app/build/outputs/apk/release/app-release-unsigned.apk}"
output_apk="${SIGNED_APK:-$repo_root/app/build/outputs/apk/release/app-release.apk}"

[[ -n "$sdk_root" ]] || { printf 'ERROR: define ANDROID_SDK_ROOT o ANDROID_HOME.\n' >&2; exit 2; }

if [[ -z "$build_tools" ]]; then
  build_tools="$(find "$sdk_root/build-tools" -mindepth 1 -maxdepth 1 -type d -printf '%f\n' | sort -V | tail -1)"
fi
zipalign="$sdk_root/build-tools/$build_tools/zipalign"
apksigner="$sdk_root/build-tools/$build_tools/apksigner"
[[ -x "$zipalign" && -x "$apksigner" ]] || { printf 'ERROR: faltan zipalign/apksigner en Build Tools %s.\n' "$build_tools" >&2; exit 1; }

if [[ -f "$output_apk" && ( ! -f "$unsigned_apk" || "$output_apk" -nt "$unsigned_apk" ) ]]; then
  "$apksigner" verify --verbose "$output_apk" >/dev/null
  printf 'OK: APK release ya firmado y verificado: %s\n' "$output_apk"
  exit 0
fi

[[ -f "$unsigned_apk" ]] || {
  printf 'ERROR: no existe un APK release para firmar o verificar.\n' >&2
  exit 1
}

required_vars=(KEYSTORE_PATH KEY_ALIAS STORE_PASSWORD KEY_PASSWORD)
for variable in "${required_vars[@]}"; do
  [[ -n "${!variable:-}" ]] || {
    printf 'ERROR: define la variable secreta %s solo en tu entorno local.\n' "$variable" >&2
    exit 2
  }
done
[[ -f "$KEYSTORE_PATH" ]] || { printf 'ERROR: no existe el keystore indicado.\n' >&2; exit 1; }

temp_aligned="$(mktemp --suffix=.aligned.apk)"
trap 'rm -f "$temp_aligned"' EXIT
mkdir -p "$(dirname -- "$output_apk")"
"$zipalign" -f -p 4 "$unsigned_apk" "$temp_aligned"
STORE_PASSWORD="$STORE_PASSWORD" KEY_PASSWORD="$KEY_PASSWORD" "$apksigner" sign \
  --ks "$KEYSTORE_PATH" \
  --ks-key-alias "$KEY_ALIAS" \
  --ks-pass env:STORE_PASSWORD \
  --key-pass env:KEY_PASSWORD \
  --out "$output_apk" "$temp_aligned"
"$apksigner" verify --verbose "$output_apk" >/dev/null
printf 'OK: APK release firmado y verificado: %s\n' "$output_apk"
