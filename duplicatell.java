import java.util.*;
public class duplicatell {
    static class Node {
        public Node prev;
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head = null ;
    static Node tail =null;
    static int size = 0 ;
    public static Node create(int data){
        Node temp = new Node(data);
        head= temp ;
        tail = temp ;
        size = 1;
        return head;
    }
    public static void insert(int data , int location){
        Node temp = new Node(data);
        if(head == null){
            head = tail = temp ;
        }
        else if(location == 0) {
            temp.next =head ;
            head = temp  ;
        } else if (location >= size) {
            tail.next = temp ;
            tail = temp ;

        }
        else {
            int i =0;
            Node current = head ;
            while(i < location-1){
                current = current.next;
                i++;
            }
            Node newnode = current.next ;
            current.next = temp;
            temp.next= newnode;
        }
        size++;
    }
    public static void duplicates(){
        HashSet<Integer> ll = new HashSet<>();
        Node current = head;
        Node prev = null;
        while(current != null){
            int duplicate = current.data;
            if(ll.contains(duplicate)){
                prev.next=current.next;
                size--;
            }
            else {
                ll.add(duplicate);
                prev =current;
            }
            current=current.next;
        }
    }
    public static void delete(int location){
        if(head == null){
            System.out.println("empty");
        }
        else if(location==0){
            head = head.next;
            size -- ;
        }
        else if (location >= size-1) {
            if (head == tail) {
                head = tail = null;
            } else {
                Node current = head;
                for (int i = 0; i < size - 2; i++) {
                    current = current.next;
                }
                current.next = null;
                current = tail;
            }
            size--;
        }
        else{
            Node current =head ;
            int  i = 0;
            while(i < location-1){
                current=current.next;
            }
            current.next = current.next.next;
            size-- ;
            if (current.next == null) {
                tail = current;
            }
        }
    }
    public static void print(Node head) {
        System.out.println("The elements of the linked list are: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner scanner =new Scanner(System.in);
        System.out.println("enetr the element for ll and -1 to stop:  ");
        while(true){
            int n =scanner.nextInt();
            if(n ==-1){
                break;
            }
            else{
                insert(n,size);
            }
        }
        print(head);
        System.out.println("list after removing duplicates: " );
        duplicates();
        print(head);
    }

}




















