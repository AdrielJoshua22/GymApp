package model;

import servicios.GestorArchivos;

public class Socio extends Persona {
    private boolean activo;
    private AptoMedico aptoMedico; // Nuevo atributo

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

    public void activar() {
        this.activo = true;
    }

    public void consultarClases() {
        System.out.println("Clases disponibles para el socio " + nombre);
    }

    public void asignarAptoMedico(AptoMedico apto) {
        this.aptoMedico = apto;
    }

    public void subirAptoMedico(GestorArchivos gestor) {
        if (aptoMedico != null) {
            gestor.subirArchivo(aptoMedico);
        } else {
            System.out.println("El socio no tiene un apto médico asignado.");
        }
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("Socio: " + getNombreCompleto() + " | DNI: " + dni + " | Edad: " + edad + " | Estado: " + (activo ? "Activo" : "Inactivo"));
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido +
                ", DNI: " + dni + ", Edad: " + edad + ", Estado: " + (activo ? "Activo" : "Inactivo");
    }

    public boolean isActivo() {
        return activo;
    }

    public int getIdSocio() {
        return id;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getDni() {
        return dni;
    }

    public AptoMedico getAptoMedico() {
        return aptoMedico;
    }
}