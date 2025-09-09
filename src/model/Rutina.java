package model;

public class Rutina {
    private final int idRutina;
    private final int idSocio;
    private final String objetivo;
    private final String descripcion;
    private final String gruposMusculares;
    private boolean activa;
    private final String listaEjercicios;
    //Constructor

    public Rutina(int idRutina, int idSocio, String objetivo, String descripcion, String gruposMusculares, String listaEjercicios) {
        this.idRutina = idRutina;
        this.idSocio = idSocio;
        this.objetivo = objetivo;
        this.descripcion = descripcion;
        this.gruposMusculares = gruposMusculares;
        this.listaEjercicios = listaEjercicios;
    }
//Metodos

    public void crearRutina() {
        System.out.println("Rutina Creada con Exito");
        System.out.println("Id Rutina " + idRutina);
        System.out.println("Id Socio" + idSocio);
        System.out.println("Objetivo" + objetivo);
        System.out.println("Descripcion" + descripcion);
        System.out.println("Grupo muscular" + gruposMusculares);
        System.out.println("Lista de Ejercicios" + listaEjercicios);

    }

    public void asignarSocio() {
        System.out.println("Usted Tiene asignada la rutina " + idRutina);

    }


}
