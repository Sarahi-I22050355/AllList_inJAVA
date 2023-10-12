
package alllist_injava.Clases;

public class SimpleList implements I_methodList{
    private Node head;
    
    public Node getHead() {
    return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public SimpleList() {
        head=null;
    }

    public void add(int data) {
        Node newNode = new Node();
        newNode.setData(data);

        if (isEmpty()) {
            setHead(newNode);
            return;
        }

        if (exist(newNode.getData())) {
            return;
        } else {
            Node currentNode = getHead();
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    public void delete(int data) {
        if (isEmpty()) {
            return;
        }

        if (getHead().getData() == data) {
            setHead(getHead().getNext());
            System.out.println("- Dato[" + data + "] se elimino de la lista");
            return;
        }

        Node currentNode = getHead();
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData() == data) {
                currentNode.setNext(currentNode.getNext().getNext());
                System.out.println("- Dato[" + data + "] se elimino de la lista");
                return;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("- Dato[" + data + "] no existe en la lista");
    }

    public void search(int data) {
        if (isEmpty()) {
            System.out.println("Lista vacía...");
            return;
        }

        Node currentNode = getHead();
        while (currentNode.getNext() != null) {
            if (currentNode.getData() == data) {
                System.out.println("- Dato[" + data + "] Existe en la lista");
                return;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("- Dato[" + data + "] No Existe en la lista");
    }

    public void show() {
        int i = 1;
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        Node currentNode = getHead();
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

        Node currentNode = getHead();
        while (currentNode.getNext() != null) {
            if (currentNode.getData() == data) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

