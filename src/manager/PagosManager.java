package manager;

import model.Pagos;
import model.Socio;

import java.time.LocalDate;
import java.util.Scanner;

public class PagosManager {
    private final SocioManager socioManager;
    private Pagos pagoActual;

    public PagosManager(SocioManager socioManager) {
        this.socioManager = socioManager;
    }

    public void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PAGOS ---");
            System.out.println("1. Registrar Pago");
            System.out.println("2. Consultar Estado");
            System.out.println("3. Generar Comprobante");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarPago(scanner);
                case 2 -> consultarEstado();
                case 3 -> generarComprobante();
                case 0 -> System.out.println("↩ Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public void registrarPago(Scanner scanner) {
        System.out.print("ID Pago: ");
        int idPago = scanner.nextInt();
        System.out.print("ID Socio: ");
        int idSocio = scanner.nextInt();
        System.out.print("Monto: ");
        int monto = scanner.nextInt();
        scanner.nextLine();
        System.out.print("¿Está activo el pago? (true/false): ");
        boolean estado = scanner.nextBoolean();
        scanner.nextLine();

        LocalDate fecha = LocalDate.now();
        pagoActual = new Pagos(idPago, idSocio, monto, fecha, estado);
        pagoActual.registrarPago();

        // Activar socio si está inactivo
        Socio socio = socioManager.buscarPorId(idSocio);
        if (socio != null && !socio.isActivo()) {
            socio.activar();
            System.out.println("Socio " + socio.getNombreCompleto() + " activado automáticamente tras el pago.");
        } else if (socio == null) {
            System.out.println("No se encontró un socio con ese ID.");
        }
    }

    private void consultarEstado() {
        if (pagoActual != null) {
            System.out.println("Estado del pago: " + pagoActual.consultarEstado());
        } else {
            System.out.println("No hay pago registrado.");
        }
    }

    private void generarComprobante() {
        if (pagoActual != null) {
            System.out.println(pagoActual.generarComprobante());
        } else {
            System.out.println("No hay pago registrado.");
        }
    }

    public void agregarPago(Pagos pago) {
        // Si querés guardar historial, podés implementar una lista aquí
    }
}