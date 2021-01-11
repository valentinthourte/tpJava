<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Juego"%>
<%@page import="Logica.Entrada"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

    </head>
    <body>
        <%
        Controladora control = new Controladora();    
        HttpSession miSesion = request.getSession();
        String tipo = (String) miSesion.getAttribute("tipo");   
        Date date = (Date) miSesion.getAttribute("fecha");
        String fecha = control.DateAString(date);
        String[] fechaEditada = fecha.split("[-]",0);
        String fechaFinal = "";
        
        for(int i =  fechaEditada.length- 1;i>=0;i--) {
            fechaFinal = fechaFinal + fechaEditada[i] + "-";
        }
        fechaFinal = fechaFinal.substring(0, fechaFinal.length() - 1);
        String juego = (String) miSesion.getAttribute("juego");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<Entrada> listaEntradas = control.traerEntradas();
        if (tipo.equals("1")) {
        %><h1>Cantidad de entradas vendidas para la fecha <%=fecha%></h1>
            <%
            int count = 0;
            
            for (Entrada entre: listaEntradas) {
                Date fechaEntrada = entre.getFecha();
                Date fechaEnviar = df.parse(fechaFinal);
                if(fechaEntrada.compareTo(fechaEnviar) == 0) {
                    count += 1;
                }
            }
            %>
            <div>
                La cantidad de entradas vendidas para la fecha <%=fecha%> es <%=count%>
            </div>
            
            
            
        <%}%>
        <%
            if (tipo.equals("2")) {
                %><h1>Cantidad de entradas vendidas para la fecha <%=fecha%></h1>
            <%
                int contador = 0;
                Date date2 = (Date) request.getAttribute("fecha");
                for (Entrada entrada: listaEntradas) {
                    if(entrada.getJuego().getNombre().equals(juego)) {
                        Date fechaEntrada = entrada.getFecha();
                        Date fechaEnviar = df.parse(fechaFinal);
                        if(fechaEntrada.compareTo(fechaEnviar) == 0) {
                            contador += 1;
                        }
                    }   
            }
        %>
        <div>
            La cantidad de entradas vendidas para la fecha <%=fecha%> del juego <%=juego%> es <%=contador%>
        </div>
    <%}%>
    <form action="index.jsp">
        <input type="submit" value="Volver al inicio">
    </form>
    </body>
</html>
