/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ejerciciointegrador2.servlets;

import com.mycompany.ejerciciointegrador2.logica.Controladora;
import com.mycompany.ejerciciointegrador2.logica.Equipo;
import com.mycompany.ejerciciointegrador2.logica.Partido;
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
@WebServlet(name = "SvEquipos", urlPatterns = {"/SvEquipos"})
public class SvEquipos extends HttpServlet {

    Controladora control = new Controladora();
    Equipo equipo = new Equipo();
    Partido partido = new Partido();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        ArrayList<Partido> partidos = new ArrayList<>();
        
        for(Partido partido : control.traerPartidos()){
            partidos.add(partido);
        }
        
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombreEquipo = request.getParameter("nombreEquipo");
        String jugador = request.getParameter("jugador");
        String partidos = request.getParameter("partidos");
        
        String resultado = request.getParameter("resultado");
        
        String fechaString = request.getParameter("fecha");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       
        Date fecha = null;
        
        ArrayList<Partido> partidosArray = new ArrayList<>();
        
        try {
            fecha = dateFormat.parse(fechaString);
        } catch (ParseException ex) {
            Logger.getLogger(SvEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(partidos.equals("partidoA")){
            partido.setNombre("Partido A");
        }else if(partidos.equals("partidoB")){
            partido.setNombre("Partido B");
        }else if(partidos.equals("partidoC")){
            partido.setNombre("Partido D");
        }else if(partidos.equals("partidoD")){
            partido.setNombre("Partido D");
        }
        
        
    
        
        Equipo equipo = new Equipo(0,nombreEquipo,jugador,partidosArray);
        
        control.crearEquipo(equipo);
        
        Partido partido = new Partido(0,partidos,fecha,resultado,equipo);
        
        control.crearPartido(partido);
        
        partidosArray.add(partido);
        
        equipo.setPartidos(partidosArray);
        
        control.editarEquipo(equipo);
        
        
        response.sendRedirect("index.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
