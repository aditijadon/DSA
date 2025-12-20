package dp;

public class MinCostClimbingStairs {
    private static int[] dp;
    static int findMinCostClimbingStairs(int[] cost, int n){
        if(cost == null || n == 0) return 0;

        for(int i=0; i<n+1; i++){

        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {1,2,3};
        int n = cost.length;
        dp = new int[n+1];
        System.out.println(findMinCostClimbingStairs(cost, n));
    }
}
