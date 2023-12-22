package clase5.Ejercicio2;

public class Sombrero extends Vestimenta {

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
