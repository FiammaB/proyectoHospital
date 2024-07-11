
package com.mycompany.finalprogjpapractica.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Doctor extends Persona implements Serializable {
    
    @Basic
    private  int matricula;
    @OneToOne
    private Especialidad especialidad;
    @ManyToOne
    private Hospital hospital;

    public Doctor(int cuit, String nombre) {
        super(cuit, nombre);
    }

    public Doctor(int matricula, Especialidad especialidad, Hospital hospital, int cuit, String nombre) {
        super( cuit, nombre);
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.hospital = hospital;
    }

    public Doctor(int matricula, Especialidad especialidad, Hospital hospital) {
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.hospital = hospital;
    }

    public Doctor() {
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Doctor{" + "matricula=" + matricula + ", especialidad=" + especialidad + ", hospital=" + hospital + '}';
    }



}
