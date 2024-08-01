/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.controladora;

import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaRevicionMedica;
import com.mycompany.finalprogjpapractica.logica.Paciente;
import com.mycompany.finalprogjpapractica.logica.RevicionMedica;
import com.mycompany.finalprogjpapractica.persistencia.RevicionMedicaJpaController;
import java.util.ArrayList;

/**
 *
 * @author brizu
 */
public class ControladoraRevicionMedica {
    ControladoraPersistenciaRevicionMedica controladora =new ControladoraPersistenciaRevicionMedica();
        public  void crearRevicionMedica(RevicionMedica  m){
    controladora.crearRevicionMedica(m);}
    
    public  void editarRevicionMedica(RevicionMedica m){
    controladora.editarRevicionMedica(m);}
    
    public  void eliminarRevicionMedica(int id){
    controladora.eliminarRevicionMedica(id);}
    
    public  ArrayList<RevicionMedica>buscarRevicionesMedicas(){
    return controladora.buscarRevicionesMedicas();}
     
    public  RevicionMedica buscarRevicionMedica(int id){
    return controladora.bucarRevicionMedica(id);}
}
