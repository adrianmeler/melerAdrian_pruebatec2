package Clase7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;


public class Ejercicio1 {

    public static void main(String[] args) {
        // TODO code application logic here

        String url = "jdbc:mysql://localhost:3306/universidad"; // URL de la base de datos "clinica"
        String usuario = "root"; // Nombre de usuario de la base de datos
        String contraseña = ""; // Contraseña de la base de datos
        String opcion;
        Scanner scan = new Scanner(System.in);
        String nombreEstudiante;
        int edad;
        int calificacion;
        //utilizamos excepciones para manejar posibles errores de conexión.
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            do{
                Statement statement = conexion.createStatement();
                String sql = "SELECT * FROM estudiantes";
                ResultSet result = statement.executeQuery(sql);
                System.out.println("Lista de estudiantes: " + "\n");
                while(result.next()){

                    int id = result.getInt("id");
                    String nombre = result.getNString("nombre");
                    int edad2 = result.getInt("edad");
                    int calificacion2 = result.getInt("calificacion");

                    System.out.println("Nombre: " + nombre + " edad: " + edad2 + " calificacion: " + calificacion2);

                }

                System.out.println("\nDesea agregar un estudiante?");
                opcion = scan.nextLine();
                if(opcion.equals("si")){
                    System.out.println("Ingrese el nombre del estudiante: ");
                    nombreEstudiante = scan.nextLine();
                    System.out.println("Ingrese la edad del estudiante: ");
                    edad = Integer.parseInt(scan.nextLine());
                    System.out.println("Ingrese la calificacion del estudiante: ");
                    calificacion = Integer.parseInt(scan.nextLine());
                    Statement statement2 = conexion.createStatement();
                    String sql2 = "INSERT INTO estudiantes(nombre,edad,calificacion) VALUES(?,?,?)";

                    PreparedStatement preparedStatement = conexion.prepareStatement(sql2);

                    preparedStatement.setString(1,nombreEstudiante);
                    preparedStatement.setInt(2, edad);
                    preparedStatement.setInt(3, calificacion);

                    preparedStatement.executeUpdate();
                }
            }while(!opcion.equals("no"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

        }
    }


}

