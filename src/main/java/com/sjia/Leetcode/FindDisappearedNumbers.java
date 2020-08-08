package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDisappearedNumbers {
    // #448 https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

    // Runtime: 18 ms, faster than 27.03% of Java online submissions for Find All Numbers Disappeared in an Array.
    //Memory Usage: 48.2 MB, less than 89.42% of Java online submissions for Find All Numbers Disappeared in an Array.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            map.put(nums[i], true);
        }

        List<Integer> result = new ArrayList<>();

        for (int i=1; i<= nums.length; i++) {
            if (!map.containsKey(i)) result.add(i);
        }
        return result;
    }

}
