/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class Agente extends Thread{
    
    private String name;

    public Agente(String name) {
        super(name);
    }


    @Override
    public void run() {
       
        try {
            System.out.println("El agente " + getName() + " esta gestionando llamadas");
            Thread.sleep(1000);
            System.out.println("El agente " + getName() + " esta resolviendo una consulta");
            Thread.sleep(1000);
            System.out.println("El agente " + getName() + " esta registrando la informacion");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
}
