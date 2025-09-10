import model.Pagos;
import model.Rutina;
import model.Socio;

import java.time.LocalDate;
import java.util.Scanner;

public class GymApp {

    public static void main(String[] args) {

        Scanner tdo = new Scanner(System.in);
        String nombre, apellido;
        int edad, dni, idSocio;
        boolean activo;

        Socio Socio1 = new Socio(1, "Joshua", "Amengual", 37304055, 32, true);

        // System.out.println("Introduzca IdSocio");
        //idSocio = tdo.nextInt();
        //System.out.println("Introduzca nombre");
        //nombre = tdo.next();
        //System.out.println("Introduzca apellido");
        //apellido = tdo.next();
        //System.out.println("Introduzca DNI");
        //dni = tdo.nextInt();
        //System.out.println("Introduzca edad");
        //edad = tdo.nextInt();
        //System.out.println("Introduzca el pago");
        //activo = tdo.nextBoolean();

        //Socio Socio2 = new Socio(idSocio, nombre, apellido, dni, edad, activo);

        System.out.println("model.Socio 1 ");
        System.out.println(Socio1);

        //System.out.println("model.Socio 2 ");
        //System.out.println(Socio2);

        Pagos pago1 = new Pagos(1, 101, 5000, LocalDate.now(), true);
        pago1.registrarPago();

        Pagos pago2 = new Pagos(1, 101, 5000, LocalDate.now(), true);
        pago1.consultarEstado();

        Pagos pago3 = new Pagos(1, 101, 5000, LocalDate.now(), true);
        System.out.println(pago1.generarComprobante());

        Rutina rutina1 = new Rutina(1, 2, "Ganar Musculo", "Entrenamiento Pesado", "pecho", "banco plano", 1);
        rutina1.mostrarRutina();
    }

    }
