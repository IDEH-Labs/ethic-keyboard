# Provenance of resources — Ethic Keyboard

Check date: September 8, 2026 (translated into English on October 11, 2026)

## Method and scope

Every file under `app/src/main/res/` and `icons/` was compared byte for byte with commit
`ae49483ce31fc030ac20a96c37f34aaef2f78957` of [`rkkr/simple-keyboard`](https://github.com/rkkr/simple-keyboard),
identified in `NOTICE.md` as the base. Files not listed below matched that commit. This check establishes technical
provenance relative to upstream; it does not replace an independent legal review of the new contributions.

## Resources that differ from the base

| Paths | Nature and provenance | License / notice kept |
|---|---|---|
| `icons/icon.svg`, `icons/ic_launcher-playstore.png` | Visual contributions declared by jpi59 in `NOTICE.md`. | GPL-3.0-or-later for the declared contribution. |
| `drawable/ic_launcher.xml`, `drawable-v26/ic_launcher_foreground.xml`, `drawable-v26/ic_launcher_monochrome.xml` | Adaptation of the launcher icon on existing Android resources. | Apache-2.0 of the base; combined contribution under GPL-3.0-or-later. |
| `layout/input_view.xml`, `layout-v28/input_view.xml`, `layout/more_keys_keyboard.xml` | Interface resources derived from Simple Keyboard. | Apache-2.0; keep the upstream notices. |
| `values/attrs.xml`, `values/colors.xml`, `values/icons.xml`, `values/strings.xml`, `values/strings-appname.xml` | Derived configuration, brand and texts. | Apache-2.0 for inherited material; GPL-3.0-or-later for original changes. |
| `values-af`, `values-ar`, `values-b+sr+Latn`, `values-be-rBY`, `values-bg`, `values-bn-rBD`, `values-ca`, `values-cs`, `values-de`, `values-el`, `values-es`, `values-eu-rES`, `values-fa`, `values-fi`, `values-fr`, `values-gl-rES`, `values-hr`, `values-in`, `values-it`, `values-lt`, `values-mk-rMK`, `values-nb`, `values-nl`, `values-pl`, `values-pt`, `values-ro`, `values-ru`, `values-sk`, `values-sr`, `values-tr`, `values-uk`, `values-vi`, `values-zh-rCN`, `values-zh-rTW` (`strings.xml`) | Translations or app texts modified from the upstream resources. | Apache-2.0 for inherited text; GPL-3.0-or-later for original changes. |
| `xml/method.xml`, `xml/prefs.xml`, `xml/prefs_screen_appearance.xml`, `xml/prefs_screen_key_press.xml` | Input method declaration and derived preference screens. | Apache-2.0; keep the upstream notices. |

## Limits and maintenance

No screenshots, videos or promotional material of undocumented provenance are included. Before adding a new binary or
graphic resource, record here its file, author or source, license, date of consultation and the changes made. If its
license cannot be verified, it must not enter the public distribution or an F-Droid submission.
