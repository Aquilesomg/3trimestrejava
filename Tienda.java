import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Producto> productos = Inventario.obtenerProductos();
        List<Producto> carrito = new ArrayList<>();

        System.out.println("=== BIENVENIDO A NUESTRA TIENDA ===");
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        if (nombre != null && !nombre.isEmpty()) {
            System.out.println("Bienvenido " + nombre + "!");

            boolean salir = false;
            while (!salir) {
                int navegacion = obtenerOpcion(scanner);

                switch (navegacion) {
                    case 1:
                        obtenerProductos(productos);
                        break;
                    case 2:
                        realizarCompra(productos, carrito, scanner);
                        break;
                    case 3:
                        verCarrito(carrito);
                        break;
                    case 4:
                        salir = true;
                        System.out.println("Gracias por visitar la tienda. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }
        } else {
            System.out.println("Ingresa un nombre válido.");
        }

        scanner.close();
    }

    public static int obtenerOpcion(Scanner scanner) {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Ver Productos");
        System.out.println("2. Realizar compra");
        System.out.println("3. Ver mi carrito");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opción: ");
        return scanner.nextInt();
    }

    public static void obtenerProductos(List<Producto> productos) {
        System.out.println("\n=== Productos Disponibles ===");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.getNombre() +
                               " - $" + producto.getPrecio() +
                               " (Stock: " + producto.getStock() + ")");
        }
    }

    public static void realizarCompra(List<Producto> productos, List<Producto> carrito, Scanner scanner) {
        obtenerProductos(productos);

        System.out.print("Elige un producto (0 para volver): ");
        int opcion = scanner.nextInt();
        if (opcion == 0) return;

        if (opcion > 0 && opcion <= productos.size()) {
            Producto seleccionado = productos.get(opcion - 1);

            System.out.print("¿Cuántas unidades quieres?: ");
            int cantidad = scanner.nextInt();

            if (cantidad > 0 && cantidad <= seleccionado.getStock()) {
                seleccionado.setStock(seleccionado.getStock() - cantidad);
                for (int i = 0; i < cantidad; i++) {
                    carrito.add(seleccionado);
                }
                System.out.println("Producto agregado al carrito.");
            } else {
                System.out.println("Cantidad inválida o sin stock suficiente.");
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public static void verCarrito(List<Producto> carrito) {
        if (carrito.isEmpty()) {
            System.out.println("Tu carrito está vacío.");
            return;
        }
        double total = 0;
        System.out.println("\n=== Tu Carrito ===");
        for (Producto p : carrito) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
            total += p.getPrecio();
        }
        System.out.println("Total a pagar: $" + total);
    }
}
