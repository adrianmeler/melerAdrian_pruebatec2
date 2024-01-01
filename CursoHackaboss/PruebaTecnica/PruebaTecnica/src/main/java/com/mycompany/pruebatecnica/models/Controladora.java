/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica.models;

import com.mycompany.pruebatecnica.persistence.ControladoraPersistencia;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearEmpleado(Empleado empleado){
        controlPersis.crearEmpleado(empleado);
    }
    
    public void eliminarEmpleado(int id){
        controlPersis.eliminarEmpleado(id);
    }
    
    public void editarEmpleado(Empleado empleado){
        controlPersis.editarEmpleado(empleado);
    }
    
    public Empleado traerEmpleado(int id){
        return controlPersis.traerEmpleado(id);
    }
    
    public ArrayList<Empleado> traerEmpleados(){
        return controlPersis.traerListaEmpleados();
    }
}
