
package alllist_injava.Clases;

public class CircularDoublyLinkedList {
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
    public CircularDoublyLinkedList() {
        clear();
    }

    public void add(int data) {
        DoubleNode newNode = new DoubleNode();
        newNode.setData(data);
        if (isEmpty()) {
            head = newNode;
            head.setNext(newNode);
            head.setBack(newNode);
            lastNode = head;
        } else {
            lastNode.setNext(newNode);
            newNode.setNext(head);
            newNode.setBack(lastNode);
            lastNode = newNode;
            head.setBack(newNode);
        }
    }

    public void delete(int data) {
        DoubleNode currentNode = head;
        if (head.getData() == data) {
            System.out.println("- Dato[" + data + "] se elimino de la lista");
            head = head.getNext();
            head.setBack(lastNode);
            lastNode.setNext(head);
            return;
        }
        do {
            if (currentNode.getNext().getData() == data) {
                if (currentNode.getNext() == lastNode) {
                    System.out.println("- Dato[" + data + "] se elimino de la lista");
                    lastNode = lastNode.getBack();
                    lastNode.setNext(head);
                    return;
                }
                System.out.println("- Dato[" + data + "] se elimino de la lista");
                currentNode.getNext().setBack(currentNode);
                currentNode.setNext(currentNode.getNext().getNext());
                return;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != head);
        System.out.println("- Dato[" + data + "] No existe en la lista");
    }

    public void search(int data) {
        DoubleNode copyHead = head;
        do {
            if (copyHead.getData() == data) {
                System.out.println("- Dato[" + data + "] Existe en la lista");
                return;
            }
            copyHead = copyHead.getNext();
        } while (copyHead != head);
        System.out.println("- Dato[" + data + "] No existe en la lista");
    }

    public void show() {
        DoubleNode copyHead = head;
        int i = 1;
        System.out.println("=== Mi Lista doblemente enlazada ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + copyHead.getData());
            copyHead = copyHead.getNext();
            i++;
        } while (copyHead != head);
    }

    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }
        DoubleNode currentNode = head;
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

    public void clear() {
        head = null;
    }
}
