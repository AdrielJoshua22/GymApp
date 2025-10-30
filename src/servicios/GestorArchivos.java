package servicios;

import interfaces.ArchivoSubible;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GestorArchivos {
    private final String rutaBase;

    public GestorArchivos(String rutaBase) {
        this.rutaBase = rutaBase;
        crearCarpetaSiNoExiste();
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

    public void subirArchivo(interfaces.ArchivoSubible archivo) {
        Path rutaCompleta = Paths.get(rutaBase, archivo.obtenerNombreArchivo());

        try (FileOutputStream fos = new FileOutputStream(rutaCompleta.toFile())) {
            fos.write(archivo.obtenerContenido());
            System.out.println("Archivo subido correctamente: " + rutaCompleta.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al subir el archivo: " + e.getMessage());
        }
    }

    public static void subirAptoMedicoComoArchivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del socio: ");
        int id = scanner.nextInt();

        // Simulamos el contenido del archivo
        String contenido = "Apto médico vigente para socio ID: " + id;
        byte[] datos = contenido.getBytes();

        // Creamos el archivo subible
        ArchivoSubible archivo = new ArchivoSubible() {
            public String obtenerNombreArchivo() {
                return "apto_medico_" + id + ".txt";
            }

            public byte[] obtenerContenido() {
                return datos;
            }

            @Override
            public String obtenerTipoMime() {
                return "";
            }
        };

        // Usamos GestorArchivos
        GestorArchivos gestor = new GestorArchivos("archivos/apto_medico");
        gestor.subirArchivo(archivo);
    }
}