package pilagenerica;

public class Pila {
    private NodoPila cima;

    public Pila() {
        this.cima = null;
    }

    public void push(Object data){
        NodoPila nodo = new NodoPila(data);
        nodo.setEnlace(cima);
        cima = nodo;
    }

    public Object pop()throws Exception{
        if( esVacia() ){
            throw new Exception("La pila ya no tiene elementos");
        }
        Object valorCima = this.cima.getData();
        this.cima = this.cima.getEnlace();
        return valorCima;
    }

    private boolean esVacia() {
        return cima == null ? true : false;
    }

    /**
     * Método que muestra el contido de la pila
     */
    public void peek(){
        NodoPila copiaCima = this.cima;
        while( copiaCima != null ){
            System.out.println( copiaCima.getData() );
            copiaCima = copiaCima.getEnlace();
        }
        System.out.println("Fin de la pila");
    }




}
