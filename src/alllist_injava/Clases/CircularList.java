
package alllist_injava.Clases;

public class CircularList {
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
        clear();
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            head.setNext(head);
            lastNode = head;
        } else {
            lastNode.setNext(newNode);
            newNode.setNext(head);
            lastNode = newNode;
        }
    }
    
    public void delete(int data) {
        Node copyHead = head;
        Node copyHeadTracking = null;
        boolean buscar = false;

        if (isEmpty()) {
            return;
        }

        do {
            if (copyHead.getData() == data) {
                if (copyHead == head) {
                    System.out.println("- Dato[" + data + "] se eliminó de la lista");
                    head = head.getNext();
                    lastNode.setNext(head);
                } else if (copyHead == lastNode) {
                    System.out.println("- Dato[" + data + "] se eliminó de la lista");
                    copyHeadTracking.setNext(head);
                    lastNode = copyHeadTracking;
                } else {
                    System.out.println("- Dato[" + data + "] se eliminó de la lista");
                    copyHeadTracking.setNext(copyHead.getNext());
                }
                buscar = true;
            }

            copyHeadTracking = copyHead;
            copyHead = copyHead.getNext();
        } while (copyHead != head && !buscar);

        if (!buscar) {
            return;
        }
    }


    public void search(int data) {
        Node copyHead = head;
        boolean buscar = false;
        if (isEmpty()) {
            return;
        }
        do {
            if (copyHead.getData() == data) {
                System.out.println("- Dato[" + data + "] Existe en la lista");
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
        Node copyHead = head;
        int i = 1;
        System.out.println("=== Mi lista Circular ===");
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
