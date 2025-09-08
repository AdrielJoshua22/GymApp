package model;

public class Socio {
    private int idSocio;
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    private boolean activo;

    public Socio(int idSocio, String nombre, String apellido, int dni, int edad, boolean b) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.activo = true;
    }

    public void modificarDatos(String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        this.nombre = nuevoNombre;
        this.apellido = nuevoApellido;
        this.edad = nuevaEdad;
    }

    public void darBaja() {
        this.activo = false;
    }

    public void consultarClases() {
        System.out.println("Clases disponibles para el socio " + nombre);
        // Aquí se conectará con la clase Clase
    }

    @Override
    public String toString() {
        return "ID: " + idSocio + ", Nombre: " + nombre + ", Apellido: " + apellido +
                ", DNI: " + dni + ", Edad: " + edad + ", Estado: " + (activo ? "Activo" : "Inactivo");
    }
}
