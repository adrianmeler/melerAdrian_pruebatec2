/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5ejercicio2;

/**
 *
 * @author Adrian
 */
public class Sombrero extends Vestimenta{
    
     private String tipo;

    private String tamaño;

    public Sombrero() {
    }

    public Sombrero(int codigo, String nombre, double precio, String marca, int talla, String color, String tipo, String tamaño) {
        super(codigo, nombre, precio, marca, talla, color);
        this.tipo = tipo;
        this.tamaño = tamaño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String mostrarMarca(){

        return "Este sombrero es de marca: " + getTipo();
    }
}
