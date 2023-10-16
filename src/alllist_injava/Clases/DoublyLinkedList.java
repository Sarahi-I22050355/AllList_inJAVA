
package alllist_injava.Clases;
public class DoublyLinkedList implements I_methodList{
    private DoubleNode head;
    private DoubleNode lastNode;

    public DoublyLinkedList() {
        clear();
    }

    public void add(int data) {
        DoubleNode newNode = new DoubleNode(data);

        if (isEmpty()) {
            newNode.setNext(null);
            newNode.setBack(null);
            head = newNode;
            lastNode = newNode;
            return;
        }

        if (exist(newNode.getData())) {
            return;
        }

        if (newNode.getData() < head.getData()) {
            head.setBack(newNode);
            newNode.setNext(head);
            head = lastNode;
            head = newNode;
            return;
        }

        if (newNode.getData() > lastNode.getData()) {
            lastNode.setNext(newNode);
            newNode.setBack(lastNode);
            lastNode = newNode;
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
            head.getNext().setBack(null);
            head = head.getNext();
            return;
        }

        if (lastNode.getData() == data) {
            System.out.println("- Dato[" + data + "] se eliminó de la lista");
            lastNode = lastNode.getBack();
            lastNode.setNext(null);
            return;
        }

        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < data) {
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
        while (currentNode.getNext() != null && currentNode.getNext().getData() <= data) {
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
        while (currentNode != null) {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        }
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
        } while (currentNode != null);
    }

    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }

        if (head.getData() == data) {
            return true;
        }

        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() <= data) {
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
