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
public class InventarioAutos <T extends Auto>{
    
    private List<T> autos;

    public InventarioAutos() {
        this.autos = new ArrayList<T>();
    }
    
    public void agregarAuto(T auto){
        
        autos.add(auto);
    }
    
    public void buscarAnio(int anio){
        
        for(Auto auto: autos){
            if(auto.getAnio() == anio){
                System.out.println(auto.getMarca());
            }
        }
    }
    
    public double valorTotal(){
        
        double valorTotal = autos.stream()
                .mapToDouble(Auto::getPrecio)
                .reduce(0.0,(x,y) -> x+y);
                
        return valorTotal;
    }
    
}
