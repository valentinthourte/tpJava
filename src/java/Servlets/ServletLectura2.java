package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletLectura2", urlPatterns = {"/ServletLectura2"})
public class ServletLectura2 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLectura2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLectura2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        String nombreJuego = request.getParameter("juego");
        Date fecha2 = control.deStringADate(request.getParameter("fecha2"));
        
        HttpSession miSesion = null;
        
        miSesion = request.getSession(true);
        miSesion.setAttribute("tipo", "2");
        miSesion.setAttribute("fecha", fecha2);
        miSesion.setAttribute("juego", nombreJuego);
        
        response.sendRedirect("resultadoEntradas.jsp");
        
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
