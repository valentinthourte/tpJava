package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valu
 */
@WebServlet(name = "ServletJuego", urlPatterns = {"/ServletJuego"})
public class ServletJuego extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletJuego</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletJuego at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        String nombre = request.getParameter("nombre");
        int idHora = Integer.parseInt(request.getParameter("hora"));
        String empleados = request.getParameter("emple");
        int categoriaEdad = Integer.parseInt(request.getParameter("edad"));
        
        boolean valido = control.crearJuego(nombre, idHora, empleados, categoriaEdad);
        if (valido) {
            response.sendRedirect("confirmacion.jsp");
        }
        else {
            response.sendRedirect("Error.jsp");
        }
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
