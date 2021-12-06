package pilagenerica;

public class NodoPila {
    private NodoPila enlace;
    private Object   data;

    public NodoPila(Object data) {
        this.data = data;
        this.enlace = null;
    }

    public NodoPila getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoPila enlace) {
        this.enlace = enlace;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
