package org.example;

public class AutomataFinitoMatriz extends AutomataFinito{

    private int [] [] matriz;

    //Constructores de la clase AutomataFinitoMatriz.
    public AutomataFinitoMatriz(int num, int alfabeto,int[][] m) {
        super(num, alfabeto);
        this.matriz=m;
    }

    public AutomataFinitoMatriz(int num, int alfabeto, boolean[] finales,int[][] m) {
        super(num, alfabeto, finales);
        this.matriz=m;
    }
    //Metodo que pasa a la siguiente transicion
    @Override
    public int transicion(int estado, int letra) {
        int p = this.matriz[estado][letra];// Obtiene el estado resultante de la transición en la matriz
        if(p == -1) {
            return 0;// No hay transición definida para el estado y la letra, devuelve el estado 0
        } else {
            return p; // Devuelve el estado resultante de la transición
        }
    }

    @Override
    public int cierreTransicion(int estado, int[] cadena) {
        int l = -1;
        if(cadena.length>0) {
            l = transicion(estado, cadena[0]);// Realiza la primera transición con el primer símbolo de la cadena
            for(int i = 1; i < cadena.length; i++) {
                l = transicion(estado, cadena[i]);// Realiza las transiciones sucesivas con los símbolos restantes de la cadena
            }
        }
        return l; // Devuelve el estado resultante del cierre de transición
    }

    @Override
    public boolean perteneceLenguaje(int[] c) {
        int i= cierreTransicion(0,c);// Obtiene el estado resultante del cierre de transición desde el estado inicial con la cadena
        if(i!= -1) {
            return super.getFinales()[i]; // Retorna true si el estado resultante es un estado final, false en caso contrario
        } else {
            return false; // La cadena no pertenece al lenguaje del autómata
        }
    }
}
