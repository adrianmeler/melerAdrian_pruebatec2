/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import Models.Inventario;

/**
 *
 * @author Adrian
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Inventario producto = new Inventario("Laptop/",0,-2);
        
        
        try{
            
          Inventario.validarNombre(producto.getNombreProducto());
        
          Inventario.validarPrecio(producto.getPrecio());
        
          Inventario.validarCantidad(producto.getCantidadDisponible());
        
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
