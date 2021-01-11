package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.objects.NativeString.trim;


@WebServlet(name = "ServletBaja", urlPatterns = {"/ServletBaja"})
public class ServletBaja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletBaja</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletBaja at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        Controladora control = new Controladora();
        String clase = (String) request.getParameter("clase");
        int id = Integer.parseInt(request.getParameter("idBaja"));
        
        boolean esValido = control.verificarBaja(clase, id);
        if (esValido) {
            response.sendRedirect("confirmacion.jsp");
        }
        else {
            response.sendRedirect("Error.jsp");
        }
        
        
        
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
