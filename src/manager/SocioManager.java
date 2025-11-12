package manager;


import model.AptoMedico;
import model.NivelDificultad;
import model.Objetivo;
import model.Socio;
import servicios.GestorArchivos;
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
            System.out.println("7. rutinas");
            System.out.println("8. Subir apto médico");
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
                case 7 -> configurarEntrenamiento(scanner);
                case 8 -> gestionarSubidaAptoMedico(scanner);


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
            for (Socio s : socios)
                s.mostrarPerfil();
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

    private void configurarEntrenamiento(Scanner scanner) {
        System.out.print("Ingrese el ID del socio: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Socio socio = buscarPorId(id);
        if (socio != null) {
            System.out.println("Seleccione objetivo (1-Hipertrofia, 2-Cardio, 3-Movilidad): ");
            int obj = scanner.nextInt();
            Objetivo objetivo = switch (obj) {
                case 1 -> Objetivo.HIPERTROFIA;
                case 2 -> Objetivo.CARDIO;
                case 3 -> Objetivo.MOVILIDAD;
                default -> Objetivo.CARDIO;
            };

            System.out.println("Seleccione nivel (1-Principiante, 2-Intermedio, 3-Avanzado): ");
            int niv = scanner.nextInt();
            NivelDificultad nivel = switch (niv) {
                case 1 -> NivelDificultad.PRINCIPIANTE;
                case 2 -> NivelDificultad.INTERMEDIO;
                case 3 -> NivelDificultad.AVANZADO;
                default -> NivelDificultad.PRINCIPIANTE;
            };

            System.out.print("Tiempo disponible por sesión (minutos): ");
            int tiempo = scanner.nextInt();

            socio.configurarEntrenamiento(objetivo, nivel, tiempo);
            System.out.println("Perfil de entrenamiento configurado.");
        } else {
            System.out.println("Socio no encontrado.");
        }
    }


    public void mostrarSociosDisponibles() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios registrados.");
        } else {
            System.out.println("Socios disponibles:");
            for (Socio s : socios) {
                System.out.println("ID: " + s.getIdSocio() + " - " + s.getNombreCompleto());
            }
        }
    }

    public void gestionarSubidaAptoMedico(Scanner scanner) {
        mostrarSociosDisponibles();

        System.out.print("Ingrese el ID del socio: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Socio socio = buscarPorId(id);
        if (socio == null) {
            System.out.println("Socio no encontrado.");
            return;
        }

        if (socio.tieneAptoMedico()) {
            System.out.println("El socio ya tiene un apto médico asignado: " +
                    socio.getAptoMedico().obtenerNombreArchivo());
            System.out.print("¿Desea reemplazarlo? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                System.out.println("Subida cancelada.");
                return;
            }
        }

        System.out.print("Ingrese el nombre del archivo (ej: apto_juan.pdf): ");
        String nombreArchivo = scanner.nextLine();

        System.out.print("Ingrese el contenido del apto médico: ");
        String contenidoTexto = scanner.nextLine();
        byte[] contenido = contenidoTexto.getBytes();

        AptoMedico apto = new AptoMedico(nombreArchivo, contenido, "application/pdf");
        socio.asignarAptoMedico(apto);

        GestorArchivos gestor = new GestorArchivos("archivos/apto_medico");
        gestor.subirArchivo(apto);

        System.out.println("Apto médico subido correctamente para " + socio.getNombreCompleto());
    }


}