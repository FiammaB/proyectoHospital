
package com.mycompany.finalprogjpapractica.controladora;

import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaEspecialidad;
import com.mycompany.finalprogjpapractica.logica.Especialidad;
import java.util.ArrayList;


public class ControladoraEspecialidad {
       ControladoraPersistenciaEspecialidad controladora = new ControladoraPersistenciaEspecialidad();
    public  void crearEspecialidad (Especialidad e){
    controladora.crearEspecialidad(e);}
    
    public  void editarEspecialidad(Especialidad especialidad){
    controladora.editarEspecialidad(especialidad);}
    
    public  void eliminarEspecialidad(int id){
    controladora.eliminarEspecialidad(id);}
    
    public  ArrayList<Especialidad>buscarTodasEspecialidad(){
    return controladora.buscarTodasEspecialidad();}
     
    public  Especialidad buscarEspecialidad(int id){
    return controladora.buscarEspecialidad(id);}
}
