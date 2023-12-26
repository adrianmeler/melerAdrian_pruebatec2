/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Clase2Ejercicio3 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

        //Declaracion de variables y un vector de 7 posiciones
        float [] array = new float[7];

        float total = 0;

        float promedio;

        Scanner scanner = new Scanner(System.in);

        //Utilizo un bucle for para poder recorrer el vector
        for(int i = 0; i < array.length; i++){

            System.out.println("Introduzca una alta temperatura: ");

            /*La variable i aumento su valor en 1 por cada rotacion del bucle
            *Ingreso el usuario puede introducir los valores del vector
             */
            array[i] = Float.parseFloat(scanner.nextLine());

        }

        //Otro bucle for para recorrer el vector
        for(int i = 0; i < array.length; i++){
            //A la variable total se le van sumando los valores del vector
            total = total + array[i];
        }

        //Divido la variables con la suma total de los valores del vector entre la longitud del vector para calcular el promedio
        promedio = total / array.length;

        System.out.println("El promedio de las temperaturas es: " + promedio);



    }
}
