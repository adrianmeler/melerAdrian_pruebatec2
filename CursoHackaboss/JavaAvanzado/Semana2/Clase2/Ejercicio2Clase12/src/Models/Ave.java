/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Adrian
 */
public class Ave extends Mascota{
    
    private String raza;

    public Ave() {
    }

    public Ave(int id, String nombre, int edad, String especie, String raza) {
        super(id, nombre, edad, especie);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    
    
    
}
