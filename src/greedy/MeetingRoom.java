package greedy;

// TESCO

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRoom {
    static List<Integer> accomodateMaxMeetings(int[] start, int[] end){
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new int[]{end[i], start[i], i + 1});  // Store meetings as (end_time, start_time, index)
        }
        meetings.sort(Comparator.comparingInt(a -> a[0]));
        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;
        for (int[] m : meetings) {
            if (m[1] > lastEnd) {
                result.add(m[2]);
                lastEnd = m[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] start = {0,3,1,5,5,8};
        int[] end = {5,4,2,9,7,9};
        System.out.println(accomodateMaxMeetings(start, end));
    }
}
