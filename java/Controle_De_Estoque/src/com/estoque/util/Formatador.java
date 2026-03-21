package com.estoque.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatador {

    public static String formatarPreco(double preco) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
                .format(preco);
    }
}
