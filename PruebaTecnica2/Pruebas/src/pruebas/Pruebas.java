/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

/**
 *
 * @author Adrian
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String dni = "73453194A";
        
        System.out.println(dniValidation(dni));
    }
    
     private static boolean dniValidation(String dni){
         
       boolean answer = false;
        
       if((numbersValidation(dni) == true) || (letterValidation(dni) == true)){
        
           answer = true;
       }
        
        return answer;
    }
    
    private static boolean numbersValidation(String dni){
        
        boolean answer = false;
        
        String letters = "qwertyuiopñlkjhgfdsazxcvbnm";
        
        int i = 0;
        
        while(i < letters.length()){
            
            char character = letters.charAt(i);
            
            if(dni.substring(0, 8).contains(String.valueOf(character))){
                
                answer = true;
            }
            
            i++;
        }
        
        return answer;
    }
    
    private static boolean letterValidation(String dni){
        
        boolean answer = false;
        
        int z = 0;
        
         String numbers = "1234567890";
        
         while(z < numbers.length()){
            
            char character = numbers.charAt(z);
            
            if(dni.substring(8).equals(String.valueOf(character))){
            
                answer = true;
            }
            
            z++;
        }
         
         return answer;
    }
}
