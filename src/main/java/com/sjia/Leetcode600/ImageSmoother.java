package com.sjia.Leetcode600;

import java.util.Arrays;

public class ImageSmoother {
    // #661. Image Smoother     https://leetcode.com/problems/image-smoother/description/
    /*


    Input: img = [[100,200,100],[200,50,200],[100,200,100]]
    Output: [[137,141,137],[141,138,141],[137,141,137]]

    For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
    For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141


     */


    // int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int k = 0; k < 9; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        sum += img[x][y];
                        count++;
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        // Test case 1
        int[][] img1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        ImageSmoother solution = new ImageSmoother();
        int[][] result1 = solution.imageSmoother(img1);
        System.out.println("Test case 1: " + Arrays.deepToString(result1));
        // Expected output: [[0, 0, 0], [0, 0, 0], [0, 0, 0]]

        // Test case 2
        int[][] img2 = {
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}
        };
        int[][] result2 = solution.imageSmoother(img2);
        System.out.println("Test case 2: " + Arrays.deepToString(result2));
        // Expected output: [[137, 141, 137], [141, 138, 141], [137, 141, 137]]

        // Test case 3
        int[][] img3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] result3 = solution.imageSmoother(img3);
        System.out.println("Test case 3: " + Arrays.deepToString(result3));
        // Expected output: [[3, 3, 4], [4, 5, 5], [6, 6, 7]]
    }



}
