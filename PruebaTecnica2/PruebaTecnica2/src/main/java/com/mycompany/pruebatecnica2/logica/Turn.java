/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica2.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adrian
 */
@Entity
public class Turn implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurn;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    private String task;
    
    private String state;
    
    @ManyToOne
    @JoinColumn(name = "idCitizen")
    private Citizen citizen;

    public Turn() {
    }

    public Turn(int idTurn, Date date, String task, String state, Citizen citizen) {
        this.idTurn = idTurn;
        this.date = date;
        this.task = task;
        this.state = state;
        this.citizen = citizen;
    }
    
    
    

    public int getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(int idTurn) {
        this.idTurn = idTurn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

   
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

  
}
