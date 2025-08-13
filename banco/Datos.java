package banco;
import java.util.ArrayList;
import java.util.List;

public class Datos {

    public static List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario(1, "Juan", 1000, 1234, 12345));
        lista.add(new Usuario(2, "Pedro", 1000, 5678, 67890));
        lista.add(new Usuario(3, "Samuel", 1000, 9012, 12345));
        lista.add(new Usuario(4, "Mateo", 1000, 3456, 67890));

        return lista;
    }
}
