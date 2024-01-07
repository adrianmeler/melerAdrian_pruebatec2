/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2clase11;

import Models.Evento;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Adrian
 */
public class Ejercicio2Clase11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Calendar fecha = Calendar.getInstance();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        List<Evento> eventos = Arrays.asList(new Evento("Festival",createCalendar(2024,1,27),"Fiesta"),new Evento("Reunion",createCalendar(2024,1, 27), "Trabajo"),new Evento("Clase",createCalendar(2024,4,30),"Trabajo"));
        
        System.out.println("Apartado numero 1: ");
        //Entro en los eventos
        List<String> eventosFechaEspecifica = eventos.stream()
                //filtro un evento, entor otra vez en los eventos 
                .filter(evento ->
                        //busco si hay una coincidencia entre un evento y otro evento
                        eventos.stream().anyMatch(otroEvento ->
                        dateFormat.format(evento.getFecha().getTime()).equals(dateFormat.format(otroEvento.getFecha().getTime()))))
                .map(Evento::getNombre)
                .collect(Collectors.toList());

        eventosFechaEspecifica.forEach(System.out::println);

        System.out.println("\nApartado numero 2: ");
        
        //Agrupo los eventos por categoria mediante grouping by y uso counting para contar los eventos 
        Map<String,Long> eventosPorCategoria = eventos.stream()
            .collect(Collectors.groupingBy(Evento::getCategoria,Collectors.counting()));
        
        eventosPorCategoria.forEach((evento,numero) -> System.out.println(evento + ": " + numero));
        
        System.out.println("\nApartado numero 3: ");
        
        //Busco el minimo con min y luego comparo las fechas
        Optional<Evento> eventoProximo = eventos.stream()
                .min((evento1,evento2) -> evento1.getFecha().compareTo(evento2.getFecha()));
        
        eventoProximo.ifPresent(evento -> System.out.println("El evento mas proximo es: " + evento.getNombre()));
    }
    
    
      private static Calendar createCalendar(int anio, int mes, int dia) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes - 1, dia); 
        return calendar;
    }
    
}
