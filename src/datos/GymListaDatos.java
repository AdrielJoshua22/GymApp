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

    public static void cargarDatos(
            SocioManager socioManager,
            EntrenadorManager entrenadorManager,
            RutinaManager rutinaManager,
            PagosManager pagosManager
    ) {
        // Socios
        socioManager.agregarSocio(new Socio(1, "Lucía Gómez", "lucia@gmail.com", 28, 12345678, true));
        socioManager.agregarSocio(new Socio(2, "Martín Pérez", "martin@gmail.com", 35, 87654321, true));
        socioManager.agregarSocio(new Socio(3, "Sofía Ramírez", "sofia@gmail.com", 22, 11223344, true));

        // Entrenadores
        entrenadorManager.agregarEntrenador(new Entrenador(101, "Carla Ruiz", "Funcional", "Turno Mañana"));
        entrenadorManager.agregarEntrenador(new Entrenador(102, "Diego Torres", "Musculación", "Turno Tarde"));

        // Rutinas
        rutinaManager.agregarRutina(new Rutina(201, 1, "Ganar Masa Muscular", "Entrenamiento de fuerza", "Pecho, brazos, abdomen", "Banco plano 3x15", 60));
        rutinaManager.agregarRutina(new Rutina(202, 2, "Tonificar", "Entrenamiento de piernas", "Cuadriceps,gemelos,gluteos", "Sentadilla, bulgara, hiptrust", 45));

        // Pagos
        pagosManager.agregarPago(new Pagos(1, 1, 50000, LocalDate.parse("2025-09-15"), true));
        pagosManager.agregarPago(new Pagos(2, 2, 39000, LocalDate.parse("2025-09-15"), true));
        pagosManager.agregarPago(new Pagos(3, 3, 43000, LocalDate.parse("2025-09-15"), true));
    }
}
