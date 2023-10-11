
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
        DoubleNode newNode = new DoubleNode(data);
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
        DoubleNode copyHead = head;
        DoubleNode copyHeadTracking = null;
        boolean buscar = false;

        do {
            if (copyHead.getData() == data) {
                if (copyHead == head) {
                    System.out.println("- Dato[" + data + "] Existe en la lista");
                    head = head.getNext();
                    head.setBack(lastNode);
                    lastNode.setNext(head);
                } else if (copyHead == lastNode) {
                    System.out.println("- Dato[" + data + "] Existe en la lista");
                    copyHeadTracking.setNext(head);
                    lastNode = copyHeadTracking;
                } else {
                    System.out.println("- Dato[" + data + "] Existe en la lista");
                    copyHeadTracking.setNext(copyHead.getNext());
                    copyHead.getNext().setBack(copyHeadTracking);
                }
                buscar = true;
            }
            copyHeadTracking = copyHead;
            copyHead = copyHead.getNext();
        } while (!buscar);

        if (!buscar) {
            System.out.println("- Dato[" + data + "] No existe en la lista");
        }
    }

    public void search(int data) {
        DoubleNode copyHead = head;
        boolean buscar = false;
        do {
            if (copyHead.getData() == data) {
                System.out.println("- Dato[" + data + "] Existe en la lista ");
                buscar = true;
            }
            copyHead = copyHead.getNext();
        } while (copyHead != head && !buscar);
        if (!buscar) {
            System.out.println("- Dato[" + data + "] No Existe en la lista ");
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
            return;
        }
        DoubleNode copyHead = head;
        int i = 1;
        System.out.println("=== Mi Lista doblemente enlazada ===");
        do {
            System.out.println("- Nodo[" + i + "] y dato: " + copyHead.getData());
            copyHead = copyHead.getNext();
            i++;
        } while (copyHead != head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }
}
