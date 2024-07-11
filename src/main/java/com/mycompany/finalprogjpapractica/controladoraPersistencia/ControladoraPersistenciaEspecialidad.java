/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.controladoraPersistencia;

import com.mycompany.finalprogjpapractica.logica.Especialidad;
import com.mycompany.finalprogjpapractica.persistencia.EspecialidadJpaController;
import com.mycompany.finalprogjpapractica.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brizu
 */
public class ControladoraPersistenciaEspecialidad {
    EspecialidadJpaController controller = new EspecialidadJpaController();
    public void crearEspecialidad(Especialidad e) {
        controller.create(e);
        }

    public void editarDoctor(Especialidad especialidad) {
        try {
            controller.edit(especialidad);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistenciaEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public void eliminarEspecialidad(int id) {
        try {
            controller.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistenciaEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public ArrayList<Especialidad> buscarTodasEspecialidad() {
        List<Especialidad> listita =controller.findEspecialidadEntities();
        ArrayList<Especialidad> listaEspecialidades=new ArrayList<Especialidad>(listita);
       return listaEspecialidades; }

    public void buscarEspecialidad(int id) {
        controller.findEspecialidad(id);   }
    
}
