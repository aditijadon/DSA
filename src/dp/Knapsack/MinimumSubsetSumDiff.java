package dp.Knapsack;

import java.util.Arrays;

/*
Given a set of positive integers, partition it into two subsets such that the absolute difference between their sums is
minimized. Return that minimum difference.Given a set of positive integers, partition it into two subsets such that the absolute difference between their sums is minimized. Return that minimum difference.
*/

public class MinimumSubsetSumDiff {
    static int minDiffRecursion(int[] arr, int n, int s1, int total) {
        if (n == 0) return Math.abs(total - 2 * s1);  // s2 = total - s1 -> s2 - s1 -> total - 2 s1
        return Math.min(
                minDiffRecursion(arr, n-1, s1 + arr[n-1], total),
                minDiffRecursion(arr, n-1, s1, total)
        );
    }

    static int minDifferenceMemo(int[] arr, int n, int s1, int total, int[][] t) {
        if (n == 0) return Math.abs(total - 2 * s1);
        if (t[n][s1] != -1) return t[n][s1];
        return t[n][s1] = Math.min(minDifferenceMemo(arr, n-1, s1 + arr[n-1], total, t),
                minDifferenceMemo(arr, n-1, s1, total, t));
    }

    static int minDifferenceDP(int[] arr, int n){
        int total = 0;
        for (int x : arr) total += x;
        int target = total / 2;  // find all possible subset sums up to total/2, then find the sum closest to total/2.

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        int bestSum = 0;
        for (int s = target; s >= 0; s--) {
            if (dp[s]) {
                bestSum = s;
                break;
            }
        }
        return total - 2 * bestSum;
    }

//    --------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int n = 4;
        int total = 0;
        for (int x : arr) total += x;

        System.out.println(minDiffRecursion(arr, n, 0, total));  // 1

        int[][] t = new int[n+1][total + 1];
        for (int[] row : t) Arrays.fill(row, -1);
        System.out.println(minDifferenceMemo(arr, n, 0, total, t));

        System.out.println(minDifferenceDP(arr, n));
    }
}
