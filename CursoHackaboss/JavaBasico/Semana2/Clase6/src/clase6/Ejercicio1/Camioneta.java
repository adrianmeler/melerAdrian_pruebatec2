package clase6.Ejercicio1;

public class Camioneta extends Vehiculo implements Combustion {

    private String capacidadTanque;

    private String consumoCombustible;

    public Camioneta() {
    }

    public Camioneta(int id, String placa, String marca, String modelo, int anio, double costo, String capacidadTanque, String consumoCombustible) {
        super(id, placa, marca, modelo, anio, costo);
        this.capacidadTanque = capacidadTanque;
        this.consumoCombustible = consumoCombustible;
    }

    public String getCapacidadTanque() {
        return capacidadTanque;
    }

    public void setCapacidadTanque(String capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    public String getConsumoCombustible() {
        return consumoCombustible;
    }

    public void setConsumoCombustible(String consumoCombustible) {
        this.consumoCombustible = consumoCombustible;
    }

    @Override
    public String toString() {
        return "Camioneta{" +
                "capacidadTanque='" + capacidadTanque + '\'' +
                ", consumoCombustible='" + consumoCombustible + '\'' +
                '}';
    }


    @Override
    public void antiguedad() {
        System.out.println("Antiguedad de la camioneta");
    }

    @Override
    public void recargarCombustible() {
        System.out.println("Esta camioneta esta cargando combustible");
    }

}
