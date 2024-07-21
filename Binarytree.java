import java.util.Scanner;
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Binarytree {
    Node root;

    public Binarytree() {
        root = null;
        System.out.println("Binary Tree created.");
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        insertRec(root, newNode);
    }

    public void insertRec(Node latestRoot, Node newNode) {
        if (latestRoot.left == null) {
            latestRoot.left = newNode;
        } else if (latestRoot.right == null) {
            latestRoot.right = newNode;
        } else {
            insertRec(latestRoot.left, newNode);
        }
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelorder() {
        if (root == null) {
            return;
        }

        for (int i = 1; i <= height(root); i++) {
            printCurrentLevel(root, i);
        }
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight > rightHeight) {
                return (leftHeight + 1);
            } else {
                return (rightHeight + 1);
            }
        }
    }

    public void printCurrentLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public Node search(Node node, int data) {
        if (node == null || node.data == data) {
            return node;
        }

        Node foundNode = search(node.left, data);
        if (foundNode == null) {
            foundNode = search(node.right, data);
        }
        return foundNode;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    public Node deleteRec(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    public int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void print() {
        if (root == null) {
            System.out.println("Tree is empty.");
        } else {
            levelorder();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int size = sc.nextInt();
        Binarytree BT = new Binarytree();

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
                    Node searchResult = BT.search(BT.root, searchValue);
                    if (searchResult != null) {
                        System.out.println("Found");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 4:
                    System.out.println("Preorder Traversal:");
                    BT.preorder(BT.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Inorder Traversal:");
                    BT.inorder(BT.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Postorder Traversal:");
                    BT.postorder(BT.root);
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
