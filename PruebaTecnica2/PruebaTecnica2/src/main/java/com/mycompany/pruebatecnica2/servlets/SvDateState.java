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
import java.util.stream.Collector;
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
@WebServlet(name = "SvDateState", urlPatterns = {"/SvDateState"})
public class SvDateState extends HttpServlet {

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
        
        String dateString = request.getParameter("dateState");
        String state = request.getParameter("state");
        
        String stateVariable = "";
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date filteredDate = null;
        //I make sure that the date and state chosen by the user are not empty
        try{
        if((dateString != null) && (state != null)){
        //I give the state variable a value based on the input given by the user
            if(state.equals("pending")){
                stateVariable = "Pending";
            }else if(state.equals("done")){
                stateVariable = "Done";
            }
            
            final String stateVariableFinal = stateVariable;
            try {
                filteredDate = dateFormat.parse(dateString);
            } catch (ParseException ex) {
                Logger.getLogger(SvDateState.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            final Date filteredDateFinal = filteredDate;
            //Here I stream the list of turns
            List<Turn> turns = control.bringTurns().stream()
                    //I make sure that the object attributes match the users input
                    .filter(turn -> turn.getDate().equals(filteredDateFinal) && turn.getState().equals(stateVariableFinal))
                    .collect(Collectors.toList());
            
            request.setAttribute("results", turns);
            
            request.getRequestDispatcher("turnState.jsp").forward(request, response);
        }else{
            response.sendRedirect("turnState.jsp");
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
