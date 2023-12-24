/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

import com.mycompany.ejercicio2.models.Controladora;
import com.mycompany.ejercicio2.models.Platillo;
import com.mycompany.ejercicio2.persistence.ControladoraPersistencia;

/**
 *
 * @author Adrian
 */
public class Ejercicio2 {

    public static void main(String[] args) {
       
        //ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        Controladora control = new Controladora();
        
        Platillo platillo = new Platillo(1,"Albondigas","Hervir",5.6);
        Platillo platillo2 = new Platillo(2,"Tortilla","Freir",3.6);
        Platillo platillo3 = new Platillo(3,"Solomillo","Hornear",15.6);
        
        control.crearPlatillo(platillo);
        control.crearPlatillo(platillo2);
        control.crearPlatillo(platillo3);
        
        control.eliminarPlatillo(2);
        
        platillo3.setNombre("Entrecot");
        
        control.editarPlatillo(platillo3);
    }
}
