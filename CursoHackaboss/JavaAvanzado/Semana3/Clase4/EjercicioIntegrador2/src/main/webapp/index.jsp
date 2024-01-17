<%-- 
    Document   : index
    Created on : 13 ene 2024, 21:00:43
    Author     : Adrian
--%>

<%@page import="com.mycompany.ejerciciointegrador2.logica.Partido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Equipos y Partidos</h1>
        
        
        <form action="SvEquipos" method="POST">
            <h3>Registro de Equipos</h3>
            <label>Nombre del Equipo</label>
            <input type="text" name="nombreEquipo">
            <br>
            <label>Jugador: </label>
            <input type="text" name="jugador">
            <br>
            <label>Partidos: </label>
            <input type="radio" name="partidos" value="partidoA">
            <input type="radio" name="partidos" value="partidoB">
            <input type="radio" name="partidos" value="partidoC">
            <input type="radio" name="partidos" value="partidoD">
            <br>
            <h3>Registro de Partidos</h3>
            <label>Fecha: </label>
            <input type="date" name="fecha">
            <br>
            <label>Resultado: </label>
            <input type="text" name="resultado">
            <br>
            <button type="submit">Enviar</button>
        </form>
        
        <br>
        <br>
        <br>
        
         <div class="container mt-4">
            
            <form action="SvEquipos" method="GET">
            <button type="submit">Mostrar tabla</button>
            </form>
            <br>
            <br>
            <br>
            
             <div class="results-table">
            <%if(request.getAttribute("resultados") != null){%>
            <h3>Resultados</h3>
            <table>
                <thead>
                    <tr>
                        <th>Nombre: </th>
                        <th>Fecha: </th>
                        <th>Resultado: </th>
                        <th>Equipo: </th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Partido partido :(ArrayList<Partido>)request.getAttribute("resultados")) {%>
                    <tr>
                        <td><%= partido.getNombre()%></td>
                        <td><%= partido.getFecha()%></td>
                        <td><%= partido.getResultado()%></td>
                        <td><%= partido.getEquipo().getNombreEquipo()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            
            
            
       
                <%}%>
        </div>
        
    </body>
</html>
