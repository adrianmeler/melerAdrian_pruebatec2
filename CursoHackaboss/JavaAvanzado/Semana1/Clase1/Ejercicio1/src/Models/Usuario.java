/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Adrian
 */
public class Usuario {
    
    private String nombre;
    
    private String destino;
    
    private String fecha;
    
    private int numeroAsientos;

    public Usuario() {
    }

    public Usuario(String nombre, String destino, String fecha, int numeroAsientos) {
        this.nombre = nombre;
        this.destino = destino;
        this.fecha = fecha;
        this.numeroAsientos = numeroAsientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }
    
    public void validarReserva(Usuario reserva) throws ReservaInvalidaException{
        
        if((reserva.getNombre().equals("")) || (reserva.getDestino().equals("")) || (reserva.getFecha().equals("")) || (reserva.getNumeroAsientos() <= 0)){
            
            throw new ReservaInvalidaException("Error al ingresar los datos de reserva");
        }
        
    }
}
