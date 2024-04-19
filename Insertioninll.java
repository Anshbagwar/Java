
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Main {
    static int size = 0;
    static Node head;
    static Node tail;

    public static Node Creation() {
        Scanner sc = new Scanner(System.in);

        head = null;
        tail = null;

        System.out.println("enter the elements for ll and -1 to stop: ");
        while (true) {
            int n = sc.nextInt();

            if (n == -1) {
                break;
            }
            Node temp = new Node(n);

            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        return head;
    }

    public static void insert(int data, int position) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
            size++;
            return;
        } else if (position == 0) {
            temp.next = head;
            head = temp;
        } else if (position >= size) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
            tail = temp;
        } else {
            Node tempn = head;
            int i = 0;
            while (i < position - 1) {
                tempn = tempn.next;
                i++;
            }
            Node nayaNode = tempn.next;
            tempn.next = temp;
            temp.next = nayaNode;
        }
        size++;
    }

    public static void print(Node head) {
        System.out.println("linked list entered is: ");
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        head = Creation();
        print(head);

        int choice;
        while (true) {
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at specific location");
            System.out.println("4. Print the linked list");
            System.out.println("5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter value to insert at the beginning");
                    int databegin = sc.nextInt();
                    insert(databegin, 0);
                    break;
                case 2:
                    System.out.println("Enter data to insert at the end: ");
                    int dataEnd = sc.nextInt();
                    insert(dataEnd, size);
                    break;
                case 3:
                    System.out.println("Enter value to insert at location");
                    int dataLoc = sc.nextInt();
                    System.out.println("Enter position: ");
                    int position = sc.nextInt();
                    insert(dataLoc, position);
                    break;
                case 4:
                    print(head);
                    break;
                case 5:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }
}
