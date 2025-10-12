package manager;

import model.Socio;
import util.IdGenerador;
import util.Validaciones;

import java.util.*;

public class SocioManager {
    private final List<Socio> socios = new ArrayList<>();
    private final Set<Integer> idsSocios = new HashSet<>();

    public void mostrarMenu(Scanner scanner) {
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

    private void crearSocio(Scanner scanner) {
        int id = IdGenerador.generarId(idsSocios, true);
        System.out.println("ID asignado automáticamente: " + id);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        int dni = Validaciones.leerDni(scanner);
        int edad = Validaciones.leerEdad(scanner);

        Socio nuevoSocio = new Socio(id, nombre, apellido, dni, edad, true);
        socios.add(nuevoSocio);
        idsSocios.add(id);

        System.out.println("Socio creado exitosamente con ID: " + id);
    }

    private void modificarSocio(Scanner scanner) {
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

    public void asignarClase(Scanner scanner) {
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

    public void mostrarSocioPorId(Scanner scanner) {
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

    private void darDeBaja(Scanner scanner) {
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

    private void mostrarTodosLosSocios() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios registrados.");
        } else {
            System.out.println("Lista de socios:");
            for (Socio s : socios) {
                System.out.println(s);
            }
        }
    }

    public Socio buscarPorId(int id) {
        for (Socio s : socios) {
            if (s.getIdSocio() == id) {
                return s;
            }
        }
        return null;
    }

    public void agregarSocio(Socio socio) {
        if (!idsSocios.contains(socio.getIdSocio())) {
            socios.add(socio);
            idsSocios.add(socio.getIdSocio());
        }
    }

    public List<Socio> getSocios() {
        return socios;
    }
}