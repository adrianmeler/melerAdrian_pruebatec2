/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import Models.Trabajador;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        Runnable trabajador1 = new Trabajador("Juan");
        Runnable trabajador2 = new Trabajador("Rosa");
        Runnable trabajador3 = new Trabajador("Ramon");
        
        Thread hilo1 = new Thread(trabajador1);
        Thread hilo2 = new Thread(trabajador2);
        Thread hilo3 = new Thread(trabajador3);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
