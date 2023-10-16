
package alllist_injava.Clases;
public class SimpleList implements I_methodList {
    private Node head;

    public SimpleList() {
        clear();
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        if (exist(newNode.getData())) {
            return;
        }

        if (newNode.getData() < head.getData()) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < newNode.getData()) {
            currentNode = currentNode.getNext();
        }

        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
    }

    public void delete(int data) {
        if (isEmpty()) {
            return;
        }

        if (head.getData() == data) {
            head = head.getNext();
            System.out.println("- Dato[" + data + "] se eliminó de la lista");
            return;
        }

        Node currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getNext() != null && currentNode.getNext().getData() == data) {
            currentNode.setNext(currentNode.getNext().getNext());
            System.out.println("- Dato[" + data + "] se eliminó de la lista");
            return;
        }

        System.out.println("- Dato[" + data + "] no existe en la lista");
    }

    public void search(int data) {
        if (isEmpty()) {
            System.out.println("Lista vacía...");
            return;
        }

        if (head.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }

        Node currentNode = head;
        while (currentNode != null && currentNode.getData() < data) {
            currentNode = currentNode.getNext();
        }

        if (currentNode != null && currentNode.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }

        System.out.println("- Dato[" + data + "] No Existe en la lista");
    }

    public void show() {
        int i = 1;

        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        Node currentNode = head;
        System.out.println("=== Mi lista simple ===");
        while (currentNode != null) {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        }
    }

    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }

        if (head.getData() == data) {
            return true;
        }

        Node currentNode = head;
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

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}


