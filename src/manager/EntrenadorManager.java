package manager;
import model.Entrenador;
import util.Validaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntrenadorManager {
    private static Entrenador entrenadorActual;
    private static final List<Entrenador> listaEntrenadores = new ArrayList<>();

    public static void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ENTRENADOR ---");
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Consultar Disponibilidad");
            System.out.println("3. Asignar Clase");
            System.out.println("4. Mostrar Perfil");
            System.out.println("5. Mostrar Todos");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearEntrenador(scanner);
                case 2 -> consultarDisponibilidad();
                case 3 -> asignarClase(scanner);
                case 4 -> mostrarPerfil();
                case 5 -> mostrarTodos();
                case 0 -> System.out.println("↩ Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearEntrenador(Scanner scanner) {
        System.out.print("ID Entrenador: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Validar que no exista un entrenador con ese ID
        if (buscarPorId(id) != null) {
            System.out.println("Ya existe un entrenador con ese ID.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        int dni = Validaciones.leerDni(scanner);
        int edad = Validaciones.leerEdad(scanner);

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Horario disponible: ");
        String horario = scanner.nextLine();

        entrenadorActual = new Entrenador(id, nombre, apellido, dni, edad, especialidad, horario);
        listaEntrenadores.add(entrenadorActual);
        System.out.println("Entrenador creado correctamente.");
    }

    private static void consultarDisponibilidad() {
        if (entrenadorActual != null) {
            entrenadorActual.consultarDisponibilidad();
        } else {
            System.out.println("No hay entrenador registrado actualmente.");
        }
    }

    private static void asignarClase(Scanner scanner) {
        if (entrenadorActual != null) {
            System.out.print("Nombre de la clase a asignar: ");
            String clase = scanner.nextLine();
            entrenadorActual.asignarClase(clase);
        } else {
            System.out.println("o hay entrenador registrado actualmente.");
        }
    }

    private static void mostrarPerfil() {
        if (entrenadorActual != null) {
            entrenadorActual.mostrarPerfil();
        } else {
            System.out.println("No hay entrenador registrado actualmente.");
        }
    }

    public static void mostrarTodos() {
        if (listaEntrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
        } else {
            System.out.println("Lista de entrenadores:");
            for (Entrenador e : listaEntrenadores) {
                e.mostrarPerfil();
            }
        }
    }

    public static Entrenador buscarPorId(int id) {
        for (Entrenador e : listaEntrenadores) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}