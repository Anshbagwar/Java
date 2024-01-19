import java.util.*;
class userArray  {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt() ;
        int size[] = new int[n] ;     //array intialising 
        
        System.out.println("enter the elements of the array:");

        for(int i =0 ; i < n ;i++){
            size[i] = sc.nextInt();      //taking input from the user
        }

        int firsthighest = Integer.MIN_VALUE ;      //Min fucntion beacuse min value should be easier to compare
        int secondhigh = Integer.MIN_VALUE ;        //if we take maximun values it would give us wrong answers 

        for(int i : size){
            //for (int i = 0; i < array.length; i++) {int score = array[i];}
            if(i > firsthighest){
                secondhigh = firsthighest ;
                firsthighest = i; 

            }
            else if(i > secondhigh && i < firsthighest)
            {
                secondhigh = i;
            }
        }
        System.out.println("Top 2 arrays are : "+ firsthighest +","+ secondhigh);



    }
    
}
