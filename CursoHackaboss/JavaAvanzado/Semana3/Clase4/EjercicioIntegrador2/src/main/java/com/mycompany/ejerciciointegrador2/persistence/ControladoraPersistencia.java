/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciointegrador2.persistence;

import com.mycompany.ejerciciointegrador2.logica.Equipo;
import com.mycompany.ejerciciointegrador2.logica.Partido;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ControladoraPersistencia {
    
    EquipoJpaController equiJpa = new EquipoJpaController();
    PartidoJpaController partidoJpa = new PartidoJpaController();
    
    public void crearEquipo(Equipo equipo){
        equiJpa.create(equipo);
    }
    
    public Equipo traerEquipo(int id){
        return equiJpa.findEquipo(id);
    }
    
    public List<Equipo> traerEquipos(){
        return equiJpa.findEquipoEntities();
    }
    
    public void editarEquipo(Equipo equipo){
        try {
            equiJpa.edit(equipo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearPartido(Partido partido){
        partidoJpa.create(partido);
    }
    
    public Partido traerPartido(int id){
        return partidoJpa.findPartido(id);
    }
    
    public List<Partido> traerPartidos(){
        return partidoJpa.findPartidoEntities();
    }
    
    public void editarPartido(Partido partido){
        try {
            partidoJpa.edit(partido);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
