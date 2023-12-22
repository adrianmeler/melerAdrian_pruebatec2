package clase6.Ejercicio1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Auto auto1 = new Auto(1,"50006pjk","Tesla","Model S",2009,300000.50,"Mucha","Si");
        Auto auto2 = new Auto(2,"50246pfk","Audi","R-8",2016,200000.50,"Mucha","No");
        Auto auto3 = new Auto(3,"80006ijk","Lamborgini","Murcielago",2008,400000.50,"Mucha","No");

        Camioneta camioneta1 = new Camioneta(1,"6009pjkl","Toyota","Rover",2001,100000.90,"Mucha","Diesel");
        Camioneta camioneta2 = new Camioneta(2,"3409qjtl","Porsche","Cayenne",2008,90000.90,"Mucha","Diesel");
        Camioneta camioneta3 = new Camioneta(3,"9879tmkl","Range Rover","Nuevo",2013,80000.90,"Mucha","Diesel");

        Moto moto1 = new Moto(1,"89675RTGH","Harley Davidson","Rtp-90",2020,100000.99,"Mucha","Diesel");
        Moto moto2 = new Moto(2,"67675FGGH","Ducati","Rtp-80",2017,150000.99,"Mucha","Diesel");


        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(auto1);
        vehiculos.add(auto2);
        vehiculos.add(auto3);
        vehiculos.add(camioneta1);
        vehiculos.add(camioneta2);
        vehiculos.add(camioneta3);
        vehiculos.add(moto1);
        vehiculos.add(moto2);

        for (Vehiculo vehiculo: vehiculos) {
            if(vehiculo instanceof Auto){
                ((Auto) vehiculo).antiguedad();
                ((Auto) vehiculo).cargarEnergia();
            }

            if(vehiculo instanceof Camioneta){
                ((Camioneta) vehiculo).antiguedad();
                ((Camioneta) vehiculo).recargarCombustible();
            }

            if(vehiculo instanceof Moto){
                ((Moto) vehiculo).antiguedad();
                ((Moto) vehiculo).recargarCombustible();
            }
        }



    }
}
