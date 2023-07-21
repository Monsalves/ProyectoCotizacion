import java.util.ArrayList;

public class Administrador {

    public void  guardar(Factura factura){
        GestorDatos sas  = new GestorDatos();
        sas.guardarEnCsv(factura.getNombre(), factura.detalleFactura());

    }


}
