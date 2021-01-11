package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    int idEmpleado;
    @Basic
    String dni;
    String nombre;
    String apellido;
    int edad;
    
    
    
    @OneToOne
    Usuario usuario;
    

    public Empleado() {
    }

    public Empleado(int idEmpleado, String dni, String nombre, String apellido, int edad, Usuario usuario) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.usuario = usuario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    
}