/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio2.models;

import com.mycompany.ejercicio2.persistence.ControladoraPersistencia;

/**
 *
 * @author Adrian
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearPlatillo(Platillo platillo) {
      controlPersis.crearPlatillo(platillo);
    }
    
    public void eliminarPlatillo(int id){
        controlPersis.eliminarPlatillo(id);
    }
    
    public void editarPlatillo(Platillo platillo){
        controlPersis.editarPlatillo(platillo);
    }
    
}
