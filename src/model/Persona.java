package model;

public abstract class Persona {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected int edad;

    public Persona(int id, String nombre, String apellido, int dni, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public abstract void mostrarPerfil();
}