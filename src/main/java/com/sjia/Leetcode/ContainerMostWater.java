package com.sjia.Leetcode;

public class ContainerMostWater {

    // #11 https://leetcode.com/problems/container-with-most-water/

    //Given n non-negative integers a1, a2, ..., an ,  n>=2
    // where each represents a point at coordinate (i, ai).
    // n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    // Find two lines, which together with x-axis forms a container,
    // such that the container contains the most water.


    // Runtime: 3 ms, faster than 41.47% of Java online submissions for Container With Most Water.
    //Memory Usage: 40.5 MB, less than 13.80% of Java online submissions for Container With Most Water.
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int res =0;
        while ( l < r) {
            res = Math.max(res, Math.min(height[l], height[r])*(r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;

    }



/*
    static int maxArea(int[] container) {
        int result = 0, i = 0, j = container.length - 1;
        while (i < j) {
            result = Math.max(result, Math.min(container[i], container[j]) * (j - i));
            if (container[i] < container[j]) ++i;
            else --j;
        }
        return result;

    }*/



    public static void main(String[] args) {

        //int[] testData  = {2,5}
        //int[] testData  = {1,8,6,2,5,4,8,3,7};
        int[] testData  = {1,8,6,2,5,4,8,3,7,5};
        ContainerMostWater solution = new ContainerMostWater();
        int result = solution.maxArea(testData);

        System.out.printf(" max water is %d ", result);
    }

}
