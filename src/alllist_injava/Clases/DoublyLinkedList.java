
package alllist_injava.Clases;
public class DoublyLinkedList implements I_methodList{
    private DoubleNode head;
    private DoubleNode lastNode;

    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getLastNode() {
        return lastNode;
    }

    public void setLastNode(DoubleNode lastNode) {
        this.lastNode = lastNode;
    }

        public DoublyLinkedList() {
        clear();
    }
    @Override
    public void add(int data) {
        // Caso 0: Creamos un nuevo nodo
        DoubleNode newNode = new DoubleNode(data);
        // Caso 1: Insertamos al inicio
        if (isEmpty()) {
            head = newNode;
            lastNode = newNode;
            return;
        }
        // Caso 2: Impedimos datos repetidos
        if (exist(newNode.getData())) {
            return;
        }
        // Caso 3: El dato nuevo se inserta al inicio
        if (newNode.getData() < head.getData()) {
            head.setBack(newNode);
            newNode.setNext(head);
            head = newNode;
            return;
        }
        // Caso 4: El dato nuevo se inserta al final
        if (newNode.getData() > lastNode.getData()) {
            lastNode.setNext(newNode);
            newNode.setBack(lastNode);
            lastNode = newNode;
            return;
        }
        // Caso 5: Recorremos la lista
        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < newNode.getData()) {
            currentNode = currentNode.getNext();
        }
        // Caso 6: Insertamos en X posición
        newNode.setNext(currentNode.getNext());
        newNode.setBack(currentNode);
        if (currentNode.getNext() != null) {
            currentNode.getNext().setBack(newNode);
        }
        currentNode.setNext(newNode);
    }
    @Override
    public void delete(int data) {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            return;
        }
        // Caso 2: El dato a eliminar está al inicio de la lista
        if (head.getData() == data) {
            head = head.getNext();
            if (head != null) {
                head.setBack(null);
            }
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        // Caso 3: El dato a eliminar está al final de la lista
        if (lastNode.getData() == data) {
            lastNode = lastNode.getBack();
            if (lastNode != null) {
                lastNode.setNext(null);
            }
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        // Caso 4: Recorremos la lista
        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }
        // Caso 5: El dato está en X posición de la lista
        if (currentNode.getNext() != null && currentNode.getNext().getData() == data) {
            DoubleNode nextNode = currentNode.getNext().getNext();
            currentNode.setNext(nextNode);
            if (nextNode != null) {
                nextNode.setBack(currentNode);
            }
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        // Caso 6: No se encontró el dato
        System.out.println("- Dato[" + data + "] No existe/eliminado de la lista");
    }
    @Override
    public void search(int data) {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            return;
        }
        // Caso 2: Si el dato está al inicio
        if (head.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        // Caso 3: Si el dato está al final
        if (lastNode.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        // Caso 4: Recorremos la lista
        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        // Caso 5: Si el dato existe en X posición
        if (currentNode.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        // Caso 6: No existe el dato en la lista
        System.out.println("- Dato[" + data + "] No Existe en la lista");
    }
    @Override
    public void show() {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }
        // Caso 2: Recorremos la lista
        DoubleNode currentNode = head;
        int i = 0;
        System.out.println("=== Mi Lista doblemente enlazada ===");
        while (currentNode != null) {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        }
    }

    public void showRevers() {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }
        // Caso 2: Recorremos la lista en sentido inverso
        DoubleNode currentNode = lastNode;
        int i = 0;
        System.out.println("=== Mi Lista doblemente enlazada Reversa===");
        while (currentNode != null) {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getBack();
            i++;
        }
    }
    @Override
    public boolean exist(int data) {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            return false;
        }
        // Caso 2: Si el primer elemento ya existe
        if (head.getData() == data) {
            return true;
        }
        // Caso 3: Si el dato está al final
        if (lastNode.getData() == data) {
            return true;
        }
        // Caso 4: Recorremos la lista
        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        // Caso 5: El dato ingresado existe en X posición
        if (currentNode.getData() == data) {
            return true;
        }
        // Caso 6: El dato no existe en la lista
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
