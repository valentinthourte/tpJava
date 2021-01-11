package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    int idEntrada;

    @Basic
    int horario;
    @Temporal(TemporalType.DATE)
    Date fecha;
    
    @OneToOne
    Juego juego;
    @OneToOne
    Cliente cliente;

    public Entrada() {
    }

    public Entrada(int idEntrada, int horario, Date fecha, Juego juego, Cliente cliente) {
        this.idEntrada = idEntrada;
        this.horario = horario;
        this.fecha = fecha;
        this.juego = juego;
        this.cliente = cliente;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
