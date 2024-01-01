/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Adrian
 */
public class Inventario {
    
    
    private String nombreProducto;
    
    private double precio;
    
    private int cantidadDisponible;

    public Inventario() {
    }

    public Inventario(String nombreProducto, double precio, int cantidadDisponible) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
    
    public static void validarNombre(String nombre) throws NombreInvalidoExcepcion{
        
        String caracteresEspeciales = "!·$%&/()=?¿Ç;:_,.@";
        
        int i = 0;
        
        while(i < caracteresEspeciales.length()){
            
            if(nombre.contains(String.valueOf(caracteresEspeciales.charAt(i))) || nombre.equals("")){
                throw new NombreInvalidoExcepcion("Hay un error en el nombre introducido");
            }
        }
    }
    
    public static void validarPrecio(Double precio) throws PrecioInvalidoException{
        
        if(precio <= 0){
            throw new PrecioInvalidoException("El precio no puede ser menor 0 igual a 0");
        }
    }
    
    public static void validarCantidad(int cantidad) throws CantidadInvalidaException{
        
        if(cantidad < 0){
            throw new CantidadInvalidaException("La cantidad no puede ser menor a 0");
        }
        
    }
}
