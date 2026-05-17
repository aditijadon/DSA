package stack;

import java.util.Stack;

class MinStack {

    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currentMin = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, currentMin});
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peek()[0];
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peek()[1];
    }
}
