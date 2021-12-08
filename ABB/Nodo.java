package limonproject.ABB;

import limonproject.*;

//ando queriendo probar algo
public class Nodo {
    // CAMBIAR EL TIPO DE DATO
    protected Trabajador dato;
    protected Nodo izq;
    protected Nodo der;

    /**
     * Constructor que inicializa el nodo con el valor que le ingreses, las ramas
     * izquierda y derecha son nulas
     * 
     * @param valor
     */
    public Nodo(Trabajador valor) {
        this.dato = valor;
        this.izq = null;
        this.der = null;
    }

    /**
     * Método constructor que inicializa todas las variables
     * 
     * @param ramaIzdo
     * @param valor
     * @param ramaDcho
     */
    public Nodo(Nodo ramaIzdo, Trabajador valor, Nodo ramaDcho) {
        dato = valor;
        izq = ramaIzdo;
        der = ramaDcho;
    }
    public Nodo(){
        dato = null;
        izq = null;
        der = null;
    }
    /**
     * @Override
     * @param newData
     */
    public void insertar(Trabajador newData) {
        if (newData.getId() < this.dato.getId()) {
            if (izq == null)
                izq = new Nodo(newData);
            else
                izq.insertar(newData);
        } else if (newData.getId() > this.dato.getId()) {
            if (der == null)
                der = new Nodo(newData);
            else
                der.insertar(newData);
        }
    }
    /**
     * @Override
     * @param newData
     */
    public void insertar(Nodo newData) {
        if ((newData.dato).getId() < this.dato.getId()) {
            if (izq == null)
                izq =  newData;
            else
                izq.insertar(newData);
        } else if ((newData.dato).getId() > this.dato.getId()) {
            if (der == null)
                der = newData;
            else
                der.insertar(newData);
        }
    }

    /**
     * Regresa el valor del nodo
     * 
     * @return data del nodo
     */
    public Trabajador valorNodo() {
        return dato;
    }

    /**
     * Regresa el nodo izquierdo
     * 
     * @return nodo izquierdo
     */
    public Nodo subarbolIzdo() {
        return izq;
    }

    /**
     * Regresa el nodo derecho
     * 
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
     * 
     * @param izq
     */
    public void ramaIzdo(Nodo izq) {
        this.izq = izq;
    }

    /**
     * Asigna un nuevo valor al nodo derecho
     * 
     * @param der
     */
    public void ramaDcho(Nodo der) {
        this.der = der;
    }
    /**
     * Este método clona el 
     */
    public Nodo clone() {
        if(this.izq == null){
            return new Nodo(null,this.dato.clone(),this.der.clone());
        }
        if(this.der==null){
            return new Nodo(this.izq.clone(), this.dato.clone(),null);
        }
        return new Nodo(this.izq.clone(), this.dato.clone(), this.der.clone());
    }
}
