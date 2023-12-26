/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase3ejercicio1;

/**
 *
 * @author Adrian
 */
public class main {
    
    public static void main(String[] args) {

        //Creo 4 objetos, 3 con parametros y 1 sin parametros
        Electrodomestico electrodomestico1 = new Electrodomestico(1,"LG","RTX506","800W","Negro");

        Electrodomestico electrodomestico2 = new Electrodomestico(2,"LG","RTB106","800W","Gris");

        Electrodomestico electrodomestico3 = new Electrodomestico(3,"LG","ZDX504","800W","Rojo");

        Electrodomestico electrodomestico4 = new Electrodomestico();

        //Llamo al metodo para mostrar los datos

        System.out.println("Apartado C: ");
        electrodomestico1.mostrarDatos();

        System.out.println("Segundo articulo: ");

        electrodomestico2.mostrarDatos();

        System.out.println("Tercer articulo: ");

        electrodomestico3.mostrarDatos();

        System.out.println(electrodomestico4.getMarca());

    }
}
