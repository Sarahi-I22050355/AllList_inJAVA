
package alllist_injava.Clases;
public class CircularDoublyLinkedList implements I_methodList {
    private DoubleNode head;
    private DoubleNode lastNode;

    public CircularDoublyLinkedList() {
        clear();
    }

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

    public void delete(int data) {
        if (isEmpty()) {
            return;
        }

        if (head.getData() == data) {
            System.out.println("- Dato[" + data + "] se eliminó de la lista");
            head = head.getNext();
            head.setBack(lastNode);
            lastNode.setNext(head);
            return;
        }

        if (lastNode.getData() == data) {
            System.out.println("- Dato[" + data + "] se eliminó de la lista");
            lastNode = lastNode.getBack();
            lastNode.setNext(head);
            head.setBack(lastNode);
            return;
        }

        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getNext().getData() == data) {
            System.out.println("- Dato[" + data + "] se eliminó de la lista");
            currentNode.getNext().getNext().setBack(currentNode);
            currentNode.setNext(currentNode.getNext().getNext());
            return;
        }

        System.out.println("- Dato[" + data + "] no existe en la lista");
    }

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

    public void show() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        DoubleNode currentNode = head;
        int i = 1;
        System.out.println("=== Mi Lista doblemente enlazada ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        } while (currentNode != head);
    }

    public void showRevers() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        DoubleNode currentNode = lastNode;
        int i = 1;
        System.out.println("=== Mi Lista doblemente enlazada Reversa ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getBack();
            i++;
        } while (currentNode != lastNode);
    }

    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }

        if (head.getData() == data) {
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

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public DoubleNode getHead() {
        return head;
    }

    public DoubleNode getLastNode() {
        return lastNode;
    }
}
