package alllist_injava;
import alllist_injava.Clases.Auto;
import alllist_injava.Clases.CircularDoublyLinkedList;
import alllist_injava.Clases.CircularList;
import alllist_injava.Clases.DoublyLinkedList;
import alllist_injava.Clases.SimpleList;
import java.util.Random;
import java.util.Scanner;

public class AllList_inJAVA {
    public static void main(String[] args) {
        Random random = new Random();
        Auto automatic = new Auto();
        try (Scanner scanner = new Scanner(System.in)) {
            int option;
            
            while (true) {
                System.out.println("*****Listas*****\n[1] Simple.\n[2] Circular.\n[3] Doble enlazada.\n[4] Cicular doble enlazada.\n[5] Salir");
                System.out.print("Opcion: ");
                option = scanner.nextInt();
                
                if (option == 5) {
                    break;  // Salir del bucle
                }
                
                switch (option) {
                    case 1:
                        System.out.println();
                        SimpleList simpleList = new SimpleList();
                        automatic.autoAddSimpleList(simpleList, random);
                        automatic.autoDeleteSimpleList(simpleList, random);
                        automatic.autoSearchSimpleList(simpleList, random);
                        break;
                    case 2:
                        System.out.println();
                        CircularList circularList = new CircularList();
                        automatic.autoAddCircularList(circularList, random);
                        automatic.autoDeleteCircularList(circularList, random);
                        automatic.autoSearchCircularList(circularList, random);
                        break;
                    case 3:
                        System.out.println();
                        DoublyLinkedList doublyListLinked = new DoublyLinkedList();
                        automatic.autoAddDoublyListLinked(doublyListLinked, random);
                        automatic.autoDeleteDoublyListLinked(doublyListLinked, random);
                        automatic.autoSearchDoublyListLinked(doublyListLinked, random);
                        break;
                    case 4:
                        System.out.println();
                        CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();
                        automatic.autoAddCircularDoublyLinkedList(circularDoublyLinkedList, random);
                        automatic.autoDeleteCircularDoublyLinkedList(circularDoublyLinkedList, random);
                        automatic.autoSearchCircularDoublyLinkedList(circularDoublyLinkedList, random);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
    
