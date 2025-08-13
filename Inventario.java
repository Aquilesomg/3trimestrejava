import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public static List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(1, "Manzana", 200, 20));
        lista.add(new Producto(2, "Pan", 50, 0));
        lista.add(new Producto(3, "Arroz", 230, 25));
        lista.add(new Producto(4, "Pera", 160, 20));
        lista.add(new Producto(5, "Uva", 100, 30));
        lista.add(new Producto(6, "Banana", 120, 10));

        return lista;
    }
}
