package limonproject.ABB;

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
    boolean esVacio() {
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
    public void inOrden(Nodo r) {
        if (r != null) {
            inOrden(r.izq);
            System.out.println("Dato: " + r.dato);
            inOrden(r.der);
        }
    }

    public void inOrdenArbol(Nodo r) {
        if (r != null) {
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
     * 
     * @param raiz
     */
    public void preOrden(Nodo r) {
        if ((Nodo) r != null) {
            System.out.println("Dato: " + r.dato);
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
    public void postOrden(Nodo r) {
        if (r != null) {
            postOrden(r.izq);
            postOrden(r.der);
            System.out.println("Dato: " + r.dato);
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
        while (Integer.parseInt(aux.valorNodo().getId()) != datoBusqueda) {
            if (datoBusqueda < aux.valorNodo().getId()) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
            if (aux == null) {
                System.out.println("Dato no encontrado");
                return null;
            }
        }
        System.out.println("Dato encontrado");
        return aux;
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

    
    //METODO PARA MODIFICAR
    public void modificar(int id) throws Exception{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        NodoLista actual = primero;
        boolean encontrado;
        encontrado = false;
        
        while ((actual.getData() != null)) 
        {
            encontrado = Trabajador.class.cast(actual.getData()).getId() == id;
            if(encontrado)
            {
                System.out.println("\tQUE APARTADO DESEAS MODIFICAR?");
                System.out.println("\t+--+------------+");
                System.out.println("\t|1.| NOMBRE     |");
                System.out.println("\t|2.| APELLIDO P |");
                System.out.println("\t|3.| APELLIDO M |");
                System.out.println("\t|4.| EDAD       |");
                System.out.println("\t|5.| GENERO     |");
                System.out.println("\t|6.| SUELDO     |");
                System.out.println("\t|7.| PUESTO     |");
                System.out.println("\t+--+------------+");

                
                try{
                        int opciones = Integer.parseInt(lector.readLine());

                        switch(opciones){
                            case 1:
                            System.out.println("\n\tMODIFICA TU NOMBRE");
                            String nom  = lector.readLine();
                            ((Trabajador) actual.getData()).setNombre(nom);
            
                            break;
                            
                            case 2:
                            System.out.println("\tMODIFICA TU APELLIDO PATERNO");
                            String apeP  = lector.readLine();
                            ((Trabajador) actual.getData()).setApellidoP(apeP);
                            break;

                            case 3:
                            System.out.println("\tMODIFICA TU APELLIDO MATERNO");
                            String apeM  = lector.readLine();
                            ((Trabajador) actual.getData()).setApellidoM(apeM);
                            break;

                            case 4:
                            System.out.println("\tMODIFICA TU EDAD");
                            int edad = Integer.parseInt(lector.readLine());
                            ((Trabajador) actual.getData()).setEdad(edad);
                            break;

                            case 5:
                            System.out.println("\tMODIFICA TU GENERO");
                            String gene = lector.readLine();
                            ((Trabajador) actual.getData()).setGenero(gene);
                            break;

                            case 6:
                            System.out.println("\tMODIFICA TU SUELDO");
                            double suel = Double.parseDouble(lector.readLine());
                            ((Trabajador) actual.getData()).setSueldo(suel);
                            break;

                            case 7:
                            System.out.println("\tMODIFICA TU PUESTO");
                            String pues = lector.readLine();
                            ((Trabajador) actual.getData()).setPuesto(pues);
                            break;

                            default:
                            System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("\t|      ESTA OPCION NO ES VALIDA       |");
                            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                    }
                    

                }catch(InputMismatchException e ){
                    System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                    System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    lector.readLine();
                    }
                    break;
             }
             actual = actual.getEnlace();

        }
        
    }

    /*
     * public void agregarNodo(Trabajador elemento, ArbolBinario busqueda) {
     * Nodo nuevo = new Nodo(elemento);
     * if (raiz == null) {
     * raiz = nuevo;
     * } else {
     * Nodo aux = raiz;
     * Nodo papa;
     * while (true) {
     * papa = aux;
     * if (Integer.parseInt((elemento).toString()) <
     * Integer.parseInt((aux.dato).toString())) {
     * aux = aux.izq;
     * if (aux == null) {
     * papa.izq = nuevo;
     * return;
     * }
     * } else {
     * aux = aux.der;
     * if (aux == null) {
     * papa.der = nuevo;
     * return;
     * }
     * }
     * 
     * }
     * 
     * }
     * }
     */
}