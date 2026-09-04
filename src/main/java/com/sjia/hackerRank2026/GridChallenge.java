package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridChallenge {
    // https://www.hackerrank.com/challenges/grid-challenge/problem

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int rowCount = grid.size();
        int colCount = grid.get(0).length();

        List<char[]> sortedGrid = new ArrayList<>();
        for (int i =0; i < rowCount ; i++) {
            char[] tmp = grid.get(i).toCharArray();
            Arrays.sort(tmp);
            sortedGrid.add(tmp);
        }

        for (int col=0; col < colCount; col++) {
            for (int row=0; row < rowCount-1; row++) {
                if (sortedGrid.get(row)[col] > sortedGrid.get(row+1)[col]){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        // Example 1: Should output "YES"
        List<String> grid1 = List.of("ebacd", "fghij", "olmkn", "trpqs", "xywuv");
        System.out.println("Grid 1 Result: " + gridChallenge(grid1));

        // Example 2: Should output "NO"
        List<String> grid2 = List.of("mpxz", "abcd", "wlbf");
        System.out.println("Grid 2 Result: " + gridChallenge(grid2));
    }

}
