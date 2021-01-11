<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    </head>
    <body>
        <h1>Pestaña de alta</h1>
        <div style="width: 100%;">

            <div class="crearDiv">
                <h3 class="crearHead">Cliente</h3>
                <form action="ServletCliente" method="POST">
                Dni: <Input type="text" name="dni" class="input"><BR>
                Nombre: <INPUT type="text" name="nombre" class="input"><BR>
                Apellido: <input type="text" name="apellido" class="input"><BR>
                Edad: <input type="text" name="edad" class="input"><BR>

                <input type="submit" value="Enviar">
            </form>
            </div>
          
            <div class="crearDiv" style="margin-top: 0px;">
                <h3 class="crearHead">Usuario</h3>
                <form action="ServletUsuario" method="POST">
                Nombre de usuario: <Input type="text" name="nombreUsuario" class="input"><BR>
                Contraseña: <INPUT type="text" name="contra" class="input"><BR>
                

                <input type="submit" value="Enviar">
            </form>
            </div>
            <div class="crearDiv">
                <h3 class="crearHead">Juego</h3>
                <form action="ServletJuego" method="POST">
                Id categoria edad: <Input type="text" name="edad" class="input"><BR>
                Horario(id): <INPUT type="text" name="hora" class="input"><BR>
                Nombre: <input type="text" name="nombre" class="input"><BR>
                Empleados(Id's separados por coma): <input type="text" name="emple" class="input"><BR>
                <input type="submit" value="Enviar">
            </form>
            </div>
            <div class="crearDiv">
                <h3 class="crearHead">Entrada</h3>
                <form action="ServletEntrada" method="POST">
                Hora deseada: <Input type="text" name="hora" class="input"><BR>
                Fecha(dd-mm-aaaa): <INPUT type="text" name="fecha" class="input"><BR>
                Juego:  <input type="text" name="juego" class="input"><BR>
                Dni Cliente: <input type="text" name="dni" class="input"><BR>

                <input type="submit" value="Enviar">
            </form>
            </div>
        </div>
        <div>
            <div class="crearDiv">
                <h3 class="crearHead">Empleado</h3>
                <form action="ServletEmpleado" method="POST">
                Dni: <Input type="text" name="dni" class="input"><BR>
                Nombre: <INPUT type="text" name="nombre" class="input"><BR>
                Apellido: <input type="text" name="apellido" class="input"><BR>
                Edad: <input type="text" name="edad" class="input"><BR>
                Usuario(nombre): <input type="text" name="usu" class="input"><BR>
                <input type="submit" value="Enviar">
            </form>
            </div>
            <div class="crearDiv">
                <h3 class="crearHead">Horario</h3>
                <form action="ServletHorario" method="POST">
                Horario apertura: <Input type="text" name="apertura" class="input"><BR>
                Horario cierre: <INPUT type="text" name="cierre" class="input"><BR>
                <input type="submit" value="Enviar">
            </form>
            </div>
            <div class="crearDiv">
                <h3 class="crearHead">Categoria de edad</h3>
                <form action="ServletEdad" method="POST">
                Edad minima: <Input type="text" name="min" class="input"><BR>
                Edad maxima: <INPUT type="text" name="max" class="input"><BR>
                <input type="submit" value="Enviar">
            </form>
            </div>
        </div>
        <form action="index.jsp" id="formLectura">
            <input type="submit" value="Volver al inicio">
        </form>
    </body>
</html>
