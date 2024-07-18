/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.controladora;

import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaDoctor;
import com.mycompany.finalprogjpapractica.logica.Doctor;
import com.mycompany.finalprogjpapractica.persistencia.DoctorJpaController;
import java.util.ArrayList;

/**
 *
 * @author brizu
 */
public class ControladoraDoctor {
        ControladoraPersistenciaDoctor controladora = new ControladoraPersistenciaDoctor();

   
    public  void crearDoctor(Doctor doctor){
    controladora.crearDoctor(doctor);}
    
    public  void editarDoctor(Doctor doctor){
    controladora.editarDoctor(doctor);}
    
    public  void eliminarDoctor(int id){
    controladora.eliminarDoctor(id);}
    
    public  ArrayList<Doctor>buscarTodosDoctores(){
    return controladora.buscarTodosDoctores();}
     
    public  Doctor buscarDoctor(int id){
    return controladora.buscarDoctor(id);}
    

  


}
