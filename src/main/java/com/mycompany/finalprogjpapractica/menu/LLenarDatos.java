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


public class LLenarDatos {


    public static void main(String[] args) {
        //controladores
        ControladoraDoctor cd= new ControladoraDoctor();
        ControladoraHospital ch= new ControladoraHospital();
        ControladoraEspecialidad ce=new ControladoraEspecialidad();
        ControladoraPaciente cp= new ControladoraPaciente();
        ControladoraRevicionMedica crm= new ControladoraRevicionMedica();
        //crear tablas
        Hospital hospital1= new Hospital();
        ch.crearHospital(hospital1);
        Doctor doctor1=new Doctor();
        cd.crearDoctor(doctor1);
        Especialidad especialidad1= new Especialidad();
        ce.crearEspecialidad(especialidad1);
        Paciente paciente1 =new Paciente();
        cp.crearPaciente(paciente1);
        RevicionMedica revicionMedica1= new RevicionMedica();
        crm.crearRevicionMedica(revicionMedica1);
                
    }
    
}
