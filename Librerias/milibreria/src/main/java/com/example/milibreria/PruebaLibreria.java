package com.example.milibreria;

/**
 * Created by guill on 10/02/2017.
 */

public class PruebaLibreria {

    public static final String texto = "Hola mundo";

    public static double Promedio(int v[]){
        double prom = 0;
        int suma = 0;
        for(int i = 0; i < v.length; i++){
            suma = suma + v[i];
        }
        prom = suma/v.length;
        return prom;
    }
}
