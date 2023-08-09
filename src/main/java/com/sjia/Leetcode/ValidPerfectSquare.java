package com.sjia.Leetcode;

public class ValidPerfectSquare {
    // #367. Valid Perfect Square https://leetcode.com/problems/valid-perfect-square/
    // #forkid

    /*
    Given a positive integer num, return true if num is a perfect square or false otherwise.

    A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

    You must not use any built-in library function, such as sqrt.
     */



/*
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int i=1;
        while (num > 0) {
            num -= i;
            i +=2;
        }
        return num==0;
    }*/

    // refer #69 Newton
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
    //Memory Usage: 38.6 MB, less than 5.15% of Java online submissions for Valid Perfect Square.
    public boolean isPerfectSquare(int num) {
        long root = num;
        while (root * root > num) {
            root = (root + num / root)/2;
        }
        return root * root == num;
    }



    // binary search
    public boolean isPerfectSquare_binary(int num) {
        if (num < 2) {
            return true; // 0 and 1 are valid perfect squares
        }

        long left = 2;
        long right = num / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare solution = new ValidPerfectSquare();
        int num = 16;
        boolean isValidSquare = solution.isPerfectSquare_binary(num);
        System.out.println("Is a valid perfect square: " + isValidSquare); // Output: true
    }


}
