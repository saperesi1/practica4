package org.example;

import java.util.List;

public class Token {
    private String idToken;
private List<Integer> lexema;

    public Token(String id, List<Integer> l) {
        this.idToken=id;
        this.lexema=l;
    }


    public String getId() {
        return this.idToken;
    }
    public List<Integer> getLexema() {
        return this.lexema;
    }
}
