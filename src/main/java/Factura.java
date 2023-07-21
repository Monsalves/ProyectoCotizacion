import java.util.ArrayList;

public class Factura {
    private String nombre;
    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public Factura(String codigo){
        this.nombre = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public String detalleFactura(){
        String detalle = "";
        for (int i = 0; i < productos.size(); i++) {
            detalle = productos.get(i).detalleProducto() + detalle;

        }
        return detalle;
    }



}
