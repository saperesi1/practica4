package org.example;

public abstract class AutomataFinito {

    private int numEstados;
    private boolean[] finales;
    private int tamAlfabeto;
// private int estActual;

    public AutomataFinito (int num, int alfabeto){
        this.numEstados=num;
        this.tamAlfabeto=alfabeto;
        this.finales= new boolean[alfabeto];
    }
    public AutomataFinito (int num, int alfabeto, boolean [] finales){
        this.numEstados=num;
        this.tamAlfabeto=alfabeto;
        this.finales= finales;
    }
    public void marcarFinal(int estado){
   this.finales[estado]=true;

    }
  public void  setFinales(boolean[] estadosFinales){
      this.finales = estadosFinales;
  }
  public int  getNumEstados(){
        return this.numEstados;
  }
    public boolean[] getFinales(){
        return this.finales;
    }
   public boolean esEstadoFinal (int estado){
        if(this.finales[estado]==true){
            return true;
        }
        return false;
    }
    public abstract int transicion (int estado, int letra);
    public abstract int cierreTransicion (int estado, int cadena []);
    public abstract boolean perteneceLenguaje (int[] c);
}
