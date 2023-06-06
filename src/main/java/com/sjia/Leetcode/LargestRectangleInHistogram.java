package com.sjia.Leetcode;

public class LargestRectangleInHistogram {
    //  #84. Largest Rectangle in Histogram  https://leetcode.com/problems/largest-rectangle-in-histogram/
    /*
    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
    return the area of the largest rectangle in the histogram.
     */

    // Input: heights = [2,1,5,6,2,3]   Output: 10
    // Input: heights = [2,4]  Output: 4
    // 1 <= heights.length <= 10^5  0 <= heights[i] <= 104


    // https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/1727776/java-c-explanation-going-from-brute-to-optimal-approach/

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0; // Base Condition
        int maxArea = 0;
        int left[] = new int[n]; // fill left boundary
        int right[] = new int[n]; // fill right boundary

        left[0] = -1;
        right[n - 1] = n;

        //
        for(int i = 1; i < n; i++){
            int prev = i - 1; // previous for comparing the heights
            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = left[prev]; // we have done this to minimise the jumps we make to the left
            }
            left[i] = prev;
        }
        // Similarly  do for right
        for(int i = n - 2; i >= 0; i--){
            int prev = i + 1;
            while(prev < n && heights[prev] >= heights[i]){
                prev = right[prev];
            }
            right[i] = prev;
        }
        // once we have these two arrays fill we need width & area
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangleArea(heights);
        System.out.println("Largest rectangle area: " + maxArea);
    }



}
