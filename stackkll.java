import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class stackkll {
    public Node head;
    public Node tail;
    public int size;

    public Node create(int data) {
        Node temp = new Node(data);
        head = tail = temp;
        size = 1;
        return head;
    }

    public void insertion(int data, int location) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else if (location == 0) {
            temp.next = head;
            head = temp;
        } else if (location >= size) {
            tail.next = temp;
            tail = temp;
        } else {
            Node traverse = head;
            int i = 0;
            while (i < location - 1) {
                traverse = traverse.next;
                i++;
            }
            Node newnode = traverse.next;
            traverse.next = temp;
            temp.next = newnode;
        }
        size++;
    }

    public void deletion(int location) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size - 1) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node current = head;
                for (int i = 0; i < size - 2; i++) {
                    current = current.next;
                }
                current.next = null;
                tail = current;
            }
            size--;
        } else {
            Node current = head;
            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
            if (current.next == null) {
                tail = current;
            }
        }
    }

    public int peek() {
        if (isempty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return head.data;
        }
    }


    public void display() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }


    public void push(int data) {
        insertion(data, 0);
    }

    public int pop() {
        int result = -1;
        if (isempty()) {
            System.out.println("Stack is empty");
        } else {
            result = head.data;
            deletion(0);
        }
        return result;
    }

    public boolean isempty() {
        return head == null;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        stackkll stack = new stackkll();
        System.out.println("Enter elements and -1 to stop: ");
        while (true) {
            int n = sc.nextInt();
            if (n == -1) {
                break;
            } else {
                stack.push(n);
            }
        }

        while (true) {
            System.out.println("Choose an operation: 1. push 2. pop 3. peek 4. empty or not 5. display 6. exit");
            int operation = sc.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter element to push:");
                    int element = sc.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    int poppedElement = stack.pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;
                case 3:
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        System.out.println("Top element is: " + topElement);
                    }
                    break;
                case 4:
                    System.out.println("Empty or not: " + stack.isempty());
                    break;
                case 5:
                    stack.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid operation. Try again.");
                    break;
            }
        }
    }
}
