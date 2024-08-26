import java.util.*;

class Node {
    Map<Character, Node> children;
    boolean endOfString;

    public Node() {
        children = new HashMap<>();
        endOfString = false;
    }
}

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
        System.out.println("Trie has been created");
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node temp = current.children.get(ch);
            if (temp == null) {
                temp = new Node();
                current.children.put(ch, temp);
            }
            current = temp;
        }
        current.endOfString = true;
    }

    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node temp = current.children.get(ch);
            if (temp == null) {
                System.out.println("Word does not exist in trie");
                return false;
            }
            current = temp;
        }
        if (current.endOfString) {
            System.out.println("Word exists");
        } else {
            System.out.println("Word does not exist as a complete word in trie");
        }
        return current.endOfString;
    }

    public boolean helperDelete(Node current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfString) {
                return false; // Word not found
            }
            current.endOfString = false; // Unmark the end of the word

            return current.children.isEmpty(); // If no children, this node should be deleted
        }

        char ch = word.charAt(index);
        Node node = current.children.get(ch);

        if (node == null) {
            return false; // Word not found
        }

        boolean shouldDeleteCurrentNode = helperDelete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty() && !current.endOfString;
        }

        return false;
    }

    public void delete(String word) {
        if (search(word)) {
            helperDelete(root, word, 0);
        }
    }public void printAllWords(Node current, String word) {
        if (current.endOfString) {
            System.out.println(word);
        }

        for (Map.Entry<Character, Node> entry : current.children.entrySet()) {
            printAllWords(entry.getValue(), word + entry.getKey());
        }
    }

    public void printTrie() {
        printAllWords(root, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie TRIE = new Trie();

        System.out.println("Enter number of words to insert:");
        int n = sc.nextInt();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter words to insert:");
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            TRIE.insert(word);
        }

        System.out.println("Enter a word to search:");
        String searchWord = sc.nextLine();
        TRIE.search(searchWord);

        System.out.println("Enter a word to delete:");
        String deleteWord = sc.nextLine();
        TRIE.delete(deleteWord);
        System.out.println("Deleted word: " + deleteWord);
        TRIE.printTrie();
    }
}
