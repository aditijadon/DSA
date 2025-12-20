package array;

public class StockBuySell {
    static int maxProfitBruteForce(int[] prices) {   // O (n*n)
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    static int maxProfit(int[] prices) {
        int n = prices.length;
        int minSoFar = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            if (minSoFar > prices[i]) minSoFar = prices[i];
            else maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfitBruteForce(prices));
        System.out.println(maxProfit(prices));
    }
}
