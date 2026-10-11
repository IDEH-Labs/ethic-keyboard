# License and provenance audit — Ethic Keyboard

Review date: 2026-09-07 (translated into English and its status updated on 2026-10-11)
Scope: the Git tree, the current commit and the build configuration.

## Executive summary

**Result: GNU GPL version 3 or later adopted for the combined work.** The code base allows distribution under GPLv3 or
later because Apache 2.0 material is compatible with GPLv3, as long as its notices are kept.

The technical provenance of the current resources was compared with the declared upstream commit and recorded in
`PROCEDENCIA-RECURSOS.md`. The visual contributions attributed to jpi59 remain a statement by the maintainer; this
audit does not provide external proof of authorship and does not replace a legal review.

## Verified facts

- The repository contains the full GPLv3 text in `LICENSE` and the Apache License 2.0 in `LICENSE-APACHE-2.0`.
- `NOTICE.md` identifies the base project `rkkr/simple-keyboard`, the audited base commit and the AOSP LatinIME
  heritage.
- The Java files and most inherited resources carry Apache 2.0 notices and copyrights of AOSP and/or contributors to the
  base project.
- The project declares no runtime dependencies in `app/build.gradle`.
- The Android Gradle plugin and Gradle are build tools; they are not packaged as app dependencies.
- The manifest declares only `android.permission.VIBRATE`; it declares no Internet permission.
- The identified own changes are the brand, namespace/package, texts, transparency settings and documentation.
- `local.properties` is excluded by `.gitignore` and is not part of the distribution.
- jpi59 copyright notices were added to the two XML resources modified during this audit.

## Provenance and obligations

### AOSP / Simple Keyboard code

Every copyright and license notice of the derived files must be kept, together with a copy of Apache 2.0 and the
notices in `NOTICE.md`. Modified files must state that they were changed. Upstream references:

- https://github.com/rkkr/simple-keyboard
- https://github.com/rkkr/simple-keyboard/blob/master/LICENSE
- https://source.android.com/docs/setup/contribute/licenses

### jpi59's changes

jpi59's original modifications are licensed under GPLv3 or later within the combined work. This does not make the
inherited code a work whose copyright belongs exclusively to jpi59; the existing attributions must remain.

### Binary and graphic resources

`icons/icon.svg`, `icons/ic_launcher-playstore.png` and the adaptation of the Android vectors are visual contributions
by jpi59, documented in `NOTICE.md`. Inherited screenshots and the promotional asset without a confirmed individual
license were removed from the tree, and the public repository uses a clean distribution history that does not contain
them.

Some XML vectors have no visible license header. The byte-for-byte comparison against the upstream commit documented in
`PROCEDENCIA-RECURSOS.md` confirms their technical provenance when they do not differ; the ones that differ are listed
as derived works or declared contributions. The comparison must be repeated whenever new resources are added.

## Relicensing compatibility

- Apache 2.0 is a free license and allows modification, distribution and commercial use, subject to its notices and
  conditions.
- Apache 2.0 is compatible with GPLv3 as stated by the ASF and the FSF; that does not allow removing Apache notices or
  unilaterally changing third parties' copyright.
- jpi59's original contributions are licensed under GPLv3 or later; inherited files keep their Apache notices.
- Licensing the whole repository under the AGPLv3 is not recommended: the keyboard is a local app, not a network
  service, and the AGPL brings no proportional advantage here.
- It is neither ethical nor legally correct to present `LICENSE` as if all the code were jpi59's.

References:

- https://www.apache.org/licenses/GPL-compatibility
- https://www.gnu.org/licenses/license-compatibility.en.html
- https://www.gnu.org/licenses/license-list.en.html

## Ongoing obligations

1. Keep binary resources of uncertain license out of the public history.
2. Repeat the comparison of resources against upstream and update `PROCEDENCIA-RECURSOS.md` with every change.
3. Document or remove any future resource whose license, source or contribution cannot be verified.
4. Keep the combined work under the GNU GPL version 3 or later, preserving all Apache 2.0 notices and conditions of
   the code inherited from AOSP and Simple Keyboard.
5. Check that the public repository contains no personal data, tokens, keys or private paths.
6. Keep the privacy policy at a URL reachable without signing in.

## Release status (October 11, 2026)

Version 6.6.6 is published on GitHub as a signed APK with its checksum, and F-Droid accepted its recipe on October 9,
2026. This document is a technical audit of provenance and compatibility, not professional legal advice.

## Conclusion

**License of the combined work: GNU GPL version 3 or later.**
**License kept for inherited code: Apache License 2.0, with its notices (`NOTICE.md`).**
**AGPLv3: not recommended for this local app.**
