# Preparación de una entrega release

Sin credenciales, la compilación release genera estos artefactos:

```text
app/build/outputs/apk/release/app-release-unsigned.apk
app/build/outputs/bundle/release/app-release.aab
```

La clave privada debe ser creada, respaldada y custodiada por el titular del proyecto; nunca debe entrar en Git, `local.properties` ni una variable persistente del repositorio.

## Firma local

Define las variables solo en la sesión local **antes de compilar**:

```bash
source /home/Familia/Proyectos/jpi59/entorno-android-jpi59.sh
export KEYSTORE_PATH="/ruta/privada/ethic-keyboard-release.jks"
export KEY_ALIAS="ethic-keyboard"
export STORE_PASSWORD='contraseña-del-keystore'
export KEY_PASSWORD='contraseña-de-la-clave'
./gradlew :app:assembleRelease :app:bundleRelease --no-daemon
./scripts/firmar-release.sh
```

Con las cuatro variables definidas, Gradle firma el APK y el AAB con la misma
clave; `scripts/firmar-release.sh` detecta ese APK y verifica su firma. Si el APK
fue compilado sin credenciales y existe el artefacto sin firma, el script lo
alinea, firma y verifica. Las contraseñas no se escriben en archivos del
repositorio ni en los registros de CI.

Google Play requiere el AAB y Play App Signing. Al registrar una aplicación que
ya se distribuyó con `org.jpi59.teclado`, se debe inscribir la clave de firma
existente para que las actualizaciones conserven compatibilidad con la APK ya
instalada.

Antes de publicar, registra de forma privada la huella SHA-256 del certificado, prueba instalación/actualización en un dispositivo y conserva una copia de seguridad del keystore. Perder la clave impedirá actualizar la aplicación con el mismo paquete.
