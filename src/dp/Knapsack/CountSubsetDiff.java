package dp.Knapsack;

import java.util.Arrays;

public class CountSubsetDiff {
    private static int[][] dp;

    static int getCountSubsetDiffDp(int[] arr, int sum, int n){
        // Sum(S1) - Sum(S2) = diff
        // Sum(S1) + Sum(S2) = Sum(arr)
        // Sum(S1) = (Sum(arr) + diff) / 2

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
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
        System.out.println("Count of Subsets With difference (DP): " + getCountSubsetDiffDp(arr, sumS1, n));
    }
}
