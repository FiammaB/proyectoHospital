
package com.mycompany.finalprogjpapractica.menu;

import com.mycompany.finalprogjpapractica.controladoraPersistencia.ControladoraPersistenciaHospital;
import com.mycompany.finalprogjpapractica.logica.Hospital;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuHospital {
    static  ControladoraPersistenciaHospital ch =new ControladoraPersistenciaHospital();
    public  static void menuHospital(){  
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(" Menu Hospital");
            System.out.println("ingrese la opcion q desee");
            System.out.println("1-ingresar un nuevo Hospital");
            System.out.println("2-editar Hospital");
            System.out.println("3-buscar Hospital");
            System.out.println("4-eliminar Hospital");
            System.out.println("5- volver");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    ingresarHospital(sc);
                }

                case 2 -> {editarHospital(sc);}
                case 3 ->{buscarHospital(sc);}
                case 4->{eliminarHospital(sc);}
                case 5->{System.out.println("volviendo..");
                }
                default -> {
                    System.out.println("ese numero no es una opcion");
                }
            }

        } while (opcion != 5);

}
    public static void ingresarHospital(Scanner sc) {
        mostrarHospital();
        sc.nextLine();
        System.out.println("ingreso de hospitales");
        System.out.println("ingrese el nombre del hospital");
        String nombreH = sc.nextLine().trim();
        ArrayList<Hospital> listaHospitales = new  ArrayList<>();
        listaHospitales=ch.buscarHospitales();
        if(!listaHospitales.isEmpty()){
        for (Hospital listaHospitale : listaHospitales) {
            while(listaHospitale.getNombreHospital().equalsIgnoreCase(nombreH)) {
                System.out.println("ese hospital ya existe ingrese otro nombre");
                nombreH= sc.nextLine();
            }
        }
        }
      
        System.out.println("ingrese el codigo del hospital");
        int codigo = sc.nextInt();
        sc.nextLine();
          if(!listaHospitales.isEmpty()){
        for (Hospital listaHospitale : listaHospitales) {
            while(listaHospitale.getCodigoHospital()== codigo) {
                System.out.println("ese hospital ya existe ingrese otro codigo");
                codigo= sc.nextInt();
            }
        }
        }
        Hospital hosp = new Hospital(nombreH, codigo);
        ch.crearHospital(hosp);
    }
    public static void editarHospital(Scanner sc) {
           System.out.println("EDICION DE HOSPITAL");
        mostrarHospital();
        int opciones;
            System.out.println("ingrese el id del hospital q desea editar");
            int id = sc.nextInt();
            sc.nextLine();
            while (ch.bucarHospital(id) == null) {
                System.out.println("el id es incorrecto intente nuevamente");
                id = sc.nextInt();
            }
           Hospital hospitalEncontrado = ch.bucarHospital(id);
           do{
            System.out.println("eliga un opcion a editar");
            System.out.println("1-editar codigo");
            System.out.println("2-editar nombre ");
            System.out.println("3-actualizar datos");
            opciones = sc.nextInt();
            sc.nextLine();
            switch (opciones) {
                case 1 -> {
                    System.out.println("ingrese el nuevo codigo");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                   hospitalEncontrado.setCodigoHospital(codigo);
                    System.out.println(" nuevo codigo registrado");
                }
                case 2 -> {
                    System.out.println("ingrese el nuevo nombre");
                    String nombre = sc.nextLine();
                    hospitalEncontrado.setNombreHospital(nombre);
                    
                }
                case 3 -> {
                    ch.editarHospital(hospitalEncontrado);
                    System.out.println("datos actualizados");
                }

                default -> {
                    System.out.println("ese numero no exite, intete con otro");

                }
            
        }
           }while (opciones != 3);
    }
           
    public static void buscarHospital(Scanner sc) {
        mostrarHospital();
        System.out.println("ingrese el id del hospital q busca");
        int id= sc.nextInt();
        while(ch.bucarHospital(id)==null){
            System.out.println("el id ingresado no corresponde con ningun hospital,intente nuevamente");
            id = sc.nextInt();
        }
          ArrayList<Hospital> listaHospitales = new  ArrayList<>();
        listaHospitales=ch.buscarHospitales();
        if(!listaHospitales.isEmpty()){
        for (Hospital listaHospitale : listaHospitales) {
            if (listaHospitale.getId()==id) {
                System.out.println("Hospital encontrado");
                System.out.println("codigo: "+listaHospitale.getCodigoHospital()+" nombre: "+ listaHospitale.getNombreHospital());
                
            }
        }
        }
    }
    public static void eliminarHospital(Scanner sc ) {
 mostrarHospital();
        System.out.println("ingrese el id del hospital que desea eliminar ");
        int id= sc.nextInt();
        while(ch.bucarHospital(id)==null){
            System.out.println("el id ingresado no corresponde con ningun hospital,intente nuevamente");
            id = sc.nextInt();
        }
          ArrayList<Hospital> listaHospitales = new  ArrayList<>();
        listaHospitales=ch.buscarHospitales();
        if(!listaHospitales.isEmpty()){
        for (Hospital listaHospitale : listaHospitales) {
            if (listaHospitale.getId()==id) {
                ch.eliminarHospital(id);
                System.out.println("Hospital eliminado");
               
                
            }
        }
        }
        mostrarHospital();
    }
    public static void mostrarHospital() {
   ArrayList<Hospital> listaHospitales = new  ArrayList<>();
        listaHospitales=ch.buscarHospitales();
        if(!listaHospitales.isEmpty()){
        for (Hospital listaHospitale : listaHospitales) {
            System.out.println("ID: "+listaHospitale.getId()+" CODIGO: "+listaHospitale.getCodigoHospital()+" NOMBRE: "+listaHospitale.getNombreHospital());
        }
        }
    }
    
}
