import java.util.Scanner;
import java.util.Stack;

class PalindromeChecker {
    private String str;

    public PalindromeChecker(String str) {
        this.str = str;
    }

    public boolean checkPalindrome() {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker(input);

        if (checker.checkPalindrome()) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}