import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the sorted array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n == 0) {
            System.out.println("Array is empty. No duplicates to remove.");
        } else {
            int i = 0;

            for (int j = 1; j < n; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            System.out.println("Modified array:");
            for (int k = 0; k <= i; k++) {
                System.out.print(nums[k] + " ");
            }
            System.out.println("\nLength of modified array: " + (i + 1));
        }
    }
}
