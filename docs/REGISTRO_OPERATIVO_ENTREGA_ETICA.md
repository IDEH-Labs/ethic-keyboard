# Operational record of ethical delivery

Last updated: 2026-09-10 (translated into English on 2026-10-11; the content describes the 6.6.3 delivery)

This document keeps verified facts, decisions and limits of the Ethic Keyboard delivery process. It stores no
passwords, tokens, private keys, credential paths or device identifiers.

## Delivery 6.6.3

- Version: `6.6.3` (`versionCode 151`).
- Hardening commit: `3d96fda75f9d747e65a4e4cf0470343984edc440`.
- Published references: branch `fdroid-hardening` and annotated tag `v6.6.3`.
- The main branch was not modified during this delivery.
- The F-Droid recipe lives in a separate `fdroiddata` contribution: `metadata/org.jpi59.teclado.yml`.
- Inclusion request: https://gitlab.com/fdroid/fdroiddata/-/merge_requests/48454 (accepted on October 9, 2026, with
  version 6.6.6).

## Verified controls

- The resulting manifest requests only `android.permission.VIBRATE`.
- No Internet permission was declared, and cleartext HTTP traffic was disabled with
  `android:usesCleartextTraffic="false"`.
- The release excludes version-control and dependency metadata that the APK does not need.
- The release build, `lintVitalRelease`, the license and privacy checks, and F-Droid's branch and MR pipelines passed.
- At that point F-Droid had built the version from the published recipe; that alone was not a certification of
  byte-for-byte reproducibility against an external APK signed by the developer. The recipe later added `Binaries` and
  `AllowedAPKSigningKeys` for reproducible builds.
- The local update was signed with the existing distribution key. Android accepted it as an update of the previous
  installation, confirming signature compatibility. The device reported version `6.6.3` / code `151` and kept its
  first-install date.

## Publishing and signing rules

1. Never store passwords, tokens or private keys in the repository, documentation, command output or messages.
2. Ask for the password in a local dialog with hidden input; keep it only in the memory of the build process.
3. Always use the distribution key already associated with the package. Never create a new key to update an existing
   installation.
4. Check that exactly one expected alias exists before signing.
5. Use a process that stops at the first error (`set -e`).
6. Build from clean, with the SDK path declared explicitly.
7. Before installing, check the expected `versionCode` and `versionName` inside the APK and verify the signature with
   `apksigner`.
8. Update with `adb install -r` only after those checks; never uninstall to force an incompatible signature, because it
   would delete data.
9. After installing, check the version, first-install date and permissions on the device itself.

## Lesson learned

In a first installation attempt, a build failed because the SDK path was not declared, and an earlier signed APK was
left available. Android kept the previous version; no data was deleted. Since then the procedure requires a clean
build, an immediate stop on errors and a check of the version inside the APK before any installation.

## F-Droid flow for future versions

1. Create a release tag pointing to the exact commit of the code.
2. Keep the Fastlane metadata in `metadata/<locale>/` of the source: short description, full description and changes per
   `versionCode`.
3. Update the `fdroiddata` recipe in a dedicated branch, pinning the commit, version, code, Gradle output and tag-based
   updates.
4. Fix first the failures checked by CI; do not hide or attribute to a bot causes that are not in its logs.
5. Open the MR only when the pipelines are green. Do not enable auto-merge or publish binaries outside the authorized
   channels.
6. Distinguish automatic validation from the maintainers' decision: inclusion and publication depend on F-Droid.

## Next review

Before each release, review this document, the current policies of the distribution channels and the effective
permissions of the APK. Record here only verifiable evidence and process changes that reduce risk.
