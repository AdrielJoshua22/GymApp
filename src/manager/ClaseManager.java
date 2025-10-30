package manager;

import model.Clase;
import model.Entrenador;
import model.Socio;

import java.util.Scanner;

public class ClaseManager {
    private static Clase claseActual;

    public static void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ CLASE ---");
            System.out.println("1. Crear Clase");
            System.out.println("2. Inscribir Socio");
            System.out.println("3. Cancelar Clase");
            System.out.println("4. Mostrar Información");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearClase(scanner);
                case 2 -> inscribirSocio(scanner);
                case 3 -> cancelarClase();
                case 4 -> mostrarInfo();
                case 0 -> System.out.println("↩ Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearClase(Scanner scanner) {
        System.out.print("ID Clase: ");
        int idClase = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre de la actividad: ");
        String actividad = scanner.nextLine();

        System.out.print("Horario: ");
        String horario = scanner.nextLine();

        System.out.print("Cupo máximo: ");
        int cupo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entrenadores disponibles:");
        EntrenadorManager.mostrarTodos();

        System.out.print("ID del entrenador a asignar: ");
        int idEntrenador = scanner.nextInt();
        scanner.nextLine();

        Entrenador entrenador = EntrenadorManager.buscarPorId(idEntrenador);
        if (entrenador == null) {
            System.out.println("Entrenador no encontrado.");
            return;
        }

        claseActual = new Clase(idClase, actividad, horario, cupo, entrenador);
        System.out.println("Clase creada con éxito.");
    }

    private static void inscribirSocio(Scanner scanner) {
        if (claseActual != null) {
            System.out.println("Datos del socio:");
            System.out.print("ID Socio: ");
            int idSocio = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("DNI: ");
            int dni = scanner.nextInt();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            Socio socio = new Socio(idSocio, nombre, apellido, dni, edad, true);
            claseActual.inscribirSocio(socio);
        } else {
            System.out.println("No hay clase creada.");
        }
    }

    private static void cancelarClase() {
        if (claseActual != null) {
            claseActual.cancelarClase();
        } else {
            System.out.println("No hay clase creada.");
        }
    }

    private static void mostrarInfo() {
        if (claseActual != null) {
            claseActual.mostrarInfoClase();
        } else {
            System.out.println("No hay clase creada.");
        }
    }
}