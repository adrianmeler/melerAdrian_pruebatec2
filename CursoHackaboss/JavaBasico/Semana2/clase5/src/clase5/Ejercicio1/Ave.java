package Clase5;

public class Ave extends Animal {

    private String envergaduraAlas;

    private String tipoVuelo;

    private String colorPlumas;

    private String tipoPico;

    public Ave() {

    }

    public Ave(int id, String nombre, int edad, String tipoPiel, String tipoAlimentacion, String envergaduraAlas, String tipoVuelo, String colorPlumas, String tipoPico) {
        super(id, nombre, edad, tipoPiel, tipoAlimentacion);
        this.envergaduraAlas = envergaduraAlas;
        this.tipoVuelo = tipoVuelo;
        this.colorPlumas = colorPlumas;
        this.tipoPico = tipoPico;
    }

    public String getEnvergaduraAlas() {
        return envergaduraAlas;
    }

    public void setEnvergaduraAlas(String envergaduraAlas) {
        this.envergaduraAlas = envergaduraAlas;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String getColorPlumas() {
        return colorPlumas;
    }

    public void setColorPlumas(String colorPlumas) {
        this.colorPlumas = colorPlumas;
    }

    public String getTipoPico() {
        return tipoPico;
    }

    public void setTipoPico(String tipoPico) {
        this.tipoPico = tipoPico;
    }

    @Override
    public String saludar(){
        return "Hola, soy un ave";
    }
}
