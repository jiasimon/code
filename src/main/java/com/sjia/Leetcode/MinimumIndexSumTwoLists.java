package com.sjia.Leetcode;

import java.util.*;

public class MinimumIndexSumTwoLists {
    // #599. Minimum Index Sum of Two Lists https://leetcode.com/problems/minimum-index-sum-of-two-lists/

    // Runtime: 8 ms, faster than 72.08% of Java online submissions for Minimum Index Sum of Two Lists.
    //Memory Usage: 40 MB, less than 72.07% of Java online submissions for Minimum Index Sum of Two Lists.
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length < list2.length) {
            findRestaurant(list2, list1);
        }
        int minSum = 2000, sum;
        HashMap<String, Integer> tmp = new HashMap<>();
        for(int i=0; i< list1.length; i++) {
            tmp.put(list1[i],i);
        }
        List<String> result = new ArrayList<>();
        for ( int j=0; j< list2.length; j++) {
            if(tmp.containsKey(list2[j])) {
                sum = j + tmp.get(list2[j]);
                if (sum<minSum) {
                    result.clear();
                    result.add(list2[j]);
                    minSum = sum;
                } else if ( sum== minSum) {
                    result.add(list2[j]);
                }
            }
        }
        return result.toArray(new String[result.size()]);

    }



    public String[] findRestaurant_map(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Create a map to store the index of each restaurant in list1
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        // Iterate through list2 and check if the restaurant exists in list1
        // If it exists, calculate the index sum and update minSum and result accordingly
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = i + map.get(list2[i]);
                if (indexSum < minSum) {
                    minSum = indexSum;
                    result.clear();
                    result.add(list2[i]);
                } else if (indexSum == minSum) {
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        MinimumIndexSumTwoLists solution = new MinimumIndexSumTwoLists();

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        System.out.println("Test Case 1: " + Arrays.toString(solution.findRestaurant(list1, list2))); // Output: [Shogun, Burger King]
    }


}
