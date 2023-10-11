package alllist_injava.Clases;

public class Node {
    private Node next;
    private int data;

    public Node() {
        next = null;
    }

    public Node(int d) {
        data = d;
        next = null;
    }

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
