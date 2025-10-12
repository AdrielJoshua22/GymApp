package datos;

import manager.EntrenadorManager;
import manager.PagosManager;
import manager.RutinaManager;
import manager.SocioManager;
import model.Entrenador;
import model.Pagos;
import model.Rutina;
import model.Socio;

import java.time.LocalDate;

public class GymListaDatos {

    private final EntrenadorManager entrenadorManager = new EntrenadorManager();

    public static void cargarDatos(
            SocioManager socioManager,
            EntrenadorManager entrenadorManager,
            RutinaManager rutinaManager,
            PagosManager pagosManager
    ) {
        cargarSocios(socioManager);
        cargarEntrenadores(entrenadorManager);
        cargarRutinas(rutinaManager);
        cargarPagos(pagosManager);
    }

    private static void cargarSocios(SocioManager socioManager) {
        socioManager.agregarSocio(new Socio(1, "Lucía", "Gomez", 28555789, 37, true));
        socioManager.agregarSocio(new Socio(2, "Martín", "Perez", 27889707, 38, true));
        socioManager.agregarSocio(new Socio(3, "Sofía", "Blanco", 37333999, 32, true));
    }

    public static void cargarEntrenadores(EntrenadorManager entrenadorManager) {
        EntrenadorManager.agregarEntrenador(new Entrenador(102, "Carla", "Perez", 3232333, 33, "Crossfit", "Turno mañana"));
        EntrenadorManager.agregarEntrenador(new Entrenador(103, "Juan", "Castro", 35678933, 30, "Funcional", "Turno tarde"));
        EntrenadorManager.agregarEntrenador(new Entrenador(104, "Carlos", "Martines", 3278893, 33, "Crossfit", "Turno noche"));
    }

    private static void cargarRutinas(RutinaManager rutinaManager) {
        rutinaManager.agregarRutina(new Rutina(201, 1, "Ganar Masa Muscular", "Entrenamiento de fuerza", "Pecho, brazos, abdomen", "Banco plano 3x15", 60));
        rutinaManager.agregarRutina(new Rutina(202, 2, "Tonificar", "Entrenamiento de piernas", "Cuádriceps, gemelos, glúteos", "Sentadilla, búlgara, hip thrust", 45));
    }

    private static void cargarPagos(PagosManager pagosManager) {
        pagosManager.agregarPago(new Pagos(1, 1, 50000, LocalDate.parse("2025-09-15"), true));
        pagosManager.agregarPago(new Pagos(2, 2, 39000, LocalDate.parse("2025-09-15"), true));
        pagosManager.agregarPago(new Pagos(3, 3, 43000, LocalDate.parse("2025-09-15"), true));
    }

    public EntrenadorManager getEntrenadorManager() {
        return entrenadorManager;
    }

}

