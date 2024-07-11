/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.controladoraPersistencia;

import com.mycompany.finalprogjpapractica.logica.Hospital;
import com.mycompany.finalprogjpapractica.persistencia.EspecialidadJpaController;
import com.mycompany.finalprogjpapractica.persistencia.HospitalJpaController;
import com.mycompany.finalprogjpapractica.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brizu
 */
public class ControladoraPersistenciaHospital {
       HospitalJpaController controller= new HospitalJpaController();
    public ControladoraPersistenciaHospital() {
    }

    public void crearHospital(Hospital h) {
        controller.create(h);
          }

    public void editarHospital(Hospital h) {
       controller.create(h);    }

    public void eliminarHospital(int id) {
           try {
               controller.destroy(id);
           } catch (NonexistentEntityException ex) {
               Logger.getLogger(ControladoraPersistenciaHospital.class.getName()).log(Level.SEVERE, null, ex);
           }
 }

    public ArrayList<Hospital> buscarHospitales() {
        List<Hospital> listita =controller.findHospitalEntities(0, 0);
        ArrayList<Hospital> listaHospitales=new ArrayList<Hospital>(listita);
       return listaHospitales;    }

    public void bucarHospital(int id) {
        controller.findHospital(id);   }
    
}
