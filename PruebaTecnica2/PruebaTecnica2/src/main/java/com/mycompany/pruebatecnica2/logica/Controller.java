/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica2.logica;

import com.mycompany.pruebatecnica2.persistence.PersistenceController;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Controller {
    
     PersistenceController control = new PersistenceController();
    
    public void createTurn(Turn turn){
        control.createTurn(turn);
    }
    
    public Turn bringTurn(int id){
        return control.bringTurn(id);
    }
     
    public List<Turn> bringTurns(){
        return control.bringTurns();
    }
    
    public void editTurn(Turn turn){
        control.editTurn(turn);
    }
    
    public void deleteTurn(int id){
        control.deleteTurn(id);
    }
    
    
    
    public void createCitizen(Citizen citizen){
        control.createCitizen(citizen);
    }
    
     public Citizen bringCitizen(int id){
        return control.bringCitizen(id);
    }
     
    public List<Citizen> bringCitizens(){
        return control.bringCitizens();
    }
    
    public void editCitizen(Citizen citizen){
        control.editCitizen(citizen);
    }
    
    public void deleteCitizen(int id){
        control.deleteCitizen(id);
    }
}
