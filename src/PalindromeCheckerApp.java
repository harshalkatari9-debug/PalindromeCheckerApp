import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    // Two Pointer Method
    public static boolean twoPointerPalindrome(String str) {

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

    // Stack Method
    public static boolean stackPalindrome(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque Method
    public static boolean dequePalindrome(String str) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    // MAIN METHOD (REQUIRED)
    public static void main(String[] args) {

        String text = "racecar";

        long start;
        long end;

        // Two Pointer
        start = System.nanoTime();
        boolean result1 = twoPointerPalindrome(text);
        end = System.nanoTime();
        long time1 = end - start;

        // Stack
        start = System.nanoTime();
        boolean result2 = stackPalindrome(text);
        end = System.nanoTime();
        long time2 = end - start;

        // Deque
        start = System.nanoTime();
        boolean result3 = dequePalindrome(text);
        end = System.nanoTime();
        long time3 = end - start;

        // Display Results
        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Execution Time: " + time1 + " ns");

        System.out.println("Stack Result: " + result2);
        System.out.println("Execution Time: " + time2 + " ns");

        System.out.println("Deque Result: " + result3);
        System.out.println("Execution Time: " + time3 + " ns");
    }
}