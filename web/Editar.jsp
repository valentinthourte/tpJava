
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    </head>
    <body>
        <h1>Pestaña de edición</h1>
        
        <div style="width: 100%;">
            <div class="editarDiv">
                <h3>Cliente</h3>
                <h5>Complete los campos a editar</h5>
                <form action="ServletEditar" method="post">
                    Id del cliente a editar: <input type="text" name="id" class="input"><BR> 
                    Dni: <Input type="text" name="dni" class="input"><BR>
                    Nombre: <INPUT type="text" name="nombre" class="input"><BR>
                    Apellido: <input type="text" name="apellido" class="input"><BR>
                    Edad: <input type="text" name="edad" class="input"><BR>
                    <input type="submit" value="Editar">
                </form>
            </div> 
            <div class="editarDiv">
                <h3>Usuario</h3>
                <h5>Complete los campos a editar</h5>
                <form action="ServletEditar" method="post">
                    Id del usuario a editar: <input type="text" name="idUsu" class="input"><BR> 
                    Nombre: <INPUT type="text" name="nombreUsuario" class="input"><BR>
                    Contraseña <input type="text" name="contra" class="input"><BR>
                    <input type="submit" value="Editar">
                </form>
            </div> 
            <div class="editarDiv">
                <h3>Entrada</h3>
                <h5>Complete los campos a editar</h5>
                <form action="ServletEditar" method="post">
                    Id de la entrada a editar: <input type="text" name="idEntrada" class="input"><BR> 
                    Hora deseada: <Input type="text" name="hora" class="input"><BR>
                    Fecha(dd-mm-aaaa): <INPUT type="text" name="fecha" class="input"><BR>
                    Juego:  <input type="text" name="juego" class="input"><BR>
                    Dni Cliente: <input type="text" name="dniC" class="input"><BR>
                    <input type="submit" value="Editar">
                </form>
            </div>
            <div class="editarDiv">
                <h3>Juego</h3>
                <h5>Complete los campos a editar</h5>
                <form action="ServletEditar" method="post">
                    Id del juego a editar: <input type="text" name="idJuego" class="input"><BR> 
                    Hora deseada: <Input type="text" name="horaJ" class="input"><BR>
                    Edad: <input type="text" name="edadJ" class="input"><BR>
                    Nombre: <INPUT type="text" name="nombreJ" class="input"><BR>
                    Empleados(Id's separados por coma): <input type="text" name="empleJ" class="input"><BR>
                    <input type="submit" value="Editar">
                </form>
            </div>
            <div class="editarDiv">
                <h3>Edad</h3>
                <h5>Complete los campos a editar</h5>
                <form action="ServletEditar" method="post">
                    Id de la cat. de edad a editar: <input type="text" name="idEdad" class="input"><BR> 
                    Edad minima: <input type="text" name="edadMin" class="input"><BR>
                    Edad maxima: <input type="text" name="edadMax" class="input"><BR>
                    <input type="submit" value="Editar">
                </form>
            </div> 
            <div class="editarDiv">
                <h3>Horario</h3>
                <h5>Complete los campos a editar</h5>
                <form action="ServletEditar" method="post">
                    Id del horario a editar: <input type="text" name="idHorario" class="input"><BR> 
                    Hora apertura: <Input type="text" name="horaApertura" class="input"><BR>
                    Hora cierre: <Input type="text" name="horaCierre" class="input"><BR>
                    <input type="submit" value="Editar">
                </form>
            </div> 
            <div class="editarDiv" id="editarEmpleado">
                <h3>Empleado</h3>
                <h5>Complete los campos a editar</h5>
                <form action="ServletEditar" method="post">
                    Id del empleado a editar: <input type="text" name="idEmple" class="input"><BR> 
                    Dni: <Input type="text" name="dniE" class="input"><BR>
                    Nombre: <INPUT type="text" name="nombreE" class="input"><BR>
                    Apellido: <input type="text" name="apellidoE" class="input"><BR>
                    Edad: <input type="text" name="edadE" class="input"><BR>
                    Nombre de Usuario: <INPUT type="text" name="nombreUsuarioE" class="input"><BR>
                    Contraseña <input type="text" name="contraE" class="input"><BR>
                    <input type="submit" value="Editar">
                </form>
            </div>
            
            
            <form action="index.jsp" id="formLectura">
                <input type="submit" value="Volver al inicio">
            </form>
            
            
        </div>
        
        
        
        
        
        
    </body>
</html>
