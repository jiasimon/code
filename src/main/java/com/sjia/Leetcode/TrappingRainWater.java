package com.sjia.Leetcode;

public class TrappingRainWater {
    // #42 https://leetcode.com/problems/trapping-rain-water/

    // n == height.length
    //0 <= n <= 3 * 104
    //0 <= height[i] <= 105

    // height = [4,2,0,3,2,5]   output = 9   0 +2 +4 +1+2  =9
    // [0,1,0,2,1,0,1,3,2,1,2,1] 1 + 1 +2 +1 +1 =6


    // Runtime: 1 ms, faster than 87.43% of Java online submissions for Trapping Rain Water.
    //Memory Usage: 38.3 MB, less than 6.63% of Java online submissions for Trapping Rain Water.
    public int trap(int[] height){
        int a = 0;
        int b = height.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (a <= b) {
            leftmax = Math.max(leftmax, height[a]);
            rightmax = Math.max(rightmax, height[b]);
            if (leftmax < rightmax) {
                max += (leftmax - height[a]);   // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            } else {
                max += (rightmax - height[b]);
                b--;
            }
        }
        return max;
    }


}
