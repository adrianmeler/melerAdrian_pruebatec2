/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2clase12;

import Models.Ave;
import Models.Gato;
import Models.Mascota;
import Models.Perro;
import Models.RegistroMascotas;

/**
 *
 * @author Adrian
 */
public class Ejercicio2Clase12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Mascota mascota = new Ave(1,"Maria",(int)(Math.random() * 20) + 0,"Ave","Golondrina");
        Mascota mascota2 = new Gato(2,"Carlota",(int)(Math.random() * 20) + 0,"Gato","British Shorthair");
        Mascota mascota3 = new Perro(3,"Yinsug",(int)(Math.random() * 20) + 0,"Perro","Sharpei");
        Mascota mascota4 = new Gato(4,"Mateo",(int)(Math.random() * 20) + 0,"Gato","Maine Coon");
    
        RegistroMascotas registro = new RegistroMascotas();
        
        registro.agregarMascota(mascota);
        registro.agregarMascota(mascota2);
        registro.agregarMascota(mascota3);
        registro.agregarMascota(mascota4);
        
        registro.buscarNombre("Carlota");
        
        System.out.println(registro.cantidadTotal());
    }
    
}
