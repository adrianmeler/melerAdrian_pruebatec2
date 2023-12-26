/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2ejercicio1;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Clase2Ejercicio1 {

    /**
     * @param args the command line arguments
     */
   public class Ejercicio1 {

    public static void main(String[] args) {

        int edad;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ejercicio 1:");

        System.out.println("Cual es tu edad?");

        edad = scanner.nextInt();

        /*Utilizo un if else para mostrar un mensaje en caso de que el valor ingresado
        *por pantalla sea mayor o igual a 18 o menor a 18
        */
        if(edad >= 18){
            System.out.println("Puedes entrar a la fiesta");
        }else{
            System.out.println("No puedes entrar a la fiesta, eres menor de edad!");
        }


    }
    
   }
   
}

