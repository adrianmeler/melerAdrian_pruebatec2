/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Adrian
 */
public class ExploradorDirectorios {
    
    
    private Directorio directorio;

    public ExploradorDirectorios(Directorio directorio) {
        this.directorio = directorio;
    }

    public Directorio getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Directorio directorio) {
        this.directorio = directorio;
    }
    
    
    public static void explorarDirectorio(Directorio directorio){
        
       System.out.println(directorio.getNombre());
       
       for(String archivo : directorio.getArchivos()){
           System.out.println(archivo);
       }
       
       for(Directorio subdirectorios : directorio.getSubdirectorios()){
           
           explorarDirectorio(subdirectorios);
       }
        
    }
    
    
    
}
