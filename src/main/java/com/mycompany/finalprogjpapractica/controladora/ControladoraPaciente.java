/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.controladora;

import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaHospital;
import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaPaciente;
import com.mycompany.finalprogjpapractica.logica.Hospital;
import com.mycompany.finalprogjpapractica.logica.Paciente;
import com.mycompany.finalprogjpapractica.persistencia.PacienteJpaController;
import java.util.ArrayList;

/**
 *
 * @author brizu
 */
public class ControladoraPaciente {
    ControladoraPersistenciaPaciente controladora= new ControladoraPersistenciaPaciente();
        
    public  void crearPaciente(Paciente  p){
    controladora.crearPaciente(p);}
    
    public  void editarPaciente(Paciente p){
    controladora.editarHospital(p);}
    
    public  void eliminarPaciente(int id){
    controladora.eliminarPaciente(id);}
    
    public  ArrayList<Paciente>buscarPacientes(){
    return controladora.buscarPacientes();}
     
    public  Paciente buscarPaciente(int id){
    return controladora.bucarPaciente(id);}
}

