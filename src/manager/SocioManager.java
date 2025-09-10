package manager;

import model.Socio;

import java.util.Scanner;

public class SocioManager {
    private static Socio socioActual;

    public static void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ SOCIO ---");
            System.out.println("1. Crear Socio");
            System.out.println("2. Modificar Socio");
            System.out.println("3. Asignar Clase");
            System.out.println("4. Mostrar Datos");
            System.out.println("5. Dar de Baja");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearSocio(scanner);
                    break;
                case 2:
                    modificarSocio(scanner);
                    break;
                case 3:
                    asignarClase();
                    break;
                case 4:
                    mostrarDatos();
                    break;
                case 5:
                    darDeBaja();
                    break;
                case 0:
                    System.out.println("↩️ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearSocio(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
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
        socioActual = new Socio(id, nombre, apellido, dni, edad, true);
        System.out.println("✅ Socio creado.");
    }

    private static void modificarSocio(Scanner scanner) {
        if (socioActual != null) {
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Nueva edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            socioActual.modificarDatos(nombre, apellido, edad);
            System.out.println("✅ Datos modificados.");
        } else {
            System.out.println("⚠️ No hay socio creado.");
        }
    }

    private static void asignarClase() {
        if (socioActual != null) {
            socioActual.consultarClases();
        } else {
            System.out.println("⚠️ No hay socio creado.");
        }
    }

    private static void mostrarDatos() {
        if (socioActual != null) {
            System.out.println(socioActual);
        } else {
            System.out.println("⚠️ No hay socio creado.");
        }
    }

    private static void darDeBaja() {
        if (socioActual != null) {
            socioActual.darBaja();
            System.out.println("⚠️ Socio dado de baja.");
        } else {
            System.out.println("⚠️ No hay socio creado.");
        }
    }
}