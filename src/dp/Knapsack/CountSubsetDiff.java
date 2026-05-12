package dp.Knapsack;

import java.util.Arrays;

public class CountSubsetDiff {
    private static int[][] dp;

    // Sum(S1) - Sum(S2) = diff
    // Sum(S1) + Sum(S2) = Sum(arr)
    // Sum(S1) = (Sum(arr) + diff) / 2

    static int getCountRecursion(int[] arr, int target, int n) {
        if (target == 0) return 1;
        if (n == 0) return 0;
        if (arr[n - 1] <= target)
            return getCountRecursion(arr, target, n - 1) + getCountRecursion(arr, target - arr[n - 1], n - 1);
        else return getCountRecursion(arr, target, n - 1);
    }

    static int getCountSubsetDiffDp(int[] arr, int sum, int n){
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1]<=j) dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int n = arr.length;
        int diff = 1;
        int sum = Arrays.stream(arr).sum();
        int sumS1 = (sum + diff) / 2;
        dp = new int[n+1][sumS1+1];
        System.out.println("Count of Subsets With difference (Recursion): " + getCountRecursion(arr, sumS1, n));
        System.out.println("Count of Subsets With difference (DP): " + getCountSubsetDiffDp(arr, sumS1, n));
    }
}
