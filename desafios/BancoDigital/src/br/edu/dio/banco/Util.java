package br.edu.dio.banco;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Util {
    public static String doubleToBRL(double valor){
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
    }

    public static String idContaFormatador(int idConta){
        return String.format("%04d", idConta);
    }
}
