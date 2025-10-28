package model;

import interfaces.ArchivoSubible;

import java.time.LocalDate;

/**
 * Representa un archivo de apto médico que puede ser subido al sistema.
 */
public class AptoMedico implements ArchivoSubible {
    private final String nombreArchivo;
    private final byte[] contenido;
    private final String tipoMime;


    @Override
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public byte[] obtenerContenido() {
        return contenido;
    }

    @Override
    public String obtenerTipoMime() {
        return tipoMime;
    }

    private final LocalDate fechaSubida;

    public AptoMedico(String nombreArchivo, byte[] contenido, String tipoMime) {
        this.nombreArchivo = nombreArchivo;
        this.contenido = contenido;
        this.tipoMime = tipoMime;
        this.fechaSubida = LocalDate.now();
    }

    public LocalDate getFechaSubida() {
        return fechaSubida;
    }

}