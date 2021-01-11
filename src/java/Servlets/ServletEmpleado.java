package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletEmpleado", urlPatterns = {"/ServletEmpleado"})
public class ServletEmpleado extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String dni = request.getParameter("dni");
        String nombreUsuario = request.getParameter("usu");
        
        control.crearEmpleado(dni, nombre, apellido, edad, nombreUsuario);
        
        response.sendRedirect("confirmacion.jsp");
        
        
        
        
        
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
