# Política de privacidad — Ethic Keyboard

Última actualización: 12 de septiembre de 2026
Aplicable a: Ethic Keyboard 6.6.6 (`org.jpi59.teclado`)

## Responsable y contacto

El responsable de esta versión es **jpi59**, mantenedor identificado en el
repositorio público de Ethic Keyboard. Para consultas, incidencias o solicitudes
relacionadas con privacidad, utiliza el [gestor público de incidencias](https://github.com/jpi59/ethic-keyboard/issues).

## Datos que procesa el teclado

Un teclado de Android recibe el texto, la selección y la información del campo
activo que Android y la aplicación receptora le entregan para poder escribir. En
la versión 6.6.6, Ethic Keyboard procesa esos datos en memoria durante la sesión
de entrada y los entrega a la aplicación en la que el usuario está escribiendo.
No guarda, perfila, vende, comparte ni transmite ese texto a servidores de jpi59
ni a terceros.

Cuando el usuario pulsa la acción de pegar, el teclado puede leer el texto del
portapapeles del sistema para insertarlo donde el usuario lo ha solicitado. No
crea una copia persistente del portapapeles ni lo transmite.

## Preferencias locales y retención

La aplicación conserva en el almacenamiento privado del dispositivo las
preferencias necesarias para funcionar, como idiomas o distribuciones activas,
tema, tamaño y opciones de vibración. No se diseñan para contener el texto que
se escribe. Permanecen hasta que el usuario las cambia, borra los datos de la
aplicación desde Ajustes de Android o desinstala la aplicación.

La aplicación desactiva sus copias de seguridad en la nube mediante
`android:allowBackup="false"` y no solicita copias de seguridad. Algunos
fabricantes pueden conservar transferencias de dispositivo a dispositivo como
parte de la migración del sistema; esa función depende del sistema operativo y
no es un servicio de Ethic Keyboard.

## Red, compartición y permisos

Ethic Keyboard no declara permiso de Internet ni integra anuncios, analítica,
telemetría, rastreadores ni servicios de red. Por tanto, no recoge ni comparte
datos fuera del dispositivo mediante la aplicación.

El único permiso normal declarado es `VIBRATE`, utilizado para la respuesta
háptica y configurable por el usuario. `BIND_INPUT_METHOD` es el permiso que
Android exige a un servicio de teclado; no concede acceso a Internet.

La aplicación no ofrece cuentas, perfiles ni sincronización propios. No hay
cuentas ni datos de cuenta que eliminar en servidores de Ethic Keyboard.

## Seguridad y tus controles

El código fuente está disponible para revisión pública. Puedes dejar de usar el
teclado, desactivarlo desde los ajustes de métodos de entrada o borrar sus datos
desde los Ajustes de Android. Borrar los datos elimina las preferencias locales y
restaura la configuración inicial del teclado.

## Cambios de esta política

Si una versión futura cambia estas prácticas, esta política se actualizará antes
de distribuir esa versión, indicando la fecha y el cambio realizado. La URL de
esta política se mantiene accesible desde los ajustes de la aplicación y debe
coincidir con las declaraciones de la tienda donde se distribuya.
