
package alllist_injava.Clases;

public class SimpleList {
        private Node head;
        // Getter para head
    public Node getHead() {
        return head;
    }

    // Setter para head
    public void setHead(Node head) {
        this.head = head;
    }

    public SimpleList() {
        clear();
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        }
        if (exist(newNode.getData())) {
            return;
        } else {
            Node copyHead = head;
            while (copyHead.getNext() != null) {
                copyHead = copyHead.getNext();
            }
            copyHead.setNext(newNode);
        }
    }

    /*public void delete(int data) {
        Node copyHead = head;
        Node copyHeadTracking = null;
        if (isEmpty()) {
            return;
        }
        if (head != null) {
            copyHead = head;
            while ((copyHead.getNext() != null) && (copyHead.getData() != data)) {
                copyHeadTracking = copyHead;
                copyHead = copyHead.getNext();
            }
            if (copyHead.getData() != data) {
                return;
            } else {
                if (head == copyHead) {
                    head = copyHead.getNext();
                } else {
                    copyHeadTracking.setNext(copyHead.getNext());
                }
                copyHead = null;
            }
        }
    }*/
    public void delete(int data) {
    Node copyHead = head;
    Node copyHeadTracking = null;

    if (isEmpty()) {
        return;
    } else {
        copyHead = head;
        while (copyHead.getNext() != null && copyHead.getData() != data) {
            copyHeadTracking = copyHead;
            copyHead = copyHead.getNext();
        }
        if (copyHead.getData() != data) {
            System.out.println("- Dato[" + data + "] no existe en la lista");
        } else {
            if (head == copyHead) {
                System.out.println("- Dato[" + data + "] se eliminó de la lista");
                head = copyHead.getNext();
                return;
            } else {
                System.out.println("- Dato[" + data + "] se eliminó de la lista");
                copyHeadTracking.setNext(copyHead.getNext());
            }
            copyHead = null;
        }
    }
}


    /*public void search(int data) {
        if (isEmpty()) {
            System.out.println("Lista vacia...");
        }
        if (head != null && head.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        Node copyHead = head;
        while (copyHead.getNext() != null) {
            if (copyHead.getNext().getData() >= data) {
                break;
            }
            copyHead = copyHead.getNext();
        }
        if (copyHead.getNext() != null && copyHead.getNext().getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        System.out.println("- Dato[" + data + "] No Existe en la lista ");
    }*/
    public void search(int data) {
        if (isEmpty()) {
            System.out.println("Lista vacía...");
        }
        if (!isEmpty() && head.getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        Node copyHead = head;
        while (copyHead.getNext() != null) {
            if (copyHead.getNext().getData() == data) {
                break;
            }
            copyHead = copyHead.getNext();
        }
        if (copyHead.getNext() != null && copyHead.getNext().getData() == data) {
            System.out.println("- Dato[" + data + "] Existe en la lista");
            return;
        }
        System.out.println("- Dato[" + data + "] No Existe en la lista");
    }


    public void show() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
            return;
        }
        Node copyHead = head;
        int i = 1;
        System.out.println("=== Mi lista simple ===");
        while (copyHead != null) {
            System.out.println("- Nodo[" + i + "] y dato: " + copyHead.getData());
            copyHead = copyHead.getNext();
            i++;
        }
    }

    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }
        if (head != null && head.getData() == data) {
            return true;
        }
        Node copyHead = head;
        while (copyHead.getNext() != null) {
            if (copyHead.getNext().getData() >= data) {
                break;
            }
            copyHead = copyHead.getNext();
        }
        if (copyHead.getNext() != null && copyHead.getNext().getData() == data) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }
    public void clear(){
        head=null;
    }
}
