package clase6.Ejercicio1;

public abstract class Vehiculo {

    private int id;

    private String placa;

    private String marca;

    private String modelo;

    private int anio;

    private double costo;

    public Vehiculo() {
    }

    public Vehiculo(int id, String placa, String marca, String modelo, int anio, double costo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.costo = costo;
    }

    public abstract void antiguedad();
}
