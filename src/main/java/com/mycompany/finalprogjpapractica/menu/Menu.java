/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.menu;

import java.util.Scanner;

/**
 *
 * @author brizu
 */
public class Menu {

    public static void menu() {
            Scanner sc = new Scanner(System.in);

        System.out.println("--------Bienvenid@s------------");
        System.out.println("eliga una opcion");
        System.out.println("1-Hospital");
        System.out.println("2-RevicionMedica");
        System.out.println("3-Especialidad");
        System.out.println("4-Paciente");
        System.out.println("5-doctor");
        System.out.println("salir");
        int opcion =sc.nextInt();
        switch (opcion) {
            case 1->MenuHospital.menuHospital();
            case 2-> MenuRevicionMedica.menuRevicionMedica();
            case 3->  MenuEspecialidad.menuEspecialidad();
            case 4->MenuPaciente.menuPaciente();
            case 5->MenuDoctor.menuDoctor();
            case 6-> System.out.println("¡¡¡muchas graciasss!!");
            default-> System.out.println("Opción incorrecta, intente nuevamente.");
        }
    }

    
}
