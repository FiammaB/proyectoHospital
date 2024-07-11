package com.mycompany.finalprogjpapractica.logica;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int cuit;

    @Column
    private String nombre;

    public Persona() {
    }



    public Persona(int cuit, String nombre) {
        this.cuit = cuit;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", cuit=" + cuit + ", nombre=" + nombre + '}';
    }
}
