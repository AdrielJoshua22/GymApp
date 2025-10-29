package servicios;

import model.Rutina;
import model.Socio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlanificadorRutinas {

    private final List<String> baseEjercicios = List.of(
            "Sentadillas", "Flexiones", "Plancha", "Burpees", "Remo con banda", "Zancadas", "Abdominales"
    );

    public Rutina generarRutinaPara(Socio socio) {
        int tiempo = socio.getTiempoDisponible();
        List<String> ejerciciosSeleccionados = new ArrayList<>();
        int tiempoRestante = tiempo;

        for (String ejercicio : baseEjercicios) {
            int duracionEjercicio = 6; // fijo por ahora
            if (duracionEjercicio <= tiempoRestante) {
                ejerciciosSeleccionados.add(ejercicio);
                tiempoRestante -= duracionEjercicio;
            }
        }

        String listaEjercicios = String.join(", ", ejerciciosSeleccionados);
        String grupoMuscular = "Mixto";

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