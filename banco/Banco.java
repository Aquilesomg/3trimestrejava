package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>(Datos.obtenerUsuarios());

        boolean salirPrograma = false;

        while (!salirPrograma) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            String opcionMenu = scanner.nextLine();

            switch (opcionMenu) {
                case "1":
                    Usuario usuario = iniciarSesion(scanner, usuarios);
                    if (usuario != null) {
                        menuUsuario(scanner, usuarios, usuario);
                    } else {
                        System.out.println("Credenciales incorrectas.");
                    }
                    break;

                case "2":
                    crearCuenta(scanner, usuarios);
                    break;

                case "3":
                    salirPrograma = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static Usuario iniciarSesion(Scanner scanner, List<Usuario> usuarios) {
        System.out.print("Ingrese su número de cuenta: ");
        int numCuenta = scanner.nextInt();
        System.out.print("Ingrese su pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        for (Usuario u : usuarios) {
            if (u.getnumeroCuenta() == numCuenta && u.getPin() == pin) {
                System.out.println("Bienvenido " + u.getNombre());
                return u;
            }
        }
        return null;
    }

    private static void crearCuenta(Scanner scanner, List<Usuario> usuarios) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Ingrese un pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        int numCuenta;
        while (true) {
            numCuenta = (int) (Math.random() * 90000) + 10000;
            boolean existe = false;
            for (Usuario u : usuarios) {
                if (u.getnumeroCuenta() == numCuenta) {
                    existe = true;
                    break;
                }
            }
            if (!existe) break;
        }

        Usuario nuevo = new Usuario(usuarios.size() + 1, nombre, saldo, pin, numCuenta);
        usuarios.add(nuevo);
        System.out.println("Cuenta creada con éxito. Su número de cuenta es: " + numCuenta);
    }

    private static void menuUsuario(Scanner scanner, List<Usuario> usuarios, Usuario usuario) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== MENÚ USUARIO =====");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Transferir");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Monto a depositar: ");
                    double dep = scanner.nextDouble();
                    scanner.nextLine();
                    usuario.setSaldo(usuario.getSaldo() + dep);
                    System.out.println("Depósito realizado. Saldo actual: " + usuario.getSaldo());
                    break;

                case "2":
                    System.out.print("Monto a retirar: ");
                    double ret = scanner.nextDouble();
                    scanner.nextLine();
                    if (ret <= usuario.getSaldo()) {
                        usuario.setSaldo(usuario.getSaldo() - ret);
                        System.out.println("Retiro realizado. Saldo actual: " + usuario.getSaldo());
                    } else {
                        System.out.println("Fondos insuficientes.");
                    }
                    break;

                case "3":
                    System.out.print("Monto a transferir: ");
                    double trans = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Número de cuenta destino: ");
                    int numDest = scanner.nextInt();
                    scanner.nextLine();

                    Usuario destino = null;
                    for (Usuario u : usuarios) {
                        if (u.getnumeroCuenta() == numDest && u != usuario) {
                            destino = u;
                            break;
                        }
                    }

                    if (destino != null) {
                        if (trans <= usuario.getSaldo()) {
                            usuario.setSaldo(usuario.getSaldo() - trans);
                            destino.setSaldo(destino.getSaldo() + trans);
                            System.out.println("Transferencia realizada. Saldo actual: " + usuario.getSaldo());
                        } else {
                            System.out.println("Fondos insuficientes para transferir.");
                        }
                    } else {
                        System.out.println("Cuenta destino inválida.");
                    }
                    break;

                case "4":
                    System.out.println("Cerrando sesión...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
