package com.sjia.Leetcode;

import java.util.Arrays;

public class Heaters475 {
    // #475. Heaters    https://leetcode.com/problems/heaters/description/

    /*
    Every house can be warmed, as long as the house is within the heater's warm radius range.

    Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.

    Notice that all the heaters follow your radius standard, and the warm radius will the same.

    Input: houses = [1,2,3], heaters = [2]  Output: 1
    Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

    Input: houses = [1,2,3,4], heaters = [1,4]      Output: 1
    Input: houses = [1,2,3,4], heaters = [1,4]
    Output: 1
    Explanation: The two heaters were placed at positions 1 and 4. We need to use a radius 1 standard, then all the houses can be

    Input: houses = [1,5], heaters = [2]    Output: 3

    1 <= houses.length, heaters.length <= 3 * 10^4
    1 <= houses[i], heaters[i] <= 10^9
     */

    // sort heaters
    // 14 ms, 76.71%; 46.4 MB, 52.87%
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int maxRadius = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
                int distToPrev = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int distToNext = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                maxRadius = Math.max(maxRadius, Math.min(distToPrev, distToNext));
            }
        }

        return maxRadius;
    }


    public static void main(String[] args) {
        Heaters475 solution = new Heaters475();
        int[] houses = {1, 2, 3};
        int[] heaters = {2};

        int minRadius = solution.findRadius(houses, heaters);
        System.out.println("Minimum Radius: " + minRadius); // Output: 1
    }
}
