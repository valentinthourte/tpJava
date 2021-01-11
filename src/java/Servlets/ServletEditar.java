package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletEditar", urlPatterns = {"/ServletEditar"})
public class ServletEditar extends HttpServlet {

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
            out.println("<title>Servlet ServletEditar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEditar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Controladora control = new Controladora();
        

        String dniEmple = request.getParameter("dni");
        String idUsu = request.getParameter("idUsu");
        String idCli = request.getParameter("id");
        String idEmple = request.getParameter("idEmple");
        String idJuego = request.getParameter("idJuego");
        String idEdad = request.getParameter("idEdad");
        String idHorario = request.getParameter("idHorario");
        String idEntrada = request.getParameter("idEntrada");
        
        
        boolean esValido;
        String tipo = control.verificarTipo(idUsu, idCli, idEmple, idJuego, idEdad, idHorario, idEntrada);
        if (!tipo.equals("")) {
            if (tipo.equals("Cliente")) {
                if (!idCli.equals("")) {
                    int edad = 0;
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String edadString = request.getParameter("edad");
                    String dni = request.getParameter("dni");
                    esValido = control.editarCliente(idCli, nombre, apellido, edadString, dni);
                    if (esValido) {
                        response.sendRedirect("confirmacion.jsp");
                    }
                    else {
                        response.sendRedirect("Error.jsp");
                    }
                }
                else {
                    response.sendRedirect("Error.jsp");
                }

            }



            else if (tipo.equals("Usuario")) {
                if (!request.getParameter("idUsu").equals("")) {
                    String nombreUsuario = request.getParameter("nombreUsuario");
                    String contra = request.getParameter("contra");
                    esValido = control.editarUsuario(idUsu, nombreUsuario, contra);
                    if (esValido) {
                    response.sendRedirect("confirmacion.jsp");
                    }
                    else {
                        response.sendRedirect("Error.jsp");
                    }
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (tipo.equals("Empleado")) {
                if (!idEmple.equals("")) {
                    String nombre = request.getParameter("nombreE");
                    String apellido = request.getParameter("apellidoE");
                    String edadString = request.getParameter("edadE");
                    String dni = request.getParameter("dniE");
                    String nombreUsuario = request.getParameter("nombreUsuarioE");
                    String contra = request.getParameter("contraE");

                    esValido = control.editarEmpleado(idEmple, nombre, apellido, edadString, dni, nombreUsuario, contra);

                    if (esValido) {
                        response.sendRedirect("confirmacion.jsp");
                    }
                    else {
                        response.sendRedirect("Error.jsp");
                    }
                }
            }
            else if (tipo.equals("Entrada")) {
                if (!idEntrada.equals("")) {
                    String horario = request.getParameter("hora");
                    String fecha = request.getParameter("fecha");
                    String juego = request.getParameter("juego");
                    String dni = request.getParameter("dniC");

                    esValido = control.editarEntrada(idEntrada, horario, fecha, juego, dni);

                    if (esValido) {
                        response.sendRedirect("confirmacion.jsp");
                    }
                    else {
                        response.sendRedirect("Error.jsp");
                    }
                }  
            }
            else if (tipo.equals("Juego")) {
                if (!idJuego.equals("")) {
                    String nombreJuego = request.getParameter("nombreJ");
                    String edadJuego = request.getParameter("edadJ");
                    String horarioJuego = request.getParameter("horaJ");
                    String empleadosJuego = request.getParameter("empleJ");

                    esValido = control.editarJuego(idJuego, nombreJuego, edadJuego, horarioJuego, empleadosJuego);

                    if (esValido) {
                        response.sendRedirect("confirmacion.jsp");
                    }
                    else {
                        response.sendRedirect("Error.jsp");
                    }
                }
            }
            else if (tipo.equals("Edad")) {
                String edadMin = request.getParameter("edadMin");
                String edadMax = request.getParameter("edadMax");

                esValido = control.editarEdad(idEdad, edadMin, edadMax);

                if (esValido) {
                    response.sendRedirect("confirmacion.jsp");
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
            }
            else if (tipo.equals("Horario")) {
                String horaApertura = request.getParameter("horaApertura");
                String horaCierre = request.getParameter("horaCierre");

                esValido = control.editarHorario(idHorario, horaApertura, horaCierre);

                if (esValido) {
                    response.sendRedirect("confirmacion.jsp");
                }
                else {
                    response.sendRedirect("Error.jsp");
                }
            }
            else {
                response.sendRedirect("Error.jsp");
            }




        }
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
