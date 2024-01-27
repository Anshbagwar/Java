import java.util.*;
public class stock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int size[] = new int[n];
        System.out.println("enter the price of the stocks: ");
        for(int i =  0; i<n ;i++){
            size[i] = sc.nextInt();
        }
       int min  = Integer.MIN_VALUE ;
       int maxprofit = 0 ;
       for(int i : size){
        if(i < min){
            min =i ;
        }
        else if( i - min > maxprofit){
            maxprofit = i- min ;
        }

       }
       System.out.println("max profit: "+ maxprofit);
    }
    
}
