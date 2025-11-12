package servicios;

import interfaces.ArchivoSubible;
import model.AptoMedico;
import model.Socio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class GestorArchivos {
    private final String rutaBase;

    public GestorArchivos(String rutaBase) {
        this.rutaBase = rutaBase;
        crearCarpetaSiNoExiste();
    }

    public static void subirArchivoMedicoDesdeConsola(List<Socio> listaSocios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del socio: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Socio socio = buscarSocioPorId(listaSocios, id);
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

        System.out.print("Ingrese el nombre del archivo (ej: apto_sofia.pdf): ");
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

    private static Socio buscarSocioPorId(List<Socio> listaSocios, int id) {
        for (Socio socio : listaSocios) {
            if (socio.getIdSocio() == id) {
                return socio;
            }
        }
        return null;
    }

    private void crearCarpetaSiNoExiste() {
        Path carpeta = Paths.get(rutaBase);
        if (!Files.exists(carpeta)) {
            try {
                Files.createDirectories(carpeta);
                System.out.println("Carpeta creada: " + carpeta.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("No se pudo crear la carpeta: " + e.getMessage());
            }
        }
    }

    public void subirArchivo(ArchivoSubible archivo) {
        Path rutaCompleta = Paths.get(rutaBase, archivo.obtenerNombreArchivo());

        // Validar si el archivo ya existe
        if (Files.exists(rutaCompleta)) {
            System.out.print("El archivo ya existe. ¿Desea reemplazarlo? (s/n): ");
            String respuesta = new Scanner(System.in).nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                System.out.println("Subida cancelada.");
                return;
            }
        }

        try (FileOutputStream fos = new FileOutputStream(rutaCompleta.toFile())) {
            fos.write(archivo.obtenerContenido());
            System.out.println("Archivo subido correctamente: " + rutaCompleta.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("E" +
                    "Error al subir el archivo: " + e.getMessage());
        }
    }
}