import java.util.Scanner;

public class reversestring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        StringBuilder s = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < s.length() / 2; i++) {
            int front = i;
            int back = s.length() - 1 - i;

            char frontCharacter = s.charAt(front);
            char backCharacter = s.charAt(back);

            s.setCharAt(front, backCharacter);
            s.setCharAt(back, frontCharacter);
        }

        System.out.println("Reversed string: " + s);
    }
}
