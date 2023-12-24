/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio2.persistence;

import com.mycompany.ejercicio2.models.Platillo;
import com.mycompany.ejercicio2.persistence.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ControladoraPersistencia {
    
     PlatilloJpaController platillo = new PlatilloJpaController();

    public void crearPlatillo(Platillo plato) {
        
        platillo.create(plato);
    }

    public void eliminarPlatillo(int id) {
          try {
              platillo.destroy(id);
          } catch (NonexistentEntityException ex) {
              Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    public void editarPlatillo(Platillo plato) {
          try {
              platillo.edit(plato);
          } catch (Exception ex) {
              Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
}
