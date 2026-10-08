# Auditoría de licencias y procedencia — Ethic Keyboard

Fecha de revisión: 2026-09-07  
Alcance: árbol Git local en `master`, commit vigente y configuración de compilación.

## Conclusión ejecutiva

**Resultado: GPLv3 técnicamente adoptada para la obra combinada, condicionada para publicación pública.** La base de código permite una distribución GPLv3 porque el material Apache 2.0 es compatible con GPLv3, siempre que se conserven los avisos y se completen las verificaciones de los recursos binarios.

La procedencia técnica de los recursos actuales fue comparada con el commit upstream declarado y se registró en `PROCEDENCIA-RECURSOS.md`. Las aportaciones visuales atribuidas a jpi59 siguen siendo una declaración del mantenedor; esta auditoría no aporta una prueba externa de autoría ni sustituye una revisión jurídica.

## Hechos comprobados

- El repositorio contiene la licencia completa GPLv3 en `LICENSE` y Apache License 2.0 en `LICENSE-APACHE-2.0`.
- `NOTICE.md` identifica el proyecto base `rkkr/simple-keyboard`, el commit base auditado y la herencia de AOSP LatinIME.
- Los archivos Java y la mayoría de recursos heredados contienen avisos Apache 2.0 y copyright de AOSP y/o colaboradores del proyecto base.
- El proyecto no tiene dependencias de ejecución declaradas en `app/build.gradle`.
- El plugin de Android y Gradle son herramientas de compilación; no se empaquetan como dependencias de la aplicación.
- El manifiesto declara únicamente `android.permission.VIBRATE`; no declara permiso de Internet.
- Los cambios propios identificados son marca, namespace/paquete, textos, ajustes de transparencia y documentación.
- `local.properties` está excluido por `.gitignore` y no forma parte de la distribución.
- Se añadieron avisos de copyright de jpi59 a los dos recursos XML modificados en esta auditoría.

## Procedencia y obligaciones

### Código AOSP/Simple Keyboard

Debe conservarse cada aviso de copyright y licencia de los archivos derivados, junto con una copia de Apache 2.0 y los avisos de `NOTICE.md`. Los archivos modificados deben indicar que fueron cambiados. La referencia upstream utilizada es:

- https://github.com/rkkr/simple-keyboard
- https://github.com/rkkr/simple-keyboard/blob/master/LICENSE
- https://source.android.com/docs/setup/contribute/licenses

### Cambios de jpi59

Las modificaciones originales de jpi59 pueden publicarse bajo Apache 2.0. Esto no convierte el código heredado en una obra cuyo copyright pertenezca exclusivamente a jpi59; las atribuciones existentes deben permanecer.

### Recursos binarios y gráficos

`icons/icon.svg`, `icons/ic_launcher-playstore.png` y la adaptación de los vectores Android son contribuciones visuales de jpi59, documentadas en `NOTICE.md`. Las capturas y el recurso promocional heredados sin licencia individual cerrada fueron retirados del árbol actual. Sus objetos permanecen en la historia Git privada; el repositorio público debe usar el historial limpio de distribución.

Algunos vectores XML no tienen encabezado de licencia visible. La comparación byte a byte contra el commit upstream documentada en `PROCEDENCIA-RECURSOS.md` confirma su procedencia técnica cuando no difieren; los que difieren están inventariados como derivados o aportaciones declaradas. Debe repetirse esa comparación al incorporar recursos nuevos.

## Compatibilidad de relicenciamiento

- Apache 2.0 es una licencia libre y permite modificaciones, distribución y uso comercial, sujeto a sus avisos y condiciones.
- Apache 2.0 es compatible con GPLv3 en el sentido indicado por la ASF y la FSF; eso no autoriza borrar los avisos Apache ni cambiar unilateralmente el copyright de terceros.
- Las contribuciones originales de jpi59 pueden licenciarse bajo GPLv3-or-later, pero el conjunto requiere un análisis archivo por archivo y una estrategia de avisos clara.
- No se recomienda declarar todo el repositorio como AGPLv3 sin una auditoría de compatibilidad específica. El teclado es una aplicación local, no un servicio de red, y AGPL no aporta una ventaja proporcional aquí.
- No es ético ni jurídicamente correcto sustituir `LICENSE` por GPL/AGPL como si todo el código fuera de jpi59.

Referencias:

- https://www.apache.org/licenses/GPL-compatibility
- https://www.gnu.org/licenses/license-compatibility.en.html
- https://www.gnu.org/licenses/license-list.en.html

## Acciones necesarias antes de hacer público el repositorio

1. Mantener fuera del historial público los recursos binarios de licencia incierta; el árbol de distribución actual ya los retiró.
2. Repetir la comparación de recursos contra upstream y actualizar `PROCEDENCIA-RECURSOS.md` con cada cambio.
3. Documentar o retirar cualquier recurso futuro cuya licencia, fuente o contribución no pueda verificarse.
4. Mantener la obra combinada bajo GNU GPLv3 o posterior, preservando todos los avisos y condiciones de Apache 2.0 para el código heredado de AOSP y Simple Keyboard.
5. Revisar el contenido final del repositorio público para asegurar que no contiene datos personales, tokens, claves o rutas privadas.
6. Publicar la política de privacidad en una URL accesible sin autenticación; `docs/privacy.html` queda preparada para GitHub Pages.

## Estado de la entrega

La revisión técnica de código, permisos y documentación está preparada. Sigue siendo incorrecto afirmar que la aplicación está publicada hasta firmar el APK con la clave del titular, comprobar la firma y hacer público el repositorio limpio. Este documento no constituye asesoramiento jurídico profesional.

## Dictamen provisional

**Licencia adoptada para la obra combinada: GNU GPLv3-or-later.**
**Licencia conservada para código heredado: Apache License 2.0.**
**Estado de publicación: condicionado.**  
**GPLv3: adoptada formalmente para la obra combinada (LICENSE), respetando los avisos de Apache 2.0 (NOTICE.md).**  
**AGPLv3: no recomendada para esta aplicación local.**

Este documento es una auditoría técnica de procedencia y compatibilidad, no asesoramiento jurídico profesional.
