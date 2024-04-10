import java.util.* ;
import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the size of the square matrix: ");
        int size = scanner.nextInt();

        
        int[][] userArray = new int[size][size];

      
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                userArray[i][j] = scanner.nextInt();
            }
        }
    }
}
