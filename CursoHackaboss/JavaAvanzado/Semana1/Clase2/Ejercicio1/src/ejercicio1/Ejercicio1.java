/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

import Models.Agente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Agente agente1 = new Agente("Pepe");
        Agente agente2 = new Agente("Jordi");
        Agente agente3 = new Agente("Samantha");
        
        agente1.start();
        agente2.start();
        agente3.start();
        
        try {
            agente1.join();
            agente2.join();
            agente3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
