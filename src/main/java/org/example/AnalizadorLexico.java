package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalizadorLexico {
    private int[] cadena;
    private AutomataFinito A;
    private int posActual;
    private Token tokens;
    private List<Token> historico;



    public AnalizadorLexico(int[] c,AutomataFinito a,Token t)   {

       this.A=a;
       this.historico=new ArrayList<Token>();
       this.tokens=t;
       this.posActual=0;
       this.cadena=c;
    }

    public Token nextToken() {






    }

    public boolean hasMoreTokens(){

    }
    public List<Token> getHistotico(){
        return this.historico;
    }
    public void reset(){
        this.posActual=0;
        this.historico.clear();
    }
    public void nuevaCadena(int[] cadena){}

    public void finalizarAnalisis(){}
}
