package dp.Knapsack;

public class EqualSumPartition {
    static boolean isEqualSumRecursion(int[] arr, int n, int target) {
        if (target == 0) return true;
        if (n == 0) return false;
        if (arr[n - 1] > target) return isEqualSumRecursion(arr, n - 1, target);
        return isEqualSumRecursion(arr, n - 1, target) ||
                isEqualSumRecursion(arr, n - 1, target - arr[n - 1]);
    }

    static boolean canPartitionRecursion(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        return isEqualSumRecursion(arr, arr.length, target);
    }

//    -------------------------------------------------------------------------------

    static boolean isEqualSumMemo(int[] arr, int n, int target, Boolean[][] t) {
        if (target == 0) return true;
        if (n == 0) return false;
        if (t[n][target] != null) return t[n][target];
        boolean result;
        if (arr[n - 1] > target) {
            result = isEqualSumMemo(arr, n - 1, target, t);
        } else {
            result = isEqualSumMemo(arr, n - 1, target, t) ||
                    isEqualSumMemo(arr, n - 1, target - arr[n - 1], t);
        }
        t[n][target] = result;
        return result;
    }

    static boolean canPartitionMemo(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        Boolean[][] t = new Boolean[arr.length + 1][target + 1];
        return isEqualSumMemo(arr, arr.length, target, t);
    }

//    ---------------------------------------------------------------------

    static boolean isEqualSumDP(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};
        System.out.println(canPartitionRecursion(arr1));  // true
        System.out.println(canPartitionMemo(arr1));  // true
        System.out.println(isEqualSumDP(arr1));  // true

        int[] arr2 = {1, 2, 3, 5};
        System.out.println(canPartitionRecursion(arr2));  // false
        System.out.println(canPartitionMemo(arr2));  // false
        System.out.println(isEqualSumDP(arr2));  // false
    }
}
