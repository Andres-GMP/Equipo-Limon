package EquipoLimonEstructura.ABB;
import java.nio.charset.StandardCharsets;

public class ArbolBinario {
    protected Nodo raiz;
    public ArbolBinario() {
        raiz = null;
    }
    /**
     * Método que regresa el nodo raiz
     * @param raiz
     */
    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }
    /**
     * Regresa la raiz del arbol
     * @return
     */
    public Nodo raizArbol() {
        return raiz;
    }
    /**
     * Método que verifica que el arbol no esté vacio
     * @return boolean variable
     */
    boolean esVacio() {
        return raiz == null;
    }
    /**
     * Método que crea un nuevo subabrol para la estructura
     * @param ramaIzdo
     * @param valor
     * @param ramaDcho
     * @return
     */
    public static Nodo nuevoArbol(Nodo ramaIzdo, Trabajador valor, Nodo ramaDcho) {
        return new Nodo(ramaIzdo, valor, ramaDcho);
    }    
    /**
     * Método que recorre el árbol binario de busqueda de manera in-Orden
     * revisa el nodo izquierdo y después el derecho
     * IRD
     * http://aniei.org.mx/paginas/uam/CursoPoo/curso_poo_12.html
     * @param raiz
     */
    public void inOrden(Nodo r){
        if (r!= null){
            inOrden(r.izq);
            System.out.println("Dato: "+ r.dato);
            inOrden(r.der);
        }
    }

    public void inOrdenArbol(Nodo r){
        if (r!= null){
            inOrden(r.izq);
            this.agregarNodo(r, this);
            // System.out.println("Dato: "+ r.dato);
            inOrden(r.der);
        }
    }

    /**
     * Método que recorre el árbol binario de busqueda de manera pre-Orden
     * revisa el nodo raiz, el izquierdo y luego el derecho
     * RID
     * http://aniei.org.mx/paginas/uam/CursoPoo/curso_poo_12.html
     * @param raiz
     */
    public void preOrden (Nodo r){
        if((Nodo)r!= null){
            System.out.println("Dato: "+r.dato);
            preOrden(r.izq);
            preOrden(r.der);
        }
    }
/**
 * Método que recorre el árbol binario de busqueda de manera post-Orden 
 * revis el nodo izquierdo, el derecho y luego la raiz
 * IDR
 * http://aniei.org.mx/paginas/uam/CursoPoo/curso_poo_12.html
 * @param raiz
 */
    public void postOrden(Nodo r){
        if(r!= null){
            postOrden(r.izq);
            postOrden(r.der);
            System.out.println("Dato: "+r.dato);
        }
    }

/**
 * Método que retorna el nodo que se este buscando 
 * @param datoBusqueda
 * @return
 */
    public Nodo busqueda(int datoBusqueda){ 
        //raiz
        Nodo aux = this.raiz;
        //
        while(Integer.parseInt((aux.dato).toString())!= datoBusqueda)
        {
            if(datoBusqueda<Integer.parseInt((aux.dato).toString())){
                aux = aux.izq;
            }else{
                aux = aux.der;
            }
            if(aux ==null){
                System.out.println("Dato no encontrado");
                   return null;
            }
        }
        System.out.println("Dato encontrado");
        return aux;
    }


/**
 * Método que agrega nodos a un árbol de tipo Trabajador
 * @param elemento
 * @param busqueda
 */
    public void agregarNodo(Trabajador elemento, ArbolBinario busqueda){
        Nodo nuevo = new Nodo(elemento);
        if(raiz == null){
            raiz = nuevo;
        }else{
            Nodo aux = raiz;
            Nodo papa;
            while(true){
                papa = aux;
                if(Integer.parseInt((elemento).toString())<Integer.parseInt((aux.dato).toString())){
                    aux = aux.izq;
                    if(aux == null){
                        papa.izq = nuevo;
                        return;
                    }
                }else{
                    aux = aux.der;
                    if(aux == null){
                        papa.der = nuevo;
                        return;
                    }
                }

            }

        }
    }

}