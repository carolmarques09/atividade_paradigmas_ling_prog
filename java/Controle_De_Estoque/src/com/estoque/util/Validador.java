package com.estoque.util;

public class Validador {
    public static boolean nomeValido(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }
}
