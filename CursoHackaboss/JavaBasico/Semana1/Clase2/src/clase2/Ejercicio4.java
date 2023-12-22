package Clase5;

import java.util.Scanner;
public class Ejercicio4 {

    public static void main(String[] args) {

        //Declaracion de variables y una matriz de 5x5
        String [][] asientos = new String[5][5];

        Scanner scanner = new Scanner(System.in);

        int fila;

        int asiento;

        String opcion;

        int aux1;

        //Doy un valor de tipo String a cada una de las posiciones de la matriz
        asientos[0][0] = "x";
        asientos[0][1] = "o";
        asientos[0][2] = "o";
        asientos[0][3] = "o";
        asientos[0][4] = "x";
        asientos[1][0] = "o";
        asientos[1][1] = "x";
        asientos[1][2] = "x";
        asientos[1][3] = "o";
        asientos[1][4] = "o";
        asientos[2][0] = "o";
        asientos[2][1] = "o";
        asientos[2][2] = "x";
        asientos[2][3] = "x";
        asientos[2][4] = "x";
        asientos[3][0] = "o";
        asientos[3][1] = "o";
        asientos[3][2] = "o";
        asientos[3][3] = "x";
        asientos[3][4] = "x";
        asientos[4][0] = "x";
        asientos[4][1] = "x";
        asientos[4][2] = "o";
        asientos[4][3] = "o";
        asientos[4][4] = "o";

        System.out.println("Ejercicio 4:");


        do {

            System.out.println("-----Pared-----");
            //Tengo que hacer un bucle for dentro de otro bucle for para asi poder recorrer todas las posiciones de la matriz
            for (int i = 0; i < 5; i++) {
                aux1 = i + 1;
                System.out.println("Fila " + aux1);
                for (int j = 0; j < 5; j++) {

                    System.out.print("| " + asientos[i][j] + " |");

                    //Hago un if para que asi cuando la variable j valga 4 entonces haga un salto de linea para poder dibujar los asientos
                    if (j == 4) {
                        System.out.print("\n");
                    }
                }
            }

            System.out.println("-----Pantalla-----");

            System.out.println("Nota: Asientos del 1 al 5 de izquierda a derecha.");

            System.out.println("\nElija la fila en la que desee su asiento: ");

            fila = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.println("Ahora escoja el asiento: ");

            asiento = Integer.parseInt(scanner.nextLine()) - 1;

            /*Ingreso los valores asignados por el usuario como fila y columna en la matriz para asi revisar si su valor es una x o una o
            *Si el valor es una x se muestra un mensaje por pantalla
            *Si el valor es diferente entonces se reemplaza por una x
             */
           if(asientos[fila][asiento].equals("x")){
               System.out.println("Lo siento, ese asiento esta ocupado");
           }else{
               asientos[fila][asiento] = asientos[fila][asiento].replace("o","x");
           }

           System.out.println("Desea continuar? si/no");

           opcion = scanner.nextLine();

           //El bucle termina cuando el usuario escribe no
        }while(!opcion.equals("no"));

        System.out.println("Gracias por comprar con nosotros!");
    }
}
