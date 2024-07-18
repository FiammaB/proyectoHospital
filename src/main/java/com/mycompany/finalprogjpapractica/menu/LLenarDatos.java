/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.finalprogjpapractica.menu;

import com.mycompany.finalprogjpapractica.controladora.ControladoraDoctor;
import com.mycompany.finalprogjpapractica.controladora.ControladoraEspecialidad;
import com.mycompany.finalprogjpapractica.controladora.ControladoraHospital;
import com.mycompany.finalprogjpapractica.controladora.ControladoraPaciente;
import com.mycompany.finalprogjpapractica.controladora.ControladoraRevicionMedica;
import com.mycompany.finalprogjpapractica.logica.Doctor;
import com.mycompany.finalprogjpapractica.logica.Especialidad;
import com.mycompany.finalprogjpapractica.logica.Hospital;
import com.mycompany.finalprogjpapractica.logica.Paciente;
import com.mycompany.finalprogjpapractica.logica.RevicionMedica;
import java.util.Date;


public class LLenarDatos {


    public static void main(String[] args) {
        //controladores
        ControladoraDoctor cd= new ControladoraDoctor();
        ControladoraHospital ch= new ControladoraHospital();
        ControladoraEspecialidad ce=new ControladoraEspecialidad();
        ControladoraPaciente cp= new ControladoraPaciente();
        ControladoraRevicionMedica crm= new ControladoraRevicionMedica();
        //crear tablas
       Hospital hospital1= new Hospital("lagomagiore", 3454);
       Hospital  hospital2 = new  Hospital("Central", 4560);
      
        RevicionMedica revicionMedica1= new RevicionMedica(15, 235345, new Date());
        RevicionMedica revicionMedica2= new RevicionMedica(10, 345, new Date());
        
        Especialidad especialidad1= new Especialidad(32, "Traumatologia");
        Especialidad especialidad2= new Especialidad(2, "Oftalmologia");
     
    Paciente paciente1 =new Paciente(343, new Date(), hospital1,revicionMedica1 );
    Paciente paciente2 =new Paciente(343, new Date(), hospital2,revicionMedica2 );
     
      Doctor doctor1=new Doctor(2435, especialidad1, hospital2, 4545555, "Roberto");
      Doctor doctor2=new Doctor(2535, especialidad2, hospital1, 45446555, "Fiamma");
    
          //llenar tablas
           ch.crearHospital(hospital1);
           ch.crearHospital(hospital2);
           crm.crearRevicionMedica(revicionMedica1);
           crm.crearRevicionMedica(revicionMedica2);
           ce.crearEspecialidad(especialidad1);
           ce.crearEspecialidad(especialidad2);
          cp.crearPaciente(paciente1);
          cp.crearPaciente(paciente2);
          cd.crearDoctor(doctor1);
          cd.crearDoctor(doctor2);
         Menu.menu();
    }
    
}
