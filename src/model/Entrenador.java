package model;

public class Entrenador {
    private int idEntrenador;
    private String nombre;
    private String especialidad;
    private String horarioDisponible;

    public Entrenador(int idEntrenador, String nombre, String especialidad, String horarioDisponible) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horarioDisponible = horarioDisponible;
    }

    public void asignarClase(String nombreClase) {
        System.out.println("Entrenador " + nombre + " ha sido asignado a la clase: " + nombreClase);
       
    }

    public void consultarDisponibilidad() {
        System.out.println("Entrenador " + nombre + " está disponible en: " + horarioDisponible);
    }

    @Override
    public String toString() {
        return "ID: " + idEntrenador + ", Nombre: " + nombre + ", Especialidad: " + especialidad +
                ", Horario Disponible: " + horarioDisponible;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
