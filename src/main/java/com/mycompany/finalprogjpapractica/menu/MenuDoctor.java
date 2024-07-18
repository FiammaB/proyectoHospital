
package com.mycompany.finalprogjpapractica.menu;

import com.mycompany.finalprogjpapractica.controladora.ControladoraDoctor;
import com.mycompany.finalprogjpapractica.controladora.ControladoraEspecialidad;
import com.mycompany.finalprogjpapractica.controladora.ControladoraHospital;
import com.mycompany.finalprogjpapractica.logica.Doctor;
import com.mycompany.finalprogjpapractica.logica.Especialidad;
import com.mycompany.finalprogjpapractica.logica.Hospital;
import java.util.ArrayList;
import java.util.Scanner;


class MenuDoctor {
       static ControladoraDoctor cd = new ControladoraDoctor();
        static ControladoraHospital ch = new ControladoraHospital();
        static ControladoraEspecialidad ce = new ControladoraEspecialidad();
      public static void menuDoctor(){
          Scanner sc = new Scanner(System.in);
          int opcion =0;
          do {              
          System.out.println("Esta en la seccion DOCTOR");
          System.out.println("eliga la opcion que desee");
          System.out.println("1-registrar doctor");
          System.out.println("2-buscar doctor");
          System.out.println("3-editar datos de un doctor");
          System.out.println("4-eliminar datos de un doctor");
          System.out.println("5-volver");
           opcion = sc.nextInt();
          switch (opcion) {
              case 1->registrarDoctores();
              case 2->BuscarDoctores();
              case 3->editarDoctores();
              case 4->eliminarDoctores();
              case 5->System.out.println("volviendo...");

              default->System.out.println("la opcion es incorrecta, intente nuevamente");
          }
          } while (opcion!=5);
          
         
    }
       public static boolean mostrarDoctores(){
        System.out.println("LISTA DE DOCTORES DISPONIBLES");
        ArrayList<Doctor> listaDoctores = new ArrayList();
        listaDoctores = cd.buscarTodosDoctores();

        if (!listaDoctores.isEmpty()) {
            for (Doctor doc : listaDoctores) {
                System.out.println("ID:" + doc.getId() + " Nombre:" + doc.getNombre());
            }
            return true;
        } else{
            System.out.println("No hay doctores registrados en el sistema.");
            return false;
        }        
    }
       public static void registrarDoctores(){
           Scanner sc = new Scanner(System.in);
           System.out.println("ingrese el cuit del doctor");
           int cuit = sc.nextInt();
           System.out.println("ingrese el nombre del doctor");
           String nombre = sc.nextLine();
           System.out.println("Ingrese el codigo de la especialidad");
           ArrayList<Especialidad>listaEspecialidades = new ArrayList<>();
           listaEspecialidades=ce.buscarTodasEspecialidad();
           for (Especialidad especialidades : listaEspecialidades) {
               System.out.println("codigo: "+especialidades.getCodigo()+" nombre: "+especialidades.getNombre());
           }
           int especialidad= sc.nextInt();
           while(ce.buscarEspecialidad(especialidad)==null) {
               System.out.println("no se encontro una especialidad con ese codigo,vuelva a intentarlo");
               especialidad=sc.nextInt();
               
           }
           Especialidad especialidadEncontrada = ce.buscarEspecialidad(especialidad);
           System.out.println("ingrese el id de hospital: ");
           System.out.println("hospitalesDisponibles: ");
           ArrayList<Hospital>listaHospitales= new ArrayList<>();
           listaHospitales=ch.buscarHospiales();
           
           for (Hospital hospitales : listaHospitales) {
               System.out.println("codigo: "+hospitales.getCodigoHospital()+" nombre: "+hospitales.getNombreHospital());
           }
           int hospital= sc.nextInt();
           while(ch.buscarHospital(hospital)==null) {
               System.out.println("no se encontro una especialidad con ese codigo,vuelva a intentarlo");
               hospital=sc.nextInt();
           }
           Hospital hospitalEncontrado= ch.buscarHospital(hospital);
           Doctor doctor= new Doctor(cuit, especialidadEncontrada, hospitalEncontrado, cuit, nombre);
           cd.crearDoctor(doctor);
           hospitalEncontrado.registrarDoctor(doctor);
           ch.editarHospital(hospitalEncontrado);
    }
       public static void BuscarDoctores(){
           Scanner sc = new Scanner(System.in);
           mostrarDoctores();
           System.out.println("ingrese el numero de matricula");
           int matricula= sc.nextInt();
           while (cd.buscarDoctor(matricula)==null) {
               System.out.println("la matricula no es correcta,intente nuevamente");
               matricula=sc.nextInt();
               
           }
           Doctor doctorEncontrado= cd.buscarDoctor(matricula);
           System.out.println("id "+doctorEncontrado.getId()+" matricula: "+doctorEncontrado.getMatricula()+" nombre: "+doctorEncontrado.getNombre()+
                   " especialidad: "+doctorEncontrado.getEspecialidad().getNombre()+"hospital"+doctorEncontrado.getHospital().getNombreHospital());
           }
       public static void editarDoctores(){
             Scanner sc = new Scanner(System.in);
           mostrarDoctores();
           System.out.println("ingrese el numero de matricula");
           int matricula= sc.nextInt();
           while (cd.buscarDoctor(matricula)==null) {
               System.out.println("la matricula no es correcta,intente nuevamente");
               matricula=sc.nextInt();
               
           }
           Doctor doctorEncontrado= cd.buscarDoctor(matricula);
           int opcion;
           do {               
                         System.out.println("eliga la opcion que quiere editar");
                         System.out.println("1-matricula");
                         System.out.println("2-nombre de doctor");
                         System.out.println("3-cuit");
                         System.out.println("4-especilidad");
                         System.out.println("5-hospital");
                         System.out.println("6-guardar/actualizar datos");
                         opcion=sc.nextInt();
                         switch (opcion) {
                   case 1->{System.out.println("ingresa la nueva matricula");
                                 matricula= sc.nextInt();
                                doctorEncontrado.setMatricula(matricula);
                       
                   }
                    case 2->{System.out.println("ingresa nuevo nombre del doctor");
                                 String nombre = sc.nextLine();
                                doctorEncontrado.setNombre(nombre);
                       
                   } 
                    case 3->{System.out.println("ingresa nuevo cuit del doctor");
                                 int cuit = sc.nextInt();
                                doctorEncontrado.setCuit(cuit);
                       
                   }
                   case 4->{ System.out.println("Ingrese el codigo de la especialidad");
           ArrayList<Especialidad>listaEspecialidades = new ArrayList<>();
           listaEspecialidades=ce.buscarTodasEspecialidad();
           for (Especialidad especialidades : listaEspecialidades) {
               System.out.println("codigo: "+especialidades.getCodigo()+" nombre: "+especialidades.getNombre());
           }
           int especialidad= sc.nextInt();
           while(ce.buscarEspecialidad(especialidad)==null) {
               System.out.println("no se encontro una especialidad con ese codigo,vuelva a intentarlo");
               especialidad=sc.nextInt();
               
           } Especialidad espeEncontrada = ce.buscarEspecialidad(especialidad);
                        doctorEncontrado.setEspecialidad(espeEncontrada);
                       
                   }
                   case 5 ->{ System.out.println("ingrese el id de hospital: ");
           System.out.println("hospitalesDisponibles: ");
           ArrayList<Hospital>listaHospitales= new ArrayList<>();
           listaHospitales=ch.buscarHospiales();
           
           for (Hospital hospitales : listaHospitales) {
               System.out.println("codigo: "+hospitales.getCodigoHospital()+" nombre: "+hospitales.getNombreHospital());
           }
           int hospital= sc.nextInt();
           while(ch.buscarHospital(hospital)==null) {
               System.out.println("no se encontro una especialidad con ese codigo,vuelva a intentarlo");
               hospital=sc.nextInt();
           }
           Hospital hospitalEncontrado= ch.buscarHospital(hospital);
           doctorEncontrado.setHospital(hospitalEncontrado);
                   }
                   case 6-> {cd.editarDoctor(doctorEncontrado);
                       System.out.println("datos actualizados");
                   }
                   default-> System.out.println("opcion invalida intente nuvamente ");
               }
           } while (opcion!=6);

       }
       public static void eliminarDoctores(){
           Scanner sc = new Scanner(System.in);
           mostrarDoctores();
           System.out.println("ingrese id del doctor q desea eliminar");
           int id =sc.nextInt();
           while (cd.buscarDoctor(id)==null) {
               System.out.println("el id no es correcto, intente nuevamente");
               id= sc.nextInt();
               
           }
           Doctor doctorEncontrado=cd.buscarDoctor(id);
           Hospital hospitalEncontrado = ch.buscarHospital(doctorEncontrado.getHospital().getId());
          for (int i = 0; i < hospitalEncontrado.getListaDoctores().size(); i++) {
                if(hospitalEncontrado.getListaDoctores().get(i).getId() == doctorEncontrado.getId()){
                    hospitalEncontrado.eliminarDoctor(i);
                }
            }
          
           cd.eliminarDoctor(id);
           ch.editarHospital(hospitalEncontrado);
           
       }
}
