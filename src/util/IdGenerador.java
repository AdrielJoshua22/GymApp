package util;

import java.util.Set;


public class IdGenerador {
    private static int ultimoIdSocio = 4;
    private static int ultimoIdEntrenador = 10000;

    public static int generarId(Set<Integer> idsExistentes, boolean esSocio) {
        int nuevoId = esSocio ? ultimoIdSocio : ultimoIdEntrenador;
        while (idsExistentes.contains(nuevoId)) {
            nuevoId++;
        }
        if (esSocio) {
            ultimoIdSocio = nuevoId + 1;
        } else {
            ultimoIdEntrenador = nuevoId + 1;
        }
        return nuevoId;
    }
}