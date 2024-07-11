
package com.mycompany.finalprogjpapractica.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente extends  Persona implements Serializable{
    private int codigoPaciente;
    private Date fechaInternacion;
    @ManyToOne
    private Hospital hospital ;
    @OneToOne
    private RevicionMedica revicionMedica ;

    public Paciente(int codigoPaciente, Date fechaInternacion, Hospital hospital, RevicionMedica revicionMedica, int cuit, String nombre) {
        super(cuit, nombre);
        this.codigoPaciente = codigoPaciente;
        this.fechaInternacion = fechaInternacion;
        this.hospital = hospital;
        this.revicionMedica = revicionMedica;
    }

    public Paciente(int codigoPaciente, Date fechaInternacion, Hospital hospital, RevicionMedica revicionMedica) {
        this.codigoPaciente = codigoPaciente;
        this.fechaInternacion = fechaInternacion;
        this.hospital = hospital;
        this.revicionMedica = revicionMedica;
    }

   
 
    public Paciente() {
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public RevicionMedica getRevicionMedica() {
        return revicionMedica;
    }

    public void setRevicionMedica(RevicionMedica revicionMedica) {
        this.revicionMedica = revicionMedica;
    }

    @Override
    public String toString() {
        return "Paciente{" + "codigoPaciente=" + codigoPaciente + ", fechaInternacion=" + fechaInternacion + ", hospital=" + hospital + ", revicionMedica=" + revicionMedica + '}';
    }
    
}
