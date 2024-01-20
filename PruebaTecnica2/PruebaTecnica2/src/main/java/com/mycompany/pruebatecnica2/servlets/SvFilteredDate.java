/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pruebatecnica2.servlets;

import com.mycompany.pruebatecnica2.logica.Controller;
import com.mycompany.pruebatecnica2.logica.Turn;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrian
 */
@WebServlet(name = "SvFilteredDate", urlPatterns = {"/SvFilteredDate"})
public class SvFilteredDate extends HttpServlet {
    
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
        
        String filteredDateString = request.getParameter("filteredDate");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date filteredDate = null;
        
        //I make sure that the date specified by the user isnt empty
        if(filteredDateString != null){
            
            try {
                filteredDate = dateFormat.parse(filteredDateString);
            } catch (ParseException ex) {
                Logger.getLogger(SvFilteredDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            final Date filteredDateFinal = filteredDate;
            //I stream the turns and check if the turn date equals the users input
            List<Turn> filteredTurns = control.bringTurns().stream()
                .filter(turn -> turn.getDate().equals(filteredDateFinal))
                .collect(Collectors.toList());
            
            request.setAttribute("results", filteredTurns);
            
            request.getRequestDispatcher("turnDate.jsp").forward(request, response);
       
        }
      
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
