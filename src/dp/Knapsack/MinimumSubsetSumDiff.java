package dp.Knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDiff {
    private static boolean[] dp;

    static int getMinSubsetDiffDP(int[] arr, int maxSumDiff, int n){
        dp[0] = true;
        for(int i=0; i<n+1; i++){
            for (int j=maxSumDiff; j>=arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        int minDiff = maxSumDiff;
        for (int sum = 0; sum <= maxSumDiff / 2; sum++) {
            if (dp[sum]) {
                minDiff = Math.min(minDiff, Math.abs((maxSumDiff - sum) - sum));
            }
        }

        return minDiff;

    }

    public static void main(String[] args) {
        int[] arr = {1,6,11,5};
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        dp = new boolean[sum+1];
        System.out.println("Min Sum Diff (DP): " + getMinSubsetDiffDP(arr, sum, n));
    }
}
