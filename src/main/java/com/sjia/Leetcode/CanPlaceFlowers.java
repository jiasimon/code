package com.sjia.Leetcode;

public class CanPlaceFlowers {
    // #605. Can Place Flowers https://leetcode.com/problems/can-place-flowers/

    // Runtime: 1 ms, faster than 97.03% of Java online submissions for Can Place Flowers.
    //Memory Usage: 40.7 MB, less than 89.30% of Java online submissions for Can Place Flowers.
/*    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 ) return (flowerbed[0]==0 && n==1) || n==0;
        int i=0, count=0;
        while (i< flowerbed.length) {
            if ( i==0 && flowerbed[i] ==0 && flowerbed[i+1]==0 ) {
                flowerbed[i++] = 1;
                count++;
            } else if ( i== (flowerbed.length -1) && flowerbed[i-1]==0 && flowerbed[i]==0 ) {
                flowerbed[i++] = 1;
                count++;
            } else if (  i>0 && (i < flowerbed.length -1) && flowerbed[i - 1] == 0  && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i++] = 1;
                count++;
            }
            if (count >= n) return true;
            i++;
        }
        return false;
    }*/


    // Runtime: 1 ms, faster than 97.03% of Java online submissions for Can Place Flowers.
    //Memory Usage: 40.9 MB, less than 74.87% of Java online submissions for Can Place Flowers.

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if(count>=n)
                return true;
            i++;
        }
        return false;
    }

    public boolean canPlaceFlowers_gpt(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                // Check if the current position is suitable for planting
                // Consider the edge cases
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1; // Plant at current position
                    count++; // Increment the count of planted flowers
                }
            }
        }

        return count >= n; // Check if enough flowers have been planted
    }

    public static void main(String[] args) {
        CanPlaceFlowers solution = new CanPlaceFlowers();

        // Test Case 1
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println("Test Case 1: " + solution.canPlaceFlowers(flowerbed1, n1)); // Output: true

        // Test Case 2
        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println("Test Case 2: " + solution.canPlaceFlowers(flowerbed2, n2)); // Output: false
    }


}
