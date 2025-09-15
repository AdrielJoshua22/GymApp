import manager.EntrenadorManager;
import manager.PagosManager;
import manager.RutinaManager;
import manager.SocioManager;
import model.Entrenador;
import model.Rutina;
import model.Socio;

public class GymListaDatos {

    public static void cargarDatos(
            SocioManager socioManager,
            EntrenadorManager entrenadorManager,
            RutinaManager rutinaManager,
            PagosManager
                    pagoManager
    ) {
        // Socios
        socioManager.agregarSocio(new Socio("001", "Lucía Gómez", "lucia@gmail.com", "12345678"));
        socioManager.agregarSocio(new Socio("002", "Martín Pérez", "martin@gmail.com", "87654321"));
        socioManager.agregarSocio(new Socio("003", "Sofía Ramírez", "sofia@gmail.com", "11223344"));

        // Entrenadores
        entrenadorManager.agregarEntrenador(new Entrenador("E01", "Carla Ruiz", "Funcional"));
        entrenadorManager.agregarEntrenador(new Entrenador("E02", "Diego Torres", "Musculación"));

        // Rutinas
        rutinaManager.agregarRutina(new Rutina("R01", "Full Body", "Lunes, Miércoles, Viernes", "E01"));
        rutinaManager.agregarRutina(new Rutina("R02", "Piernas", "Martes y Jueves", "E02"));

        // Pagos
        pagoManager.agregarPago(new Pago("001", "2025-09-01", 5000.0));
        pagoManager.agregarPago(new Pago("002", "2025-09-05", 4500.0));
        pagoManager.agregarPago(new Pago("003", "2025-09-10", 4800.0));
    }
}