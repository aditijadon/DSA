package dp.Knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDiff {
    static int minDiffRecursion(int[] arr, int n, int s1, int sumTotal) {
        if (n == 0) return Math.abs(sumTotal - 2 * s1);
        return Math.min(minDiffRecursion(arr, n-1, s1 + arr[n-1], sumTotal), minDiffRecursion(arr, n-1, s1, sumTotal));
    }

    static int minDifference(int[] arr, int n) {
        int total = 0;
        for (int x : arr) total += x;
        return minDiffRecursion(arr, n, 0, total);
    }

//    -------------------------------------------

    static int minDiffMemo(int[] arr, int n, int s1, int sumTotal, int[][] t) {
        if (n == 0) return t[n][sumTotal] = Math.abs(sumTotal - 2 * s1);
        return t[n][sumTotal] = Math.min(minDiffMemo(arr, n-1, s1 + arr[n-1], sumTotal, t),
                minDiffMemo(arr, n-1, s1, sumTotal, t));
    }

    static int minDifferenceMemo(int[] arr, int n) {
        int total = 0;
        for (int x : arr) total += x;

        int[][] t = new int[n+1][total+1];
        for (int[] row : t) Arrays.fill(row, -1);
        
        return minDiffMemo(arr, n, 0, total, t);
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(minDifference(arr, arr.length));  // 1
    }
}
