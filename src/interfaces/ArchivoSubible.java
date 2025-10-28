package interfaces;

/**
 * Representa un contrato para cualquier archivo que pueda ser subido al sistema.
 */
public interface ArchivoSubible {
    /**
     * Devuelve el nombre del archivo, incluyendo extensión.
     */
    String obtenerNombreArchivo();

    /**
     * Devuelve el contenido del archivo en forma de arreglo de bytes.
     */
    byte[] obtenerContenido();

    /**
     * Devuelve el tipo MIME del archivo (ej. "application/pdf", "image/jpeg").
     */
    String obtenerTipoMime();
}