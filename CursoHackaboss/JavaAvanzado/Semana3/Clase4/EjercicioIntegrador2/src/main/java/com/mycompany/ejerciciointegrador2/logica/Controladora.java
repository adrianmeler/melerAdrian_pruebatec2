/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciointegrador2.logica;

import com.mycompany.ejerciciointegrador2.persistence.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Controladora {
    
    ControladoraPersistencia control = new ControladoraPersistencia();
    
    public void crearEquipo(Equipo equipo){
        control.crearEquipo(equipo);
    }
          
    public Equipo traerEquipo(int id){
        return control.traerEquipo(id);
    }
    
    public List<Equipo> traerEquipos(){
        return control.traerEquipos();
    }
      
    public void editarEquipo(Equipo equipo){
        control.editarEquipo(equipo);
    }
    
    public void crearPartido(Partido partido){
        control.crearPartido(partido);
    }
          
    public Partido traerPartido(int id){
        return control.traerPartido(id);
    }
    
    public List<Partido> traerPartidos(){
        return control.traerPartidos();
    }
     
    public void editarPartido(Partido partido){
        control.editarPartido(partido);
    }
}
