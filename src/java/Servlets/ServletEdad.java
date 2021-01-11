package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletEdad", urlPatterns = {"/ServletEdad"})
public class ServletEdad extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletEdad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEdad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        int edadMin = Integer.parseInt(request.getParameter("min"));
        int edadMax = Integer.parseInt(request.getParameter("max"));
        
        control.crearEdad(edadMin, edadMax);
        
        response.sendRedirect("confirmacion.jsp");
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
