package com.sjia.Leetcode;

public class CanPlaceFlowers {
    // #605 https://leetcode.com/problems/can-place-flowers/

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



}
