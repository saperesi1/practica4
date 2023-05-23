package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalizadorLexico {
    private int[] cadena;
    private AutomataFinito automata;
    private int posActual;
    private Token tokens;
    private List<Token> historico;



    public AnalizadorLexico(int[] c,AutomataFinito a,Token t)   {

       this.automata=a;
       this.historico=new ArrayList<Token>();
       this.tokens=t;
       this.posActual=0;
       this.cadena=c;
    }

    public Token nextToken() {
        if (!hasMoreTokens()) {
            return null; // No hay más tokens
        }

        int estadoActual = 0;
        int ultimoEstadoFinal = -1;
        int ultimaPosicionFinal = -1;

        for (int i = posActual; i < cadena.length; i++) {
            estadoActual = automata.transicion(estadoActual, cadena[i]);
            if (estadoActual == -1) {
                break; // No se puede realizar la transición, finalizar búsqueda
            }

            if (automata.esEstadoFinal(estadoActual)) {
                ultimoEstadoFinal = estadoActual;
                ultimaPosicionFinal = i;
            }
        }

        if (ultimaPosicionFinal != -1) {
            int[] lexema = new int[ultimaPosicionFinal - posActual + 1];
            for (int i = posActual; i <= ultimaPosicionFinal; i++) {
                lexema[i - posActual] = cadena[i];
            }

            String identificador = obtenerIdentificadorToken(ultimoEstadoFinal);
            Token token = new Token(identificador, lexema);
            historico.add(token);
            posActual = ultimaPosicionFinal + 1; // Actualizar la posición para el siguiente token
            return token;
        }

        return null; // No se encontró un token válido
    }


    public boolean hasMoreTokens(){
        return (this.automata.getNumEstados()>this.historico.size());
    }
    public List<Token> getHistotico(){
        return this.historico;
    }
    public void reset(){
        this.posActual=0;
        this.historico.clear();
    }
    public void nuevaCadena(int[] c){
        this.cadena=c;
        reset();
    }

    public void finalizarAnalisis(){

        this.posActual=-1;
        this.historico=null;




    }
}
