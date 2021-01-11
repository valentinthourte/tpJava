package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Juego implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    int idJuego;
    
    @OneToOne
    EdadJuego categoriaEdad;
    @Basic
    String nombre;
    @OneToOne
    Horario horario;
    @OneToMany
    List<Empleado> listaEncargados = new ArrayList<Empleado>();

    public Juego() {
    }

    public Juego(int idJuego, EdadJuego categoriaEdad, String nombre, Horario horario) {
        this.idJuego = idJuego;
        this.categoriaEdad = categoriaEdad;
        this.nombre = nombre;
        this.horario = horario;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public EdadJuego getCategoriaEdad() {
        return categoriaEdad;
    }

    public void setCategoriaEdad(EdadJuego categoriaEdad) {
        this.categoriaEdad = categoriaEdad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Empleado> getListaEncargados() {
        return listaEncargados;
    }

    public void setListaEncargados(List<Empleado> listaEncargados) {
        this.listaEncargados = listaEncargados;
    }
    
    
    
    
    
}
