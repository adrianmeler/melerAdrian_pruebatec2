/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioclase14.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "votacion")

public class Votacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int partidoA;
    private int partidoB;
    private int partidoC;

    public Votacion() {
    }

    public Votacion(Long id, int partidoA, int partidoB, int partidoC) {
        this.id = id;
        this.partidoA = partidoA;
        this.partidoB = partidoB;
        this.partidoC = partidoC;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPartidoA() {
        return partidoA;
    }

    public void setPartidoA(int partidoA) {
        this.partidoA = partidoA;
    }

    public int getPartidoB() {
        return partidoB;
    }

    public void setPartidoB(int partidoB) {
        this.partidoB = partidoB;
    }

    public int getPartidoC() {
        return partidoC;
    }

    public void setPartidoC(int partidoC) {
        this.partidoC = partidoC;
    }

    @Override
    public String toString() {
        return "Votacion{" + "id=" + id + ", partidoA=" + partidoA + ", partidoB=" + partidoB + ", partidoC=" + partidoC + '}';
    }
    
    
    
}
