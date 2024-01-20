/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pruebatecnica2.servlets;

import com.mycompany.pruebatecnica2.logica.Citizen;

import com.mycompany.pruebatecnica2.logica.Controller;
import com.mycompany.pruebatecnica2.logica.Turn;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrian
 */
@WebServlet(name = "SvTurns", urlPatterns = {"/SvTurns"})
public class SvTurns extends HttpServlet {

    Controller control = new Controller();
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String dni = request.getParameter("dni");
        String dateString = request.getParameter("date");
        String procedure = request.getParameter("procedure");
        String state = "Pending";
        
        ArrayList<Turn> turns = new ArrayList<>();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       
        Date date = null;
        
        Citizen citizen = new Citizen();

        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(SvTurns.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Here I use two static methods to validate the name and dni 
        try{
            
            if((nameValidation(name) == false) && (dniValidation(dni) == false)){
                citizen.setIdCitizen(0);

                citizen.setName(name);
            
                citizen.setDni(dni);
            
                citizen.setTurns(turns);
           
                control.createCitizen(citizen);
            
            }else{
               response.sendRedirect("index.jsp"); 
            }
        
            Turn turn = new Turn(0,date,procedure,state,citizen);
            
            control.createTurn(turn);
            
            turns.add(turn);
            
            citizen.setTurns(turns);
            
            control.editCitizen(citizen);
            
            response.sendRedirect("index.jsp");
        
        }catch (Exception e){
            System.out.println(e);
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

     //Method to check for special characters
    private static boolean nameValidation(String word){
        
        boolean answer = false;
         
        String specialCharacters = "!·$%&/()=?¿*^Ç-.,;:_1234567890";
         
        int i = 0;
         
        //I use a while loop to iterate through the special characters
        while(i < specialCharacters.length()){
             
            char character = specialCharacters.charAt(i);
            //if the word contains any of the special characters then the answer will be true
            if (word.contains(String.valueOf(character))) {
               answer = true;
            }
             
            i++;
        }
         
         return answer;
    }
    
    private static boolean dniValidation(String dni){
         
       boolean answer = false;
       
       //To make the method shorter I separated it into two methods
       if((numbersValidation(dni) == true) || (letterValidation(dni) == true)){
        
           answer = true;
       }
        
        return answer;
    }
    
    //Method to validate that a portion of the input only has numbers
    private static boolean numbersValidation(String dni){
        
        boolean answer = false;
        
        String letters = "qwertyuiopñlkjhgfdsazxcvbnm";
        
        int i = 0;
        //I iterate through the letters with a while loop
        while(i < letters.length()){
            
            char character = letters.charAt(i);
            //If the specified portion of the input contains letters then the answer is true
            if(dni.substring(0, 8).contains(String.valueOf(character))){
                
                answer = true;
            }
            
            i++;
        }
        
        return answer;
    }
    
    //method to validate that the input doesnt have a number
    private static boolean letterValidation(String dni){
        
        boolean answer = false;
        
        int z = 0;
        
         String numbers = "1234567890";
        //I iterate through the numbers with a while loop
         while(z < numbers.length()){
            
            char character = numbers.charAt(z);
            //If the last character has a number the the answer is true
            if(dni.substring(8).equals(String.valueOf(character))){
            
                answer = true;
            }
            
            z++;
        }
         
         return answer;
    }
}
