
package alllist_injava.Clases;
public class CircularDoublyLinkedList implements I_methodList {
    private DoubleNode head;
    private DoubleNode lastNode;

    public CircularDoublyLinkedList() {
        clear();
    }
        public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    // Getters y Setters para lastNode
    public DoubleNode getLastNode() {
        return lastNode;
    }

    public void setLastNode(DoubleNode lastNode) {
        this.lastNode = lastNode;
    }
    @Override
    public void add(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (isEmpty()) {
            head = newNode;
            newNode.setBack(head);
            newNode.setNext(head);
            lastNode = head;
            return;
        }
        if (exist(newNode.getData())) {
            return;
        }
        if (newNode.getData() < head.getData()) {
            newNode.setNext(head);
            newNode.setBack(head);
            head.setNext(newNode);
            head.setBack(newNode);
            lastNode = head;
            head = newNode;
            return;
        }
        if (newNode.getData() > lastNode.getData()) {
            newNode.setBack(lastNode);
            lastNode.setNext(newNode);
            lastNode = newNode;
            lastNode.setNext(head);
            head.setBack(lastNode);
            return;
        }
        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() < newNode.getData()) {
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode.getNext());
        newNode.setBack(currentNode);
        currentNode.getNext().setBack(newNode);
        currentNode.setNext(newNode);
    }
    @Override
    public void delete(int data) {
        if (isEmpty()) {
            return;
        }
        if (head.getData() == lastNode.getData()) {
            clear();
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        if (head.getData() == data) {
            head = head.getNext();
            head.setBack(lastNode);
            lastNode.setNext(head);
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        if (lastNode.getData() == data) {
            lastNode = lastNode.getBack();
            lastNode.setNext(head);
            head.setBack(lastNode);
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }
        if (currentNode.getNext().getData() == data) {
            currentNode.getNext().getNext().setBack(currentNode);
            currentNode.setNext(currentNode.getNext().getNext());
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        System.out.println("- Dato[" + data + "] No encontrado/eliminado de la lista");
    }
    @Override
    public void search(int data) {
        if (isEmpty()) {
            return;
        }
        if (head.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        if (lastNode.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        if (currentNode.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        System.out.println("- Dato[" + data + "] No Existe en la lista");
    }
    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
            return;
        }
        DoubleNode currentNode = head;
        int i = 0;
        System.out.println("=== Mi Lista circular doblemente enlazada ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        } while (currentNode != head);
    }

    public void showRevers() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
            return;
        }
        DoubleNode currentNode = lastNode;
        int i = 0;
        System.out.println("=== Mi Lista circular doblemente enlazada Reversa ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getBack();
            i++;
        } while (currentNode != lastNode);
    }
    @Override
    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }
        if (head.getData() == data) {
            return true;
        }
        if (lastNode.getData() == data) {
            return true;
        }
        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        if (currentNode.getData() == data) {
            return true;
        }
        return false;
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    public void clear() {
        head = null;
        lastNode = null;
    }
}
