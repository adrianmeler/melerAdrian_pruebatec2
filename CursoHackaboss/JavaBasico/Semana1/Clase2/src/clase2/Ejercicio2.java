package Clase5;

import java.util.Scanner;

public class Ejercicio2 {

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