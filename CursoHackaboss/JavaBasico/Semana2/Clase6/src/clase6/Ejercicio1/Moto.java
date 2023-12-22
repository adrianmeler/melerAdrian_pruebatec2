package clase6.Ejercicio1;

public class Moto extends Vehiculo implements Combustion {

    private String cilindrada;

    private String tipoMotor;

    public Moto() {
    }

    public Moto(int id, String placa, String marca, String modelo, int anio, double costo, String cilindrada, String tipoMotor) {
        super(id, placa, marca, modelo, anio, costo);
        this.cilindrada = cilindrada;
        this.tipoMotor = tipoMotor;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindrada='" + cilindrada + '\'' +
                ", tipoMotor='" + tipoMotor + '\'' +
                '}';
    }


    @Override
    public void antiguedad() {
        System.out.println("Esta es la antiguedad");
    }

    @Override
    public void recargarCombustible() {
        System.out.println("Esta moto esta cargando combustible");
    }
}
