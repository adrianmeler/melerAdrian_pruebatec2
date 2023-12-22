package clase5.Ejercicio2;

import clase5.Ejercicio2.Camiseta;

public class Ejercicio2 {

    public static void main(String[] args) {

        Zapato zapato1 = new Zapato(1,"Superstar",40.56,"Adidas",42,"Blanco","Cuero","Ninguno");
        Zapato zapato2 = new Zapato(1,"All Star",50.56,"Converse",42,"Negro","Tela","Ninguno");
        Zapato zapato3 = new Zapato(1,"Air Jordan",60.56,"Nike",42,"Blanco","Cuero","Ninguno");

        Pantalon pantalon1 = new Pantalon(1,"Rose",20.30,"Tommy",40,"Rosado","Skinny","Tela");
        Pantalon pantalon2 = new Pantalon(2,"Marine",30.30,"Zara",41,"Azul","Oversize","Bordeado");
        Pantalon pantalon3 = new Pantalon(3,"Pana",40.30,"Holister",43,"Marron","Normal","Tela");

        Camiseta camiseta1 = new Camiseta(1,"Moda",10.30,"Zara",10,"Blanco","Corta","Ancho");
        Camiseta camiseta2 = new Camiseta(2,"Fina",20.30,"Holister",15,"Negro","Larga","Normal");

        Sombrero sombrero = new Sombrero(1,"Americano",40.50,"Zara",15,"Amarillo","Playero","Pequeño");

        Vestimenta [] ropa = {zapato1,zapato2,zapato3,pantalon1,pantalon2,pantalon3,camiseta1,camiseta2,sombrero};

        for (int i = 0; i < ropa.length; i++){

            System.out.println(ropa[i].mostrarMarca());
        }

    }
}
