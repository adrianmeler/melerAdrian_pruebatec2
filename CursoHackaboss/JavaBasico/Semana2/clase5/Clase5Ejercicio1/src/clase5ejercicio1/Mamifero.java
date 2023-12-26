/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5ejercicio1;

/**
 *
 * @author Adrian
 */
public class Mamifero extends Animal{
    
     private int numeroPatas;

    private String tipoReproduccion;

    private String pelaje;

    private String habitat;

    public Mamifero() {
    }

    public Mamifero(int id, String nombre, int edad, String tipoPiel, String tipoAlimentacion, int numeroPatas, String tipoReproduccion, String pelaje, String habitat) {
        super(id, nombre, edad, tipoPiel, tipoAlimentacion);
        this.numeroPatas = numeroPatas;
        this.tipoReproduccion = tipoReproduccion;
        this.pelaje = pelaje;
        this.habitat = habitat;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    public String getTipoReproduccion() {
        return tipoReproduccion;
    }

    public void setTipoReproduccion(String tipoReproduccion) {
        this.tipoReproduccion = tipoReproduccion;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String saludar(){
        return "Hola, soy un mamifero";
    }
}
