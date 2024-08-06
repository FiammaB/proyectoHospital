/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.menu;

import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaRevicionMedica;
import com.mycompany.finalprogjpapractica.logica.RevicionMedica;
import java.util.ArrayList;

import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author brizu
 */
class MenuRevicionMedica {

    static ControladoraPersistenciaRevicionMedica crm = new ControladoraPersistenciaRevicionMedica();

    public static void menuRevicionMedica() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(" Menu revicion medica");
            System.out.println("ingrese la opcion q desee");
            System.out.println("1-ingresar nueva revicion medica");
            System.out.println("2-editar revicion medica");
            System.out.println("3-buscar revicion medica");
            System.out.println("4-eliminar revicion medica");
            System.out.println("5- volver");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    generarRevisaciones(sc);
                }

                case 2 -> {editarRevisaciones(sc);}
                case 3 ->{BuscarRevisaciones(sc);}
                case 4->{eliminarRevisacion(sc);}
                case 5->{System.out.println("volviendo..");
                }
                default -> {
                    System.out.println("ese numero no es una opcion");
                }
            }

        } while (opcion != 5);

    }

    public static void MostrarRevisaciones() {
        ArrayList<RevicionMedica> listaRevicionMedicas = new ArrayList<>();
        listaRevicionMedicas = crm.buscarRevicionesMedicas();
        if (!listaRevicionMedicas.isEmpty()) {
            for (RevicionMedica listaRevicionMedica : listaRevicionMedicas) {
                System.out.println(listaRevicionMedica.toString());
            }
        }
    }

    public static void generarRevisaciones(Scanner sc) {
        ArrayList<RevicionMedica> listaRevicionMedicas = new ArrayList<RevicionMedica>();
        listaRevicionMedicas = crm.buscarRevicionesMedicas();
        System.out.println("NUEVA REVICION MEDICA");
        System.out.println("ingrese el id");

        int id = sc.nextInt();
        if (!listaRevicionMedicas.isEmpty()) {
            for (RevicionMedica listaRevicionMedica : listaRevicionMedicas) {
                while (listaRevicionMedica.getCodigo() == id) {
                    System.out.println("el codigo ingresado ya existe,intente nuevamente");
                    id = sc.nextInt();
                }

            }
        }
        System.out.println("ingrese el codigo");

        int codigo = sc.nextInt();
        if (!listaRevicionMedicas.isEmpty()) {
            for (RevicionMedica listaRevicionMedica : listaRevicionMedicas) {
                while (listaRevicionMedica.getCodigo() == codigo) {
                    System.out.println("el codigo ingresado ya existe,intente nuevamente");
                    codigo = sc.nextInt();
                }

            }
        }
        sc.nextLine();
        System.out.println("ingrese la fecha en formato YYYY/MM/DD");
        String fecha = sc.nextLine();
        Date fechaRM = Date.valueOf(fecha);
        RevicionMedica revicionMedica = new RevicionMedica(id, codigo, fechaRM);
        crm.crearRevicionMedica(revicionMedica);
    }

    public static void editarRevisaciones(Scanner sc ) {
        System.out.println("EDICION DE REVICIONES MEDICAS");
        MostrarRevisaciones();
        int opciones;
            System.out.println("ingrese el id de la revicon medica q desea editar");
            int id = sc.nextInt();
            while (crm.bucarRevicionMedica(id) == null) {
                System.out.println("el id es incorrecto intente nuevamente");
                id = sc.nextInt();
            }
            do {            
            
            RevicionMedica revicionMedicaEncontrada = crm.bucarRevicionMedica(id);
            System.out.println("eliga un opcion a editar");
            System.out.println("1-editar codigo");
            System.out.println("2-editar fecha");
            System.out.println("3-actualizar datos");
            opciones = sc.nextInt();
            switch (opciones) {
                case 1 -> {
                    System.out.println("ingrese el nuevo codigo");
                    int codigo = sc.nextInt();
                    revicionMedicaEncontrada.setCodigo(codigo);
                   
                }
                case 2 -> {
                    System.out.println("ingrese la nueva fecha");
                    String fechanueva = sc.nextLine();
                    java.sql.Date fechaRev = java.sql.Date.valueOf(fechanueva);
                    revicionMedicaEncontrada.setFecha(fechaRev);
                }
                case 3 -> {
                    crm.editarRevicionMedica(revicionMedicaEncontrada);
                    System.out.println("datos actualizados");
                }

                default -> {
                    System.out.println("ese numero no exite, intete con otro");

                }
            }
        } while (opciones != 3);

    }

    public static void BuscarRevisaciones(Scanner sc){
         boolean revicion=false;
        do {               
        System.out.println("ingrese el id de la revisacion que deseea buscar"); 
        ArrayList<RevicionMedica> listadeReviciones = new ArrayList<>();
        listadeReviciones=crm.buscarRevicionesMedicas();
        int id= sc.nextInt();
       
           for (RevicionMedica listadeRevicione : listadeReviciones) {
           if (listadeRevicione.getId()==id){
               System.out.println("revicion encotrada "+ listadeRevicione.toString()); 
               revicion=true;
           }
               if (!revicion) {
                   System.out.println("el id no corresponde a una revisacion, intente nuevamnete");
                   break;
               }
        }
            } while (!revicion);
    }
    public static void eliminarRevisacion(Scanner sc) {
        
            boolean revicion=false;
        do {               
        System.out.println("ingrese el id de la revisacion que deseea eliminar"); 
        ArrayList<RevicionMedica> listadeReviciones = new ArrayList<>();
        listadeReviciones=crm.buscarRevicionesMedicas();
        int id= sc.nextInt();
       
           for (RevicionMedica listadeRevicione : listadeReviciones) {
           if (listadeRevicione.getId()==id){
               crm.eliminarRevicionMedica(id);
               System.out.println("revicion eliminada "); 
               revicion=true;
           }
               if (!revicion) {
                   System.out.println("el id no corresponde a una revisacion, intente nuevamnete");
               }
        }
            } while (!revicion);
        MostrarRevisaciones();
    }
    
}

    
