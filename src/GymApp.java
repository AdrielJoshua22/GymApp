import datos.GymListaDatos;
import manager.*;

import java.util.Scanner;

public class GymApp {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Instanciar managers
        SocioManager socioManager = new SocioManager();
        RutinaManager rutinaManager = new RutinaManager();
        PagosManager pagosManager = new PagosManager();
        EntrenadorManager entrenadorManager = new EntrenadorManager();
        ClaseManager claseManager = new ClaseManager();

        // Cargar datos de ejemplo
        GymListaDatos.cargarDatos(socioManager, entrenadorManager, rutinaManager, pagosManager);
        System.out.println("Datos de ejemplo cargados correctamente.\n");

        // Menú principal
        do {
            System.out.println("=== GYMAPP - MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Socios");
            System.out.println("2. Gestión de Rutinas");
            System.out.println("3. Gestión de Pagos");
            System.out.println("4. Gestión de Entrenadores");
            System.out.println("5. Gestión de Clases");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    SocioManager.mostrarMenu(scanner);
                    break;
                case 2:
                    RutinaManager.mostrarMenu(scanner);
                    break;
                case 3:
                    PagosManager.mostrarMenu(scanner);
                    break;
                case 4:
                    EntrenadorManager.mostrarMenu(scanner);
                    break;
                case 5:
                    ClaseManager.mostrarMenu(scanner);
                    break;
                case 0:
                    System.out.println("¡Gracias por usar GymApp!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}