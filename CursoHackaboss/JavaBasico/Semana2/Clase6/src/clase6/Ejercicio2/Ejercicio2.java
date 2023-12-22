package clase6.Ejercicio2;

import java.util.ArrayList;
public class Ejercicio2 {

    public static void main(String[] args) {


        Producto producto1 = new Producto(1,"Laptop","Acer","Portatil",900.50,1000.00,500);
        Producto producto2 = new Producto(2,"Smartphone","Apple","Modelo 15",850.50,900.00,400);
        Producto producto3 = new Producto(3,"Cargador","Samsung","Europeo",50.50,60.00,300);
        Producto producto4 = new Producto(4,"Auriculares","Beats","Inalambrico",200.50,250.00,700);
        Producto producto5 = new Producto(5,"Tablet","Samsung","Small",700.50,750.00,1000);
        Producto producto6 = new Producto(6,"Televisor","LG","Inteligente",800.50,900.00,200);
        Producto producto7 = new Producto(7,"Raton","Acer","Inalambrico",600.50,700.00,600);
        Producto producto8 = new Producto(8,"PS5","Playstation","Europeo",700.50,750.00,300);
        Producto producto9 = new Producto(9,"Cascos","Urbanista","Inalambrico",120.50,150.00,100);
        Producto producto10 = new Producto(10,"Laptop","Acer","Portatil",500.50,600.00,5000);


        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);

        double aux = productos.get(0).getPrecioVenta();
        double aux2 = productos.get(0).getPrecioCosto();


        for (Producto obj: productos) {

            if(aux < obj.getPrecioVenta()){
                aux = obj.getPrecioVenta();
            }
        }

        System.out.println("El mayor precio es: " + aux);

        for (Producto obj: productos) {

            if(aux2 > obj.getPrecioCosto()){
                aux2 = obj.getPrecioCosto();
            }
        }

        System.out.println("El mayor precio es: " + aux2);

        productos.remove(4);
    }
}
