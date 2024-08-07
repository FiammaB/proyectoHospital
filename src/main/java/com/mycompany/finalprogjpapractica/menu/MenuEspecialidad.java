/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.menu;

import com.mycompany.finalprogjpapractica.controladora.ControladoraEspecialidad;
import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaDoctor;
import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaEspecialidad;
import com.mycompany.finalprogjpapractica.logica.Doctor;
import com.mycompany.finalprogjpapractica.logica.Especialidad;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brizu
 */
class MenuEspecialidad {
    static  ControladoraPersistenciaEspecialidad ce = new ControladoraPersistenciaEspecialidad();
    static  ControladoraPersistenciaDoctor cd = new ControladoraPersistenciaDoctor();
    public static void menuEspecialidad(){
               Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(" Menu Especialidad");
            System.out.println("ingrese la opcion q desee");
            System.out.println("1-ingresar nueva especialidad");
            System.out.println("2-editar especialidad");
            System.out.println("3-buscar especialidad");
            System.out.println("4-eliminar especialidad");
            System.out.println("5- volver");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    generarEspecialidad(sc);
                }

                case 2 -> {editarEspecialidad(sc);}
                case 3 ->{BuscarEspecialidad(sc);}
                case 4->{eliminarEspecialidad( sc);}
                case 5->{System.out.println("volviendo..");
                }
                default -> {
                    System.out.println("ese numero no es una opcion");
                }
            }

        } while (opcion != 5); 
    }
    public static void mostrarEspecialidades() {
        ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();
        listaEspecialidades = ce.buscarTodasEspecialidad();
        if (!listaEspecialidades.isEmpty()) {
            for (Especialidad especialidad : listaEspecialidades) {
                System.out.println(especialidad.toString());
            }
        }
    }

    public static void generarEspecialidad(Scanner sc) {
        ArrayList<Especialidad> listaEspecialidades = new ArrayList<Especialidad>();
        listaEspecialidades = ce.buscarTodasEspecialidad();
        System.out.println("NUEVA especialidad");
        System.out.println("ingrese el id");

        int id = sc.nextInt();
         sc.nextLine();
        if (!listaEspecialidades.isEmpty()) {
            for (Especialidad especialidad : listaEspecialidades) {
                while (especialidad.getCodigo() == id) {
                    System.out.println("el codigo ingresado ya existe,intente nuevamente");
                    id = sc.nextInt();
                }

            }
        }
        
        System.out.println("ingrese el codigo");

        int codigo = sc.nextInt();
        if (!listaEspecialidades.isEmpty()) {
            for (Especialidad especialidad : listaEspecialidades) {
                while (especialidad.getCodigo() == codigo) {
                    System.out.println("el codigo ingresado ya existe,intente nuevamente");
                    codigo = sc.nextInt();
                }

            }
        }
     sc.nextLine();
        System.out.println("ingrese el nombre de la especialidad");
        String nombre = sc.nextLine();
        Especialidad especialidad = new  Especialidad(codigo, nombre);
        ce.crearEspecialidad(especialidad);    }

    public static void editarEspecialidad(Scanner sc ) {
        System.out.println("EDICION DE ESPECIALIDADES");
        mostrarEspecialidades();
        int opciones;
            System.out.println("ingrese el id de la revicon medica q desea editar");
            int id = sc.nextInt();
            while (ce.buscarEspecialidad(id) == null) {
                System.out.println("el id es incorrecto intente nuevamente");
                id = sc.nextInt();
            }
            do{
            Especialidad especialidadEncontrada =ce.buscarEspecialidad(id);
            System.out.println("eliga un opcion a editar");
            System.out.println("1-editar nombre");
            System.out.println("2-actualizar datos");
            opciones = sc.nextInt();
            switch (opciones) {
     
                case 1 -> {
                         sc.nextLine();
                    System.out.println("ingrese la nuevo nombre");
                    String nombre = sc.nextLine();
                     especialidadEncontrada.setNombre(nombre);
                    
                }
                case 2 -> {
                    ce.editarEspecialidad(especialidadEncontrada);
                    System.out.println("datos actualizados");
                }

                default -> {
                    System.out.println("ese numero no exite, intete con otro");

                }
            }
        } while (opciones != 2);

    }

    public static void BuscarEspecialidad(Scanner sc){
         boolean especia=false;
        do {               
        System.out.println("ingrese el codigo de la revisacion que deseea buscar"); 
        ArrayList<Especialidad> listaEspecialidad = new ArrayList<>();
        listaEspecialidad= ce.buscarTodasEspecialidad();
        int id= sc.nextInt();
       
           for (Especialidad especialidad : listaEspecialidad) {
           if (especialidad.getCodigo()==id){
               System.out.println("especialidad encotrada "+ especialidad.toString()); 
               especia=true;
               break;
           }
           
        }
               if (!especia) {
                   System.out.println("el id no corresponde a una Especialidad, intente nuevamnete");
               }
           
            } while (!especia);
    }
    public static void eliminarEspecialidad (Scanner sc) {
        
            boolean especia=false;
        do {               
        System.out.println("ingrese el codigo de la revisacion que deseea eliminar"); 
        ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();
        listaEspecialidades=ce.buscarTodasEspecialidad();
        int id= sc.nextInt();
       ArrayList<Doctor> listadeDoctores = new  ArrayList<>();
       listadeDoctores= cd.buscarTodosDoctores();
            for (Doctor listadeDoctore : listadeDoctores) {
                if (listadeDoctore.getEspecialidad().getCodigo()==id) {
                    cd.eliminarDoctor(listadeDoctore.getId());
                }
                
            }
           for (Especialidad especialidades : listaEspecialidades) {
           if (especialidades.getCodigo()==id){
               
               ce.eliminarEspecialidad(id);
               System.out.println("Especialidad eliminada "); 
               especia=true;
           }
               if (!especia) {
                   System.out.println("el el codigo no corresponde a una Especialidad, intente nuevamnete");
               }
        }
            } while (!especia);
        mostrarEspecialidades();
    }
     
}
