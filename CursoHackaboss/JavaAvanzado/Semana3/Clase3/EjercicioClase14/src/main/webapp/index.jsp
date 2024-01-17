<%-- 
    Document   : index
    Created on : 12 ene 2024, 11:33:48
    Author     : Adrian
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.ejercicioclase14.logica.Votacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Votacion</h1>
        
        <div class="container mt-4">
        <form action="SvVotacion" method="POST">
            <h3>Elija su voto: </h3>
            <input type="radio" name="voto" value="1">
            <label for="partidoA">Partido A</label>
            <br>
            <input type="radio" name="voto" value="2">
            <label for="partidoA">Partido B</label>
            <br>
            <input type="radio" name="voto" value="3">
            <label for="partidoA">Partido C</label>
            <br>
            <button type="submit" class="btn btn-primary">Votar</button>
        </form>
        </div>
        
        <div class="container mt-4">
            
            <form action="SvVotacion" method="GET">
            <button class="btn btn-primary" type="submit">Resultados</button>
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
                        <th>Partido A</th>
                        <th>Partido B</th>
                        <th>Partido C</th>
                    </tr>
                </thead>
                <tbody>
                     <tr>
                    <%for (Integer votos :(ArrayList<Integer>)request.getAttribute("resultados")) {%>
                    
                        <td><%= votos%></td>
                    
                    <%}%>
                    </tr>
                </tbody>
            </table>
            
            
            
       
                <%}%>
        </div>
        
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
