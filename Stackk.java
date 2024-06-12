import java.util.Scanner;

//Stack using arrays
public class Stackk {
    int arr[];
    int topofStack;

    public Stackk(int size) {
        this.arr = new int[size];
        this.topofStack = -1;
        System.out.println("stack created with size : " + size);
    }

    public boolean isEmpty() {
        if (topofStack == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isfull() {
        if (topofStack == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    //push
    public void push(int data) {
        if (isfull()) {
            System.out.println("full");
        } else {
            arr[topofStack + 1] = data;
            topofStack++;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("empty stack");
            return -1;
        } else {
            int top = arr[topofStack];
            topofStack--;
            return top;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("empty");
            return -1;
        } else {
            return arr[topofStack];
        }
    }
    public void delete(){
        topofStack = -1;
        System.out.println("stack deleted");
        
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= topofStack; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter stack size: ");
        int size = sc.nextInt();
        Stackk stack = new Stackk(size);

        System.out.println("Enter " + size + " elements to push into the stack:");
        for (int i = 0; i < size; i++) {
            int n = sc.nextInt();
            stack.push(n);
        }

        while (true) {
            System.out.println("Choose an operation: 1. push 2. pop 3. peek 4. display 5. delte");
            int operation = sc.nextInt();

            switch (operation) {
                case 1: // push
                    System.out.println("Enter the element to push: ");
                    int element = sc.nextInt();
                    stack.push(element);
                    break;
                case 2: // pop
                    int poppedElement = stack.pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;
                case 3: // peek
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        System.out.println("Top element: " + topElement);
                    }
                    break;
                case 4: // display
                    stack.display();
                    break;
                case 5:
                    stack.delete();
                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
    }
}


