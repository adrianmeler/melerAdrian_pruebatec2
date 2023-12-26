/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase3ejercicio1;

/**
 *
 * @author Adrian
 */
public class Electrodomestico {
    
     private int cod;

    private String marca;

    private String modelo;

    private String consumo;

    private String color;

    //Constructor vacio
    public Electrodomestico() {
    }
    //Constructor con parametros
    public Electrodomestico(int cod, String marca, String modelo, String consumo, String color) {
        this.cod = cod;
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.color = color;
    }

    //Getters y setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Creo un metodo para poder mostrar los datos solicitados
    public void mostrarDatos(){
        System.out.println("Marca: " + this.marca + "\n" + "Modelo: " + this.modelo + "\n" + "Consumo energetico: " + this.consumo);
    }
}
