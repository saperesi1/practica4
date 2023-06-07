package org.example;

import java.util.ArrayList;
import java.util.List;

public class ej2 {
    private String cadena;           // Cadena de entrada a analizar
    private int posActual;           // Posición actual en la cadena
    private List<Token> historico;   // Historial de tokens reconocidos

    public ej2(String cadena) {
        this.cadena = cadena;
        this.posActual = 0;
        this.historico = new ArrayList<>();
    }

    public void finalizarAnalisis() {
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
            case 'b':
                token = new Token("uno", null);
                break;
            case '(':
                if (posActual < cadena.length() - 1 && cadena.charAt(posActual + 1) == 'a') {
                    token = new Token("dos", null);
                    posActual++; // Avanzar una posición adicional para ignorar el siguiente 'a'
                } else if (posActual < cadena.length() - 1 && cadena.charAt(posActual + 1) == 'c') {
                    token = new Token("tres", null);
                    posActual++; // Avanzar una posición adicional para ignorar el siguiente 'c'
                } else {
                    token = new Token("desconocido", null);
                }
                break;
            case 'c':
                if (posActual < cadena.length() - 1 && cadena.charAt(posActual + 1) == ')') {
                    token = new Token("cuatro", null);
                    posActual++; // Avanzar una posición adicional para ignorar el siguiente ')'
                } else {
                    token = new Token("desconocido", null);
                }
                break;
            default:
                token = new Token("desconocido", null);
                break;
        }

        historico.add(token);   // Agregar el token reconocido al historial
        posActual++;            // Avanzar a la siguiente posición de la cadena
        return token;
    }
}
