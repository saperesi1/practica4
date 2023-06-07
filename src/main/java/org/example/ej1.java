package org.example;

import java.util.ArrayList;
import java.util.List;

public class ej1 {
    private String cadena;// Cadena de entrada a analizar
    private int posActual; // Posición actual en la cadena
    private List<Token> historico;// Historial de tokens reconocidos

    public ej1(String cadena) {
        this.cadena = cadena;
        this.posActual = 0;
        this.historico = new ArrayList<>();
    }

    public void ej1() {
        this.posActual = -1;
        this.historico = null;
    }

    public void nuevaCadena(String cadena) {
        this.cadena = cadena;
        reset();
    }

    public void reset() {
        this.posActual = 0;
        this.historico.clear();
    }

    public List<Token> getHistorico() {
        return this.historico;
    }

    public boolean hasMoreTokens() {
        return posActual < cadena.length();
    }

    public Token nextToken() {
        if (posActual >= cadena.length()) {
            return null; // No hay más tokens
        }

        char currentChar = cadena.charAt(posActual);
        Token token = null;
       // Verificar el carácter actual y asignar el token correspondiente
        switch (currentChar) {
            case 'a':
                token = new Token("cero",null);
                break;
            case 'b':
                token = new Token("uno",null);
                break;
            case 'c':
                token = new Token("cuatro",null);
                break;
            default:
                token = new Token("desconocido",null);
                break;
        }

        historico.add(token);// Agregar el token reconocido al historial
        posActual++; // Avanzar a la siguiente posición de la cadena
        return token;
    }
}
