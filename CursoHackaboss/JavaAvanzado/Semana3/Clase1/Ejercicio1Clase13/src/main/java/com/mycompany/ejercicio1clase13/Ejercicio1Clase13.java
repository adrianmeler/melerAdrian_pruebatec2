/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1clase13;

import Models.Directorio;
import Models.ExploradorDirectorios;
import java.util.Arrays;

/**
 *
 * @author Adrian
 */
public class Ejercicio1Clase13 {

    public static void main(String[] args) {
        
        Directorio directorio1 = new Directorio(1,"Root");
        Directorio directorio2 = new Directorio(2,"Descargas");
        Directorio directorio3 = new Directorio(3,"Musica");
        Directorio directorio4 = new Directorio(4,"Documentos");
        
        directorio1.agregarSubdirectorio(directorio2);
        directorio1.agregarSubdirectorio(directorio3);
        directorio1.agregarSubdirectorio(directorio4);
        
        directorio2.agregarArchivos("Skype.exe");
        directorio3.agregarArchivos("Cancion.txt");
        directorio4.agregarArchivos("Word.txt");

        ExploradorDirectorios.explorarDirectorio(directorio1);
        
    }
    
   
}
