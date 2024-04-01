import java.util.*;
class Node{
    int data;           //Basic structure
    Node next ;

    public Node(int data){
        this.data = data; 
        this.next = null;
    }
}
class Main{
    static int size = 0;
    static Node head ;    
    static Node tail ;

    public static Node Creation(){
    Scanner sc= new Scanner(System.in);

    head = null;        //head and tail are initially null values will insert in it
    tail = null ;

    System.out.println("enter the elements for ll and -1 to stop: ");
    while(true){
        int n = sc.nextInt();
    
    if(n==-1){          //insertion will take place untill -1 is enetred by the user
        break ;
    }
    Node temp = new Node(n);     //New node named temp because jo bhi nata date aayega that will new node for operation

    if(head == null){  //head null hua toh first value will be temp only
        head = temp ;          
        tail = temp ;
    }
    else{               //else head k baad wali value will be the temp
        tail.next = temp ;
        tail = temp ;
    }
    size++;          
}
    return head ; 

}

public static void insert(int data,int position) {
    Node temp = new Node(data);         //insertion of new data 
    if(head == null){
        head = temp ; 
        tail=temp ;
        size++;
        return ; 
    }
    else if(position == 0){          //first index 
        temp.next = head ; 
        head = temp ;
    }
    else if(position >= size){
        Node current = head ;                //>= size means tail k liye jayega and temp will be the tail 
        while(current.next!=null){
            current = current.next ; 
        }
        current.next=temp ;
        tail=temp;
    }
    else{
        Node tempn = head ;                  
        int i = 0; 
        while(i<position-1){          //to reach our specific index for insertion 
            tempn = tempn.next;
            i++;
        }
        Node nayaNode = tempn.next ;   //specific position pr pahuch jayega phir 
        tempn.next = temp ;//naya node ka neext will be the temp
        temp.next = nayaNode ;  //temp ka next hoajyega nayanode
    }
    size++;
    
}
public static void print(Node head) {
    System.out.println("linked list enetered is: ");
    Node current = head ; 
    while(current != null){
        System.out.println(current.data+" ");
        current = current.next ; 
    }
    System.out.println();
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    head  = Creation();
    print(head);

    int choice ; 
    while (true) {
        System.out.println("1.Insert at the begnning");
        System.out.println("2.Insert at end");
        System.out.println("3.Insert at specific location");
        System.out.println("4.print the ll");
        System.out.println("5.exit");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("enter value to insert at the beggning");
                int databegin = sc.nextInt();
                insertion(databegin,0);
                break;
            case 2:
                System.out.println("enter data to insert at end: ");
                int datae = sc.nextInt();
                insertion(datae,size);
                break;


            case 3:
                System.out.println("enter value to insert at location");
                int datal = sc.nextInt();
                System.out.println("enter position: ");
                int p = sc.nextInt();
                insertion(datal,p);
                break;
            case 4:
                
                print(head);
                break;
            case 5:
                System.out.println("exiting");
                break;

            default:
                System.out.println("invalid choice!");
                break;
        }
        if(choice ==5 ){
            break;
        }
    }
}
}