/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica.persistence;

import com.mycompany.pruebatecnica.models.Empleado;
import com.mycompany.pruebatecnica.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ControladoraPersistencia {
    
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    
    public void crearEmpleado(Empleado empleado){
        empleadoJpa.create(empleado);
    }
    
    public void eliminarEmpleado(int id) {
        try {
            empleadoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarEmpleado(Empleado empleado){
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado traerEmpleado(int id) {
        return empleadoJpa.findEmpleado(id);
    }

    public ArrayList<Empleado> traerListaEmpleados() {
        List<Empleado> lista = empleadoJpa.findEmpleadoEntities();
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>(lista);
        return listaEmpleados;
    }
}
