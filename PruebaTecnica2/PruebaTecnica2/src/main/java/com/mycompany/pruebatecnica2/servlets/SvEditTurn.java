/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pruebatecnica2.servlets;

import com.mycompany.pruebatecnica2.logica.Controller;
import com.mycompany.pruebatecnica2.logica.Turn;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrian
 */
@WebServlet(name = "SvEditTurn", urlPatterns = {"/SvEditTurn"})
public class SvEditTurn extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("idEdit"));
        
        Turn turn = control.bringTurn(id);
        
        turn.setState("Done");
        
        control.editTurn(turn);
        
        response.sendRedirect("adminZone.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
