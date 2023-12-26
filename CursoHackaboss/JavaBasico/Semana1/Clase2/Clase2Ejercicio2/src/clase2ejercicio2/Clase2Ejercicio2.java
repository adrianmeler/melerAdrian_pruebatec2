/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2ejercicio2;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Clase2Ejercicio2 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        //Declaracion de variables
        float precio;
        String respuesta;
        float resultado = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ejercicio 2:");

        //Utilizo un bucle do while para que se pueda realizar la operacion 1 vez y que muestre al usuario el mensaje
        do {
            System.out.println("Ingrese el coste de su producto:");
            //Convierto lo que el usuario ingresa por pantalla a un float
            precio = Float.parseFloat(scanner.nextLine());
            resultado = resultado + precio;

            System.out.println("¿Quieres seguir ingresando productos? Si/no");
            respuesta = scanner.nextLine();

            //El bucle sigue hasta que el usuario escriba no
        } while (!respuesta.equals("no"));

        System.out.println("El total es: " + resultado);
    }

    
}
