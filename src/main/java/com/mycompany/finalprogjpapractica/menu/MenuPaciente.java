/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.menu;

import com.mycompany.finalprogjpapractica.controladora.ControladoraHospital;
import com.mycompany.finalprogjpapractica.controladora.ControladoraPaciente;
import com.mycompany.finalprogjpapractica.controladora.ControladoraRevicionMedica;
import com.mycompany.finalprogjpapractica.logica.Hospital;
import com.mycompany.finalprogjpapractica.logica.Paciente;
import com.mycompany.finalprogjpapractica.logica.RevicionMedica;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
/**
 *
 * @author brizu
 */
class MenuPaciente {
    static ControladoraHospital ch = new ControladoraHospital();
    static ControladoraPaciente cp = new ControladoraPaciente();
    static  ControladoraRevicionMedica crm = new ControladoraRevicionMedica();
     
    public static void menuPaciente(){
        Scanner sc = new Scanner(System.in);
        int opcion;
            do {            
              System.out.println("Bienvenido al menu de pacientes ");
                System.out.println("Eliga la opcion q desee: ");
                System.out.println("1-registrar un paciente");
                System.out.println("2-buscar un paciente");
                System.out.println("3-editar un paciente");
                System.out.println("4-eliminar un paciente");
                System.out.println("5-volver");
                opcion=sc.nextInt();
                switch (opcion) {
            case 1->registrarPaciente();
             case 2->buscarPaciente() ;   
             case 3->editarPaciente();
              case 4->eliminarPaciente();
               case 5->System.out.println("volviendo.....");
            default-> System.out.println("opcion incorrecta, intente nuevamente");
        }
        } while (opcion!=5);
              
    }
    public static void registrarPaciente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("REGISTRO DE PACIENTES");
        System.out.println("ingrese el codigo del paciente");
        int codigo= sc.nextInt(); 
        System.out.println("ingrese el cuit del paciente");
        int cuit= sc.nextInt(); 
        sc.nextLine();
                System.out.println("ingrese el nombre del paciente");
        String nombre= sc.nextLine(); 
        System.out.println("----LISTA DE HOSPITALES DISPONIBLES---");
        ArrayList<Hospital>listaHospitales= new ArrayList<>();
        listaHospitales = ch.buscarHospiales();
        if (!listaHospitales.isEmpty()){
            for (Hospital listaHospital : listaHospitales) {
                System.out.println("Codigo "+listaHospital.getCodigoHospital()+" ID: "+listaHospital.getId() + " nombre del hopital: "+listaHospital.getNombreHospital());
            }
        }
        sc.nextLine();
        System.out.println("ingresar id de hospital:  ");
        int id =sc.nextInt();
        while (ch.buscarHospital(id)==null) {
            System.out.println("el id ingresado es incorrecto, intente nuevamente");
            id=sc.nextInt();
        }
        Hospital hospitalEncontrado = ch.buscarHospital(id);
        System.out.println("----LISTA REVICIONES MEDICAS DISPONIBLES---");
        ArrayList<RevicionMedica>listaRevicionMedicas= new ArrayList<>();
        listaRevicionMedicas = crm.buscarRevicionesMedicas();
        if (!listaRevicionMedicas.isEmpty()){
            for (RevicionMedica reviciones : listaRevicionMedicas) {
                System.out.println("codigo: "+reviciones.getCodigo()+ " ID: "+reviciones.getId()+" Fecha: "+reviciones.getFecha());
            }
        }
        System.out.println("ingresar id de Revicion Medica ");
        int idRM =sc.nextInt();
        while (crm.buscarRevicionMedica(idRM)==null) {
            System.out.println("el id ingresado es incorrecto, intente nuevamente");
            idRM=sc.nextInt();
        }
        RevicionMedica revicionEncontrada=crm.buscarRevicionMedica(id);
        Paciente paciente = new Paciente(codigo, new java.util.Date(), hospitalEncontrado, revicionEncontrada, id, nombre);
        cp.crearPaciente(paciente);
        hospitalEncontrado.registrarPaciente(paciente);
        ch.editarHospital(hospitalEncontrado);
    }
     
    public static void editarPaciente(){
        mostrarPacientes();
         Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el id del paciente q quiera editar");
        int id=sc.nextInt();
         while (cp.buscarPaciente(id)==null) {
             
             System.out.println("id no encontrada, intente nuevamente");
             id=sc.nextInt();
             
        }
         Paciente pacienteEncontrado = cp.buscarPaciente(id);
         int opcion;
         do{
         System.out.println("eliga una opcion para editar al paciente: ");
         System.out.println("1-editar nombre de paciente");
         System.out.println("2-editar codigo de paciente");
         System.out.println("3-editar cuit ");
         System.out.println("4-editar Hospital");
         System.out.println("5- editar fecha de ingreso");
         System.out.println("6-actualizar datos");
         opcion=sc.nextInt();
         switch (opcion) {
            case 1->{ 
                sc.nextLine();
                System.out.println("Ingrese el nuevo  nombre del paciente");
                         String nombre = sc.nextLine();
                        pacienteEncontrado.setNombre(nombre);         
            }
            case 2 -> {sc.nextLine();
                System.out.println("ingrese el nuevo codigo del paciente");
                            int codigo = sc.nextInt();
                            pacienteEncontrado.setCodigoPaciente(codigo);
            }
            case 3 -> {sc.nextLine();
            System.out.println("ingrese el nuevo cuit del paciente");
                            int cuit = sc.nextInt();
                            pacienteEncontrado.setCuit(cuit);
            }
            case 4->{System.out.println("----LISTA DE HOSPITALES DISPONIBLES---");
        ArrayList<Hospital>listaHospitales= new ArrayList<>();
        listaHospitales = ch.buscarHospiales();
        if (!listaHospitales.isEmpty()){
            for (Hospital listaHospital : listaHospitales) {
                System.out.println("Codigo "+listaHospital.getCodigoHospital()+" ID: "+listaHospital.getId() + "nombre del hopital"+listaHospital.getNombreHospital());
            }
        }
        System.out.println("ingresar id de hospital:  ");
        int idhop =sc.nextInt();
        while (ch.buscarHospital(idhop)==null) {
            System.out.println("el id ingresado es incorrecto, intente nuevamente");
            idhop=sc.nextInt();
        }
        Hospital hospitalEncontrado = ch.buscarHospital(idhop);
        pacienteEncontrado.setHospital(hospitalEncontrado);
        hospitalEncontrado.getListaPacientes().add(pacienteEncontrado);
        ch.editarHospital(hospitalEncontrado);
        
            }
            case 5 ->{System.out.println("ingrese la fecha del paciente");
            String fecha = sc.next();
            Date fechi=Date.valueOf(fecha);
            pacienteEncontrado.setFechaInternacion(fechi);
            }
            case 6 -> {cp.editarPaciente(pacienteEncontrado);
                System.out.println("paciente actualizado");
            }
            default->System.out.println("la opcion elegida no existe,intente nuevamente");
        }
         
         }while(opcion!=6);
        
    }
    public static void buscarPaciente(){  
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el codigo del paciente a buscar");
        int id=sc.nextInt();
        sc.nextLine();
        
        
        while(cp.buscarPaciente(id)==null){
            System.out.println("el id es incorrecto, intente nuevamente");
            id=sc.nextInt();
        }
      ArrayList<Paciente> listaPacientes= new ArrayList();
      listaPacientes=cp.buscarPacientes();
      if(!listaPacientes.isEmpty()){
        for (Paciente listaPaciente : listaPacientes) {
            if (id==listaPaciente.getId()) {
                System.out.println("paciente encontrado");
                System.out.println("Cuit "+listaPaciente.getCuit()+" Nombre  "+listaPaciente.getNombre()+" Codigo"+listaPaciente.getCodigoPaciente()+" "+listaPaciente.getHospital().getNombreHospital());
            }
        }
      }
    }
   public static void eliminarPaciente() {
        if (mostrarPacientes()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el ID del paciente a eliminar: ");
            int id = sc.nextInt();

            while (cp.buscarPaciente(id) == null) {
                System.out.println("No existe ningún paciente con el ID ingresado, intente nuevamente: ");
                id = sc.nextInt();
            }

            // Sacar del hospital y de la base los datos
            Paciente pacEncontrado = cp.buscarPaciente(id);
            Hospital hospEncontrado = ch.buscarHospital(pacEncontrado.getHospital().getId());
            for (int i = 0; i < hospEncontrado.getListaPacientes().size(); i++) {
                if (hospEncontrado.getListaPacientes().get(i).getId() == pacEncontrado.getId()) {
                    hospEncontrado.eliminarPaciente(i);
                }
            }
            ch.editarHospital(hospEncontrado);
            cp.eliminarPaciente(id);

            System.out.println("Paciente eliminado correctamente.");
        }
    }
    public static boolean mostrarPacientes(){
        System.out.println("-------LISTA DE PACIENTES------");
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        listaPacientes= cp.buscarPacientes();
        if (!listaPacientes.isEmpty()) {
                    for (Paciente listaPaciente : listaPacientes) {
            System.out.println("Cuit: "+listaPaciente.getCuit()+" id " +listaPaciente.getId()+" nombre; "+listaPaciente.getNombre()+
                    "nombre hospital"+listaPaciente.getHospital().getNombreHospital()+" revicion medica "+listaPaciente.getRevicionMedica().toString());
            
        }
                    return true;
                 
        }   else{return false;}

    }
}
