package manager;

import model.Rutina;
import model.Socio;
import servicios.PlanificadorRutinas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RutinaManager {
    private static final List<Rutina> rutinas = new ArrayList<>();

    public static void mostrarMenu(Scanner scanner, SocioManager socioManager) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ RUTINA ---");
            System.out.println("1. Crear Rutina");
            System.out.println("2. Modificar Rutina");
            System.out.println("3. Mostrar Rutinas");
            System.out.println("4. Asignar Socio a Rutina");
            System.out.println("5. Generar Rutina Inteligente");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearRutina(scanner);
                case 2 -> modificarRutina(scanner);
                case 3 -> mostrarRutinas();
                case 4 -> asignarSocio(scanner);
                case 5 -> generarRutinaInteligente(scanner, socioManager);
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
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

        Rutina nuevaRutina = new Rutina(idRutina, idSocio, objetivo, descripcion, grupo, ejercicios, duracion);
        rutinas.add(nuevaRutina);
        System.out.println("Rutina creada.");
    }

    private static void modificarRutina(Scanner scanner) {
        if (rutinas.isEmpty()) {
            System.out.println("No hay rutinas creadas.");
            return;
        }

        System.out.print("Ingrese el ID de la rutina a modificar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        Rutina rutina = buscarPorId(idBuscado);
        if (rutina != null) {
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

            rutina.modificarRutina(idBuscado, rutina.getIdSocio(), nuevoObjetivo, nuevaDescripcion, nuevoGrupo, nuevaLista, nuevaDuracion);
            System.out.println("Rutina modificada.");
        } else {
            System.out.println("Rutina no encontrada.");
        }
    }

    private static void mostrarRutinas() {
        if (rutinas.isEmpty()) {
            System.out.println("No hay rutinas creadas.");
        } else {
            System.out.println("Rutinas disponibles:");
            for (Rutina r : rutinas) {
                r.mostrarRutina();
                System.out.println("---------------------");
            }
        }
    }

    private static void asignarSocio(Scanner scanner) {
        if (rutinas.isEmpty()) {
            System.out.println("No hay rutinas creadas.");
            return;
        }

        System.out.print("Ingrese el ID de la rutina a asignar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        Rutina rutina = buscarPorId(idBuscado);
        if (rutina != null) {
            rutina.asignarSocio();
        } else {
            System.out.println("Rutina no encontrada.");
        }
    }

    private static Rutina buscarPorId(int id) {
        for (Rutina r : rutinas) {
            if (r.getIdRutina() == id) {
                return r;
            }
        }
        return null;
    }

    public void agregarRutina(Rutina rutina) {
        rutinas.add(rutina);
    }

    private static void generarRutinaInteligente(Scanner scanner, SocioManager socioManager) {
        System.out.print("Ingrese el ID del socio: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Socio socio = socioManager.buscarPorId(id);
        if (socio != null && socio.isActivo()) {
            if (socio.getAptoMedico() == null) {
                System.out.println("El socio no tiene apto médico asignado. No se puede generar rutina.");
                return;
            }

            PlanificadorRutinas planificador = new PlanificadorRutinas();
            Rutina rutina = planificador.generarRutinaPara(socio);
            rutinas.add(rutina);
            System.out.println("Rutina generada automáticamente:");
            rutina.mostrarRutina();
        } else {
            System.out.println("Socio no encontrado o inactivo.");
        }
    }
}