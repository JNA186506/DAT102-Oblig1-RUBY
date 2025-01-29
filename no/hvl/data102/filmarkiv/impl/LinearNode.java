package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {
    public T data;
    public LinearNode<T> neste;

    public LinearNode(T data) {
        this.data = data;
        this.neste = null;
    }

    public LinearNode<T> getNeste() {
        return neste;
    }

    public void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if (neste == null) {
            return "[" + data + " | null ] ";
        }

        return "[" + data + " |  -]--> " + neste;
    }
}
