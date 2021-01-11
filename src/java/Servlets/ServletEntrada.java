package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import Logica.Horario;
import Logica.Juego;    
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletEntrada", urlPatterns = {"/ServletEntrada"})
public class ServletEntrada extends HttpServlet {

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
            out.println("<title>Servlet ServletEntrada</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEntrada at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();
        int horaDeseada = Integer.parseInt(request.getParameter("hora"));
        Date fecha = control.deStringADate(request.getParameter("fecha"));
        String nombreJuego = request.getParameter("juego");
        String dni = request.getParameter("dni");
        
        boolean valido = true;
        List<Cliente> listaClientes = control.traerClientes();
        List<Juego> listaJuegos = control.traerJuegos();
        Juego juego = null;
        for (Juego jueg: listaJuegos) {
            if (jueg.getNombre().equals(nombreJuego)) {
                juego = jueg;
            }
        }
        Cliente responsable = null;
        for (Cliente cli: listaClientes) {
            if(cli.getDni().equals(dni)) {
                responsable = cli;
            }
        }
        if (juego != null && responsable != null) {
            Horario hora = juego.getHorario();
            int horarioApertura = hora.getHorarioApertura();
            int horarioCierre = hora.getHorarioCierre();
            
            int edadMin = juego.getCategoriaEdad().getEdadMin();
            int edadMax = juego.getCategoriaEdad().getEdadMax();
            int edad = responsable.getEdad();
            
            
            if (horarioApertura < horaDeseada && horaDeseada < horarioCierre) {
                if(edadMin < edad && edad < edadMax) {
                    control.crearEntrada(horaDeseada, fecha, juego, responsable);
                }
            }
            else {
                valido = false;
            }
        }
        else {
            valido = false;
        }
        
        if (valido) {
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
