package stack;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];  // Car[i][0] = position
            cars[i][1] = (double)(target - position[i]) / speed[i]; // Car[i][1] = time to target
        }

        Arrays.sort(cars, Comparator.comparingDouble(a -> a[0]));

        // ------------- either ----------------

        int fleetCount = 0;
        double currentFleetTime = 0.0;
        for (int i = n - 1; i >= 0; i--) {  // Iterate from the closest car to the target
            // If this car takes MORE time than the current fleet leader in front of it,
            // it cannot catch up. It forms a new fleet.
            if (cars[i][1] > currentFleetTime) {
                fleetCount++;
                currentFleetTime = cars[i][1];
            }
            // If its time is less than or equal, it merges into the fleet ahead (do nothing)
        }
        return fleetCount;

        // --------------- or -------------------

//        Stack<Double> stack = new Stack<>();
//        for (double[] p : cars) {
//            stack.push((double) (target - p[0]) / p[1]);
//            if (stack.size() >= 2 &&
//                    stack.peek() <= stack.get(stack.size() - 2))
//            {
//                stack.pop();
//            }
//        }
//        return stack.size();
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }
}
