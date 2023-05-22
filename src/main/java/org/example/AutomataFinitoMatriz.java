package org.example;

public class AutomataFinitoMatriz extends AutomataFinito{

    private int [] [] matriz;

    public AutomataFinitoMatriz(int num, int alfabeto,int[][] m) {
        super(num, alfabeto);
        this.matriz=m;
    }

    public AutomataFinitoMatriz(int num, int alfabeto, boolean[] finales,int[][] m) {
        super(num, alfabeto, finales);
        this.matriz=m;
    }

    @Override
    public int transicion(int estado, int letra) {
        int p = this.matriz[estado][letra];
        if(p == -1) {
            return 0;
        } else {
            return p;
        }
    }

    @Override
    public int cierreTransicion(int estado, int[] cadena) {
        int l = -1;
        if(cadena.length>0) {
            l = transicion(estado, cadena[0]);
            for(int i = 1; i < cadena.length; i++) {
                l = transicion(estado, cadena[i]);
            }
        }
        return l;
    }

    @Override
    public boolean perteneceLenguaje(int[] c) {
        int i= cierreTransicion(0,c);
        if(i!= -1) {
            return super.getFinales()[i];
        } else {
            return false;
        }
    }
}
