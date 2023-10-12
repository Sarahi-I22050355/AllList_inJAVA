
package alllist_injava.Clases;

public class DoubleNode {
    //encapsulamiento
    private DoubleNode back;
    private DoubleNode next;
    private int data;

    public DoubleNode() {
        back = null;
        next = null;
    }

    public DoubleNode(int d) {
        data = d;
        back = null;
        next = null;
    }
    //metodos accesores
    public DoubleNode getBack() {
        return back;
    }

    public void setBack(DoubleNode back) {
        this.back = back;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
