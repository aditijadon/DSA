package dp;

public class ClimbingStairs {
    private static int[] dp;
    static int climbStairs(int n) {
        if (n <= 2) return n;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        dp = new int[n+1];
        System.out.println(climbStairs(n));
    }
}
