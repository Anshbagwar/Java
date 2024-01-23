import java.util.*;
public class Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int size[] = new int[n];
        int index = 0;

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            size[i] = sc.nextInt();
        }

        // Remove duplicates
        int count = 0 ;
        for(int i =0 ;i < n ; i++){
            boolean duplicates =false ;
            for(int j =0; j< count ;j++){
                if(size[i] == size[j]){         //comparing if they are equal or not
                    duplicates =true ;
                    break ;
                }
            }
                if(!duplicates){           //if not duplicatee
                    size[count] = size[i] ;//adds the element to the new array at the count index.
                    count++;
                }
            }

        int unique [] = Arrays.copyOf(size, count);//creating a new array of same size and count


        System.out.println("Array after removing duplicates: ");
        for (int i = 0; i < unique.length; i++) {
            System.out.print(unique[i] + " ");
        }
    }
}
