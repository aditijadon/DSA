package dp.Knapsack;

import java.util.Arrays;

public class EqualSumPartition {
    private static boolean[][] dp;

    static boolean isEqualSumPartDp(int[] arr, int sum, int n) {
        if(sum % 2 != 0) return false;
        else {
            int equalSum = sum/2;
            dp = new boolean[n+1][equalSum+1];
            return isSubsetSumDp(arr, equalSum, n);
        }
    }

    public static boolean isSubsetSumDp(int[] arr, int sum, int n){ //subsetSum Implementation
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,5,5};
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        System.out.println("Is equal sum possible (DP): " + isEqualSumPartDp(arr, sum, n));

    }
}
