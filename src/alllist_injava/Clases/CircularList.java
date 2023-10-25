
package alllist_injava.Clases;

public class CircularList implements I_methodList{
    private Node head;
    private Node lastNode;

    public Node getHead() {
        return head;
    }
    
    public void setHead(Node head){
        this.head=head;
    }
    
    public Node getLastNode() {
        return lastNode;
    }
    public void setLastNode(Node lastNode){
        this.lastNode=lastNode;
    }
        public CircularList() {
        clear();
    }
    @Override
    public void add(int data) {
        // Caso 0: Creamos un nuevo nodo
        Node newNode = new Node(data);
        // Caso 1: Insertamos al inicio
        if (isEmpty()) {
            head = newNode;
            head.setNext(head);
            lastNode = newNode;
            return;
        }
        // Caso 2: Impedimos datos repetidos
        if (exist(newNode.getData())) {
            return;
        }
        // Caso 3: Colocamos el dato después del primero
        if (newNode.getData() < head.getData()) {
            newNode.setNext(head);
            head = newNode;
            lastNode.setNext(head);
            return;
        }
        // Caso 4: Recorremos la lista
        Node currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() <= newNode.getData()) {
            currentNode = currentNode.getNext();
        }
        // Caso 5: Insertamos en X posición
        if (newNode.getData() < currentNode.getNext().getData()) {
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            return;
        }
        // Caso 6: Insertamos al último
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        lastNode = newNode;
    }
    @Override
    public void delete(int data) {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            return;
        }
        // Caso 2: El dato está al inicio de la lista
        if (head.getData() == data) {
            head = head.getNext();
            lastNode.setNext(head);
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        // Caso 3: Recorremos la lista
        Node currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }
        // Caso 4: El dato está al final de la lista
        if (currentNode.getNext() == lastNode && currentNode.getNext().getData() == data) {
            currentNode.setNext(currentNode.getNext().getNext());
            lastNode = currentNode;
            lastNode.setNext(head);
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        // Caso 5: El dato está en X posición de la lista
        if (currentNode.getNext().getData() == data) {
            currentNode.setNext(currentNode.getNext().getNext());
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        // Caso 6: No se encontró el dato
        System.out.println("- Dato[" + data + "] No encontrado/eliminado de la lista");
    }
    @Override
    public void search(int data) {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            return;
        }
        // Caso 2: El dato está al inicio de la lista
        if (head.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        // Caso 3: Recorremos la lista
        Node currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        // Caso 4: El dato ingresado existe en X posición
        if (currentNode.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        // Caso 5: No existe el dato
        System.out.println("- Dato[" + data + "] No Existe en la lista");
    }
    @Override
    public void show() {
        // Caso 1: Comprobamos si la lista está vacía
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }
        // Caso 2: Recorremos la lista
        Node currentNode = head;
        int i = 0;
        System.out.println("=== Mi lista Circular ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        } while (currentNode != head);
    }
    @Override
    public boolean exist(int data) {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            return false;
        }
        // Caso 2: Si el dato ya existe al inicio
        if (head.getData() == data) {
            return true;
        }
        // Caso 3: Recorremos la lista
        Node currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        // Caso 4: Si el dato ya existe en X posición o al final
        if (currentNode.getData() == data) {
            return true;
        }
        // Caso 5: El dato no existe en la lista
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
