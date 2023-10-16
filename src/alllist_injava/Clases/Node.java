package alllist_injava.Clases;

public class Node {
    //encapsulamiento
    protected Node next;
    protected int data;

    public Node(int d) {
        data = d;
        next = null;
    }
//metodos accesores
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
