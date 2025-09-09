package model;

import java.time.LocalDate;


public class Pagos {
    private final int idPago;
    private final int idSocio;
    private final int monto;
    private final LocalDate fecha;
    private final boolean estado;

    public Pagos(int idPago, int idSocio, int monto, LocalDate fecha, boolean estado) {
        this.idPago = idPago;
        this.idSocio = idSocio;
        this.monto = monto;
        this.fecha = fecha;
        this.estado = estado;

    }

    public void registrarPago() {
        System.out.println("Pago registrado:");
        System.out.println("ID Pago: " + idPago);
        System.out.println("ID Socio: " + idSocio);
        System.out.println("Monto: $" + monto);
        System.out.println("Fecha: " + fecha);
        System.out.println("Estado: " + (estado ? "Activo" : "Inactivo"));
    }

}



