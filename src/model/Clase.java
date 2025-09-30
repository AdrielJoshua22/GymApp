package model;
import java.util.ArrayList;
import java.util.List;

public class Clase {
    private final int idClase;
    private final String nombreActividad;
    private final String horario;
    private final int cupoMaximo;
    private final Entrenador entrenadorAsignado;
    private final List<Socio> listaSocios;

    public Clase(int idClase, String nombreActividad, String horario, int cupoMaximo, Entrenador entrenadorAsignado) {
        this.idClase = idClase;
        this.nombreActividad = nombreActividad;
        this.horario = horario;
        this.cupoMaximo = cupoMaximo;
        this.entrenadorAsignado = entrenadorAsignado;
        this.listaSocios = new ArrayList<>();
    }

    public void inscribirSocio(Socio socio) {
        if (listaSocios.size() < cupoMaximo && socio != null) {
            listaSocios.add(socio);
            System.out.println("Socio " + socio.getNombre() + " inscrito en la clase " + nombreActividad);
        } else {
            System.out.println("No se puede inscribir: cupo completo o socio inválido.");
        }
    }

    public void cancelarClase() {
        listaSocios.clear();
        System.out.println("Clase " + nombreActividad + " cancelada. Todos los socios han sido removidos.");
    }

    public void mostrarInfoClase() {
        System.out.println("Clase: " + nombreActividad);
        System.out.println("Horario: " + horario);
        System.out.println("Cupo máximo: " + cupoMaximo);
        System.out.println("Entrenador: " + entrenadorAsignado.getNombre());
        System.out.println("Socios inscritos:");
        for (Socio s : listaSocios) {
            System.out.println("- " + s.getNombre() + " " + s.getApellido());
        }
    }


    public String getNombreActividad() {
        return nombreActividad;
    }

    public String getHorario() {
        return horario;
    }
}
