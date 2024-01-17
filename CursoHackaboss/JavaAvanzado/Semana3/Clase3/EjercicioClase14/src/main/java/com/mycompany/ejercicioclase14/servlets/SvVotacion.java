/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ejercicioclase14.servlets;

import com.mycompany.ejercicioclase14.logica.Controladora;
import com.mycompany.ejercicioclase14.logica.Votacion;
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
@WebServlet(name = "SvVotacion", urlPatterns = {"/SvVotacion"})
public class SvVotacion extends HttpServlet {
    
    Controladora control = new Controladora();
    Votacion voto = new Votacion();

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Votacion> votos = new ArrayList<>();
        ArrayList<Integer> resultados = new ArrayList<>();
        int partidoA = 0;
        int partidoB = 0;
        int partidoC = 0;
        
        for(Votacion voto : control.traerVotos()){
            
            if(voto.getPartidoA() == 1){
                partidoA++;
            }else if(voto.getPartidoB() == 1){
                partidoB++;
            }else if(voto.getPartidoC() == 1){
                partidoC++;
            }
            
        }
        
        resultados.add(partidoA);
            
        resultados.add(partidoB);
            
        resultados.add(partidoC);
        
        request.setAttribute("resultados", resultados);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String votos = request.getParameter("voto");
        
        if(votos.equals("1")){
            voto.setPartidoA(1);
            voto.setPartidoB(0);
            voto.setPartidoC(0);
        }else if(votos.equals("2")){
            voto.setPartidoA(0);
            voto.setPartidoB(1);
            voto.setPartidoC(0);
        }else if(votos.equals("3")){
            voto.setPartidoA(0);
            voto.setPartidoB(0);
            voto.setPartidoC(1);
        }
        
        control.crearVoto(voto);
        
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
