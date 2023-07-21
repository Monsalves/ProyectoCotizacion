import java.io.*;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Random;

public class GestorDatos {
    public  void guardarEnCsv(String datosStr, String nombreArchivo) {
        String[] filas = datosStr.trim().split("\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Codigo;Producto;Color;Cantidad;Precio");
            writer.newLine();
            for (String fila : filas) {
                String[] columnas = fila.split(";");
                for (int i = 0; i < columnas.length; i++) {
                    writer.write(columnas[i]);
                    if (i < columnas.length - 1) {
                        writer.write(";");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Producto> cargarDesdeCsv(String nombreArchivo) {
        ArrayList<Producto> productos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            // Omitir la primera línea (encabezados)
            reader.readLine();

            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] columnas = linea.split(";");
                if (columnas.length == 5) {
                    String codigo = columnas[0];
                    String nombre = columnas[1];
                    String color = columnas[2];
                    int cantidad = Integer.parseInt(columnas[3]);
                    int precio = Integer.parseInt(columnas[4]);

                    Producto producto = new Producto(codigo, nombre, color, cantidad, precio);
                    productos.add(producto);
                } else {
                    // Si una línea no tiene los atributos esperados, puedes manejarlo aquí.
                    // Por ejemplo, ignorar la línea o mostrar un mensaje de error.
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productos;
    }


    public ArrayList<Producto> generarProductosAleatorios(int cantidad) {
        ArrayList<Producto> productosAleatorios = new ArrayList<>();
        Random random = new Random();

        String[] nombres = {"Producto 1", "Producto 2", "Producto 3", "Producto 4", "Producto 5"};
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Negro", "Blanco"};
        int precioMin = 1000;
        int precioMax = 20000;
        int cantidadMin = 1;
        int cantidadMax = 100;

        for (int i = 0; i < cantidad; i++) {
            String codigo = "P" + String.format("%03d", i + 1); // Generar códigos como P001, P002, ...
            String nombre = nombres[random.nextInt(nombres.length)];
            String color = colores[random.nextInt(colores.length)];
            int cantidadProducto = random.nextInt(cantidadMax - cantidadMin + 1) + cantidadMin;
            int precio = random.nextInt(precioMax - precioMin + 1) + precioMin;

            Producto producto = new Producto(codigo, nombre, color, cantidadProducto, precio);
            productosAleatorios.add(producto);
        }

        return productosAleatorios;
    }


}
