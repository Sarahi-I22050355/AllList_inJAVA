
package alllist_injava.Clases;

public class CircularList implements I_methodList{
    private Node head;
    private Node lastNode;

    public CircularList() {
        clear();
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            head.setNext(head);
            lastNode = newNode;
            return;
        }

        if (exist(newNode.getData())) {
            return;
        }

        if (newNode.getData() < head.getData()) {
            newNode.setNext(head);
            lastNode.setNext(newNode);
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() <= newNode.getData()) {
            currentNode = currentNode.getNext();
        }

        if (newNode.getData() < currentNode.getNext().getData()) {
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            return;
        }

        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        lastNode = newNode;
    }

    public void delete(int data) {
        if (isEmpty()) {
            return;
        }

        if (head.getData() == data) {
            System.out.println("- Dato[" + data + "] se eliminó de la lista");
            head = head.getNext();
            lastNode.setNext(head);
            return;
        }

        Node currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getNext().getData() == data) {
            System.out.println("- Dato[" + data + "] se eliminó de la lista");
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

        Node currentNode = head;
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

        Node currentNode = head;
        int i = 1;
        System.out.println("=== Mi lista Circular ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        } while (currentNode != head);
    }

    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }

        if (head.getData() == data) {
            return true;
        }

        Node currentNode = head;
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

    public Node getHead() {
        return head;
    }

    public Node getLastNode() {
        return lastNode;
    }
}
