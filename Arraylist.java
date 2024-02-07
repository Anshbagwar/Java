import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Enter the size: ");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            int x = sc.nextInt();
            numbers.add(x);
        }

        System.out.println("Elements in the ArrayList: " + numbers);

        System.out.println("Enter the element to be searched: ");
        int search = sc.nextInt();

        for (int i = 0; i <size; i++) {
            if (numbers.get(i).equals(search)) {
                System.out.println("Element " + search + " found at index " + i);
                return;
            }
        }

        System.out.println("Element " + search + " not found in the ArrayList.");
    }
}
