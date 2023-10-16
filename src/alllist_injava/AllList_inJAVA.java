
package alllist_injava;

import alllist_injava.Clases.CircularDoublyLinkedList;
import alllist_injava.Clases.CircularList;
import alllist_injava.Clases.DoublyLinkedList;
import alllist_injava.Clases.SimpleList;
import java.util.Random;
import java.util.Scanner;

public class AllList_inJAVA {

    public static void main(String[] args) {
                Random RL = new Random();
        boolean Exit = false;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("#Ver todas las Listas#");
            System.out.println("[1] Lista simple.");
            System.out.println("[2] Lista circular.");
            System.out.println("[3] Lista doble enlazada.");
            System.out.println("[4] Lista circular doble enlazada.");
            System.out.println("[5] Salir.");
            System.out.print("Ingresa una opción (1 - 5): ");
            int Op = scanner.nextInt();

            switch (Op) {
                case 1:
                    SimpleList SList = new SimpleList();
                    SList.add(23);
                    SList.add(1);
                    SList.add(789);
                    SList.add(456);
                    SList.add(3);
                    SList.show();
                    SList.search(1);
                    SList.search(456);
                    SList.search(23);
                    SList.delete(1);
                    SList.delete(456);
                    SList.delete(23);
                    SList.show();
                    System.out.println("== Random list ==");
                    SimpleList RList = new SimpleList();
                    RList.add(RL.nextInt(5) + 1);
                    RList.add(RL.nextInt(5) + 1);
                    RList.add(RL.nextInt(5) + 1);
                    RList.add(RL.nextInt(5) + 1);
                    RList.add(RL.nextInt(5) + 1);
                    RList.show();
                    scanner.nextLine();
                    break;
                case 2:
                    CircularList CList = new CircularList();
                    CList.add(23);
                    CList.add(1);
                    CList.add(789);
                    CList.add(456);
                    CList.add(3);
                    CList.show();
                    CList.search(1);
                    CList.search(456);
                    CList.search(23);
                    CList.delete(1);
                    CList.delete(456);
                    CList.delete(23);
                    CList.show();
                    System.out.println("== Random list ==");
                    CircularList RCList = new CircularList();
                    RCList.add(RL.nextInt(5) + 1);
                    RCList.add(RL.nextInt(5) + 1);
                    RCList.add(RL.nextInt(5) + 1);
                    RCList.add(RL.nextInt(5) + 1);
                    RCList.add(RL.nextInt(5) + 1);
                    RCList.show();
                    scanner.nextLine();
                    break;
                case 3:
                    DoublyLinkedList LList = new DoublyLinkedList();
                    LList.add(23);
                    LList.add(1);
                    LList.add(789);
                    LList.add(456);
                    LList.add(3);
                    LList.show();
                    LList.showRevers();
                    LList.search(1);
                    LList.search(456);
                    LList.search(23);
                    LList.delete(1);
                    LList.delete(456);
                    LList.delete(23);
                    LList.show();
                    System.out.println("== Random list ==");
                    DoublyLinkedList RLList = new DoublyLinkedList();
                    RLList.add(RL.nextInt(5) + 1);
                    RLList.add(RL.nextInt(5) + 1);
                    RLList.add(RL.nextInt(5) + 1);
                    RLList.add(RL.nextInt(5) + 1);
                    RLList.add(RL.nextInt(5) + 1);
                    RLList.show();
                    scanner.nextLine();
                    break;
                case 4:
                    CircularDoublyLinkedList CDList = new CircularDoublyLinkedList();
                    CDList.add(23);
                    CDList.add(1);
                    CDList.add(789);
                    CDList.add(456);
                    CDList.add(3);
                    CDList.show();
                    CDList.showRevers();
                    CDList.search(1);
                    CDList.search(456);
                    CDList.search(23);
                    CDList.delete(1);
                    CDList.delete(456);
                    CDList.delete(23);
                    CDList.show();
                    System.out.println("== Random list ==");
                    CircularDoublyLinkedList RCDList = new CircularDoublyLinkedList();
                    RCDList.add(RL.nextInt(5) + 1);
                    RCDList.add(RL.nextInt(5) + 1);
                    RCDList.add(RL.nextInt(5) + 1);
                    RCDList.add(RL.nextInt(5) + 1);
                    RCDList.add(RL.nextInt(5) + 1);
                    RCDList.show();
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Fin del programa...");
                    Exit = true;
                    break;
                default:
                    System.out.println("Ingresa un valor de (1 a 5)...");
                    scanner.nextLine();
                    break;
            }
        } while (!Exit);
        scanner.close();
    }
    
}
    
