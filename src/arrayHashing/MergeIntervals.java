package arrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// TESCO

public class MergeIntervals {
    // First sort intervals by their starting point -> merge 2 -> again loog -> again merge O(n*n)

    private static List<List<Integer>> mergeBruteForce(int[][] intervals){    // O(N*logN) + O(N)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;

            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            ans.add(Arrays.asList(start, end));
            i = j;
        }
        return ans;
    }

    private static List<List<Integer>> merge(int[][] intervals){   // O(N*logN) + O(N)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if(ans.isEmpty() || ans.get(ans.size() - 1).get(1) < interval[0]){
                ans.add(Arrays.asList(interval[0], interval[1]));
            }
            else {
                int last = ans.size() - 1;
                int maxEnd = Math.max(
                        ans.get(last).get(1),
                        interval[1]
                );
                ans.get(last).set(1, maxEnd);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<List<Integer>> result = merge(intervals);
        for (List<Integer> interval : result) {
            System.out.print(interval + " ");
        }
    }
}
