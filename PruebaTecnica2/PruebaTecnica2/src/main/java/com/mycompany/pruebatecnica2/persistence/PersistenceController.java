/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica2.persistence;

import com.mycompany.pruebatecnica2.logica.Citizen;
import com.mycompany.pruebatecnica2.logica.Turn;
import com.mycompany.pruebatecnica2.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class PersistenceController {
    
    CitizenJpaController citJpa = new CitizenJpaController();
    TurnJpaController turnJpa = new TurnJpaController();

    public void createTurn(Turn turn) {
    
        turnJpa.create(turn);
    }

    public Turn bringTurn(int id) {
    
        return turnJpa.findTurn(id);
    }

    public List<Turn> bringTurns() {
    
        return turnJpa.findTurnEntities();
    }
    
   

    public void editTurn(Turn turn) {
    
        try {
            turnJpa.edit(turn);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteTurn(int id) {
    
        try {
            turnJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createCitizen(Citizen citizen) {
    
        citJpa.create(citizen);
    }
    
    public Citizen bringCitizen(int id) {
    
        return citJpa.findCitizen(id);
    }

    public List<Citizen> bringCitizens() {
    
        return citJpa.findCitizenEntities();
    }

    public void editCitizen(Citizen citizen) {
    
        try {
            citJpa.edit(citizen);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCitizen(int id) {
    
        try {
            citJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
