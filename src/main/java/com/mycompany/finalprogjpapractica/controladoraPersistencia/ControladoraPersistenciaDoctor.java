/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.controladoraPersistencia;

import com.mycompany.finalprogjpapractica.controladora.ControladoraDoctor;
import com.mycompany.finalprogjpapractica.logica.Doctor;
import com.mycompany.finalprogjpapractica.persistencia.DoctorJpaController;
import com.mycompany.finalprogjpapractica.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brizu
 */
public class ControladoraPersistenciaDoctor {
    DoctorJpaController controladoraDoctor = new DoctorJpaController();

    public void crearDoctor(Doctor doctor) {
         controladoraDoctor.create(doctor);    }

    public void editarDoctor(Doctor doctor) {
        try {
            controladoraDoctor.edit(doctor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistenciaDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public void eliminarDoctor(int id) {
        try {
            controladoraDoctor.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistenciaDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public ArrayList<Doctor> buscarTodosDoctores() {
        List<Doctor>listita = controladoraDoctor.findDoctorEntities();
        ArrayList<Doctor>listaDoctores= new ArrayList<Doctor>(listita);
     return  listaDoctores;}

    public Doctor buscarDoctor(int id) {
        return controladoraDoctor.findDoctor(id);  }
  
}
