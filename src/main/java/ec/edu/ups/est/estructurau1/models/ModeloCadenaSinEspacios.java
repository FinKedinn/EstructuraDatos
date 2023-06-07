/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.est.estructurau1.models;

import java.util.Arrays;

/**
 *
 * @author pablo
 */
public class ModeloCadenaSinEspacios extends Dato<String> {

    public ModeloCadenaSinEspacios(String objetoDato) {
        super(objetoDato);

    }

    @Override
    public Dato<String> ordenarBurbuja(boolean ascendentemente, boolean info) {
        String cadena = objetoDato;
        char[] caracteres = cadena.toCharArray();

        int n = caracteres.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascendentemente) {
                    if (caracteres[j] > caracteres[j + 1]) {
                        // Intercambiar caracteres
                        char temp = caracteres[j];
                        caracteres[j] = caracteres[j + 1];
                        caracteres[j + 1] = temp;
                    }
                } else {
                    if (caracteres[j] < caracteres[j + 1]) {
                        // Intercambiar caracteres
                        char temp = caracteres[j];
                        caracteres[j] = caracteres[j + 1];
                        caracteres[j + 1] = temp;
                    }
                }
            }
        }

        String resultado = new String(caracteres);
        return new ModeloCadenaSinEspacios(resultado);
    }

   @Override
    public Dato<String> ordenarSeleccion(boolean ascendentemente) {
        String cadena = objetoDato;
        char[] caracteres = cadena.toCharArray();

        int n = caracteres.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (ascendentemente) {
                    if (caracteres[j] < caracteres[minIdx]) {
                        minIdx = j;
                    }
                } else {
                    if (caracteres[j] > caracteres[minIdx]) {
                        minIdx = j;
                    }
                }
            }

            
            char temp = caracteres[i];
            caracteres[i] = caracteres[minIdx];
            caracteres[minIdx] = temp;
        }

        String resultado = new String(caracteres);
        return new ModeloCadenaSinEspacios(resultado);
    }


    @Override
    public Dato<String> ordenarInsercion(boolean ascendentemente) {
        String cadena = objetoDato;
        char[] caracteres = cadena.toCharArray();

        int n = caracteres.length;
        for (int i = 1; i < n; i++) {
            char key = caracteres[i];
            int j = i - 1;

            if (ascendentemente) {
                while (j >= 0 && caracteres[j] > key) {
                    caracteres[j + 1] = caracteres[j];
                    j--;
                }
            } else {
                while (j >= 0 && caracteres[j] < key) {
                    caracteres[j + 1] = caracteres[j];
                    j--;
                }
            }

            caracteres[j + 1] = key;
        }

        String resultado = new String(caracteres);
        return new ModeloCadenaSinEspacios(resultado);
    }

}