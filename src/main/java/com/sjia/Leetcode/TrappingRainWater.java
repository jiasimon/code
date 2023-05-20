package com.sjia.Leetcode;

public class TrappingRainWater {
    // #42. Trapping Rain Water https://leetcode.com/problems/trapping-rain-water/

    // n == height.length
    //0 <= n <= 3 * 10^4
    //0 <= height[i] <= 10^5

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


    // 执行用时：1 ms, 在所有 Java 提交中击败了99.99% 的用户
    // 内存消耗：38.3 MB, 在所有 Java 提交中击败了78.87% 的用户
    public int trap2(int[] height) {
        int a = 0 , b=height.length-1;
        int res = 0;
        int lMax =0, rMax=0;
        while (a < b) {
            lMax = Math.max(lMax, height[a]);
            rMax = Math.max(rMax, height[b]);
            if (lMax <= rMax) {
                res += lMax - height[a];
                a++;
            } else {
                res += rMax - height[b];
                b--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = solution.trap(height);
        System.out.println(result);
    }


}
