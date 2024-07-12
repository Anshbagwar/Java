import java.util.Scanner;

public class Binaryarr {
    int[] arr;
    int lastindex;

    public Binaryarr(int size) {
        arr = new int[size + 1];
        this.lastindex = 0;
        System.out.println("Array of size " + size + " created.");
    }

    public boolean isFull() {
        return lastindex == arr.length - 1;
    }

    public void insert(int data) {
        if (!isFull()) {
            arr[lastindex + 1] = data;
            lastindex++;
        } else {
            System.out.println("Array is full.");
        }
    }

    public void preorder(int index) {
        if (index > lastindex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preorder(index * 2);
        preorder(index * 2 + 1);
    }

    public void inorder(int index) {
        if (index > lastindex) {
            return;
        }
        inorder(index * 2);
        System.out.print(arr[index] + " ");
        inorder(index * 2 + 1);
    }

    public void postorder(int index) {
        if (index > lastindex) {
            return;
        }
        postorder(index * 2);
        postorder(index * 2 + 1);
        System.out.print(arr[index] + " ");
    }

    public void levelorder() {
        for (int i = 1; i <= lastindex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int search(int x) {
        for (int i = 1; i <= lastindex; i++) {
            if (arr[i] == x) {
                System.out.println("Found at index " + i);
                return i;
            }
        }
        System.out.println("Not found");
        return -1;
    }

    public void delete(int x) {
        int location = search(x);
        if (location == -1) {
            return;
        } else {
            arr[location] = arr[lastindex];
            lastindex--;
            System.out.println("Deleted");
        }
    }

    public void print() {
        if (lastindex == 0) {
            System.out.println("Array is empty.");
        } else {
            for (int i = 1; i <= lastindex; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int size = sc.nextInt();
        Binaryarr BT = new Binaryarr(size);

        System.out.println("Enter the values of size " + size);
        for (int i = 0; i < size; i++) {
            int x = sc.nextInt();
            BT.insert(x);
        }

        BT.print();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Inorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Level Order Traversal");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = sc.nextInt();
                    BT.insert(insertValue);
                    BT.print();
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = sc.nextInt();
                    BT.delete(deleteValue);
                    BT.print();
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    int searchValue = sc.nextInt();
                    BT.search(searchValue);
                    break;
                case 4:
                    System.out.println("Preorder Traversal:");
                    BT.preorder(1);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Inorder Traversal:");
                    BT.inorder(1);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Postorder Traversal:");
                    BT.postorder(1);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Level Order Traversal:");
                    BT.levelorder();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);

        sc.close();
    }
}
