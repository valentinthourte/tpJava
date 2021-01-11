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

@WebServlet(name = "ServletLecturaEntrada", urlPatterns = {"/ServletLecturaEntrada"})
public class ServletLecturaEntrada extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLecturaEntrada</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLecturaEntrada at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        
        Date fecha = control.deStringADate(request.getParameter("fecha"));
        
        HttpSession miSesion = null;

        
        
        miSesion = request.getSession(true);
        miSesion.setAttribute("fecha", fecha);
        miSesion.setAttribute("tipo", "1");
        response.sendRedirect("resultadoEntradas.jsp");
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
