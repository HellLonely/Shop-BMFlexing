

<h1 align="center">Tienda BMFlexing</h1>


<h2>Inicio y Login</h2>

En el momento que la aplicación se inicia la primera tarea que hace
es revisar si todas sus dependencias funcionan ````comprobarSistema()````
una de estas depencias es la base de datos, el programa lanzara una advertencia de que no hay conexión.


<div style="display: flex;justify-content:center">
    <img src="src/img/warning.png" style="width:270px">
</div>



<h2> Administración 👷‍♂️</h2>

Como en toda aplicación necesitamos administrar a los usuarios o el contenido de la base de datos.

Para administrar **BMFlexing** todos los administradores tendran un panel el cual podran realizar distintas tareas.

<ol>
    <li>Añadir recambios</li>
    <li>Añadir bicicletas</li>
    <li>Crear usuarios</li>
    <li>Gestionar Usuarios</li>
    <li>Crear administradores</li>
    <li>Gestionar administradores</li>
</ol>


<h2>Sistema de logs 📜</h2>

Se crean archivos txt con los siguientes datos:

+ Fecha 
+ Error o Instrucción
+ Modulo

Para el sistema de los logs se usan dos archivos con distintios lenguajes.

+ logCreator.py
+ logSystem.java

Funciona a partir de una función que se encargar de ejecutar el codigo Python pasandole los parametros necesarios para crear el registro.

<img src="src/img/log1.png" style="width:500px">

<h3>¿Cuando se crean los <strong>logs </strong>?</h3>

Los logs se crean cuando el usuario hace el **login** a la aplicación ```logButonActionPerformed()``` cuando adquiere alguno 
de nuestros productos, cuando se crea un nuevo usuario ```createUserActionPerformed()```, ocurre algun fallo en el programa 
(e.j Fallo al conectar con la base de datos ```dataBaseTestConection()```).

<h3>Administración de logs</h3>

Por el momento la unica opción para gestionar los logs de la aplicación
se encuentra en las funcionalidades de **Admin**, que presenta un botón para
eliminar los logs ```clearLog()```


<h2> DAO 🐬</h2>

En esta clase se almacenan todos los metodos que realizan alguna consulta a la base de datos. 

Esta clase consta de solo 3 atributos.

```java
    private static String connectionJDBC;
    private static String userSQL;
    private static String passwordSQL;
```

<h4>connectionJDBC</h4>
<p>A esta variable se le pasa el link del conector a la base de datos.</p>

```jdbc:mysql://ipDeDestino:puerto/baseDeDatos```

<h4>userSQL y passwordSQL</h3>

Son basicamente el usuario y la contraseña de la conexion a la base de datos.

<h3>Estructura básica de los metodos </h3>

Todos los metodos contiene una estructura **try, catch**, que siempre probara a conectarse a la base de datos, pasando como parametros las variables antes mencionadas.

``` Java
try (Connection conexion = DriverManager.getConnection(conectionIp, userSQL, passwordSQL);PreparedStatement ps = conexion.prepareStatement(sentenciaSQL))
```

Si la conexion es posible se ejecuta el contenido si no
devuelve el mensaje de error SQL ````e.getErrorCode() ````  obtener el codigo de error ````e.getSQLState()```` y el mensaje que nos devuelve  ````e.getMessage()```` .

A lo largo de todo el proyecto se utilizan varias consultas a la base de datos. Asi que nos parece correcto hacer una pequeña lista de todos los metodos de acceso para facilitar entender el código de manera externa.


<h3 style="margin-bottom:10px;">DAO 🐬 | Metodos usados</h3>


|Nombre|Descripción|
|---|---|
|```dataBaseTestConection()``` |Comprueba que la conexion con la base de datos.|
|```insertNewUser ()```|Inserta un nuevo usuario en la tabla usuario.
|```loginUser()```|Comprueba el nombre de usuario y contraseña para habilitar el **login**.|
|```loginAdmin()```|Comprueba el nombre de usuario y contraseña del usuario para loguearlo con los permisos de **Administrador**.|
|```getAdminTipo()```|Extrae el tipo de administrador de la sesión.|
|```insertRecambio()```|Crea un nuevo **Recambio** en la base de datos.|
|```modeloFactura()```|Consultar a Richard|
| ```actualizarPrecios()```|Consultar a Richard|
|```getUsuariosDatos()```|Obtiene la información del **Usuario** para mostrarlo en la aplicación.|
|```insertarFactura()```|Crea una nueva **Factura** en la base de datos.|
|```getIdCliente()```|Obtiene la id del **Usuario** mediante su nombre.|
|```piezasCuadro()```|Extrae todos los **Recambios** de tipo cuadro.|
|```piezasRuedas()```|Extrae todos los **Recambios** de tipo ruedas.|
|```piezasFrenos()```|Extrae todos los **Recambios** de tipo frenos.|
|```piezasShock()```|Extrae todos los **Recambios** de tipo shock.|
|```piezasHorquilla()```|Extrae todos los **Recambios** de tipo horquilla.|
|```getAdmins()```|Obtiene la información de todos los **Administradores**.|
|```deleteAdmin()```|Elimina a un **Administrador** mediante su id.|
|```promoteUser()```|Añade a un **Usuario** a la tabla de **Administradores**.|
|```getAllRecambios()```|Extrae la información de todos los **Recambios** mostrandolos en la aplicación.|
|```getRecambio()```|Extrae la información de un **Recambio**.|
|```updateRecambio()```|Modifica las informacion de un solo **Recambio**.|



```dataBaseTestConection()```  → Comprueba que la conexion con la base de datos.


```insertNewUser ()```  → Inserta un nuevo usuario en la tabla usuario.

```loginUser()``` → Comprueba el nombre de usuario y contraseña para habilitar el **login**.

```loginAdmin()``` → Comprueba el nombre de usuario y contraseña del usuario para loguearlo con los permisos de **Administrador**.

```getAdminTipo()``` → Extrae el tipo de administrador de la sesión.

```insertRecambio()``` → Crea un nuevo **Recambio** en la base de datos.

```modeloFactura()``` → Consultar a Richard
 
```actualizarPrecios()``` → Consultar a Richard

```getUsuariosDatos()``` → Obtiene la información del **Usuario** para mostrarlo en la aplicación.

```insertarFactura()``` → Crea una nueva **Factura** en la base de datos.

```getIdCliente()``` → Obtiene la id del **Usuario** mediante su nombre.

```piezasCuadro()``` → Extrae todos los **Recambios** de tipo cuadro.

```piezasRuedas()``` → Extrae todos los **Recambios** de tipo ruedas.

```piezasFrenos()``` → Extrae todos los **Recambios** de tipo frenos.

```piezasShock()``` → Extrae todos los **Recambios** de tipo shock.

```piezasHorquilla()``` → Extrae todos los **Recambios** de tipo horquilla.
 
```getAdmins()``` →  Obtiene la información de todos los **Administradores**.

```deleteAdmin()``` → Elimina a un **Administrador** mediante su id.

```promoteUser()``` → Añade a un **Usuario** a la tabla de **Administradores**.

```getAllRecambios()``` → Extrae la información de todos los **Recambios** mostrandolos en la aplicación.

```getRecambio()``` → Extrae la información de un **Recambio**.

```updateRecambio()``` → Modifica las informacion de un solo **Recambio**.