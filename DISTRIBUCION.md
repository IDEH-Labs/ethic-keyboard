# Distribution record — Ethic Keyboard

Status: **production APK published on GitHub; accepted into F-Droid's metadata on October 9, 2026, waiting for
F-Droid to build and publish it**.

## Identity

- Name: Ethic Keyboard
- Android package: `org.jpi59.teclado`
- Published version: `6.6.6` (`versionCode 154`)
- License of the combined work: GNU GPL version 3 or any later version; the inherited Apache 2.0 notices are kept.
- Built-in privacy policy: `PRIVACY_JPI59.md`, reachable from the app's settings.

## What has been checked

- The code declares no network permission and no advertising or telemetry dependency.
- The manifest declares only `VIBRATE` as a normal permission.
- Automatic backup and system backup requests are turned off.
- The release build produces an unsigned artifact that stays local until it is signed.
- The direct `6.6.6` APK was aligned, signed and verified with `apksigner`. Its SHA-256 checksum and the SHA-256
  fingerprint of its certificate are in the
  [public release](https://github.com/IDEH-Labs/ethic-keyboard/releases/tag/v6.6.6).
- The production APK was installed and checked on a device before it was published.
- The privacy and license scripts pass.
- The current tree does not contain the screenshots or the promotional asset of uncertain license.

## Status by channel

- **Codeberg:** source code, tags, and releases synchronized under [IDEH-Labs/ethic-keyboard](https://codeberg.org/IDEH-Labs/ethic-keyboard).
- **GitHub:** the tagged code, the signed APK and its checksum are published at [GitHub Releases](https://github.com/IDEH-Labs/ethic-keyboard/releases).
- **F-Droid:** the recipe was accepted (merge request !48454, October 9, 2026). The app appears in the catalog once
  F-Droid builds and publishes it.
- **Google Play:** not published, and availability must not be claimed. Using that channel requires an AAB, Play App
  Signing with the existing key, and verified store listing, rating and Data safety declarations.

## Compatibility between channels

The direct APK is signed with the owner's key. The F-Droid recipe uses reproducible builds (`Binaries` and
`AllowedAPKSigningKeys`): F-Droid builds the source, checks that the result matches the published APK and distributes
the APK signed by the developer. F-Droid and direct installations can therefore update each other. Google Play must
use the existing signing key through Play App Signing to keep that compatibility.

## Verification commands

```bash
./gradlew :app:assembleRelease --no-daemon
./scripts/verificar-licencias.sh
./scripts/verificar-privacidad.sh app/build/outputs/apk/release/app-release-unsigned.apk
export KEYSTORE_PATH="/private/path/ethic-keyboard-release.jks"
export KEY_ALIAS="ethic-keyboard"
export STORE_PASSWORD='...'
export KEY_PASSWORD='...'
./scripts/firmar-release.sh
```

An unsigned APK must not be published, and passwords, keystores or private paths must never be committed to Git.
