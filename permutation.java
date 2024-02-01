import java.util.*;

public class PermutationChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size: ");
        int n = sc.nextInt();
        int size1[] = new int[n];
        int size2[] = new int[n];

        System.out.println("Enter the elements of the 1st array: ");
        for (int i = 0; i < n; i++) {
            size1[i] = sc.nextInt();
        }

        System.out.println("Enter the elements of the 2nd array: ");
        for (int j = 0; j < n; j++) {
            size2[j] = sc.nextInt();
        }

        boolean check = false;
        int sum1 = 0, mul1 = 1; 
        int sum2 = 0, mul2 = 1; 

        for (int i = 0; i < n; i++) {
            sum1 += size1[i];
            mul1 *= size1[i];

            sum2 += size2[i];
            mul2 *= size2[i];
        }

        if (sum1 == sum2 && mul1 == mul2) {
            check = true;
            System.out.println("Permutational to each other: " + check);
        } else {
            System.out.println("Not permutational to each other");
        }
    }
}
