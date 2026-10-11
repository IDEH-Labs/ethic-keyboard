# Privacy policy — Ethic Keyboard

Last updated: October 11, 2026 (translated into English; the practices are unchanged since September 12, 2026)
Applies to: Ethic Keyboard 6.6.6 (`org.jpi59.teclado`)

## Controller and contact

The controller for this version is **jpi59** (IDEH Labs), the maintainer identified in the public Ethic Keyboard
repository. For questions, issues or requests about privacy, use the
[public issue tracker](https://github.com/IDEH-Labs/ethic-keyboard/issues).

## Data the keyboard processes

An Android keyboard receives the text, the selection and the information about the active field that Android and the
receiving app give it so that the person can type. In version 6.6.6, Ethic Keyboard processes that data in memory
during the input session and passes it to the app where the user is typing. It does not store, profile, sell, share
or transmit that text to servers of jpi59 or of third parties.

When the user taps the paste action, the keyboard can read the text in the system clipboard to insert it where the
user asked. It does not create a persistent copy of the clipboard and does not transmit it.

## Local preferences and retention

The app keeps, in the device's private storage, the preferences it needs to work, such as active languages or
layouts, theme, size and vibration options. They are not designed to contain the text that is typed. They remain until
the user changes them, clears the app's data from Android's Settings or uninstalls the app.

The app turns off its cloud backups with `android:allowBackup="false"` and does not request backups. Some
manufacturers may keep device-to-device transfers as part of the system migration; that feature depends on the
operating system and is not a service of Ethic Keyboard.

## Network, sharing and permissions

Ethic Keyboard declares no Internet permission and includes no ads, analytics, telemetry, trackers or network
services. Therefore it does not collect or share data outside the device through the app.

The only normal permission declared is `VIBRATE`, used for haptic feedback and configurable by the user.
`BIND_INPUT_METHOD` is the permission Android requires of a keyboard service; it does not grant Internet access.

The app offers no accounts, profiles or synchronization of its own. There are no accounts or account data to delete
on servers of Ethic Keyboard.

## Security and your controls

The source code is available for public review. You can stop using the keyboard, turn it off in the input method
settings or clear its data in Android's Settings. Clearing the data deletes the local preferences and restores the
keyboard's initial settings.

## Changes to this policy

If a future version changes these practices, this policy will be updated before that version is distributed, stating
the date and the change. The URL of this policy remains reachable from the app's settings and must match the
statements of any store where the app is distributed.
