package dp.UnboundedKnapsack;

public class RodCuttingProblem {
    private static int[][] dp;

    static boolean rodCutting(int[] length, int[] price, int W, int n){
        return true;
    }

    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,70};
        int W = 7;
        int n = 4;
        dp = new int[n+1][W+1];
        System.out.println("Max Profit using DP is: " + rodCutting(length, price, W, n));
    }
}
