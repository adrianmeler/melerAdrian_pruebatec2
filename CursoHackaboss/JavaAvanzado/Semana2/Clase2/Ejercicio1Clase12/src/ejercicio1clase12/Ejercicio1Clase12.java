/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1clase12;

import Models.Auto;
import Models.InventarioAutos;

/**
 *
 * @author Adrian
 */
public class Ejercicio1Clase12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Auto auto = new Auto("Porshe","Cayenna",2014,50000.00);
        Auto auto2 = new Auto("Nissan","Gtr",2018,60000.00);
        Auto auto3 = new Auto("Ford","Fiesta",2004,10000.00);
        Auto auto4 = new Auto("Lamborgini","Murcielago",2009,70000.00);
        
        InventarioAutos inventario = new InventarioAutos();
        
        inventario.agregarAuto(auto);
        inventario.agregarAuto(auto2);
        inventario.agregarAuto(auto3);
        inventario.agregarAuto(auto4);
        
        inventario.buscarAnio(2018);
        
        System.out.println(inventario.valorTotal());
    
    }
    
}
