package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    public static boolean hasCommonAncestor(int[][] input, int c1, int c2) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] row : input) {
            if (!map.containsKey(row[1])) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(row[0]);
                map.put(row[1], tmp);
            } else {
                map.get(row[1]).add(row[0]);
            }
        }
        // System.out.println(map);

        ArrayList<Integer> list1 = new ArrayList<Integer>();

        // getAncestor(map, c1, map.get(c1));  // it cause "java.util.ConcurrentModificationException"

        getAncestor(map, c1, list1);
//        System.out.println("list1 is : " + list1);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        getAncestor(map, c2, list2);

//        System.out.println("list2 is : " + list2);

        // return list1.stream().anyMatch(list2::contains);

       list1.retainAll(list2);
       return list1.size()>0;



    }


    private static void getAncestor(HashMap<Integer, ArrayList<Integer>> map, int c, ArrayList<Integer> list) {
        if (!map.containsKey(c)) {
            // System.out.println(list);
            return;
        }

        for (Integer k : map.get(c)) {
            list.add(k);
            getAncestor(map, k, list);
        }

    }


    public static void main(String[] argv) {
        int[][] parentChildPairs1 = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
        };

        int[][] parentChildPairs2 = new int[][]{
                {1, 3}, {11, 10}, {11, 12}, {2, 3}, {10, 2},
                {10, 5}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
        };

        // Solution solution = new Solution();
        hasCommonAncestor(parentChildPairs2, 4, 12);
        System.out.println("4, 12 CommonAncestor is: " + hasCommonAncestor(parentChildPairs2, 4, 12));

        System.out.println("1, 6 CommonAncestor is: " + hasCommonAncestor(parentChildPairs2, 1, 6));

        System.out.println("1, 12 CommonAncestor is: " + hasCommonAncestor(parentChildPairs2, 1, 12));

        // parentChildPairs1
        System.out.println("3, 8 CommonAncestor is: " + hasCommonAncestor(parentChildPairs1, 3, 8));

        System.out.println("5, 8 CommonAncestor is: " +
                hasCommonAncestor(parentChildPairs1, 5, 8));

        System.out.println("6, 8 CommonAncestor is: " +
                hasCommonAncestor(parentChildPairs1, 6, 8));

        System.out.println("4, 14 CommonAncestor is: " +
                hasCommonAncestor(parentChildPairs1, 4, 14));

    }

}
