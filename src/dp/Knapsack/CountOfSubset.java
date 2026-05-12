package dp.Knapsack;

/*
Count number of subsets with sum equal to given sum.
*/

public class CountOfSubset {
    static int countSubsets(int[] arr, int n, int sum) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (arr[n - 1] > sum) return countSubsets(arr, n - 1, sum);
        return countSubsets(arr, n - 1, sum) + countSubsets(arr, n - 1, sum - arr[n - 1]);
    }

    static int countSubsetsMemo(int[] arr, int n, int sum, Integer[][] dp) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][sum] != null) return dp[n][sum];
        if (arr[n - 1] > sum)
            return dp[n][sum] = countSubsetsMemo(arr, n - 1, sum, dp);
        else
            return dp[n][sum] = countSubsetsMemo(arr, n - 1, sum, dp) + countSubsetsMemo(arr, n - 1, sum - arr[n - 1], dp);
    }

    static int countSubsetsDP(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int sum = 6;
        System.out.println(countSubsets(arr, arr.length, sum)); // Output: 3

        Integer[][] t = new Integer[arr.length + 1][sum + 1];
        System.out.println(countSubsetsMemo(arr, arr.length, sum, t));

        System.out.println(countSubsetsDP(arr, sum));
    }

}
