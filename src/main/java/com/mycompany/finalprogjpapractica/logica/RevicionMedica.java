
package com.mycompany.finalprogjpapractica.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RevicionMedica implements Serializable {
   @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   @Basic
   private int codigo;
   @Temporal(TemporalType.DATE)
   private Date fecha;

    public RevicionMedica(int id, int codigo, Date fecha) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
    }

    public RevicionMedica() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "RevicionMedica{" + "id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + '}';
    }
   
}
