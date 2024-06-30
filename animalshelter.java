import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class animalshelter {
    private Queue<String> dogs = new LinkedList<>();
    private Queue<String> cats = new LinkedList<>();
    private int order = 0;

    // Enqueue method
    public void enqueue(String animal, String name) {
        String entry = ++order + ":" + name;
        if (animal.equalsIgnoreCase("dog")) {
            dogs.offer(entry);
        } else if (animal.equalsIgnoreCase("cat")) {
            cats.offer(entry);
        } else {
            System.out.println("Invalid animal type.");
        }
    }

    // Dequeue any
    public String dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return "No animals available.";
        } else if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
            return dogs.poll();
        } else {
            String oldestDog = dogs.peek();
            String oldestCat = cats.peek();
            int dogOrder = Integer.parseInt(oldestDog.split(":")[0]);
            int catOrder = Integer.parseInt(oldestCat.split(":")[0]);
            if (dogOrder < catOrder) {
                return dogs.poll();
            } else {
                return cats.poll();
            }
        }
    }

    // Dequeue dogs
    public String dequeueDogs() {
        if (dogs.isEmpty()) {
            return "No dogs available.";
        } else {
            return dogs.poll();
        }
    }

    // Dequeue cats
    public String dequeueCats() {
        if (cats.isEmpty()) {
            return "No cats available.";
        } else {
            return cats.poll();
        }
    }

    // Peek dogs
    public String peekDogs() {
        if (dogs.isEmpty()) {
            return "No dogs available.";
        } else {
            return dogs.peek();
        }
    }

    // Peek cats
    public String peekCats() {
        if (cats.isEmpty()) {
            return "No cats available.";
        } else {
            return cats.peek();
        }
    }

    // Get size of the queue
    public int size() {
        return dogs.size() + cats.size();
    }

    // Main method to test
    public static void main(String[] args) {
        animalshelter shelter = new animalshelter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue any");
            System.out.println("3. Dequeue dogs");
            System.out.println("4. Dequeue cats");
            System.out.println("5. Peek dogs");
            System.out.println("6. Peek cats");
            System.out.println("7. Size of queue");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter type (dog/cat):");
                    String type = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    shelter.enqueue(type, name);
                    break;
                case 2:
                    if (shelter.size() == 0) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Dequeued: " + shelter.dequeueAny());
                    }
                    break;
                case 3:
                    if (shelter.size() == 0 || shelter.peekDogs().startsWith("No")) {
                        System.out.println("No dogs to dequeue.");
                    } else {
                        System.out.println("Dequeued dog: " + shelter.dequeueDogs());
                    }
                    break;
                case 4:
                    if (shelter.size() == 0 || shelter.peekCats().startsWith("No")) {
                        System.out.println("No cats to dequeue.");
                    } else {
                        System.out.println("Dequeued cat: " + shelter.dequeueCats());
                    }
                    break;
                case 5:
                    System.out.println("Peeked dog: " + shelter.peekDogs());
                    break;
                case 6:
                    System.out.println("Peeked cat: " + shelter.peekCats());
                    break;
                case 7:
                    System.out.println("Size of the queue: " + shelter.size());
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
