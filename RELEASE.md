# Preparing a release

Without credentials, the release build produces these artifacts:

```text
app/build/outputs/apk/release/app-release-unsigned.apk
app/build/outputs/bundle/release/app-release.aab
```

The private key must be created, backed up and kept by the project owner; it must never enter Git,
`local.properties` or a persistent variable of the repository.

## Local signing

Set the variables only in the local session, **before building** (load your Android SDK environment first):

```bash
export KEYSTORE_PATH="/private/path/ethic-keyboard-release.jks"
export KEY_ALIAS="ethic-keyboard"
export STORE_PASSWORD='keystore-password'
export KEY_PASSWORD='key-password'
./gradlew :app:assembleRelease :app:bundleRelease --no-daemon
./scripts/firmar-release.sh
```

With the four variables set, Gradle signs the APK and the AAB with the same key; `scripts/firmar-release.sh` finds
that APK and verifies its signature. If the APK was built without credentials and the unsigned artifact exists, the
script aligns, signs and verifies it. Passwords are never written to files of the repository or to CI logs.

Google Play requires the AAB and Play App Signing. When registering an app already distributed as
`org.jpi59.teclado`, the existing signing key must be enrolled so that updates stay compatible with the installed APK.

Before publishing, record the SHA-256 fingerprint of the certificate privately, test installing and updating on a
device, and keep a backup of the keystore. Losing the key makes it impossible to update the app under the same
package.
