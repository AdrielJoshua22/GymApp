package manager;

import model.Entrenador;

import java.util.Scanner;

public class EntrenadorManager {
    private static Entrenador entrenadorActual;

    public static void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ENTRENADOR ---");
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Consultar Disponibilidad");
            System.out.println("3. Asignar Clase");
            System.out.println("4. Mostrar Datos");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearEntrenador(scanner);
                    break;
                case 2:
                    consultarDisponibilidad();
                    break;
                case 3:
                    asignarClase(scanner);
                    break;
                case 4:
                    mostrarDatos();
                    break;
                case 0:
                    System.out.println("↩Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearEntrenador(Scanner scanner) {
        System.out.print("ID Entrenador: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Horario disponible: ");
        String horario = scanner.nextLine();

        entrenadorActual = new Entrenador(id, nombre, especialidad, horario);
        System.out.println("Entrenador creado.");
    }

    private static void consultarDisponibilidad() {
        if (entrenadorActual != null) {
            entrenadorActual.consultarDisponibilidad();
        } else {
            System.out.println("No hay entrenador registrado.");
        }
    }

    private static void asignarClase(Scanner scanner) {
        if (entrenadorActual != null) {
            System.out.print("Nombre de la clase a asignar: ");
            String clase = scanner.nextLine();
            entrenadorActual.asignarClase(clase);
        } else {
            System.out.println("No hay entrenador registrado.");
        }
    }

    private static void mostrarDatos() {
        if (entrenadorActual != null) {
            System.out.println(entrenadorActual);
        } else {
            System.out.println("No hay entrenador registrado.");
        }
    }

    public void agregarEntrenador(Entrenador entrenador) {
    }
}