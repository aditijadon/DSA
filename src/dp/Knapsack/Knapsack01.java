package dp.Knapsack;

public class Knapsack01 {
    private static int[][] t;
    private static int[][] dp;

    public static int maxProfitRecursion(int[] wt, int[] val, int W, int n){
        if(n == 0 || W == 0) return 0;
        if(wt[n-1]<=W){
            return Math.max(val[n-1] + maxProfitRecursion(wt, val, W-wt[n-1], n-1), maxProfitRecursion(wt, val, W, n-1));
        }
        else {
            return maxProfitRecursion(wt, val, W, n-1);
        }
    }

    public static int maxProfitMemo(int[] wt, int[] val, int W, int n){
        if(n == 0 || W == 0) return 0;
        if(t[n][W] != -1) return t[n][W];

        if(wt[n-1]<=W){
            return t[n][W] = Math.max(val[n-1] + maxProfitMemo(wt, val, W-wt[n-1], n-1), maxProfitMemo(wt, val, W, n-1));
        }
        else {
            return t[n][W] = maxProfitMemo(wt, val, W, n-1);
        }
    }

    public static int maxProfitDP(int[] wt, int[] val, int W, int n){
        //initialisation replacing the base condition
        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int W = 7;
        int n = 4;
        t = new int[n+1][W+1];
        dp = new int[n+1][W+1];

        System.out.println("Max Profit using DP is: " + maxProfitDP(wt, val, W, n));
    }
}
