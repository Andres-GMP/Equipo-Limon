package limonproject.ABB;
//ando queriendo probar algo
public class Nodo {
    //CAMBIAR EL TIPO DE DATO
    protected Trabajador dato;
    protected Nodo izq;
    protected Nodo der;
    
    /**
     * Constructor que inicializa el nodo con el valor que le ingreses, las ramas izquierda y derecha son nulas
     * @param valor
     */
    public Nodo(Trabajador valor) {
        this.dato = valor;
        this.izq = null;
        this.der = null;
    }
    
    /**
     * Método constructor que inicializa todas las variables
     * @param ramaIzdo
     * @param valor
     * @param ramaDcho
     */
    public Nodo(Nodo ramaIzdo, Trabajador valor, Nodo ramaDcho) {
        dato = valor;
        izq = ramaIzdo;
        der = ramaDcho;
    }
    /**
     * Regresa el valor del nodo
     * @return data del nodo
     */
    public Trabajador valorNodo() {
        return dato;
    }
    /**
     * Regresa el nodo izquierdo
     * @return nodo izquierdo
     */
    public Nodo subarbolIzdo() {
        return izq;
    }
    /**
     * Regresa el nodo derecho
     * @return nodo derecho
     */
    public Nodo subarbolDecho() {
        return der;
    }
    /**
     * Asigna un nuevo valor al nodo
     */
    public void nuevoValor(Trabajador valor) {
        this.dato = valor;
    }
    /**
     * Asigna un nuevo valor al nodo izquierdo
     * @param izq
     */
    public void ramaIzdo(Nodo izq) {
        this.izq = izq;
    }
    /**
     * Asigna un nuevo valor al nodo derecho
     * @param der
     */
    public void ramaDcho(Nodo der) {
        this.der = der;
    }
}
