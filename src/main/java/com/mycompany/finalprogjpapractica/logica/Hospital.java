
package com.mycompany.finalprogjpapractica.logica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
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

    public Hospital() {
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

    @Override
    public String toString() {
        return "Hospital{" + "Id=" + id + ", listaDoctores=" + listaDoctores + ", listaPacientes=" + listaPacientes + '}';
    }
    
}
