package com.sjia.Leetcode;

public class WaterJugProblem {
    // #365. Water and Jug Problem  https://leetcode.com/problems/water-and-jug-problem/description/
    // #forkid  #math

    /*
    Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

    If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.

    Operations allowed:

    Fill any of the jugs with water.
    Empty any of the jugs.
    Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
     */

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false; // Impossible to reach the target
        }

        if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity ||
                jug1Capacity + jug2Capacity == targetCapacity) {
            return true; // One of the jugs or their sum matches the target
        }

        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        WaterJugProblem solution = new WaterJugProblem();
        int jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4;
        boolean canMeasure = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        System.out.println("Can measure the target capacity: " + canMeasure); // Output: true
    }


}
