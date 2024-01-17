/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioclase14.persistence;

import com.mycompany.ejercicioclase14.logica.Votacion;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class ControladoraPersistencia {
    
    VotacionJpaController control = new VotacionJpaController();
    
    public void crearVoto(Votacion voto){
        
        control.create(voto);
    }
    
     public List<Votacion> traerVotos(){
        
        return control.findVotacionEntities();
    }
}
