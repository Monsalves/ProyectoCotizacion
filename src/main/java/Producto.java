import java.util.ArrayList;

public class Producto {
    private String codigo;
    private String nombre;
    private String color;
    private int cantidad;
    private int precio;

    public Producto(String codigo, String nombre,String color,int cantidad, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre(){return nombre;}
    public String getCodigo(){return codigo;}


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList listaDetalle(){
        ArrayList datos = new ArrayList();
        datos.add(codigo);
        datos.add(nombre);
        datos.add(color);
        datos.add(String.valueOf(cantidad));
        datos.add(String.valueOf(precio));

        return datos;
    }
    public String detalleProducto(){
        ArrayList detalle = listaDetalle();
        String detalleString = String.join(";",detalle);
        detalleString = detalleString +"\n";
        return detalleString;
    }



}
