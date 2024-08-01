/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.controladoraPersistencia;

import com.mycompany.finalprogjpapractica.logica.Paciente;
import com.mycompany.finalprogjpapractica.logica.RevicionMedica;
import com.mycompany.finalprogjpapractica.persistencia.RevicionMedicaJpaController;
import com.mycompany.finalprogjpapractica.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brizu
 */
public class ControladoraPersistenciaRevicionMedica {
    RevicionMedicaJpaController controller =new RevicionMedicaJpaController();
   

    public void crearRevicionMedica(RevicionMedica m) {
        controller.create(m);
          }

    public void editarRevicionMedica(RevicionMedica m) {
        try {
            controller.edit(m);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistenciaRevicionMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public void eliminarRevicionMedica(int id) {
        try {
            controller.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistenciaRevicionMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public ArrayList<RevicionMedica> buscarRevicionesMedicas() {
        List<RevicionMedica> listita= controller.findRevicionMedicaEntities(); 
        ArrayList<RevicionMedica> listaRevicionesMedicas=new ArrayList<RevicionMedica>(listita);
        return listaRevicionesMedicas;
    }

    public RevicionMedica bucarRevicionMedica(int id) {
       return controller.findRevicionMedica(id);  }
    
}
