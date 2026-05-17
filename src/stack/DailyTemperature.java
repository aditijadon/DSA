package stack;

/*
You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a
future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0
instead.
*/

import java.util.Stack;

public class DailyTemperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int temperatures[] = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(temperatures));
    }
}
