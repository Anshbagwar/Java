import java.util.*;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int size[] = new int[n]; 
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {  
            size[i] = sc.nextInt();
        }
//time compexity =O(N)
        for (int i = 0; i < n / 2; i++) {//.................O(n)
            int last = n - i - 1;//O(1)
            int temp = size[i];//O(1)
            size[i] = size[last];//O(1)
            size[last] = temp;//O(1)
        }

        System.out.println("Reversed Array: " + Arrays.toString(size));//......O(n)
    }
}
