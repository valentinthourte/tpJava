
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creacion de usuario</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

    </head>
    <body>
        <h1>Registrarse</h1>
        <form action="ServletUsuario" method="post">
            Nombre de usuario: <input type="text" name="nombreUsuario">
            Contraseña: <input type="text" name="contra">
            <input type="submit" value="Crear">
        </form>
    </body>
</html>
