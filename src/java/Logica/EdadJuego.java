package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EdadJuego implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    int idCategoria;
    
    @Basic
    int edadMin;
    int edadMax;

    public EdadJuego() {
    }

    public EdadJuego(int idCategoria, int edadMin, int edadMax) {
        this.idCategoria = idCategoria;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(int edadMax) {
        this.edadMax = edadMax;
    }
    
    
    
}
