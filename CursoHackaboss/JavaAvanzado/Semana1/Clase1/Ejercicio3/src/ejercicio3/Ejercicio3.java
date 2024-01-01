/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;

import Models.PosicionInvalidaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int [] vector = new int [5];
        
        agregarDatos(4,5,2,7,8,vector);
        
        try {
            System.out.println(mostrarDato(7
                    ,vector));
        } catch (PosicionInvalidaException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void agregarDatos(int numero,int numero2,int numero3, int numero4,int numero5, int [] vector){
        
        try{
          
            vector[0] = numero;
            
            vector[1] = numero2;
            
            vector[2] = numero3;
            
            vector[3] = numero4;
            
            vector[4] = numero5;
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static int mostrarDato(int numero,int [] vector) throws PosicionInvalidaException{
        
        int resultado = 0;
        
        try{
        
            resultado = resultado + vector[numero];
            
            if((numero >= 6) || (numero < 0)){
                throw new PosicionInvalidaException("La posicion ingresada no existe");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return resultado;
    }
    
}
