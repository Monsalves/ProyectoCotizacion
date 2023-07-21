import java.sql.SQLOutput;
import java.util.ArrayList;

public class Luncher {

        public static void main(String[] args) {
            //Producto producto1 = new Producto("P002", "Producto 1", "Rojo", 5, 100);
            //Producto producto2 = new Producto("P002", "Producto 2", "Azul", 3, 150);
            // Crear una factura

            Factura factura = new Factura("inventario.csv");
            GestorDatos sas = new GestorDatos();
            ArrayList<Producto> productos =  sas.generarProductosAleatorios(20);

            for (Producto producto : productos){
                factura.agregarProducto(producto);
            }
            sas.guardarEnCsv(factura.detalleFactura(),factura.getNombre());




        }
}

