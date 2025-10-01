package util;

import java.util.Scanner;


public class Validaciones {

    public static int leerDni(Scanner scanner) {
        int dni;
        do {
            System.out.print("DNI (7 u 8 dígitos): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese solo números: ");
                scanner.next();
            }
            dni = scanner.nextInt();
            scanner.nextLine();
            if (String.valueOf(dni).length() < 7 || String.valueOf(dni).length() > 8) {
                System.out.println("El DNI debe tener 7 u 8 dígitos.");
            }
        } while (String.valueOf(dni).length() < 7 || String.valueOf(dni).length() > 8);
        return dni;
    }

    public static int leerEdad(Scanner scanner) {
        int edad;
        do {
            System.out.print("Edad (entre 10 y 100): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese una edad válida: ");
                scanner.next();
            }
            edad = scanner.nextInt();
            scanner.nextLine();
            if (edad < 10 || edad > 100) {
                System.out.println("Edad fuera de rango.");
            }
        } while (edad < 10 || edad > 100);
        return edad;
    }
}