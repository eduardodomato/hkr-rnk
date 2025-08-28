import java.util.Stack;

public class StackSample {

    public static boolean hasMatchingParentheses(String s) {
        if (s.length() == 0) {
            System.out.println();
            return false;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if ('('==c) {
                stack.push(c);
            } else if (')'==c) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(hasMatchingParentheses("((asdasd)asd)()("));

    }
}
