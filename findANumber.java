import java.util.*;
public class findANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int size[] = new int[n];
        System.out.println("enter the elements of the array: ");
        for(int i =  0; i<n ;i++){
            size[i] = sc.nextInt();
        }
        System.out.println("enter the target value: ");
        int target = sc.nextInt();
        for(int i =0;i<n ;i++){
            for(int j= i+1 ;j<n ;j++){
                if(size[i]+size[j] == target){
                    System.out.println("sum found at index "+i+" "+j);

                }
                else{
                    System.out.println("Sum not found!");
                }
            }

        }
    }
}
