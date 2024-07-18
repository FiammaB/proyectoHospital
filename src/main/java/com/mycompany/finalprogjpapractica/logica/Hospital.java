
package com.mycompany.finalprogjpapractica.logica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    
    @OneToMany(mappedBy="hospital")
    ArrayList<Doctor> listaDoctores= new ArrayList<>();
    @OneToMany(mappedBy="hospital")
    ArrayList<Paciente> listaPacientes= new ArrayList<>();
    @Basic
    private String nombreHospital;
    private  int codigoHospital;
    public Hospital() {
    }

    public Hospital(String nombreHospital, int codigoHospital) {
        this.nombreHospital = nombreHospital;
        this.codigoHospital = codigoHospital;
    }

    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public int getCodigoHospital() {
        return codigoHospital;
    }

    public void setCodigoHospital(int codigoHospital) {
        this.codigoHospital = codigoHospital;
    }

    public void registrarPaciente(Paciente pac){
        this.listaPacientes.add(pac);
    }
    
    public void registrarDoctor(Doctor doc){
        this.listaDoctores.add(doc);
    }
    
    public void eliminarDoctor(int i){
        this.listaDoctores.remove(i);
    }
    
    public void eliminarPaciente(int i){
        this.listaPacientes.remove(i);
    }
    @Override
    public String toString() {
        return "Hospital{" + "Id=" + id + ", listaDoctores=" + listaDoctores + ", listaPacientes=" + listaPacientes + '}';
    }
    
}
