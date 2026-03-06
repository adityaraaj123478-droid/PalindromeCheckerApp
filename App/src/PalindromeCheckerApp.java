import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    void add(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;
        Node copySecondHalf = secondHalf;

        boolean result = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        slow.next = reverse(copySecondHalf);
        return result;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        if (list.isPalindrome()) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}