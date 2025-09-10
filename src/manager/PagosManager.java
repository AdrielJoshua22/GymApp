package manager;

import model.Pagos;

import java.time.LocalDate;
import java.util.Scanner;

public class PagosManager {
    private static Pagos pagoActual;

    public static void mostrarMenu(Scanner scanner) {
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
                case 1:
                    registrarPago(scanner);
                    break;
                case 2:
                    consultarEstado();
                    break;
                case 3:
                    generarComprobante();
                    break;
                case 0:
                    System.out.println("↩️ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void registrarPago(Scanner scanner) {
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
    }

    private static void consultarEstado() {
        if (pagoActual != null) {
            System.out.println("📌 Estado del pago: " + pagoActual.consultarEstado());
        } else {
            System.out.println("⚠️ No hay pago registrado.");
        }
    }

    private static void generarComprobante() {
        if (pagoActual != null) {
            System.out.println(pagoActual.generarComprobante());
        } else {
            System.out.println("⚠️ No hay pago registrado.");
        }
    }
}