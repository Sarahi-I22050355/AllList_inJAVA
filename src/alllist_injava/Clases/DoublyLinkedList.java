
package alllist_injava.Clases;

public class DoublyLinkedList implements I_methodList{
        private DoubleNode head;
    private DoubleNode lastNode;
        // Getter para head
    public DoubleNode getHead() {
        return head;
    }

    // Setter para head
    public void setHead(DoubleNode head) {
        this.head = head;
    }

    // Getter para lastNode
    public DoubleNode getLastNode() {
        return lastNode;
    }

    // Setter para lastNode
    public void setLastNode(DoubleNode lastNode) {
        this.lastNode = lastNode;
    }

    public DoublyLinkedList() {
        head=null;
    }

    // Agrega un nuevo nodo con el dato proporcionado al final de la lista
    @Override
    public void add(int data) {
        DoubleNode newNode = new DoubleNode();
        newNode.setData(data);

        if (isEmpty()) {
            setHead(newNode);
            getHead().setNext(null);
            getHead().setBack(null);
            setLastNode(getHead());
        }

        if (exist(newNode.getData())) {
            return;
        } else {
            getLastNode().setNext(newNode);
            newNode.setNext(null);
            newNode.setBack(getLastNode());
            setLastNode(newNode);
        }
    }

    // Elimina un nodo con el dato proporcionado de la lista
    @Override
    public void delete(int data) {
        DoubleNode currentNode = getHead();

        if (getHead().getData() == data) {
            // Primer elemento
            System.out.println("- Dato[" + data + "] se elimino de la lista");
            getHead().getNext().setBack(null);
            setHead(getHead().getNext());
            return;
        }

        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData() == data) {
                if (currentNode.getNext() == getLastNode()) {
                    // Último elemento
                    System.out.println("- Dato[" + data + "] se elimino de la lista");
                    setLastNode(currentNode);
                    getLastNode().setNext(null);
                    return;
                }

                // X posición de la lista
                System.out.println("- Dato[" + data + "] se elimino de la lista");
                currentNode.getNext().getNext().setBack(currentNode);
                currentNode.setNext(currentNode.getNext().getNext());
                return;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("- Dato[" + data + "] no existe en la lista");
    }

    // Busca un dato en la lista y muestra un mensaje indicando si existe o no
    @Override
    public void search(int data) {
        DoubleNode currentNode = getHead();
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                System.out.println("- Dato[" + data + "] Existe en la lista");
                return;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("- Dato[" + data + "] No existe en la lista");
    }

    // Muestra todos los nodos y sus datos en la lista
    @Override
    public void show() {
        int i = 1;
        DoubleNode currentNode = getHead();
        System.out.println("=== Mi Lista doblemente enlazada ===");
        while (currentNode != null) {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        }
    }

    // Comprueba si un dato existe en la lista
    @Override
    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }
        DoubleNode currentNode = getHead();
        while (currentNode.getNext() != null) {
            if (currentNode.getData() == data) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
