/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica2.logica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Adrian
 */
@Entity
public class Citizen implements Serializable {
    
    
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCitizen;
    
    private String name;
    
    private String dni;
    
    @OneToMany(mappedBy = "citizen")
    private ArrayList<Turn> turns;

    public Citizen() {
    }

    public Citizen(int idCitizen, String name, String dni, ArrayList<Turn> turns) {
        this.idCitizen = idCitizen;
        this.name = name;
        this.dni = dni;
        this.turns = turns;
    }

    public int getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(int idCitizen) {
        this.idCitizen = idCitizen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Turn> getTurns() {
        return turns;
    }

    public void setTurns(ArrayList<Turn> turns) {
        this.turns = turns;
    }


    
    
}
