/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 *
 * @author Adrian
 */
public class RegistroMascotas <T extends Mascota>{
    
    private List<Mascota> mascotas;

    public RegistroMascotas() {
        this.mascotas = new ArrayList<Mascota>();
    }
    
    
    public void agregarMascota(T mascota){
        
        mascotas.add(mascota);
    }
    
    public void buscarNombre(String nombre){
        
        List<String> mascotaFiltrada = mascotas.stream()
                .filter(mascota -> mascota.getNombre().equals(nombre))
                .map(Mascota::getNombre)
                .collect(Collectors.toList()); 
        
        mascotaFiltrada.forEach(System.out::println);
    }
    
    public long cantidadTotal(){
        
        long cantidadTotal = mascotas.stream()
                .count();
        
        return cantidadTotal;
    }
       
}
