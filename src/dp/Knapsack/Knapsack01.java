package dp.Knapsack;

import java.util.Arrays;

/*
Given N items with values val[] and weights wt[], and knapsack capacity W. Find the maximum value you can achieve
without exceeding W (each item can be taken at most once).
*/

public class Knapsack01 {
    static int knapSackRecursion(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) return 0;
        if (wt[n-1] > W) return knapSackRecursion(W, wt, val, n-1);
        else return Math.max(
                val[n-1] + knapSackRecursion(W - wt[n-1], wt, val, n-1),
                knapSackRecursion(W, wt, val, n-1));
    }

    static int knapSackMemo(int W, int[] wt, int[] val, int n, int[][] t) {
        if (n == 0 || W == 0) return 0;
        if (t[n][W] != -1) return t[n][W];
        if (wt[n-1] > W) return t[n][W] = knapSackMemo(W, wt, val, n-1, t);
        else return t[n][W] = Math.max(
                val[n-1] + knapSackMemo(W - wt[n-1], wt, val, n-1, t),
                knapSackMemo(W, wt, val, n-1, t));
    }

    static int knapSackDP(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (wt[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = 3;
        System.out.println(knapSackRecursion(W, wt, val, val.length));

        int[][] t = new int[n+1][W+1];
        for (int[] row : t) Arrays.fill(row, -1);
        System.out.println(knapSackMemo(W, wt, val, n, t));

        System.out.println(knapSackDP(W, wt, val, val.length));
    }
}
