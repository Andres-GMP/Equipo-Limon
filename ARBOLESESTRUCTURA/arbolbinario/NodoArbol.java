package arbolbinario;

public class NodoArbol {

    int dato;
    NodoArbol hijoIzquierdo, hijoDerecho;

    public NodoArbol(int dat){
        this.dato = dat;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public String toString() {
        return "SU DATO ES " + dato;
    }

    
}
