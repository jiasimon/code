package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonAncestor {

    /*

Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.

         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11

parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
]

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 3, 1) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true

Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

        11
       /  \
      10   12
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (1, 3), (11, 10), (11, 12), (2, 3), (10, 2),
    (10, 5), (3, 4), (5, 6), (5, 7), (7, 8),
]

hasCommonAncestor(parentChildPairs2, 4, 12) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false
hasCommonAncestor(parentChildPairs2, 1, 12) => false


*/



    public boolean hasCommonAncestor( int[][] input, int c1, int c2) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for ( int[] row : input ) {
            if (! map.containsKey (row[1])) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(row[0]);
                map.put(row[1],tmp);
            } else {
                map.get(row[1]).add(row[0]);
            }
        }
        System.out.println(map);
        int current = c1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        getAncestor(map, current, list);

        System.out.println(map);

        return true;


    }


    public ArrayList<Integer> getAncestor(HashMap<Integer, ArrayList<Integer>> map , int c, ArrayList<Integer> list) {
        if (map.containsKey(c)) {
            for ( Integer k : map.get(c)) {
                list.add(k);
                getAncestor(map, k, list);
            }
        }
        System.out.println(list);
        return list;

    }


    public static void main(String[] argv) {
        int[][] parentChildPairs1 = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
        };

        int[][] parentChildPairs2 = new int[][] {
                {1, 3}, {11, 10}, {11, 12}, {2, 3}, {10, 2},
                {10, 5}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
        };

        CommonAncestor solution = new CommonAncestor();
        solution.hasCommonAncestor(parentChildPairs2, 4, 12);

    }

}
