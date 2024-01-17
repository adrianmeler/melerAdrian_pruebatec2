/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioclase14.logica;

import com.mycompany.ejercicioclase14.persistence.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Controladora {
    
    ControladoraPersistencia control = new ControladoraPersistencia();
    
    public void crearVoto(Votacion voto){
        control.crearVoto(voto);
    }
    
     public List<Votacion> traerVotos(){
        return control.traerVotos();
    }
}
