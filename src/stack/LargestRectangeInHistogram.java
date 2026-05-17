package stack;

import java.util.Stack;

public class LargestRectangeInHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            // Use 0 height for the virtual bar at the end to flush out the stack
            int currentHeight = (i == n) ? 0 : heights[i];
            // Maintain monotonic increasing property
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // If stack is empty, it means this height was the shortest so far,
                // so it can span all the way to the beginning (width = i).
                // Otherwise, width is bounded by the current index and the new top of the stack.
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {7,1,7,2,2,4};
        System.out.println(largestRectangleArea(heights));
    }
}
