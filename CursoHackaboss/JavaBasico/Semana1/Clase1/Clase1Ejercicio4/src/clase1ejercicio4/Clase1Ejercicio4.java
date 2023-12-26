/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase1ejercicio4;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Clase1Ejercicio4 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {

        //declaracion de variables
        int numero1;

        int numero2;

        int suma;


        int resta;

        int multiplicacion;

        int division;

        //Creo un objeto de la clase Scanner para ingresar datos por consola
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");

        //Igualo la variable numero1 a un dato de tipo int que ingrese el usuario por consola
        numero1 = scanner.nextInt();

        System.out.println("Ingrese otro numero: ");

        numero2 = scanner.nextInt();
        //Realizo todas las operaciones y guardo sus resultados en sus respectivas variables
        suma = numero1 + numero2;

        resta = numero1 - numero2;

        multiplicacion = numero1 * numero2;

        division = numero1 / numero2;

        //Imprimo los datos por pantalla
        System.out.println("La suma es: " + suma);

        System.out.println("La resta es: " + resta);

        System.out.println("La multiplicacion es: " + multiplicacion);

        System.out.println("La division es: " + division);




    }
    
}
