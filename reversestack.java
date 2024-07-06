import java.util.*;

public class reversestack {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        reversestack Stack = new reversestack();
        System.out.println("Enter the elements of the stack and -1 to stop:");

        int n;
        while(true){
            n = sc.nextInt();
            if(n == -1){
                break;
            }
            stack.push(n);
        }

        System.out.println("Original Stack: " + stack);

        if (!stack.isEmpty()) {
            int middle = (stack.size() + 1) / 2;
            Stack.deleteMiddle(stack, stack.size(), middle);
        }
        System.out.println("Stack after deleting middle element: " + stack);
        sc.close();
    }

    public void deleteMiddle(Stack<Integer> stack, int currentSize, int middle) {
        if (stack.isEmpty() || currentSize == middle) {
            stack.pop();
            return;
        }

        int topElement = stack.pop();
        deleteMiddle(stack, currentSize - 1, middle);
        stack.push(topElement);
    }
}
