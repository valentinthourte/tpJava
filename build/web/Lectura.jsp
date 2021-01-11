<%@page import="Logica.Juego"%>
<%@page import="Logica.EdadJuego"%>
<%@page import="Logica.Horario"%>
<%@page import="Logica.Empleado"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lectura</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    </head>
    <body>
        <h1>Lectura de datos</h1>
        <div style="width: 100%;">
            <div class="crearDiv" id="divClientes">
                <h3 id="headerCliente">Clientes</h3>
                <table id="tablaClientes" class="tabla1">
                    <thead>
                    <th>Id</th>
                    <th>Dni</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Edad</th>
                    </thead>
                    <tbody>
                        <tr class="rows">
                            <% Controladora control = new Controladora();
                                List<Cliente> listaClientes = control.traerClientes();
                                for (Cliente cli: listaClientes) {   
                            %> 
                            <%
                            int id = cli.getIdCliente();
                            String dni = cli.getDni();
                            String nombre = cli.getNombre();
                            String apellido = cli.getApellido();
                            int edad = cli.getEdad();
                            
                            %>
                            <td id="id<%=id%>"><%=id%></td>
                            <td id="dni<%=dni%>"><%=dni%></td>
                            <td id="nombre<%=nombre%>"><%=nombre%></td>
                            <td id="apellido<%=apellido%>"><%=apellido%></td>
                            <td id="edad"><%=edad%></td>   
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                
            </div>
            <div class="crearDiv" id="divClientes">
                <h3 id="headerCliente">Usuarios</h3>
                <table id="tablaClientes" class="tabla1">
                    <thead id="usu">
                    <th>Id</th>
                    <th>Nombre</th>
                    </thead>
                    <tbody id="usu">
                        <tr class="rows">
                            <%  
                                List<Usuario> listaUsuarios = control.traerUsuarios();
                                for (Usuario usu: listaUsuarios) {   
                            %> 
                            <%
                            int id = usu.getIdUsuario();
                            String nombre = usu.getNombreUsuario();                            
                            %>
                            <td id="id<%=id%>"><%=id%></td>
                            <td id="nombre<%=nombre%>"><%=nombre%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </div>
            <div class="crearDiv" id="divUsu">
                <h3 id="headerCliente">Empleados</h3>
                <table id="tablaClientes" class="tabla1" id="usu">
                    <thead>
                    <th>Id</th>
                    <th>Dni</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Edad</th>
                    <th>Nombre usuario</th>
                    </thead>
                    <tbody>
                        <tr class="rows">
                            <%  
                                List<Empleado> listaEmpleados = control.traerEmpleados();
                                for (Empleado emple: listaEmpleados) {   
                            %> 
                            <%
                            int id = emple.getIdEmpleado();
                            String dni = emple.getDni();
                            String nombre = emple.getNombre();
                            String apellido = emple.getApellido();
                            int edad = emple.getEdad();
                            String nombreUsuario = emple.getUsuario().getNombreUsuario();
                            %>
                            <td id="id<%=id%>"><%=id%></td>
                            <td id="dni<%=dni%>"><%=dni%></td>
                            <td id="nombre<%=nombre%>"><%=nombre%></td>
                            <td id="apellido<%=apellido%>"><%=apellido%></td>
                            <td id="edad"><%=edad%></td>
                            <td id="usu"<%=nombreUsuario%>><%=nombreUsuario %></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </div>
            <div class="crearDiv" id="divClientes">
                <h3 id="headerCliente">Horarios</h3>
                <table id="tablaClientes" class="tabla1" id="usu">
                    <thead>
                    <th>Id</th>
                    <th>Apertura</th>
                    <th>Cierre</th>
                    </thead>
                    <tbody>
                        <tr class="rows">
                            <%  
                                List<Horario> listaHorarios = control.traerHorarios();
                                for (Horario hora: listaHorarios) {   
                            %> 
                            <%
                            int id = hora.getIdHorario();
                            int apertura = hora.getHorarioApertura();
                            int cierre = hora.getHorarioCierre();
                            %>
                            <td id="id<%=id%>"><%=id%></td>
                            <td id="apertura<%=apertura%>"><%=apertura%></td>
                            <td id="cierre<%=cierre%>"><%=cierre%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </div>
            <div class="crearDiv" id="divClientes">
                <h3 id="headerCliente">Edad</h3>
                <table id="tablaClientes" class="tabla1" id="usu">
                    <thead>
                    <th>Id</th>
                    <th>Edad minima</th>
                    <th>Edad maxima</th>
                    </thead>
                    <tbody>
                        <tr class="rows">
                            <%  
                                List<EdadJuego> listaEdades = control.traerEdades();
                                for (EdadJuego edad: listaEdades) {   
                            %> 
                            <%
                            int id = edad.getIdCategoria();
                            int min = edad.getEdadMin();
                            int max = edad.getEdadMax();
                            %>
                            <td id="id<%=id%>"><%=id%></td>
                            <td id="apertura<%=min%>"><%=min%></td>
                            <td id="cierre<%=max%>"><%=max%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </div>
            <div class="crearDiv" id="divJuego">
                <h3 id="headerCliente">Juego</h3>
                <table id="tablaClientes" class="tabla1" id="usu">
                    <thead>
                    <th>Id</th>
                    <th>Horario(id)</th>
                    <th>Edad(id)</th>
                    <th>Nombre</th>
                    <th>Encargados</th>
                    </thead>
                    <tbody>
                        <tr class="rows">
                            <%  
                                List<Juego> listaJuegos = control.traerJuegos();
                                for (Juego juego: listaJuegos) {   
                            %> 
                            <%
                            int id = juego.getIdJuego();
                            int edad = juego.getCategoriaEdad().getIdCategoria();   
                            int horario = juego.getHorario().getIdHorario();
                            String nombre = juego.getNombre();
                            List<Empleado> listaEncargados = juego.getListaEncargados();
                            String encargados = "";
                            for (Empleado encargado: listaEncargados) {
                                encargados = encargados + encargado.getApellido() + ",";
                            }
                            %>
                            <td id="id<%=id%>"><%=id%></td>
                            <td id="edad<%=edad%>"><%=edad%></td>
                            <td id="horario<%=horario%>"><%=horario%></td>
                            <td id="nombre<%=nombre%>"><%=nombre%></td>
                            <td id="encargados<%=encargados%>"><%=encargados%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </div>
            <form action="index.jsp" id="formLectura">
                <input type="submit" value="Volver al inicio">
            </form>
            <form action="lecturaEntradas.jsp" id="formLectura">
                <input type="submit" value="Lectura de entradas">
            </form>
        </div>

        
        
        
        
        
        
        
        
    </body>
</html>
