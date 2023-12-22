package clase5.Ejercicio2;

public class Zapato extends Vestimenta {

    private String material;

    private String tipoCierre;

    public Zapato() {

    }

    public Zapato(int codigo, String nombre, double precio, String marca, int talla, String color, String material, String tipoCierre) {
        super(codigo, nombre, precio, marca, talla, color);
        this.material = material;
        this.tipoCierre = tipoCierre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    @Override
    public String mostrarMarca(){

        return "Estos zapatos son de marca: " + getMarca();
    }
}
