package servicios;

import model.Rutina;
import model.Socio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlanificadorRutinas {

    // Lista base de ejercicios disponibles
    private final List<String> baseEjercicios = List.of(
            "Sentadillas", "Flexiones", "Plancha", "Burpees", "Remo con banda", "Zancadas", "Abdominales"
    );

    /**
     * Genera una rutina personalizada según el perfil del socio.
     *
     * @param socio El socio con objetivo, nivel y tiempo disponible.
     * @return Rutina generada o null si el perfil está incompleto.
     */
    public Rutina generarRutinaPara(Socio socio) {
        // Validación de perfil
        if (socio.getObjetivoEntrenamiento() == null || socio.getNivel() == null) {
            System.out.println("El socio no tiene configurado su objetivo o nivel de entrenamiento.");
            return null;
        }

        int tiempo = socio.getTiempoDisponible();
        List<String> ejerciciosSeleccionados = new ArrayList<>();
        int tiempoRestante = tiempo;

        // Selección de ejercicios según tiempo disponible
        for (String ejercicio : baseEjercicios) {
            int duracionEjercicio = 6; // fijo por ahora
            if (duracionEjercicio <= tiempoRestante) {
                ejerciciosSeleccionados.add(ejercicio);
                tiempoRestante -= duracionEjercicio;
            }
        }

        String listaEjercicios = String.join(", ", ejerciciosSeleccionados);
        String grupoMuscular = "Mixto"; // Podés personalizarlo según objetivo

        return new Rutina(
                generarIdRutina(),
                socio.getIdSocio(),
                socio.getObjetivoEntrenamiento().name(),
                "Rutina generada automáticamente",
                grupoMuscular,
                listaEjercicios,
                tiempo - tiempoRestante
        );
    }


    private int generarIdRutina() {
        return new Random().nextInt(9000) + 1000;
    }
}