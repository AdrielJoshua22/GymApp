package model;


import servicios.GestorArchivos;


public class Socio extends Persona {
    private boolean activo;
    private AptoMedico aptoMedico;

    private Objetivo objetivoEntrenamiento;
    private NivelDificultad nivel;
    private int tiempoDisponible; // en minutos

    @Override
    public void subirAptoMedico() {
        // Lógica para subir el apto médico
        System.out.println("Apto médico subido correctamente para el socio.");
    }


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

    public boolean tieneAptoMedico() {
        return aptoMedico != null;
    }

    public AptoMedico getAptoMedico() {
        return aptoMedico;
    }

    @Override
    public void mostrarPerfil() {
        String estadoApto;
        if (aptoMedico != null) {
            estadoApto = "Subido (" + aptoMedico.obtenerNombreArchivo() + " el " + aptoMedico.getFechaSubida() + ")";
        } else {
            estadoApto = "Pendiente a subir";
        }

        System.out.println("Socio: " + getNombreCompleto() +
                " | DNI: " + dni +
                " | Edad: " + edad +
                " | Estado: " + (activo ? "Activo" : "Inactivo") +
                " | Apto médico: " + estadoApto);
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

    public void configurarEntrenamiento(Objetivo objetivo, NivelDificultad nivel, int tiempoDisponible) {
        this.objetivoEntrenamiento = objetivo;
        this.nivel = nivel;
        this.tiempoDisponible = tiempoDisponible;
    }

    public Objetivo getObjetivoEntrenamiento() {
        return objetivoEntrenamiento;
    }

    public NivelDificultad getNivel() {
        return nivel;
    }

    public int getTiempoDisponible() {
        return tiempoDisponible;
    }

    public void setObjetivoEntrenamiento(Objetivo objetivoEntrenamiento) {
        this.objetivoEntrenamiento = objetivoEntrenamiento;
    }

    public void setNivel(NivelDificultad nivel) {
        this.nivel = nivel;
    }

    public void setTiempoDisponible(int tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }

}