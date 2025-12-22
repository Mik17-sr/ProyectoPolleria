package com.mycompany.Utility;

public class validacion {
    public static boolean esDouble(String texto) {
        try {
            Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
