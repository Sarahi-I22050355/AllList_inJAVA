package alllist_injava.Clases;

import java.util.Random;
import java.util.Scanner;

public class Auto {

    public void autoAddSimpleList(SimpleList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres añadir: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.add(random.nextInt(25));
        }
        lista.show();
    }

    public void autoDeleteSimpleList(SimpleList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres borrar: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.delete(random.nextInt(25));
        }
        lista.show();
    }

    public void autoSearchSimpleList(SimpleList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres buscar: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.search(random.nextInt(25));
        }
    }

    public void autoAddCircularList(CircularList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres añadir: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.add(random.nextInt(25));
        }
        lista.show();
    }

    public void autoDeleteCircularList(CircularList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres borrar: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.delete(random.nextInt(25));
        }
        lista.show();
    }

    public void autoSearchCircularList(CircularList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres buscar: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.search(random.nextInt(25));
        }
    }

    public void autoAddDoublyListLinked(DoublyLinkedList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres añadir: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.add(random.nextInt(25));
        }
        lista.show();
    }

    public void autoDeleteDoublyListLinked(DoublyLinkedList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres borrar: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.delete(random.nextInt(25));
        }
        lista.show();
    }

    public void autoSearchDoublyListLinked(DoublyLinkedList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres buscar: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.search(random.nextInt(25));
        }
    }

    public void autoAddCircularDoublyLinkedList(CircularDoublyLinkedList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres añadir: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.add(random.nextInt(25));
        }
        lista.show();
    }

    public void autoDeleteCircularDoublyLinkedList(CircularDoublyLinkedList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres borrar: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.delete(random.nextInt(25));
        }
        lista.show();
    }

    public void autoSearchCircularDoublyLinkedList(CircularDoublyLinkedList lista, Random random) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cuantos datos quieres buscar: ");
        int cant = scanner.nextInt();
        for (int i = 0; i < cant; i++) {
            lista.search(random.nextInt(25));
        }
    }
}
