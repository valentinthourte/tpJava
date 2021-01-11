package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    int idHorario;
    @Basic
    int horarioApertura;
    int horarioCierre;

    public Horario() {
    }

    public Horario(int idHorario, int horarioApertura, int horarioCierre) {
        this.idHorario = idHorario;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(int horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public int getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(int horarioCierre) {
        this.horarioCierre = horarioCierre;
    }
    
    
}
