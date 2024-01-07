/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1clase11;

import Models.Empleado;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 *
 * @author Adrian
 */
public class Ejercicio1Clase11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Empleado> empleados = Arrays.asList(new Empleado("Adrian",1500.90,"Jefe"),new Empleado("Ronald",500.70,"Asistente"),new Empleado("Rafael",1200.60,"Asistente"), new Empleado("Clara",1400.90,"Jefe"));
        
        /*
        Aqui filtro los empleados que tengan un salario mayor a 1000
        */
        System.out.println("Apartado numero 1:");
        List<String> empleadosFiltrados =  empleados.stream()
                .filter(empleado -> empleado.getSalario() > 1000.00)
                .map(empleado -> empleado.getNombre())
                .collect(Collectors.toList());
        
        empleadosFiltrados.forEach(System.out::println);
        
        System.out.println("\nApartado numero 2:");
        
        //Agrupo los empleados por categoria y uso averaging double para sacar el promedio de los salarios
        Map<String,Double> salarioPromedio = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getCategoria, Collectors.averagingDouble(Empleado::getSalario)));
        
        System.out.println("Salario promedio");
        
        salarioPromedio.forEach((categoria,promedio) -> System.out.println(categoria + ": " + promedio));
        
        System.out.println("\nApartado numero 3:");
        
        //Saco el salario maximo usando max y comparing para comparar el salario
        Optional<Empleado> salarioMayor = empleados.stream()
                .max(Comparator.comparing(Empleado::getSalario));
        
         salarioMayor.ifPresent(empleado -> System.out.println("Empleado con el salario más alto: " + empleado.getNombre()));
    }
    
}
