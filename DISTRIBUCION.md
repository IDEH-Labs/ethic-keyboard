# Ficha final de distribución — Ethic Keyboard

Estado: **APK directa de producción publicada; F-Droid pendiente de revisión**.

## Identidad

- Nombre: Ethic Keyboard
- Paquete Android: `org.jpi59.teclado`
- Versión directa publicada: `6.6.6` (`versionCode 154`)
- Licencia del conjunto: GNU GPLv3 o posterior; se conservan los avisos Apache 2.0 heredados.
- Política de privacidad integrada: `PRIVACY_JPI59.md`, accesible desde los ajustes de la aplicación.

## Qué se ha comprobado

- El código no declara permisos de red ni dependencias de anuncios o telemetría.
- El manifiesto declara únicamente `VIBRATE` como permiso normal.
- El respaldo automático y las solicitudes de copia de seguridad del sistema están desactivados.
- La compilación release produce el artefacto sin firmar que se conserva solo
  localmente antes de la firma.
- La APK directa `6.6.6` fue alineada, firmada y verificada con `apksigner`.
  Su checksum SHA-256 y la huella SHA-256 del certificado aparecen en el
  [release público](https://github.com/jpi59/ethic-keyboard/releases/tag/v6.6.6).
- La APK de producción se instaló y verificó en un dispositivo antes de su
  publicación.
- Los scripts de privacidad y licencias pasan en este entorno.
- El árbol actual no contiene las capturas ni el recurso promocional de licencia incierta.

## Estado por canal

- **GitHub:** publicado el código etiquetado, la APK firmada y su checksum. La
  nota del release identifica el certificado y el comando de verificación.
- **F-Droid:** la receta está propuesta y su CI ha sido correcta, pero la
  incorporación depende de una revisión humana externa. No hay disponibilidad
  en el catálogo mientras la solicitud siga abierta.
- **Google Play:** no se ha publicado ni se debe afirmar disponibilidad. Antes
  de usar ese canal se requiere un AAB, Play App Signing con la clave existente
  y declaraciones verificadas de ficha, clasificación y Data safety.

## Compatibilidad entre canales

La APK directa de Ethic Keyboard se firma con la clave del titular. F-Droid firma
por defecto sus APK compiladas desde fuente con su propia clave. Por ello, una
instalación directa no se puede actualizar sobre una versión firmada por F-Droid
sin desinstalar primero la aplicación, lo que borra sus preferencias locales.
La ficha de F-Droid debe explicar esta migración antes de ser aceptada. Google
Play debe usar la clave de firma existente mediante Play App Signing para evitar
ese problema con instalaciones directas.

## Comandos de verificación

```bash
./gradlew :app:assembleRelease --no-daemon
./scripts/verificar-licencias.sh
./scripts/verificar-privacidad.sh app/build/outputs/apk/release/app-release-unsigned.apk
export KEYSTORE_PATH="/ruta/privada/ethic-keyboard-release.jks"
export KEY_ALIAS="ethic-keyboard"
export STORE_PASSWORD='...'
export KEY_PASSWORD='...'
./scripts/firmar-release.sh
```

No se debe publicar el APK sin firma ni incluir contraseñas, keystore o rutas privadas en Git.
