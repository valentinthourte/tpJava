package Persistencia;

import Logica.Cliente;
import Logica.EdadJuego;
import Logica.Empleado;
import Logica.Entrada;
import Logica.Horario;
import Logica.Juego;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    ClienteJpaController clienteJpa = new ClienteJpaController();
    EmpleadoJpaController empleJpa = new EmpleadoJpaController();
    EntradaJpaController entradaJpa = new EntradaJpaController();
    HorarioJpaController horarioJpa = new HorarioJpaController();
    JuegoJpaController juegoJpa = new JuegoJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    EdadJuegoJpaController edadJpa = new EdadJuegoJpaController();
    
    public void crearCliente (Cliente cliente) {
        try {
            clienteJpa.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarCliente (int id) {
        try {
            clienteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarCliente (Cliente cli) {
        try {
            clienteJpa.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Cliente> traerClientes () {
        List<Cliente> listaClientes = clienteJpa.findClienteEntities();
        return listaClientes;
    }
    
    public Cliente traerUnCliente (int id) {
        Cliente cli = clienteJpa.findCliente(id);
        return cli;
    }
    public void crearEmpleado (Empleado emple) {
        empleJpa.create(emple);
    }
    public void eliminarEmpleado (int id) {
        try {
            empleJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarEmpleado(Empleado emple) {
        try {
            empleJpa.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Empleado> traerEmpleados () {
        List<Empleado> listaEmpleados = empleJpa.findEmpleadoEntities();
        return listaEmpleados;
    }
    
    public Empleado traerUnEmpleado (int id) {
        Empleado emple = empleJpa.findEmpleado(id);
        return emple;
    }
    
    public void crearEntrada (Entrada entre) {
        entradaJpa.create(entre);
    }
    public void eliminarEntrada (int id) {
        try {
            entradaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarEntrada(Entrada entra) {
        try {
            entradaJpa.edit(entra);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Entrada> traerEntradas() {
        List<Entrada> listaEntradas = entradaJpa.findEntradaEntities();
        return listaEntradas;
    }
    
    public Entrada traerUnaEntrada(int id) {
        Entrada entrada = entradaJpa.findEntrada(id);
        return entrada;
    } 
    public void crearHorario (Horario horario) {
        horarioJpa.create(horario);
    }
    public void eliminarHorario (int id) {
        try {
            horarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarHorario(Horario hora) {
        try {
            horarioJpa.edit(hora);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Horario> traerHorarios() {
        List<Horario> listaHorarios =  horarioJpa.findHorarioEntities();
        return listaHorarios;
    }
    public Horario traerUnHorario(int id) {
        Horario hora = horarioJpa.findHorario(id);
        return hora;
    }
    
    public void crearJuego (Juego juego) {
        juegoJpa.create(juego);
    }
    public void eliminarJuego (int id) {
        try {
            juegoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarJuego(Juego juego) {
        try {
            juegoJpa.edit(juego);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Juego> traerJuegos() {
        List<Juego> listaJuegos = juegoJpa.findJuegoEntities();
        return listaJuegos;
    }
    public Juego traerUnJuego(int id) {
        Juego jueg = juegoJpa.findJuego(id);
        return jueg;
    }
    
    public void crearUsuario (Usuario usu) {
        usuJpa.create(usu);
    }
    public void eliminarUsuario (int id) {
        try {
            usuJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Usuario> traerUsuarios() {
        List<Usuario> listaUsuarios = usuJpa.findUsuarioEntities();
        return listaUsuarios;
    }
    public Usuario traerUnUsuario(int id) {
        Usuario usuario = usuJpa.findUsuario(id);
        return usuario;
    }
    
    public void crearEdad (EdadJuego cat) {
        edadJpa.create(cat);
    }
    public void eliminarEdad(int id) {
        try {
            edadJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarEdad(EdadJuego edadJuego) {
        try {
            edadJpa.edit(edadJuego);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<EdadJuego> traerEdades() {
        List<EdadJuego> listaEdades = edadJpa.findEdadJuegoEntities();
        return listaEdades;
    }
    public EdadJuego traerUnaEdad(int id) {
        EdadJuego edad = edadJpa.findEdadJuego(id);
        return edad;
    }
    
    public static synchronized java.util.Date deStringADate(String fecha) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        }
        catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    
}
