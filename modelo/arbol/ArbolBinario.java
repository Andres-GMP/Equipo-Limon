package limonproject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import limonproject.Trabajador;

public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    /**
     * Método que regresa el nodo raiz
     * 
     * @param raiz
     */
    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    /**
     * Regresa la raiz del arbol
     * 
     * @return
     */
    public Nodo raizArbol() {
        return raiz;
    }

    /**
     * Método que verifica que el arbol no esté vacio
     * 
     * @return boolean variable
     */
    public boolean esVacio() {
        return raiz == null;
    }

    /**
     * Método que crea un nuevo subabrol para la estructura
     * 
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
     * 
     * @param raiz
     */
    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(Nodo r) {
        if (r != null) {
            inOrden(r.izq);
            System.out.println(r.dato.toString());
            inOrden(r.der);
        }
    }

    /**
     * Método que recorre el árbol binario de busqueda de manera pre-Orden
     * revisa el nodo raiz, el izquierdo y luego el derecho
     * RID
     * http://aniei.org.mx/paginas/uam/CursoPoo/curso_poo_12.html
     * 
     * @param raiz
     */

    public void preOrden() {
        preOrden(raiz);
    }

    private void preOrden(Nodo r) {
        if ((Nodo) r != null) {
            System.out.println(r.dato.toString());
            preOrden(r.izq);
            preOrden(r.der);
        }
    }

    /**
     * Método que recorre el árbol binario de busqueda de manera post-Orden
     * revis el nodo izquierdo, el derecho y luego la raiz
     * IDR
     * http://aniei.org.mx/paginas/uam/CursoPoo/curso_poo_12.html
     * 
     * @param raiz
     */

    public void postOrden() {
        postOrden(raiz);
    }

    private void postOrden(Nodo r) {
        if (r != null) {
            postOrden(r.izq);
            postOrden(r.der);
            System.out.println(r.dato.toString());
        }
    }

    /**
     * Método que retorna el nodo que se este buscando
     * 
     * @param datoBusqueda
     * @return
     */
    public Nodo busqueda(int datoBusqueda) {
        // raiz
        Nodo aux = this.raiz;
        //
        while (aux.valorNodo().getId() != datoBusqueda) {
            if (datoBusqueda < aux.valorNodo().getId()) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }

    public void modificar(int datoBusqueda, Trabajador empleado) {

        if (busqueda(datoBusqueda) != null) {
            busqueda(datoBusqueda).nuevoValor(empleado);
        } else {
            System.out.println("Trabajador no encontrado");
        }

    }

    /**
     * Método que agrega nodos a un árbol de tipo Trabajador
     * 
     * @param elemento
     * @param busqueda
     */
    public void agregarNodo(Trabajador newData) {
        if (esVacio())
            raiz = new Nodo(newData);
        else
            raiz.insertar(newData);
    }

    // Eliminar un TRABAJADOR....

    public Nodo eliminarNodo(int datoEliminar) throws IOException {
        Nodo aux = this.raiz;
        Nodo anterior = new Nodo();
        // System.out.println(aux.valorNodo().getId());
        while (aux.valorNodo().getId() != datoEliminar) {
            anterior = aux;
            if (datoEliminar < aux.valorNodo().getId()) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
            if (aux == null) {
                return null;
            }
        }

        Nodo x = aux.clone();
        if (anterior.dato != null) {
            if (anterior.dato.getId() > aux.dato.getId())
                anterior.izq = null;
            else
                anterior.der = null;

            if (x.izq != null)
                anterior.insertar(x.izq);
            if (x.der != null)
                anterior.insertar(x.der);
        } else {
            if (x.izq != null) {
                this.raiz = anterior = x.izq;
                if (x.der != null)
                    x.izq.insertar(x.der);
            } else if (x.der != null) {
                this.raiz = anterior = x.der;
                if (x.izq != null)
                    x.der.insertar(x.izq);
            } else {
                this.raiz = null;
            }
        }

        return x;

    }
}

