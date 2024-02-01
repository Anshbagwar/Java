import java.util.*;
public class ProductMax2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int size[] = new int[n];
        System.out.println("enter the elements of the array: ");
        for(int i =  0; i<n ;i++){
            size[i] = sc.nextInt();
        }
        int maxproduct = size[0] * size[1] ;
        String pair= " ";
        for(int i =  0; i<n ;i++){
            for(int j =i+1 ;j< n ;j++){
                if(size[i] * size[j] > maxproduct){
                    maxproduct =size[i] * size[j];
                    pair = i +" "+ j;
                }
            }
        }
        System.out.println("Max product at indices: "+ pair);

        
    }
}

        
