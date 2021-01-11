<%@page import="Logica.Usuario"%>
<%@page import="Logica.Empleado"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parque de diversiones "Italpark 2.0"</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    </head>
    <body>
        <%
        HttpSession miSesion = request.getSession();
        
        String usu = (String) request.getSession().getAttribute("usuario");
        String contra = (String) request.getSession().getAttribute("contra");
        if (usu == null || contra == null) {
            response.sendRedirect("ErrorUsuario.jsp");
        }
        else {
            %>
        
        
        
        
        
        <h1>Italpark 2.0 - La revolución de la diversión</h1>
        <h3>Crear</h3>
        <div class="crear">
            <form action="crear.jsp">
                <input type="submit" value="Crear">
            </form>
        </div>
        
        <div>
            <h3>Eliminar</h3>
            <form action="ServletBaja" method="POST">
            Clase: <input type="text" name="clase">
            Id: <input type="text" name="idBaja">
            <input type="submit" value="Eliminar">
        
        </form> 
        </div>
        <div>
            <h3>Editar</h3>
            <form action="Editar.jsp">
                <input type="submit" value="Editar">
            </form>
        </div>
        
         <div>
            <h3>Lectura de datos</h3>
            <form action="Lectura.jsp">
                <input type="submit" value="Ir a lectura">
            </form>
        </div>
        
        <%
        }
        %>
    </body>

</html>
