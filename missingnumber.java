import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int size[] = new int[n - 1];  // One element is missing, isliye n-1 tk ka hi input denge
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n - 1; i++) {   //loop bhi n-1 chlega
            size[i] = sc.nextInt();
        }

        int nSum = (n * (n + 1)) / 2;  //total n number of sum nikalne ka formula
        //n =5  then sum is 15
        int sum = 0;

        for (int i : size) { //for (int i = 0; i < n; i++) {int size =n[i];}
            sum += i;
        }

        int missingNumber = nSum - sum;
        System.out.println("Missing number: " + missingNumber);
    }
}
