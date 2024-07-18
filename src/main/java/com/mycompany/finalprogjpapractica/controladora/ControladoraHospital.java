
package com.mycompany.finalprogjpapractica.controladora;

import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaHospital;
import com.mycompany.finalprogjpapractica.logica.Hospital;
import java.util.ArrayList;

public class ControladoraHospital {
     ControladoraPersistenciaHospital controladora = new ControladoraPersistenciaHospital();
    public  void crearHospital (Hospital h){
    controladora.crearHospital(h);}
    
    public  void editarHospital(Hospital h){
    controladora.editarHospital(h);}
    
    public  void eliminarHospital(int id){
    controladora.eliminarHospital(id);}
    
    public  ArrayList<Hospital>buscarHospiales(){
    return controladora.buscarHospitales();}
     
    public  Hospital buscarHospital(int id){
    return controladora.bucarHospital(id);}
}
