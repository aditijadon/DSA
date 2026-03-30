package stack;

import java.util.Stack;

public class ValidParentheses {
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; // No opening bracket for closing
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty(); // All brackets must be matched
    }

    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(isValid(s));
    }
}
