package model;

public class Socio {
    private int idSocio;
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    private boolean activo;

    public Socio(int idSocio, String nombre, String apellido, int dni, int edad, boolean activo) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.activo = activo;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
