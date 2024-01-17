/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Tarea {
    
    private String nombre;
    
    private List<Tarea> principales;
    
    private List<Tarea> subtareas;

    public Tarea() {
    }

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.principales = new ArrayList<>();
        this.subtareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tarea> getPrincipales() {
        return principales;
    }

    public void setPrincipales(List<Tarea> principales) {
        this.principales = principales;
    }

    public List<Tarea> getSubtareas() {
        return subtareas;
    }

    public void setSubtareas(List<Tarea> subtareas) {
        this.subtareas = subtareas;
    }

    @Override
    public String toString() {
        return "Tarea{" + "nombre=" + nombre + ", principales=" + principales + ", subtareas=" + subtareas + '}';
    }
    
    public void agragarPrincipal(Tarea tarea){
        
        principales.add(tarea);
    }
    
    public void agregarSubtarea(Tarea subtarea){
        
        subtareas.add(subtarea);
    }
    
    
}
