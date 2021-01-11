package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora {
    
    ControladoraPersistencia control = new ControladoraPersistencia();
    
    public void crearCliente(String dni, String nombre, String apellido, int edad) {
        Cliente cli = new Cliente();
        cli.setApellido(apellido);
        cli.setDni(dni);
        cli.setEdad(edad);
        cli.setNombre(nombre);
        
        control.crearCliente(cli);
    }
    public void crearEmpleado(String dni, String nombre, String apellido, int edad, String usu) {
        Empleado emple = new Empleado();
        emple.setApellido(apellido);
        emple.setDni(dni);
        emple.setEdad(edad);
        emple.setNombre(nombre);
        
        List<Usuario> listaUsuarios = control.traerUsuarios();
        for (Usuario usuario: listaUsuarios) {
            if(usuario.getNombreUsuario().equals(usu)) {
                emple.setUsuario(usuario);
            }
        }
        
        
        control.crearEmpleado(emple);
    }
    
    


    

    public boolean verificarBaja(String clase, int id) {
        boolean valido = true;
        if (clase.equals("Cliente")) {
            control.eliminarCliente(id);
        }
        else if (clase.equals("EdadJuego")) {
            control.eliminarEdad(id);
        }
        else if(clase.equals("Empleado")) {
            control.eliminarEmpleado(id);
        }
        else if (clase.equals("Entrada")) {
            control.eliminarEntrada(id);        
        }
        else if (clase.equals("Horario")) {
            control.eliminarHorario(id);
        }
        else if (clase.equals("Juego")) {
            control.eliminarJuego(id);
        }
        else if (clase.equals("Usuario")) {
            control.eliminarUsuario(id);
        }
        else {
            valido = false;
        }
        return valido;
        
    }

    public boolean verificarEdicion(String tipo, int id, String nombre, String apellido, int edad, String dni) {
        boolean valido = false;
        if (tipo.equals("Cliente")){
        Cliente clienteAEditar = control.traerUnCliente(id);
        if(clienteAEditar != null) {
            if (!nombre.equals("")) {
                clienteAEditar.setNombre(nombre);
            }
            if (!apellido.equals("")) {
                clienteAEditar.setApellido(apellido);
            }
            if (edad != 0) {
                clienteAEditar.setEdad(edad);
            }
            if (!dni.equals("")) {
                clienteAEditar.setDni(dni);
            }
            valido = true;
            control.editarCliente(clienteAEditar);
            }
        }
        else if (tipo.equals("Usuario")){
            Usuario usuarioEditar = control.traerUnUsuario(id);
            if (!nombre.equals("")) {
                usuarioEditar.setNombreUsuario(nombre);
            }
            if (!apellido.equals("")) {
                usuarioEditar.setContrasenia(apellido);
            }
            control.editarUsuario(usuarioEditar);
            valido = true;
        
        }
        
        
        
        
        
        
        
        
        
        return valido;
        
        
    }
    
    public List<Cliente> traerClientes() {
        return(control.traerClientes());
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

    public List<Juego> traerJuegos() {
        return control.traerJuegos();
    }

    public void crearEntrada(int categoriaHorario, Date fecha, Juego juego, Cliente responsable) {
        
        Entrada entrada = new Entrada();
        entrada.setCliente(responsable);
        entrada.setFecha(fecha);
        entrada.setHorario(categoriaHorario);
        entrada.setJuego(juego);
        control.crearEntrada(entrada);

    }

    public List<Horario> traerHorarios() {
        return control.traerHorarios();
    }


    public void crearUsuario(String nombre, String contra) {
        Usuario usu = new Usuario();
        usu.setContrasenia(contra);
        usu.setNombreUsuario(nombre);
        
        control.crearUsuario(usu);

    }

    public boolean crearJuego(String nombre, int idHora, String empleados, int categoriaEdad) {
        boolean valido = true;
        Juego juego = new Juego();
        juego.setNombre(nombre);
        List<Horario> listaHorarios = control.traerHorarios();
        Horario horarioEnviar = null;
        for (Horario hora: listaHorarios) {
            if (hora.getIdHorario() == idHora) {
                horarioEnviar = hora;
            }
        }
        EdadJuego edadEnviar = null;
        List<EdadJuego> edades= control.traerEdades();
        for (EdadJuego edad: edades) {
            if (edad.getIdCategoria() == categoriaEdad) {
                edadEnviar = edad;
            }
        }
        String coma = ",";
        boolean tieneComa = empleados.contains(coma);
        List<Empleado> arrayEmple = control.traerEmpleados();
        List<Empleado> listaEnviar = new ArrayList<>();
        if (!empleados.equals("")) {
            if (tieneComa) {
                String[] listaEmpleados = empleados.split("[,]",0);
                for (Empleado emple: arrayEmple) {
                    for (String empleado: listaEmpleados) {
                        int idEmple = emple.getIdEmpleado();
                        if (idEmple == Integer.parseInt(empleado)) {
                            listaEnviar.add(emple);
                        }
                    }
                }   
            }

            else {
               for (Empleado emple: arrayEmple) {
                   if (emple.getIdEmpleado() == Integer.parseInt(empleados)) {
                       listaEnviar.add(emple);
                   }
               }
            }
            juego.setListaEncargados(listaEnviar);
        }
        else {
            valido = false;
        }
        if (horarioEnviar != null && edadEnviar != null) {
            juego.setHorario(horarioEnviar);
            juego.setCategoriaEdad(edadEnviar);
        }
        else {
            valido = false;
        }
        
       control.crearJuego(juego);
       return valido;
    }

    public void crearHorario(int apertura, int cierre) {
        Horario horario = new Horario();
        horario.setHorarioApertura(apertura);
        horario.setHorarioCierre(cierre);

        control.crearHorario(horario);
        
        

    }

    public void crearEdad(int edadMin, int edadMax) {
        EdadJuego edad = new EdadJuego();
        edad.setEdadMax(edadMax);
        edad.setEdadMin(edadMin);
        
        control.crearEdad(edad);
    }
    
    public List<Usuario> traerUsuarios() {
        return control.traerUsuarios();
    }
    public List<Empleado> traerEmpleados() {
        return control.traerEmpleados();
    }
    
    public List<EdadJuego> traerEdades() {
        return control.traerEdades();
    }

    public static String DateAString(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatoFecha.format(fecha);
    }
    
    public List<Entrada> traerEntradas() {
    return control.traerEntradas();
}

    
    public Entrada traerUnaEntrada(int id) {
        return control.traerUnaEntrada(id);
    }

    



    public boolean editarCliente(String intIdCli, String nombre, String apellido, String edad, String dni) {
        boolean valido = false;
        Cliente cli = control.traerUnCliente(Integer.parseInt(intIdCli));
        if (!nombre.equals("")) {
            cli.setNombre(nombre);
            valido = true;
        }
        if (!apellido.equals("")) {
            cli.setApellido(apellido);
            valido = true;
        }
        if (!edad.equals("")) {
            cli.setEdad(Integer.parseInt(edad));
            valido = true;
        }
        if (!dni.equals("")) {
            cli.setDni(dni);
            valido = true;
        }
        control.editarCliente(cli);
        return valido;
        




    }

    public String verificarTipo(String idUsu, String idCli, String idEmple, String idJuego, String idEdad, String idHorario, String idEntrada) {
        String devolver = "";
        if (idUsu != null) {
            devolver = "Usuario";
        }
        else if (idCli != null) {
            devolver = "Cliente";
        }
        else if (idEmple != null) {
            devolver = "Empleado";
        }
        else if (idJuego != null) {
            devolver = "Juego";
        }
        else if (idEdad != null) {
            devolver = "Edad";
        }
        else if (idHorario != null) {
            devolver = "Horario";
        }
        else if (idEntrada != null) {
            devolver = "Entrada";
        }
        return devolver;




    }

    public boolean editarUsuario(String idUsu, String nombreUsuario, String contra) {
        Usuario usu = control.traerUnUsuario(Integer.parseInt(idUsu));
        boolean valido = false;
        if (usu != null) {
            if (!nombreUsuario.equals("")) {
                usu.setNombreUsuario(nombreUsuario);
                valido = true;
            }
            if (!contra.equals("")) {
                usu.setContrasenia(contra);
                valido = true;
            }
            control.editarUsuario(usu);
            
        }  
        return valido;
    }

    public boolean editarEmpleado(String idEmple, String nombre, String apellido, String edadString, String dni, String nombreUsuario, String contra) {
        Empleado emple = control.traerUnEmpleado(Integer.parseInt(idEmple));
        boolean valido = false;
        if (emple != null) {
                    Usuario usuEmple = emple.getUsuario();
            if (!nombre.equals("")) {
                emple.setNombre(nombre);
                valido = true;
            }
            if (!apellido.equals("")) {
                emple.setApellido(apellido);
                valido = true;
            }
            if (!edadString.equals("")) {
                emple.setEdad(Integer.parseInt(edadString));
                valido = true;
            }
            if (!dni.equals("")) {
                emple.setDni(dni);
                valido = true;
            }
            if (!nombreUsuario.equals("")) {
                usuEmple.setNombreUsuario(nombreUsuario);
                valido = true;
            }
            if (!contra.equals("")) {
                usuEmple.setContrasenia(contra);
                valido = true;
            }
            emple.setUsuario(usuEmple);
            control.editarEmpleado(emple);}
        return valido;
    }

    public boolean editarEntrada(String idEntrada, String horario, String fecha, String juego, String dni) {
        Entrada entre = control.traerUnaEntrada(Integer.parseInt(idEntrada));
        boolean valido = false;
        if (entre != null) {
            if (!horario.equals("") && fecha.length() == 10) {
                entre.setHorario(Integer.parseInt(horario));
                valido = true;
            }
            if (!fecha.equals("") && fecha.length() == 10) {
                String[] fechaEditada = fecha.split("[-]",0);
                String fechaFinal = "";

                for(int i =  fechaEditada.length- 1;i>=0;i--) {
                    fechaFinal = fechaFinal + fechaEditada[i] + "-";
                }
                fechaFinal = fechaFinal.substring(0, fechaFinal.length() - 1);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaEnviar;
                try {
                    fechaEnviar = df.parse(fechaFinal);
                    entre.setFecha(fechaEnviar);
                } catch (ParseException ex) {
                    Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
                }    
                valido = true;
            }
            if (!juego.equals("")) {
                Juego juegoEnviar = control.traerUnJuego(Integer.parseInt(juego));
                if (juegoEnviar != null) {
                    entre.setJuego(juegoEnviar);
                    valido = true;
                }
            }
            if (!dni.equals("")) {
                List<Cliente> listaClientes = control.traerClientes();
                Cliente responsable = null;
                for (Cliente cli: listaClientes) {
                    if (cli.getDni().equals(dni)) {
                        responsable = cli;
                    }
                }
                if (responsable != null) {
                    entre.setCliente(responsable);
                    valido = true;
                }
                
            }          
        }
        control.editarEntrada(entre);
        return valido;
    }


    public boolean editarJuego(String idJuego, String nombreJuego, String edadJuego, String horarioJuego, String empleadosJuego) {
        Juego juego = control.traerUnJuego(Integer.parseInt(idJuego));
        boolean valido = false;
        if (juego != null) {
            if (!nombreJuego.equals("")) {
                juego.setNombre(nombreJuego);
                valido = true;
            }
            if (!edadJuego.equals("")) {
                EdadJuego categoriaEdad = control.traerUnaEdad(Integer.parseInt(edadJuego));
                juego.setCategoriaEdad(categoriaEdad);
                valido = true;
            }
            if (!horarioJuego.equals("")) {
                Horario horario = control.traerUnHorario(Integer.parseInt(horarioJuego));
                juego.setHorario(horario);
                valido = true;
            }
            if (!empleadosJuego.equals("")) {
                List<Empleado> listaEmpleados = control.traerEmpleados();
                List<Empleado> listaEncargados = new ArrayList<Empleado>();
                String coma = ",";
                boolean tieneComa = empleadosJuego.contains(coma);
                if (tieneComa) {
                    String[] listaEmpleadosPartida   = empleadosJuego.split("[,]",0);
                    for (Empleado emple: listaEmpleados) {
                        for (String empleado: listaEmpleadosPartida) {
                            int idEmple = emple.getIdEmpleado();
                            if (idEmple == Integer.parseInt(empleado)) {
                                listaEncargados.add(emple);
                            }
                        }
                    }   
                }

                else {
                   for (Empleado emple: listaEmpleados) {
                       if (emple.getIdEmpleado() == Integer.parseInt(empleadosJuego)) {
                           listaEncargados.add(emple);
                       }
                   }
                }
                juego.setListaEncargados(listaEncargados);
                valido = true;
            }
        }
        control.editarJuego(juego);
        return valido;
    }

    public boolean editarEdad(String idEdad, String edadMin, String edadMax) {
        boolean valido = false;
        EdadJuego edad = control.traerUnaEdad(Integer.parseInt(idEdad));
        if (!edadMin.equals("")){
            edad.setEdadMin(Integer.parseInt(edadMin));
            valido = true;
        }
        if (!edadMax.equals("")){
            edad.setEdadMax(Integer.parseInt(edadMax));
            valido = true;
        }
        
        control.editarEdad(edad);
        return valido;
    }

    public boolean editarHorario(String idHorario, String horaApertura, String horaCierre) {
        boolean valido = false;
        Horario hora = control.traerUnHorario(Integer.parseInt(idHorario));
        if (!horaApertura.equals("")){
            hora.setHorarioApertura(Integer.parseInt(horaApertura));
            valido = true;
        }
        if (!horaCierre.equals("")){
            hora.setHorarioCierre(Integer.parseInt(horaCierre));
            valido = true;
        }
        
        control.editarHorario(hora);
        return valido;
    }

    
    

} 
