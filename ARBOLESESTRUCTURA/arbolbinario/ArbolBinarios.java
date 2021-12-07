package arbolbinario;

public class ArbolBinarios {

    public NodoArbol raiz;

    public ArbolBinarios(){
        raiz = null;
    }

    public void agregarNodo (int dat){
        NodoArbol nuevo = new NodoArbol (dat);
        if (raiz == null){
            raiz = nuevo;
        }
        else
        {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while(true){
                padre = auxiliar;
                if (dat < auxiliar.dato){
                    auxiliar = auxiliar.hijoIzquierdo;
                    if(auxiliar == null){
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                }
                else
                {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }

            }
        }
    }

    public void inOrden (NodoArbol in){
        if (in != null){
            inOrden(in.hijoIzquierdo);
            System.out.print(" \t" + in.dato);
            inOrden(in.hijoDerecho);
        }
    }

    public void preOrden (NodoArbol pre){
        if (pre != null){
            System.out.print(" \t" + pre.dato);
            preOrden(pre.hijoIzquierdo);
            preOrden(pre.hijoDerecho);
        }
    }

    public void postOrden (NodoArbol post){
        if (post != null){
            postOrden(post.hijoIzquierdo);
            postOrden(post.hijoDerecho);
            System.out.print(" \t" + post.dato);
        }
    }

    public NodoArbol buscarNodo(int dat)
    {
        NodoArbol aux = raiz;
        while (aux.dato != dat){
            if (dat < aux.dato){
                aux = aux.hijoIzquierdo;
            }
            else{
                aux = aux.hijoDerecho;
            }
            if (aux == null){
                return null;
            }
        }
        return aux;
    }

    public boolean esVacio(){
        return raiz == null;
    }
}
