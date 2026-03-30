package greedy;

import java.util.Arrays;

public class AssignCookies {
    static int calculateMaxKidsToGetCookies(int[] greedFactor, int[] value, int n){
        Arrays.sort(greedFactor);
        Arrays.sort(value);
        int i = 0, j =0;

        while(i<5 && j<5){
            if(value[i] >= greedFactor[j]){
                j++;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] kidGreedFactor = {};
        int[] cookiesValue = {};
        System.out.println(calculateMaxKidsToGetCookies(kidGreedFactor, cookiesValue, n));
    }
}
