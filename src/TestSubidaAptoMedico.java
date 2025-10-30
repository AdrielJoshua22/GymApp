import model.AptoMedico;
import model.Socio;
import servicios.GestorArchivos;

public class TestSubidaAptoMedico {
    static void main(String[] args) {
        // 1. Crear el gestor de archivos con la ruta donde se guardarán los archivos.aptos
        GestorArchivos gestor = new GestorArchivos("archivos/archivos.aptos");

        // 2. Crear un socio
        Socio socio = new Socio(1, "Adriel", "Gómez", 12345678, 30, true);

        // 3. Simular contenido de un apto médico
        String contenidoTexto = "Este es el apto médico de Adriel.";
        byte[] contenido = contenidoTexto.getBytes(); // En la práctica, leerías un archivo real

        // 4. Crear el apto médico
        AptoMedico apto = new AptoMedico("apto_adriel.pdf", contenido, "application/pdf");
        // 5. Asignar el apto al socio
        socio.asignarAptoMedico(apto);

        // 6. Subir el apto médico
        socio.subirAptoMedico(gestor);
    }
}