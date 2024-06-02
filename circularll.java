import java.util.Scanner;

class CircularLinkedList {
    static Node head = null;
    static Node tail = null;
    static int size = 0;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static void create(int data) {
        Node temp = new Node(data);
        head = temp;
        tail = temp;
        temp.next = head; // making it circular
        size = 1;
    }

    public static void insert(int data, int location) {
        Node temp = new Node(data);
        if (head == null) {
            create(data);
            return;
        } else if (location == 0) { // Insert at the beginning
            temp.next = head;
            head = temp;
            tail.next = head;
        } else if (location == size || location == -1) { // Insert at the end
            tail.next = temp;
            tail = temp;
            tail.next = head;
        } else { // Insert at specified location
            Node current = head;
            int i = 0;
            while (i < location - 1) {
                current = current.next;
                i++;
            }
            temp.next = current.next;
            current.next = temp;
        }
        size++;
    }

    public static void delete(int location) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node current = head;
            for (int i = 0; i < size - 1; i++) {
                current = current.next;
            }
            current.next = head;
            tail = current;
            size--;
        } else {
            Node current = head;
            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public static boolean search(int searchElement) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == searchElement) {
                System.out.println("Element found at index: " + i);
                return true;
            }
            current = current.next;
        }
        System.out.println("Element not found");
        return false;
    }

    public static void print() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("The elements of the linked list are: ");
        Node current = head;
        while (true) {
            System.out.print(current.data + " ");
            current = current.next;
            if (current == head) {
                break;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements (enter -1 to stop):");
        while (true) {
            int n = scanner.nextInt();
            if (n == -1) {
                break;
            }
            insert(n, -1);
        }

        print();

        while (true) {
            System.out.println("1. Insert at specific location\n2. Display\n3. Delete at specific location\n4. Search element\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int data = scanner.nextInt();
                    System.out.print("Enter location: ");
                    int location = scanner.nextInt();
                    insert(data, location);
                    break;
                case 2:
                    print();
                    break;
                case 3:
                    System.out.print("Enter location to delete: ");
                    int delLocation = scanner.nextInt();
                    delete(delLocation);
                    break;
                case 4:
                    System.out.print("Enter element to search: ");
                    int searchElement = scanner.nextInt();
                    search(searchElement);
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
