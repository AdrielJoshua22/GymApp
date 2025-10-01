package model;

public class Socio extends Persona {
    private boolean activo;

    public Socio(int idSocio, String nombre, String apellido, int dni, int edad, boolean activo) {
        super(idSocio, nombre, apellido, dni, edad);
        this.activo = activo;
    }

    public void modificarDatos(String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            this.nombre = nuevoNombre;
        }
        if (nuevoApellido != null && !nuevoApellido.isEmpty()) {
            this.apellido = nuevoApellido;
        }
        if (nuevaEdad > 0) {
            this.edad = nuevaEdad;
        }
    }

    public void darBaja() {
        this.activo = false;
    }

    public void consultarClases() {
        System.out.println("Clases disponibles para el socio " + nombre);
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("👤 Socio: " + getNombreCompleto() + " | DNI: " + dni + " | Edad: " + edad + " | Estado: " + (activo ? "Activo" : "Inactivo"));
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido +
                ", DNI: " + dni + ", Edad: " + edad + ", Estado: " + (activo ? "Activo" : "Inactivo");
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdSocio() {
        return id;
    }

    public void setIdSocio(int idSocio) {
        this.id = idSocio;
    }
}