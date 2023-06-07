package org.example;

public abstract class AutomataFinito {

    private int numEstados; // Número de estados del autómata
    private boolean[] finales; // Array de estados finales
    private int tamAlfabeto;// Tamaño del alfabeto
// private int estActual;
//Constructores de la clase AutomataFinito.
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
    //Marca un estado como final.
    public void marcarFinal(int estado){
   this.finales[estado]=true;

    }
    //Si hemos creado el automata finito sin estados finales podremos asignarlos con este metodo
  public void  setFinales(boolean[] estadosFinales){
      this.finales = estadosFinales;
  }
    //Obtiene el número de estados del autómata.
  public int  getNumEstados(){
        return this.numEstados;
  }
  //Obtiene los estados finales.
    public boolean[] getFinales(){
        return this.finales;
    }
    //Devolvera true en caso de que el estado metido como parametro sea final y false en otro caso
   public boolean esEstadoFinal (int estado){
        if(this.finales[estado]==true){
            return true;
        }
        return false;
    }
    //Realiza una transición en el automata es decir le decimos el estado en el que nos encontramos y lo que recibimos y nos informa de a que estado llega
    public abstract int transicion (int estado, int letra);
    // Realiza el cierre de una transición en el autómata devuelve el estado resultante del cierre de transición.
    public abstract int cierreTransicion (int estado, int cadena []);
    //Verifica si una cadena pertenece al lenguaje del autómata.
    public abstract boolean perteneceLenguaje (int[] c);
}
