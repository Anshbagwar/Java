import java.util.*;

public class Pair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int size[] = new int[n]; 
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {  
            size[i] = sc.nextInt();
        }
        // TIME COMPLEXITY: O(N^2)
        System.out.println("All possible pairs: ");
        for (int i = 0; i < n; i++) {//..................O(N)
            for (int j = 0; j < n; j++) {//..........O(N)
                System.out.println(size[i] + " " + size[j]);//.........O(1)
            }
        }
    }
}
