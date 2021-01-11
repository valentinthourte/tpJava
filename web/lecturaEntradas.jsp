<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lectura de entradas</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

    </head>
    <body>
        <h1>Pestaña de consulta de entradas</h1>
        <div>
             <div id="divEntradas">
                <h3 class="crearHead">Entradas vendidas en un determinado dia</h3>
                <form action="ServletLecturaEntrada" method="POST">
                Fecha(dd-mm-yyyy): <Input type="text" name="fecha" class="input"><BR>
                
                <input type="submit" value="Enviar">
            </form>
            </div>
            
            
            <form action="index.jsp" id="formLectura">
                <input type="submit" value="Volver al inicio">
            </form>
        </div>
        <div>
             <div id="divEntradas">
                <h3 class="crearHead">Entradas vendidas en un determinado dia de un determinado juego</h3>
                <form action="ServletLectura2" method="POST">
                Fecha(dd-mm-yyyy): <Input type="text" name="fecha2" class="input"><BR>
                Juego:<br> <input type="text" name="juego" class="input"><br>
                <input type="submit" value="Enviar">
            </form>
            </div>
            
            
            <form action="index.jsp" id="formLectura">
                <input type="submit" value="Volver al inicio">
            </form>
        </div>
    </body>
</html>
