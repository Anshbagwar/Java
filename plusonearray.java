import java.util.Scanner;

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i = n-1 ; i>=0 ; i--){ //loop from rigth to left 
            if(digits[i] < 9){
                digits[i]++ ; 
                return digits ; 
            }
            digits[i] = 0;
        }
        int result[] = new int[n+1] ;  //if all digits are  9
        result[0] = 1 ;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();


        System.out.print("Enter the number of digits in the array: ");
        int n = scanner.nextInt();
        
        int[] digits = new int[n];
        System.out.println("Enter the digits separated by space: ");
        for (int i = 0; i < n; i++) {
            digits[i] = scanner.nextInt();
        }
        
        
        int[] result = solution.plusOne(digits);
        System.out.print("Result after adding one: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
