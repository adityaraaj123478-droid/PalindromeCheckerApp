// File: UseCase13PalindromeCheckerApp.java
import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    // Algorithm 1: Reverse string and compare
    public static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Algorithm 2: Two-pointer technique
    public static boolean isPalindromeTwoPointer(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Algorithm 3: Recursive approach
    public static boolean isPalindromeRecursive(String str) {
        if (str.length() <= 1) return true;
        if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
        return isPalindromeRecursive(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Palindrome Checker Performance Comparison ===");
        System.out.print("Enter a string to check for palindrome: ");
        String input = scanner.nextLine();

        // Algorithm 1 Timing
        long startTime1 = System.nanoTime();
        boolean result1 = isPalindromeReverse(input);
        long endTime1 = System.nanoTime();

        // Algorithm 2 Timing
        long startTime2 = System.nanoTime();
        boolean result2 = isPalindromeTwoPointer(input);
        long endTime2 = System.nanoTime();

        // Algorithm 3 Timing
        long startTime3 = System.nanoTime();
        boolean result3 = isPalindromeRecursive(input);
        long endTime3 = System.nanoTime();

        // Display results
        System.out.println("\nPalindrome Check Results:");
        System.out.println("1. Reverse & Compare: " + result1 + " (Time: " + (endTime1 - startTime1) + " ns)");
        System.out.println("2. Two-Pointer:       " + result2 + " (Time: " + (endTime2 - startTime2) + " ns)");
        System.out.println("3. Recursive:         " + result3 + " (Time: " + (endTime3 - startTime3) + " ns)");
    }
}