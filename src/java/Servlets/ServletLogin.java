package Servlets;

import Logica.Controladora;
import Logica.Usuario;
import Persistencia.ControladoraPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ControladoraPersistencia control = new ControladoraPersistencia();
        List<Usuario> listaUsuarios = control.traerUsuarios();
        String nombre = request.getParameter("username");
        String contra = request.getParameter("pass");
        HttpSession miSesion = null;
        for (Usuario usu: listaUsuarios) {
            if (usu.getNombreUsuario().equals(nombre) && usu.getContrasenia().equals(contra) ) {
                miSesion = request.getSession(true);
                miSesion.setAttribute("usuario", nombre);
                miSesion.setAttribute("contra", contra);
                
                
                response.sendRedirect("index.jsp");
              
            }
            
    }
        if (miSesion == null) {
            response.sendRedirect("LoginError.jsp");
        }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}
}