# Own contributions and license policy

Date: 2026-09-07 (translated into English on 2026-10-11)
Comparison base: `ae49483ce31fc030ac20a96c37f34aaef2f78957`
Project: Ethic Keyboard (`jpi59`)

## Attribution rule

This repository is a derivative work. The comparison with the base commit identifies which changes jpi59 made, but it
does not turn inherited code into jpi59's code. The notices of AOSP, Simple Keyboard and other contributors still apply
to the derived files.

## Files and material created mainly by jpi59

These items are documentation, automation or configuration of the project and do not replace the license of the
inherited code:

- `.github/workflows/ci.yml` — continuous integration and privacy check.
- `scripts/verificar-privacidad.sh` — reproducible check of the manifest and the APK.
- `PRIVACY_JPI59.md` — the product's privacy policy.
- `AUDITORIA-LICENCIAS-ETHIC-KEYBOARD.md` — audit report.
- `CONTRIBUCIONES-JPI59.md` — this inventory.
- `RELEASE.md` and `scripts/firmar-release.sh` — preparation of reproducible signing without secrets.
- `NOTICE.md` — provenance and attribution documentation, with inherited content identified.
- Own changes to `README.md`, `metadata/` and build configuration.

License adopted for jpi59's original content within the combined work: **GNU GPL version 3 or any later version**.
Inherited code keeps Apache 2.0 and its notices; `LICENSE-APACHE-2.0` is included separately.

## Derived or mixed files

### Java code

The files under `app/src/main/java/org/jpi59/teclado/` are renamed and adapted from
`app/src/main/java/rkr/simplekeyboard/inputmethod/`. Git records the renames with a similarity of roughly 71–99 %. They
are mixed files: they contain inherited code plus namespace, identity or adaptation changes. They must keep Apache 2.0
and their original notices; jpi59's new contributions are identified in the commits and are not split out as if they
were independent works.

### XML resources

The resources under `app/src/main/res/` keep their AOSP/upstream provenance. jpi59's changes include the visual
identity, texts, app name, documentation links and the `Transparency` section of the settings. XML files modified
directly by jpi59 carry an additional notice where appropriate.

### Configuration and distribution

`app/build.gradle`, `app/proguard-rules.pro`, `gradlew`, `gradlew.bat`, `gradle/wrapper/` and `gradle.properties`
contain build or reproducibility changes. They are tools and configuration; they are not a relicensing of the app's
code. The wrapper must keep the conditions of its upstream distribution.

### Images and icons

`icons/icon.svg`, `icons/ic_launcher-playstore.png` and the adaptation of the Android vectors are graphic resources
created or adapted by jpi59. Inherited screenshots and the promotional asset without a confirmed individual record were
removed from the tree; the public repository uses a clean history that does not contain them.

## Own changes by commit

These commits belong to the private development history from which the clean public history was prepared; their
hashes are not present in the public repository.

| Commit | Contribution | Classification |
|---|---|---|
| `ed9f55b2` | namespace/package adaptation, configuration, documentation and policies | mixed: derived + jpi59 |
| `984ef684` | reproducible wrapper, CI and privacy check | mainly jpi59 / configuration |
| `852b3613` | Ethic Keyboard brand and texts in resources and metadata | mixed: modified inherited resources |
| `558351c1` | Transparency section and privacy/license summaries | jpi59 on inherited XML |
| `e4ed405f` | links to the `master` branch | jpi59 on an inherited resource |
| `a70f676d` | audit, copyright notices and documentation | mainly jpi59 |

## How it must be published

1. Distribute `LICENSE` and `NOTICE.md` with the code and with the APK where applicable.
2. Do not remove copyright notices or attributions from inherited files.
3. State jpi59's changes without claiming exclusive authorship of AOSP or Simple Keyboard.
4. Apply GPLv3-or-later to the combined work without removing or replacing the Apache notices of inherited files.
5. Record every new graphic resource before a public release.

This inventory is technical documentation of authorship and provenance; it is not professional legal advice.
