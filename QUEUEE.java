import java.util.*;
public class QUEUEE {
    int arr[] ;
    int top ;
    int begnning ;
    public QUEUEE(int size){
        this.arr = new int[size] ;
        this.top = -1 ;
        this.begnning =-1 ;
        System.out.println("queue created with size " + size);
    }
    public boolean isfull(){
        if(top == arr.length-1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean empty(){
        if(begnning == -1 || begnning == arr.length) {
            return true;
        }
        else {
            return false;
        }
    }
     public void enqueue(int data){
        if(isfull()){
            System.out.println("full");
        }
        else if(empty()){
            begnning = 0 ;
            top++ ;
            arr[top] = data ;

        }
        else{
            top++ ;
            arr[top] = data ;

        }
     }
     public int dequeue(){
        if (empty()){
            System.out.println("empty");
            return -1;
        }
        else {
            int result = arr[begnning] ;
            begnning ++ ;
            if(begnning > top){
                begnning = top = -1 ;
            }
            return result ;
        }
     }
     public void delete(){
        arr = null ;
        System.out.println("successfully delleted");
     }
     public  int peek(){
        if(!empty()){
            return arr[begnning] ;
        }
        else {
            System.out.println("empty");
            return -1;
        }
     }
    public void display() {
        if (empty()) {
            System.out.println("empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = begnning; i <= top; i++) {  // Change made: loop only through elements currently in the queue
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array: ");
        int size = sc.nextInt();
        QUEUEE queue = new QUEUEE(size);
        System.out.println("Enter " + size + " elements to push into the qeueu:");
        for (int i = 0; i < size; i++) {
            int n = sc.nextInt();
            queue.enqueue(n);
        }
        System.out.println("inserted the value in the queue");
        queue.display();
        while (true){
            System.out.println("Choose an operation: 1. enqueue 2. dequeue 3. peek 4. display 5. delte");

            int operation = sc.nextInt() ;
            switch (operation) {
                case 1: // enqueue
                    System.out.println("Enter the element to enqueue: ");
                    int element = sc.nextInt();
                    queue.enqueue(element);
                    break;
                case 2: // dequeue
                    int dequeuedElement = queue.dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued element: " + dequeuedElement);
                    }
                    break;
                case 3: // peek
                    int topElement = queue.peek();
                    if (topElement != -1) {
                        System.out.println("Front element: " + topElement);
                    }
                    break;
                case 4: // display
                    queue.display();
                    break;
                case 5: // delete
                    queue.delete();
                    break;
                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
    }
}