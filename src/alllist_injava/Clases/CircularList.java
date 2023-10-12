
package alllist_injava.Clases;

public class CircularList implements I_methodList{
        private Node head;
    private Node lastNode;

        // Getter para head
    public Node getHead() {
        return head;
    }

    // Setter para head
    public void setHead(Node head) {
        this.head = head;
    }

    // Getter para lastNode
    public Node getLastNode() {
        return lastNode;
    }

    // Setter para lastNode
    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }
    public CircularList() {
        head=null;
    }

    // Agrega un nuevo nodo con el dato proporcionado al final de la lista
    @Override
    public void add(int data) {
        Node newNode = new Node();
        newNode.setData(data);

        if (isEmpty()) {
            setHead(newNode);
            getHead().setNext(getHead());
            setLastNode(getHead());
        } else {
            getLastNode().setNext(newNode);
            newNode.setNext(getHead());
            setLastNode(newNode);
        }
    }

    // Elimina un nodo con el dato proporcionado de la lista
    @Override
    public void delete(int data) {
        if (isEmpty()) {
            return;
        }

        Node currentNode = getHead();
        do {
            if (currentNode.getNext().getData() == data) {
                if (currentNode.getNext() == getHead()) { // Primer elemento
                    System.out.println("- Dato[" + data + "] se elimino de la lista");
                    setHead(getHead().getNext());
                    getLastNode().setNext(getHead());
                    return;
                }
                if (currentNode.getNext() == getLastNode()) { // Último elemento
                    System.out.println("- Dato[" + data + "] se elimino de la lista");
                    currentNode.setNext(getHead());
                    setLastNode(currentNode);
                    return;
                }

                // X posición de la lista
                System.out.println("- Dato[" + data + "] se elimino de la lista");
                currentNode.setNext(currentNode.getNext().getNext());
                return;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != getHead());
        System.out.println("- Dato[" + data + "] no existe en la lista");
    }

    // Busca un dato en la lista y muestra un mensaje indicando si existe o no
    @Override
    public void search(int data) {
        if (isEmpty()) {
            return;
        }

        Node currentNode = getHead();
        do {
            if (currentNode.getData() == data) {
                System.out.println("- Dato[" + data + "] Existe en la lista");
                return;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != getHead());
        System.out.println("- Dato[" + data + "] No Existe en la lista");
    }

    // Muestra todos los nodos y sus datos en la lista
    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        Node currentNode = getHead();
        int i = 1;
        System.out.println("=== Mi lista Circular ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        } while (currentNode != getHead());
    }

    // Comprueba si un dato existe en la lista
    @Override
    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }

        Node currentNode = getHead();
        do {
            if (currentNode.getData() == data) {
                return true;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != getHead());

        return false;
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
