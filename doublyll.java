import java.awt.*;
import java.util.Scanner;

public class doublyll {
    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    public static Node creatdouble(int data) {
        Node temp = new Node(data);
        head = tail = temp;
        size = 1;
        return head;
    }

    public static void insertdd(int data, int location) {
        Node temp = new Node(data);
        if (head == null) {
            creatdouble(data);
        } else if (location == 0) {
            temp.next = head;
            temp.prev = null;
            head.prev = temp;
            head = temp;
        } else if (location >= size) {
            temp.next = null;
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        } else {
            Node current = head;
            int i = 0;
            while (i < location - 1) {
                current = current.next;
                i++;
            }
            temp.prev = current;
            temp.next = current.next;
            current.next = temp;
            if (temp.next != null) {
                temp.next.prev = temp;
            }
        }
        size++;
    }

    public static void insertAtEnd(int data) {
        insertdd(data, size);
    }

    public static void delete(int location) {
        if (head == null) {
            System.out.println("List is empty.");
        } else if (location == 0) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            } else {
                head = tail = null;
            }
            size--;
        } else if (location >= size - 1) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else {
                head = tail = null;
            }
            size--;
        } else {
            Node current = head;
            for (int i = 0; i < location; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            size--;
        }
    }
    public static boolean searchnode(int element){
        if(head != null){
            System.out.println("empty");
        Node temp = head ;
        for(int i =0 ; i <size ; i++) {
            if (temp.data == element) {
                System.out.println("mode found at location " + i);
                return true;
            }
            temp = temp.next;
        }
        }
        System.out.println("not found");
        return false;
    }

    public static void reversePrint() {
        if (head != null) {
            Node temp = tail;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
            System.out.println();
        } else {
            System.out.println("List does not exist.");
        }
    }

    public static void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter elemts and -1 to stop: ");
        while (true) {
            int n = scanner.nextInt();
            if (n == -1) {
                break;
            } else {
                insertAtEnd(n);
            }
        }
        print();

        while(true){
            int option ;
            System.out.println("1. Insert at specific location\n2. Display\n3. reverse traversal\n4. Search\n5. deletion");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.print("Enter data: ");
                    int data = scanner.nextInt();
                    System.out.print("Enter location: ");
                    int location = scanner.nextInt();
                    insertdd(data, location);
                    break;
                case 2:
                    System.out.println("diplay");
                    print();
                    break;
                case 3:
                    System.out.println("reverse printing: ");
                    reversePrint();
                case 4:
                    System.out.println("entter elenet to searcch");
                    int element = scanner.nextInt();
                    searchnode(element);
                    break;
                case 5:
                    System.out.print("Enter location: ");
                    int deleteLocation = scanner.nextInt();
                    delete(deleteLocation);
                    break;

            }

        }

    }

}
