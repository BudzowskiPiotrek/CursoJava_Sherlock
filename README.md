# Examen de Programación 🎓

### Examen de Programación 💻

El archivo del famoso detective Sherlock Holmes 🕵️‍♂️ ha sido digitalizado. Ahora necesitas desarrollar un algoritmo, registrar casos 📝, listar sospechosos 👥, mantener detectives asociados 🤝 y actualizar el estado de los casos según se vayan resolviendo. ✨

Comenzaremos modelando la clase `Detective_Sospechoso` y `Caso` en relación a los datos que aparecen en la base de datos. 📊

* Un `Detective_Sospechoso` tiene una `id` 🆔, un `nombre` 📛, un `nivel de peligrosidad` (un valor por defecto) ⚠️, y además tiene lo que se considera su `especialidad` y su `experiencia` 🌟.
* Un `sospechoso` tiene una `id` 🆔, un `nombre` 📛, un `apellido` 👨‍👩‍👧‍👦, una `descripción` 💬, una `id` de un caso que se resolverá 💼 y una `id` de un tipo de arma 🔫.
* Un `caso` tendrá una `id` 🆔, un `título` 📖, una `descripción` 📝, una `fecha de investigación` 📅, y un `estado` (resuelto o no) ✅❌.

Para la implementación en las clases, tendrás un valor de 2.5 puntos. 💯 (Si usas un DTO para las clases y lo haces correctamente (formateada)). 📐

**Consola y Pruebas (4 Java Application)** 🖥️☕

Con el fichero adjunto se creará la base de datos en `C:\Users\Usuario\Desktop\db\` 📁 o donde el usuario quiera. Al iniciar el programa, la consola mostrará el siguiente mensaje: `Conexión a base de datos de Sherlock Holmes Lista.` 🔗
La consola principal de la clase `controlador` deberá estar autorizada en la clase `conector` y restará 0.5 puntos. 🔑

El siguiente paso será desarrollar el `main` en el que solo se mostrará un menú de 6 opciones 📃, el cual se encargará de ir llamando a los métodos para mostrar los datos de la agencia de detectives 🕵️‍♂️. El menú deberá pedir la opción que se realizará y mostrar un bucle para que cada vez que seleccionemos la opción, hasta que el usuario decida salir. 🔄🚪 (0.5 puntos)

### MENÚ PRINCIPAL 🏡
1.  Listar Casos 📂
2.  Añadir detectives ➕
3.  Listar sospechosos 👤
4.  Listar Casos Resueltos ✅
5.  Listar Casos Pendientes ⏳
6.  Resolver Casos 💡
7.  Salir 🚪

**Selecciona una opción:** `?` 🧐

Las opciones del menú se desarrollarán de la siguiente forma: 👇

### Listar Especialidades 🌟
Mostrará todas las especialidades de nuestro departamento, es decir las especialidades de los detectives, pero solo aquellas que son distintas. 🤝 (1 punto)

#### Especialidades de la agencia: 🧠
* Deducción 🧐
* Lógica 🧠
* Investigación criminal 🚨
* Psicología criminal 😈
* Análisis de patrones 📊
* Criminología ⚖️
* Estrategia y lógica ♟️
* Otros ✨

### Añadir Detectives 🆕🕵️‍♂️
Nos permitirá insertar un nuevo detective pidiendo el nombre de éste con este mensaje. (1 punto) 🏷️

**Selecciona nombre del detective:** ➡️
* **Ingrese el nombre del detective:** `[nombre]` ✍️
* **Ingrese especialidad del detective:** `robos` 💰
* `Detective insertado.` 🎉

---

### Listar Casos 📋
Tendremos en la tabla principal la opción de listar los casos no resueltos 🕵️‍♂️ y la opción de listar casos resueltos ✅. Pero en ambas ocasiones, debemos listar en la tabla de los casos no resueltos la base de datos de los casos no resueltos 📂 y en la tabla de caso sospechoso debemos mostrar N/A. (1 punto) ✨

### Resolver Casos 🔎
Para resolver casos, una vez el usuario escoja la opción, le pediremos que elija la ID de caso que quiere resolver 🎯. A continuación, mostraremos los sospechosos 👥 y preguntaremos por la ID del sospechoso que consideremos. Si es correcto, el caso se marcará como resuelto 🎉, la ID del detective encargado se actualizará y mostraremos el nombre y los datos del sospechoso. (2 puntos) 🚀

### MENÚ PRINCIPAL 🏠
1.  Listar casos 📝
2.  Añadir detectives ➕
3.  Listar casos resueltos ✅
4.  Listar casos pendientes ⏳
5.  Resolver Casos 💡
6.  Salir 🚪

**Selecciona una opción:** `6` 🔢

A continuación se muestran los casos no resueltos:

#### Casos No Resueltos: 🕵️‍♀️🚫

| Id       | Título                   | Descripción                                 | Detective      |
| :------- | :----------------------- | :------------------------------------------ | :------------- |
| (Casos)  | El asalto en la noche.   | "Alguien suena una guitarra." 🎸           | N/A            |
| (Casos)  | El rapto del diamante.   | "El museo está desierto." 🏛️              | N/A            |
| (Casos)  | La desaparición del tesoro. | "Un viejo mercader." 👴                     | N/A            |
| (Casos)  | El secuestro del violinista. | "Un violinista." 🎻                         | N/A            |
| (Casos)  | El robo del cuadro.      | "Un artista en el tejado." 🎨               | N/A            |
| (Casos)  | El asesinato en la ópera. | "La ópera." 🎭                              | N/A            |

**Selecciona la opción:** `?` 🤔

#### Sospechosos 🤨

Cuando esté sin resolver, se verá N/A. 🤷‍♀️
Cuando esté resuelto, se verá el detective que lo resolvió. 🏆
Sospechosos: una instancia de la clase `Sospechoso`. 👤
Tiene los siguientes atributos: `id`, `nombre`, `apellido`, `descripción`, un atributo `sin resolver` que contendrá una ID de un caso no resuelto, una ID de un detective que es el detective que lo resolvió, y un atributo booleano que determinará si el caso está resuelto o no. ✔️

En este caso, el sospechoso tiene un nivel de criminalidad 8 😈 y utiliza el arma `toxina exótica` ☣️.
De los siguientes sospechosos, ¿cuál crees que ha sido? (Puntuaje 3) 💯

#### Sospechosos (1,2 puntos): 👥🔍

| Nombre                    | Apellido      | NivelCriminalidad | Arma            | Resolver |
| :------------------------ | :------------ | :---------------- | :-------------- | :------- |
| (Sospechoso) Jane Moriarty | (Apellido)    | (NivelCriminalidad) | "arma"          | (Resolver) |
| (Sospechoso) John Smith   | (Apellido)    | (NivelCriminalidad) | "arma"          | (Resolver) |
| (Sospechoso) Quirles Augustus Maltravers | (Apellido)    | (NivelCriminalidad) | "arma"          | (Resolver) |

Sospechoso tiene: `nombre` (String), `apellido` (String), `nivelCriminalidad` (Integer), `arma` (String) y una booleana para resolver el caso. ✅

**Actualización realizada con éxito. 🎉 ¡Ya nos quedan menos casos pendientes!** 🥳

Salir de la aplicación deberá desconectar de la base de datos 🔌 y terminar el bucle. 🛑 (0.5 puntos)

**Selecciona una opción:** `?` 🤔
1.  Resolver casos 📝
2.  Salir del programa, haz pronto... 🏃‍♀️

**Advertencia:** Solo puntúan los métodos que funcionen, es decir que si al arrancar el programa salta un error, no se corrige. 🐞 El formato del código debe ser correcto, si no se restarán puntos. ⚠️ Esta opción queda anulada. ❌

---
