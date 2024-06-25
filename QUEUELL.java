import java.util.*;

        public class QUEUELL {
            static Node head;
            static Node tail;
            static int size;

            public QUEUELL() {
                this.head = null;
                this.tail = null;
                this.size = 0;
                System.out.println("Queue created successfully");
            }

            public boolean empty() {
                return head == null;
            }

            public void enqueue(int data) {
                insertion(data, size);
            }

            public int dequeue() {
                if (empty()) {
                    System.out.println("Queue is empty");
                    return -1;
                } else {
                    int value = head.data;
                    deletion(0);
                    return value;
                }
            }

            private void insertion(int data, int location) {
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

            private void deletion(int location) {
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
                } else { // Delete at a specific location
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

            public void print() {
                System.out.println("The elements of the queue are: ");
                Node current = head;
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.next;
                }
                System.out.println();
            }

            public static class Node {
                int data;
                Node next;

                public Node(int data) {
                    this.data = data;
                    this.next = null;
                }
            }

            public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);
                QUEUELL queue = new QUEUELL();
                System.out.println("Enter elements to enqueue (enter -1 to stop): ");

                while (true) {
                    int element = sc.nextInt();
                    if (element == -1) {
                        break;
                    }
                    queue.enqueue(element);
                }
                while (true) {
                    System.out.println("Choose an operation: 1. Enqueue 2. Dequeue 3. Print 4. Exit");
                    int operation = sc.nextInt();
                    switch (operation) {
                        case 1:
                            System.out.println("Enter the element to enqueue: ");
                            int element = sc.nextInt();
                            queue.enqueue(element);
                            break;
                        case 2:
                            int dequeuedElement = queue.dequeue();
                            if (dequeuedElement != -1) {
                                System.out.println("Dequeued element: " + dequeuedElement);
                            }
                            break;
                        case 3:
                            queue.print();
                            break;
                        case 4:
                            System.out.println("Exiting program");
                            sc.close();
                            return;
                        default:
                            System.out.println("Invalid operation. Try again.");
                    }
                }
            }
        }



