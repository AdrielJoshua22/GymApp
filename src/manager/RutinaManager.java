package manager;

import model.Rutina;

import java.util.Scanner;

public class RutinaManager {
    private static Rutina rutinaActual;

    public static void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ RUTINA ---");
            System.out.println("1. Crear Rutina");
            System.out.println("2. Modificar Rutina");
            System.out.println("3. Mostrar Rutina");
            System.out.println("4. Asignar Socio");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearRutina(scanner);
                    break;
                case 2:
                    modificarRutina(scanner);
                    break;
                case 3:
                    mostrarRutina();
                    break;
                case 4:
                    asignarSocio();
                    break;
                case 0:
                    System.out.println("↩️ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearRutina(Scanner scanner) {
        System.out.print("ID Rutina: ");
        int idRutina = scanner.nextInt();
        System.out.print("ID Socio: ");
        int idSocio = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Objetivo: ");
        String objetivo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Grupo muscular: ");
        String grupo = scanner.nextLine();
        System.out.print("Lista de ejercicios: ");
        String ejercicios = scanner.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        rutinaActual = new Rutina(idRutina, idSocio, objetivo, descripcion, grupo, ejercicios, duracion);
        System.out.println("✅ Rutina creada.");
    }

    private static void modificarRutina(Scanner scanner) {
        if (rutinaActual != null) {
            System.out.print("Nuevo ID Rutina: ");
            int nuevaId = scanner.nextInt();
            System.out.print("Nuevo ID Socio: ");
            int nuevoIdSocio = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nuevo objetivo: ");
            String nuevoObjetivo = scanner.nextLine();
            System.out.print("Nueva descripción: ");
            String nuevaDescripcion = scanner.nextLine();
            System.out.print("Nuevo grupo muscular: ");
            String nuevoGrupo = scanner.nextLine();
            System.out.print("Nueva lista de ejercicios: ");
            String nuevaLista = scanner.nextLine();
            System.out.print("Nueva duración: ");
            int nuevaDuracion = scanner.nextInt();
            scanner.nextLine();

            rutinaActual.modificarRutina(nuevaId, nuevoIdSocio, nuevoObjetivo, nuevaDescripcion, nuevoGrupo, nuevaLista, nuevaDuracion);
            System.out.println("✅ Rutina modificada.");
        } else {
            System.out.println("⚠️ No hay rutina creada.");
        }
    }

    private static void mostrarRutina() {
        if (rutinaActual != null) {
            rutinaActual.mostrarRutina();
        } else {
            System.out.println("⚠️ No hay rutina creada.");
        }
    }

    private static void asignarSocio() {
        if (rutinaActual != null) {
            rutinaActual.asignarSocio();
        } else {
            System.out.println("⚠️ No hay rutina creada.");
        }
    }
}