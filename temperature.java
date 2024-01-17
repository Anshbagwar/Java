//Array question to print avg temperature 
//also print the days above the avg temperature recorded
import java.util.*;
public class temperature {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of days: ");
        int days = sc.nextInt() ;
        int t[] = new int[days];

        System.out.println("enter the tempersture for "+ days+ ":");
        int sum = 0 ;
        for(int i=0; i < days ;i++)
        {
            t[i]= sc.nextInt();
            sum += t[i] ;
        }

        double avg = sum /days ;
        
        //counts above the avg temp- 
        int above =0 ;
        for(int i =0 ;i < t.length ;i++){
            if(t[i] > avg){
                above++ ;
            }
            
        }
        System.out.println("Avg temp = "+ avg);
        System.out.println(above + " days above avg temperture");
    }
    
}
