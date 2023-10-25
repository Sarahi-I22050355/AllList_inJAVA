
package alllist_injava.Clases;
public class SimpleList implements I_methodList {
    private Node head;
    
    public Node getHead() {
    return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public SimpleList() {
        clear();
    }
    @Override
    public void add(int data) {
        // Caso 0: Creamos un nuevo nodo
        Node newNode = new Node(data);
        // Caso 1: Insertamos al inicio
        if (isEmpty()) {
            head = newNode;
            return;
        }
        // Caso 2: Impedimos datos repetidos
        if (exist(newNode.getData())) {
            return;
        }
        // Caso 3: Insertamos el dato al inicio de la lista
        if (newNode.getData() < head.getData()) {
            newNode.setNext(head);
            head = newNode;
            return;
        }
        // Caso 4: Recorremos la lista
        Node currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < newNode.getData()) {
            currentNode = currentNode.getNext();
        }
        // Caso 5: Insertamos en X posición o al final de la lista
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
    }
    @Override
    public void delete(int data) {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            return;
        }
        // Caso 2: Si el dato está al inicio
        if (head.getData() == data) {
            head = head.getNext();
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        // Caso 3: Recorremos la lista
        Node currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }
        // Caso 4: Si el dato está en X posición
        if (currentNode.getNext() != null && currentNode.getNext().getData() == data) {
            currentNode.setNext(currentNode.getNext().getNext());
            System.out.println("- Dato[" + data + "] Eliminado de la lista");
            return;
        }
        // Caso 5: No se encontró el dato
        System.out.println("- Dato[" + data + "] No encontrado/eliminado de la lista");
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
        // Caso 3: Recorremos la lista
        Node currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        // Caso 4: Si el dato está en X posición
        if (currentNode.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        // Caso 5: No existe el dato
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
        int i = 0;
        Node currentNode = head;
        System.out.println("=== Mi lista simple ===");
        while (currentNode != null) {
            System.out.println("- Nodo[" + i + "] y dato: " + currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        }
    }
    @Override
    public boolean exist(int data) {
        // Caso 1: Si la lista está vacía
        if (isEmpty()) {
            return false;
        }
        // Caso 2: Si el primer nodo contiene el dato
        if (head.getData() == data) {
            return true;
        }
        // Caso 3: Empezamos a recorrer la lista
        Node currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        // Caso 4: El dato existe en el último elemento
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
    }
}



