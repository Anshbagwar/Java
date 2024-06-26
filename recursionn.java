import java.util.*;
public class recursionn {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number: ");
        int n =sc.nextInt();
        recursionn rec = new recursionn();
        int x = recursionn.fact(n);
        System.out.println(x);

    }
    public static int fact(int n){
        if( n<1) return -1;
        if(n==0 || n==1){
            return 1 ;
        }
        return n * fact(n-1);
    }

}
