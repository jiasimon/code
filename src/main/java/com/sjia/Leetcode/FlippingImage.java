package com.sjia.Leetcode;

public class FlippingImage {
    // #832. https://leetcode.com/problems/flipping-an-image/

    // Runtime: 1 ms, faster than 39.15% of Java online submissions for Flipping an Image.
    //Memory Usage: 42 MB, less than 16.27% of Java online submissions for Flipping an Image.
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i=0; i<A.length; i++) {
            int N = A[0].length;
            for (int j=0; j < (N +1 ) / 2 ; j++) {
                int tmp =A[i][j] ^1;
                A[i][j] = A[i][N-1-j] ^1;
                A[i][N-1-j] =tmp;
            }
        }
        return A;
    }


}
