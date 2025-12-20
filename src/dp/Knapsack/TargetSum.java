package dp.Knapsack;

import java.util.Arrays;

public class TargetSum {
    private static int[][] dp;

    public static int isSubsetSumDp(int[] arr, int sum, int n){
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
        int target = 1;
        // same as seubset diff
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        int sumS1 = (sum + target) / 2;
        dp = new int[n+1][sum+1];
        System.out.println("combinations to achieve target sum: " + isSubsetSumDp(arr, sumS1, n));
    }
}
