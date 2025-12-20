package dp.Knapsack;

public class SubsetSum {
    private static boolean[][] dp;

    static boolean isSubsetSumRecursion(int[] arr, int sum, int n){
        if(sum==0) return true;
        if(n==0) return false;

        if(arr[n-1]<=sum){
            return isSubsetSumRecursion(arr, sum-arr[n-1], n-1) || isSubsetSumRecursion(arr, sum, n-1);
        }

        else{
            return isSubsetSumRecursion(arr, sum, n-1);
        }
    }

    public static boolean isSubsetSumDp(int[] arr, int sum, int n){
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
        int[] arr = {1,3,4,5};
        int sum = 1;
        int n = arr.length;
        dp = new boolean[n+1][sum+1];
        System.out.println("Is sum possible (Recursion): " + isSubsetSumRecursion(arr, sum, n));
        System.out.println("Is sum possible (DP): " + isSubsetSumDp(arr, sum, n));
    }
}
