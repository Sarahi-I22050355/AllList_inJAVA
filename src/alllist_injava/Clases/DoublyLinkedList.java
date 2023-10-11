
package alllist_injava.Clases;

public class DoublyLinkedList {
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
        clear();
    }

    public void add(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (isEmpty()) {
            head = newNode;
            head.setNext(null);
            head.setBack(null);
            lastNode = head;
        } else {
            lastNode.setNext(newNode);
            newNode.setNext(null);
            newNode.setBack(lastNode);
            lastNode = newNode;
        }
    }

    public void delete(int data) {
        DoubleNode copyHead = head;
        DoubleNode copyHeadTracking = null;
        boolean buscar = false;
        while (copyHead != null && !buscar) {
            if (copyHead.getData() == data) {
                if (copyHead == head) {
                    System.out.println("- Dato[" + data + "] Existe en la lista");
                    head = head.getNext();
                    if (head != null) {
                        head.setBack(null);
                    }
                } else if (copyHead == lastNode) {
                    System.out.println("- Dato[" + data + "] Existe en la lista");
                    copyHeadTracking.setNext(null);
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
        }
        if (!buscar) {
            System.out.println("- Dato[" + data + "] no existe en la lista");
        }
    }


    public void search(int data) {
        DoubleNode copyHead = head;
        boolean buscar = false;
        while (copyHead != null && !buscar) {
            if (copyHead.getData() == data) {
                System.out.println("- Dato[" + data + "] Existe en la lista ");
                buscar = true;
            }
            copyHead = copyHead.getNext();
        }
        if (!buscar) {
            System.out.println("- Dato[" + data + "] No Existe en la lista ");
        }
    }

    public void show() {
        DoubleNode copyHead = head;
        int i = 1;
        System.out.println("=== Mi Lista doblemente enlazada ===");
        while (copyHead != null) {
            System.out.println("- Nodo[" + i + "] y dato: " + copyHead.getData());
            copyHead = copyHead.getNext();
            i++;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }
}
