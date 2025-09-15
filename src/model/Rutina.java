package model;

public class Rutina {
    private int idRutina;
    private int idSocio;
    private String objetivo;
    private String descripcion;
    private String gruposMusculares;
    private boolean activa;
    private String listaEjercicios;
    private int duracion;

//Constructor

    public Rutina(int idRutina, int idSocio, String objetivo, String descripcion, String gruposMusculares, String listaEjercicios, int duracion) {
        this.idRutina = idRutina;
        this.idSocio = idSocio;
        this.objetivo = objetivo;
        this.descripcion = descripcion;
        this.gruposMusculares = gruposMusculares;
        this.listaEjercicios = listaEjercicios;
        this.duracion = duracion;
    }

    public void mostrarRutina() {
        System.out.println("Rutina Creada con Exito");
        System.out.println("Id Rutina " + idRutina);
        System.out.println("Id Socio" + idSocio);
        System.out.println("Objetivo" + objetivo);
        System.out.println("Descripcion" + descripcion);
        System.out.println("Grupo muscular" + gruposMusculares);
        System.out.println("Lista de Ejercicios" + listaEjercicios);
        System.out.println("duracion" + duracion);

    }

    public void modificarRutina(int nuevaRutina, int idSocio, String nuevoObjetivo, String nuevaDescripcion, String nuevoGrupoMuscular, String nuevaListaEjercicios, int nuevaDuracion) {
        this.idRutina = nuevaRutina;
        this.idSocio = idSocio;
        this.objetivo = nuevoObjetivo;
        this.descripcion = nuevaDescripcion;
        this.gruposMusculares = nuevoGrupoMuscular;
        this.listaEjercicios = nuevaListaEjercicios;
        this.duracion = nuevaDuracion;


    }

    //asignar socio. trae el idSocio y se lo asigna a idRutina.
    public void asignarSocio() {
        System.out.println("Usted Tiene asignada la rutina " + idRutina);

    }

    public int getIdSocio() {
        return 0;
    }

    public int getIdRutina() {
        return 0;
    }
}
