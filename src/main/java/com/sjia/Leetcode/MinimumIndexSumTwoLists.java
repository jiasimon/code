package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumTwoLists {
    // #599 https://leetcode.com/problems/minimum-index-sum-of-two-lists/

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



}
