/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebatecnica;

import com.mycompany.pruebatecnica.models.Controladora;
import com.mycompany.pruebatecnica.models.Empleado;
import com.mycompany.pruebatecnica.persistence.ControladoraPersistencia;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class PruebaTecnica {

    public static void main(String[] args) {
        
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        Controladora control = new Controladora();
        
        Calendar calendario = Calendar.getInstance();
        
        Empleado empleado = new Empleado();
        
        Empleado empleadoEdicion = new Empleado();
        
        int opcion;
        
        String opcionAgregar;
        
        String opcionEditar;
        
        String opcionEliminar;
        
        String opcionBuscar;
        
        String opcionListar;
        
        String apellido;
        
        String nombre;
        
        String cargo;
        
        String nombreMayuscula;
        
        String apellidoMayuscula;
        
        String cargoMayuscula;
        
        double salario;
        
        String fecha;
        
        int anio;
        
        int mes;
        
        int dia;
        
        int codigoEdicion;
        
        int codigoEliminacion;
        
        String cargoBuscar;
        
        String cargoBuscarMayuscula;
        
        int ultimoCodigoEliminacion;
        
        int ultimoCodigoEdicion;
        
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        Scanner scan = new Scanner(System.in);
        
        //Llamo al metodo traerEmpleados de la clase Controladora y meto el resultado en un ArrayList de tipo Empleado
        ArrayList<Empleado> empleados = control.traerEmpleados();
               
        
        do{
            System.out.println("|-------------------------------|");
            System.out.println("|Opciones:                      |");
            System.out.println("|-------------------------------|");
            System.out.println("|1-Mostrar empleados            | "
                             + "\n|2-Agregar empleado             |"
                             + "\n|3-Editar empleado              |"
                             + "\n|4-Eliminar un empleado         |"
                             + "\n|5-Buscar por cargo             |"
                             + "\n|6-Salir                        |"
                             + "\n|Elija una opcion (por numero): |");
            System.out.println("|-------------------------------");
            opcion = Integer.parseInt(scan.nextLine());
            
            //Si la opcion es menor a 7 y mayor a 0 procede el programa
            if((opcion < 7) && (opcion > 0)){
                
                //Switch con diferentes casos
                 switch(opcion){
                case 1:
                    
                    do{
                       System.out.println("Lista de empleados de la empresa:");
                       
                       //Bucle for each para recorrer el arrayList de Empleados
                    for(Empleado obj : empleados){
                       System.out.println("Nombre: " + obj.getNombre() + " Apellido: " + obj.getApellido() + " Cargo: " + obj.getCargo() + " Salario: " + obj.getSalario() + " Fecha de inicio: " + dateFormat.format(obj.getFecha().getTime()));
                    }
                    
                    System.out.println("Desea salir al menu? si/no:");
                    
                    opcionListar = scan.nextLine();
                    
                    }while(!opcionListar.equals("si"));

                    break;
                    
                case 2:
                    
                    do{
                        
                        System.out.println("Ingrese el nombre del empleado: ");
                        
                        nombre = scan.nextLine();
                        
                        nombreMayuscula = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                        
                        System.out.println("Ingrese el apellido del empleado: ");
                        
                        apellido = scan.nextLine();
                        
                        apellidoMayuscula = apellido.substring(0, 1).toUpperCase() + apellido.substring(1);
                        
                        System.out.println("Ingrese el cargo del empleado: ");
                        
                        cargo = scan.nextLine();
                        
                        cargoMayuscula = cargo.substring(0, 1).toUpperCase() + cargo.substring(1);
                       
                        System.out.println("Ingrese el salario del empleado: ");
                        
                        salario = Double.parseDouble(scan.nextLine());
                        
                        System.out.println("Ingrese el año de inicio del empleado: ");
                        
                        anio = Integer.parseInt(scan.nextLine());
                        
                        System.out.println("Ingrese el mes de inicio del empleado: ");
                        
                        mes = Integer.parseInt(scan.nextLine());
                        
                        System.out.println("Ingrese el dia de inicio del empleado: ");
                        
                        dia = Integer.parseInt(scan.nextLine());
                        
                        calendario.set(anio, mes - 1, dia);
                        
                        //Validacion de datos
                        if((!nombreMayuscula.equals("")) && (!apellidoMayuscula.equals("")) && (!cargoMayuscula.equals("")) 
                                && (validacionPalabra(nombreMayuscula) != true) && (validacionPalabra(apellidoMayuscula) != true) && (validacionPalabra(cargoMayuscula) != true) && 
                                (anio != 0) && (mes != 0) && (dia != 0)){
                            
                            empleado.setId(0);
                        
                            empleado.setNombre(nombreMayuscula);
                        
                            empleado.setApellido(apellidoMayuscula);
                        
                            empleado.setCargo(cargoMayuscula);
                        
                            empleado.setSalario(salario);
                        
                            empleado.setFecha(calendario);
                            
                            //Llamo al metodo crearEmpleado de la clase Controladora para agregar al empleado en la base de datos
                            control.crearEmpleado(empleado);
                            
                        }else{
                            System.out.println("Error en los datos ingresados");
                        }
                        
                        System.out.println("Desea salir al menu? si/no:");
                        
                        opcionAgregar = scan.nextLine();
                        
                    }while(!opcionAgregar.equals("si"));
                    
                    break;
                    
                case 3:
                    
                     do{
                       //Bucle for each para mostrar los datos de los empleados
                        for(Empleado obj : empleados){
                          System.out.println("Nombre: " + obj.getNombre() + " Apellido: " + obj.getApellido() + " Codigo de edicion: " + obj.getId());
                        }
                        
                        System.out.println("Ingrese el codigo de edicion del empleado: ");
                        
                        codigoEdicion = Integer.parseInt(scan.nextLine());
                        
                        //igualo la variable al valor del id del ultimo objeto del ArrayList
                        ultimoCodigoEdicion = empleados.get(empleados.size() -1).getId();
                        
                        //Validacion del valor ingresado por el usuario
                        if((codigoEdicion > 0) && (codigoEdicion <= ultimoCodigoEdicion)){
                            
                            //Llamo al metodo traerEmpleado para traer al empleado con el id igual al valor introducido por el usuario
                             empleadoEdicion = control.traerEmpleado(codigoEdicion);
                        
                        System.out.println("Ingrese el nombre: ");
                        
                        nombre = scan.nextLine();
                        
                        nombreMayuscula = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                        
                        System.out.println("Ingrese el apellido: ");
                        
                        apellido = scan.nextLine();
                        
                        apellidoMayuscula = apellido.substring(0, 1).toUpperCase() + apellido.substring(1);
                        
                        System.out.println("Ingrese el cargo: ");
                        
                        cargo = scan.nextLine();
                        
                        cargoMayuscula = cargo.substring(0, 1).toUpperCase() + cargo.substring(1);
                        
                        System.out.println("Ingrese el salario: ");
                        
                        salario = Double.parseDouble(scan.nextLine());
                        
                        System.out.println("Ingrese el año de inicio del empleado: ");
                        
                        anio = Integer.parseInt(scan.nextLine());
                        
                        System.out.println("Ingrese el mes de inicio del empleado: ");
                        
                        mes = Integer.parseInt(scan.nextLine());
                        
                        System.out.println("Ingrese el dia de inicio del empleado: ");
                        
                        dia = Integer.parseInt(scan.nextLine());
                        
                        calendario.set(anio, mes - 1, dia);
                        //Validacion de los datos ingresados por el usuario
                        if((!nombreMayuscula.equals("")) && (!apellidoMayuscula.equals("")) && (!cargoMayuscula.equals("")) && 
                            (validacionPalabra(nombreMayuscula) != true) && (validacionPalabra(apellidoMayuscula) != true) && (validacionPalabra(cargoMayuscula) != true) && 
                            (anio != 0) && (mes != 0) && (dia != 0)){
                            
                            empleadoEdicion.setNombre(nombreMayuscula);
                        
                            empleadoEdicion.setApellido(apellidoMayuscula);
                        
                            empleadoEdicion.setCargo(cargoMayuscula);
                        
                            empleadoEdicion.setSalario(salario);
                        
                            empleadoEdicion.setFecha(calendario);
                        
                            //Llamo al metodo editarEmpleado de la clase Controladora para editar los datos del usuario seleccionado
                            control.editarEmpleado(empleadoEdicion);
                            
                        }else{
                            System.out.println("Error en los datos ingresados");
                        }
                        
                        }else{
                             System.out.println("Error al elegir codigo de edicion");
                        }
                        
                        System.out.println("Desea salir al menu? si/no: ");
                        
                        opcionEditar = scan.nextLine();
                        
                    }while(!opcionEditar.equals("si"));
                    
                    break;
                    
                case 4:
                    
                    do{
                        
                        for(Empleado obj : empleados){
                          System.out.println("Nombre: " + obj.getNombre() + " Apellido: " + obj.getApellido() + " Codigo de eliminacion: " + obj.getId());
                        }
                        
                        System.out.println("Ingrese el codigo de eliminacion del empleado: ");
                        
                        codigoEliminacion = Integer.parseInt(scan.nextLine());
                        //Obtengo el id del ultimo elemento del arrayList para validar la opcion introducida por el usuario
                        ultimoCodigoEliminacion = empleados.get(empleados.size() -1).getId();
                        //validacion
                        if((codigoEliminacion > 0) && (codigoEliminacion <= ultimoCodigoEliminacion)){
                            
                            control.eliminarEmpleado(codigoEliminacion);
                            
                        }else{
                            System.out.println("Codigo no valido");
                        }
                        
                        System.out.println("Desea salir al menu? si/no");
                        
                        opcionEliminar = scan.nextLine();
                        
                    }while(!opcionEliminar.equals("si"));
                        
                    break;
                    
                case 5:
                    
                    do{
                       
                    System.out.println("Ingrese el cargo que quiere buscar: ");
                    
                    cargoBuscar = scan.nextLine();
                    
                    cargoBuscarMayuscula = cargoBuscar.substring(0, 1).toUpperCase() + cargoBuscar.substring(1);
                    
                    if(!cargoBuscar.equals("")){
                    
                     //bucle for each para recorrer el arrayList, si el valor introducido por el usuario es igual al cargo de alguno de los objetos entonces imprime el nombre
                     for(Empleado obj : empleados){
                     
                         if(cargoBuscarMayuscula.equals(obj.getCargo())){
                             
                            System.out.println("Nombre: " + obj.getNombre() + " Apellido: " + obj.getApellido() + " Cargo: " + obj.getCargo() + " Salario: " + obj.getSalario() + " Fecha de inicio: " + dateFormat.format(obj.getFecha().getTime()));
                         }
                     }
                    }else{
                        System.out.println("Tiene que ingresar un cargo");
                    }
                     
                     System.out.println("Desea salir al menu? si/no");
                     
                     opcionBuscar = scan.nextLine();
                     
                    }while(!opcionBuscar.equals("si"));
                    
                    break;
                    
                case 6:
                    
                    break;
                    
                
                default:
                    
                     System.out.println("Error al elegir opcion");
            }
                
            }else{
                
            System.out.println("Error al elegir opcion");
            
            }
            
        }while(opcion != 6);
        
        
        System.out.println("Gracias y hasta luego!");
    }
     
    //Metodo para validar que las palabras no tengan caracteres especiales
    private static boolean validacionPalabra(String palabra){
        
        boolean respuesta = false;
         
        String caracteresEspeciales = "!·$%&/()=?¿*^Ç-.,;:_1234567890";
         
        int i = 0;
         
        //Utilizo bucle while para recorrer el String
        while(i < caracteresEspeciales.length()){
             
            char caracter = caracteresEspeciales.charAt(i);
            //Convierto el caracter en String para ver si la palabra contiene ese String
            if (palabra.contains(String.valueOf(caracter))) {
               respuesta = true;
            }
             
            i++;
        }
         
         return respuesta;
    }
    
}

