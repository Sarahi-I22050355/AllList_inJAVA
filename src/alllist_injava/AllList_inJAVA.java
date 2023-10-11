
package alllist_injava;

import alllist_injava.Clases.CircularDoublyLinkedList;
import alllist_injava.Clases.CircularList;
import alllist_injava.Clases.DoublyLinkedList;
import alllist_injava.Clases.SimpleList;
import java.util.Scanner;

public class AllList_inJAVA {

    public static void main(String[] args) {
        boolean exit = false;
        try (Scanner scanner = new Scanner(System.in)) {
            do {

                System.out.println("#Ver todas las Listas#");
                System.out.println("[1] Lista simple.");
                System.out.println("[2] Lista circular.");
                System.out.println("[3] Lista doble enlazada.");
                System.out.println("[4] Lista circular doble enlazada.");
                System.out.println("[5] Salir.");
                System.out.print("Ingresa una opción (1 - 5): ");
                int option = scanner.nextInt();
                
                switch (option) {
                    case 1:
                        SimpleList SList = new SimpleList();
                        SList.add(1);
                        SList.add(10);
                        SList.add(100);
                        SList.add(1000);
                        SList.add(10000);
                        SList.show();
                        SList.delete(1);
                        SList.delete(100);
                        SList.delete(10000);
                        SList.show();
                        SList.search(1);
                        SList.search(100);
                        SList.search(10000);
                        scanner.nextLine(); // Consume the newline character.
                        break;
                    case 2:
                        CircularList CList = new CircularList();
                        CList.add(1);
                        CList.add(10);
                        CList.add(100);
                        CList.add(1000);
                        CList.add(10000);
                        CList.show();
                        CList.delete(1);
                        CList.delete(100);
                        CList.delete(10000);
                        CList.show();
                        CList.search(1);
                        CList.search(100);
                        CList.search(10000);
                        scanner.nextLine(); // Consume the newline character.
                        break;
                    case 3:
                        DoublyLinkedList LList = new DoublyLinkedList();
                        LList.add(1);
                        LList.add(10);
                        LList.add(100);
                        LList.add(1000);
                        LList.add(10000);
                        LList.show();
                        LList.delete(1);
                        LList.delete(100);
                        LList.delete(10000);
                        LList.show();
                        LList.search(1);
                        LList.search(100);
                        LList.search(10000);
                        scanner.nextLine(); // Consume the newline character.
                        break;
                    case 4:
                        CircularDoublyLinkedList CDList = new CircularDoublyLinkedList();
                        CDList.add(1);
                        CDList.add(10);
                        CDList.add(100);
                        CDList.add(1000);
                        CDList.add(10000);
                        CDList.show();
                        CDList.delete(1);
                        CDList.delete(100);
                        CDList.delete(10000);
                        CDList.show();
                        CDList.search(1);
                        CDList.search(100);
                        CDList.search(10000);
                        scanner.nextLine(); // Consume the newline character.
                        break;
                    case 5:
                        System.out.println("Fin del programa...");
                        scanner.nextLine(); // Consume the newline character.
                        exit = true;
                        break;
                    default:
                        System.out.println("Ingresa un valor de (1 a 5)...");
                        scanner.nextLine(); // Consume the newline character.
                        break;
                }
            } while (!exit);
        }
    }
    
}
