/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.controladoraPersistencia;

import com.mycompany.finalprogjpapractica.logica.Especialidad;
import com.mycompany.finalprogjpapractica.logica.Paciente;
import com.mycompany.finalprogjpapractica.persistencia.PacienteJpaController;
import com.mycompany.finalprogjpapractica.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brizu
 */
public class ControladoraPersistenciaPaciente {
        PacienteJpaController controller = new PacienteJpaController();
    public void crearPaciente(Paciente p) {
        controller.create(p);
           }

    public void editarHospital(Paciente p) {
            try {
                controller.edit(p);
            } catch (Exception ex) {
                Logger.getLogger(ControladoraPersistenciaPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
 }

    public void eliminarPaciente(int id) {
            try {
                controller.destroy(id);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladoraPersistenciaPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
 }

    public ArrayList<Paciente> buscarPacientes() {
            List<Paciente> listita =controller.findPacienteEntities();
        ArrayList<Paciente> listaPacientes=new ArrayList<Paciente>(listita);
       return listaPacientes;    }

    public void bucarPaciente(int id) {
        controller.findPaciente(id);   }
    
}
