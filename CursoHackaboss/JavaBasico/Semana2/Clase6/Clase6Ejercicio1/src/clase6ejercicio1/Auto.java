/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6ejercicio1;

/**
 *
 * @author Adrian
 */
public class Auto extends Vehiculo implements Electrico{
    
     private String capacidadBateria;

    private String autonomia;

    public Auto() {
    }

    public Auto(int id, String placa, String marca, String modelo, int anio, double costo, String capacidadBateria, String autonomia) {
        super(id, placa, marca, modelo, anio, costo);
        this.capacidadBateria = capacidadBateria;
        this.autonomia = autonomia;
    }

    public String getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(String capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }

    public String getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "capacidadBateria='" + capacidadBateria + '\'' +
                ", autonomia='" + autonomia + '\'' +
                '}';
    }

    @Override
    public void antiguedad() {
        System.out.println("Esta es la antiguedad");
    }

    @Override
    public void cargarEnergia() {
        System.out.println("Este auto esta cargando");
    }
}
