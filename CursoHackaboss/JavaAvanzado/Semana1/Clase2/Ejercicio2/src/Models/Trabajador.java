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
public class Trabajador implements Runnable{
    
    private String nombre;

    public Trabajador() {
    }
   
    public Trabajador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    @Override
    public void run(){
        try {
            System.out.println("El trabajador " + getNombre() + " esta ensamblando un producto");
            Thread.sleep(1000);
            System.out.println("El trabajador " + getNombre() + " esta realizando un control de calidad");
            Thread.sleep(1000);
            System.out.println("El trabajador " + getNombre() + " esta embalando el producto");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
