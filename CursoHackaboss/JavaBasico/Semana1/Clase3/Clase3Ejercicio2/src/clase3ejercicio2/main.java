/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase3ejercicio2;

/**
 *
 * @author Adrian
 */
public class main {
 
     public static void main(String[] args) {

        //Creo un vector de tipo Persona
        Persona[] personas = new Persona[5];

        //Creo 5 objetos de tipo Persona
        Persona persona1 = new Persona(1,"Adrian",27,"Manzanares","456890987");

        Persona persona2 = new Persona(2,"Alan",27,"Berlin","695890987");

        Persona persona3 = new Persona(3,"Alessia",27,"Madrid","987654432");

        Persona persona4 = new Persona(4,"Tamara",57,"Manzanares","568447729");

       Persona persona5 = new Persona(5,"Jose",67,"Caracas","04248764837");

        //Doy valor a las posiciones del vector con los objetos
        personas[0] = persona1;

        personas[1] = persona2;

        personas[2] = persona3;

        personas[3] = persona4;

        personas[4] = persona5;

        //Recorro el vector y extraigo solo el nombre y edad de cada objeto
        System.out.println("Apartado B: ");
        for(int i = 0; i < personas.length; i++){

            System.out.println(personas[i].getNombre() + " " + personas[i].getEdad());
        }

        //Cambio el nombre de dos objetos
        persona1.setNombre("Javier");

        persona2.setNombre("Rodrigo");

        //Muestro los nuevos nombres recorriendo el vector
        System.out.println("\nApartado C:");
        for(int i = 0; i < personas.length; i++){

            System.out.println(personas[i].getNombre() + " " + personas[i].getEdad());
        }

        //Recorro el vector y solo muestro el nombre y la edad de las personas que tengan mas de 30 años
        System.out.println("\nApartado D:");
        for(int i = 0; i < personas.length; i++){

            if(personas[i].getEdad() > 30) {
                System.out.println(personas[i].getNombre() + " " + personas[i].getEdad());
            }
        }



    }

}
