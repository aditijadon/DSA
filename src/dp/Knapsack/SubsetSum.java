package dp.Knapsack;

/*
Given an array and target sum, check if there is a subset with sum equal to target.
*/

public class SubsetSum {
    static boolean isSubsetSumRecursion(int[] arr, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (arr[n-1] > sum) return isSubsetSumRecursion(arr, n-1, sum);
        return isSubsetSumRecursion(arr, n-1, sum) || isSubsetSumRecursion(arr, n-1, sum - arr[n-1]);
    }

    static boolean isSubsetSumMemo(int[] arr, int n, int sum, Boolean[][] t) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (t[n][sum] != null) return t[n][sum];
        if (arr[n-1] > sum) return t[n][sum] = isSubsetSumMemo(arr, n-1, sum, t);
        return t[n][sum] = isSubsetSumMemo(arr, n-1, sum, t) || isSubsetSumMemo(arr, n-1, sum - arr[n-1], t);
    }

    static boolean isSubsetSumDP(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
            }
        }
        return dp[n][sum];
    }

    static boolean isSubsetSumSpaceOptimised(int[] arr, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : arr) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int target = 9;
        int n = 6;
        System.out.println(isSubsetSumRecursion(arr, n, target));

        Boolean[][] t = new Boolean[n + 1][target + 1];
        System.out.println(isSubsetSumMemo(arr, n, target, t));

        System.out.println(isSubsetSumDP(arr, target, n));

        System.out.println(isSubsetSumSpaceOptimised(arr, target));
    }
}
