package com.sjia.Leetcode;

public class ContainerMostWater {

    //Given n non-negative integers a1, a2, ..., an ,  n>=2
    // where each represents a point at coordinate (i, ai).
    // n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    // Find two lines, which together with x-axis forms a container,
    // such that the container contains the most water.

    static int maxArea(int[] container) {
        int result = 0, i = 0, j = container.length - 1;
        while (i < j) {
            result = Math.max(result, Math.min(container[i], container[j]) * (j - i));
            if (container[i] < container[j]) ++i;
            else --j;
        }
        return result;

    }



    public static void main(String[] args) {

        //int[] testData  = {2,5}
        //int[] testData  = {1,8,6,2,5,4,8,3,7};
        int[] testData  = {1,8,6,2,5,4,8,3,7,5};
        int result = maxArea(testData);

        System.out.printf(" max water is %d ", result);
    }

}
