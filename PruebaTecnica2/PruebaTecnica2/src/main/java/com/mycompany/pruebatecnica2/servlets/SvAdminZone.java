/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pruebatecnica2.servlets;

import com.mycompany.pruebatecnica2.logica.Controller;
import com.mycompany.pruebatecnica2.logica.Turn;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrian
 */
@WebServlet(name = "SvAdminZone", urlPatterns = {"/SvAdminZone"})
public class SvAdminZone extends HttpServlet {

    Controller control = new Controller();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ArrayList<Turn> turns = new ArrayList<>();
        
        //Here I iterate through the list of turns and add the turn into an arraylist
        for(Turn turn : control.bringTurns()){
            turns.add(turn);
        }
        
        request.setAttribute("results", turns);
        
        request.getRequestDispatcher("adminZone.jsp").forward(request, response);
    
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
