package util;

import model.Pagos;
import model.Socio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class TicketPago {

    public static void generarArchivo(Pagos pago, Socio socio) {
        String carpeta = "tickets";
        File directorio = new File(carpeta);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        String nombreArchivo = carpeta + "/ticket_pago_" + pago.getIdPago() + ".txt";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("=== GYMAPP - TICKET DE PAGO ===\n");
            writer.write("Fecha: " + pago.getFecha().format(formato) + "\n");
            writer.write("Socio: " + socio.getNombreCompleto() + "\n");
            writer.write("DNI: " + socio.getDni() + "\n");
            writer.write("Estado del socio: " + (socio.isActivo() ? "Activo" : "Inactivo") + "\n");
            writer.write("ID Pago: " + pago.getIdPago() + "\n");
            writer.write("Monto: $" + pago.getMonto() + "\n");
            writer.write("Estado del pago: " + (pago.isActivo() ? "Activo" : "Inactivo") + "\n");
            writer.write("Comprobante Nº: " + (int) (Math.random() * 1000000) + "\n");
            writer.write("===============================\n");
            System.out.println("Ticket generado en carpeta 'tickets': " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el ticket: " + e.getMessage());
        }
    }
}