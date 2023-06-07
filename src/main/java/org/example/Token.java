package org.example;

import java.util.List;

public class Token {
    private String idToken; //Identificador del Token
private List<Integer> lexema; //Contenido del token en la cadena de entrada

//Creamos un nuevo Token al que le introducimos la cadena id y los lexemas l
    public Token(String id, List<Integer> l) {
        this.idToken=id; // Asigna el identificador del token al atributo idToken
        this.lexema=l; // Asigna el contenido del token al atributo lexema

    }

//Metodo para obtener el id del Token
    public String getId() {
        return this.idToken;
    }
    //Metodo para obtener el lexema del Token
    public List<Integer> getLexema() {
        return this.lexema;
    }
}
