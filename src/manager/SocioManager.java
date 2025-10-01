package manager;

import model.Socio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocioManager {
    private static final List<Socio> socios = new ArrayList<>();

    public static void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ SOCIO ---");
            System.out.println("1. Crear Socio");
            System.out.println("2. Modificar Socio");
            System.out.println("3. Asignar Clase");
            System.out.println("4. Mostrar Socio por ID");
            System.out.println("5. Dar de Baja");
            System.out.println("6. Mostrar todos los socios");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearSocio(scanner);
                case 2 -> modificarSocio(scanner);
                case 3 -> asignarClase(scanner);
                case 4 -> mostrarSocioPorId(scanner);
                case 5 -> darDeBaja(scanner);
                case 6 -> mostrarTodosLosSocios();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
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
        int dni = leerDni(scanner);
        int edad = leerEdad(scanner);
        Socio nuevoSocio = new Socio(id, nombre, apellido, dni, edad, true);
        socios.add(nuevoSocio);
        System.out.println("Socio creado.");
    }

    private static void modificarSocio(Scanner scanner) {
        System.out.print("Ingrese el ID del socio a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Socio socio = buscarPorId(id);
        if (socio != null) {
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Nueva edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            socio.modificarDatos(nombre, apellido, edad);
            System.out.println("Datos modificados.");
        } else {
            System.out.println("Socio no encontrado.");
        }
    }

    private static void asignarClase(Scanner scanner) {
        System.out.print("Ingrese el ID del socio: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Socio socio = buscarPorId(id);
        if (socio != null) {
            socio.consultarClases();
        } else {
            System.out.println("Socio no encontrado.");
        }
    }

    private static void mostrarSocioPorId(Scanner scanner) {
        System.out.print("Ingrese el ID del socio: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Socio socio = buscarPorId(id);
        if (socio != null) {
            System.out.println(socio);
        } else {
            System.out.println("Socio no encontrado.");
        }
    }

    private static void darDeBaja(Scanner scanner) {
        System.out.print("Ingrese el ID del socio a dar de baja: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Socio socio = buscarPorId(id);
        if (socio != null) {
            socio.darBaja();
            System.out.println("Socio dado de baja.");
        } else {
            System.out.println("Socio no encontrado.");
        }
    }

    private static void mostrarTodosLosSocios() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios registrados.");
        } else {
            System.out.println("Lista de socios:");
            for (Socio s : socios) {
                System.out.println(s);
            }
        }
    }

    private static Socio buscarPorId(int id) {
        for (Socio s : socios) {
            if (s.getIdSocio() == id) {
                return s;
            }
        }
        return null;
    }

    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }

    private static int leerDni(Scanner scanner) {
        String dniInput;
        int dni = 0;
        boolean dniValido = false;
        do {
            System.out.print("DNI (7 u 8 dígitos numéricos): ");
            dniInput = scanner.nextLine();
            if (dniInput.matches("\\d{7,8}")) {
                dni = Integer.parseInt(dniInput);
                dniValido = true;
            } else {
                System.out.println("Error: El DNI debe contener solo números y tener 7 u 8 dígitos.");
            }
        } while (!dniValido);
        return dni;
    }

    private static int leerEdad(Scanner scanner) {
        String edadInput;
        int edad = 0;
        boolean edadValida = false;
        do {
            System.out.print("Edad (entre 10 y 100): ");
            edadInput = scanner.nextLine();
            if (edadInput.matches("\\d+")) {
                edad = Integer.parseInt(edadInput);
                if (edad >= 10 && edad <= 100) {
                    edadValida = true;
                } else {
                    System.out.println("Error: La edad debe estar entre 10 y 100 años.");
                }
            } else {
                System.out.println("Error: La edad debe contener solo números.");
            }
        } while (!edadValida);
        return edad;
    }
}