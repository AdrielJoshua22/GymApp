package model;

public class Entrenador extends Persona {
    private String especialidad;
    private String horarioDisponible;

    public Entrenador(int id, String nombre, String apellido, int dni, int edad, String especialidad, String horarioDisponible) {
        super(id, nombre, apellido, dni, edad);
        this.especialidad = especialidad;
        this.horarioDisponible = horarioDisponible;
    }

    public void asignarClase(String nombreClase) {
        System.out.println("Entrenador " + getNombreCompleto() + " ha sido asignado a la clase: " + nombreClase);
    }

    public void consultarDisponibilidad() {
        System.out.println("Entrenador " + getNombreCompleto() + " está disponible en: " + horarioDisponible);
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("Entrenador: " + getNombreCompleto() +
                " | DNI: " + getDni() +
                " | Edad: " + getEdad() +
                " | Especialidad: " + especialidad +
                " | Horario: " + horarioDisponible);
    }

    // Getters y setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(String horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }
}