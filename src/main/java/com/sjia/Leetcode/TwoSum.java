package com.sjia.Leetcode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    // #1 TwoSum https://leetcode.com/problems/two-sum/

/*    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            m.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            if (m.containsKey(t) && m.get(t) != i) {
                res[0] = i;
                res[1] = m.get(t);
                break;
            }
        }
        return res;
    }*/


    // Runtime: 6 ms, faster than 43.76% of Java online submissions for Two Sum.
    //Memory Usage: 41.7 MB, less than 5.44% of Java online submissions for Two Sum.

    public List<String> checkDuplicateName( String[ ] input) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        List <String> res = new ArrayList<>();
        for (String name :  input) {
            count.put(name, count.getOrDefault(name,0) +1);
        }
        for ( String name : count.keySet() ) {
            if (count.get(name) > 1 ) {
                String tmp = name + " : " + count.get(name);
                res.add(tmp);
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            if ( tmp.containsKey(target- nums[i]) ) {
                result[1] = i;
                result[0] = tmp.get(target- nums[i]);
                return result;
            } else {
                tmp.put(nums[i], i);
            }
        }
        return result;
    }

/*
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i< nums.length; i++)
            for (int j=i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] =i;
                    result[1] =j;
                    return result;
                }
            }
        return result;
    }*/


    public static void main(String[] args) {
        int[] testData = { 2, 7, 11, 15, 20, 25, 30 };
        int target = 41;
        TwoSum mySolution = new TwoSum();
        int[] result = mySolution.twoSum(testData, target);
        System.out.println("The result is: " + result[0] + " and " + result[1]);


/*

        try (PrintWriter writer = new PrintWriter("mytest.csv")) {
            StringBuilder sb = new StringBuilder();
            sb.append("FirstColumn");
            sb.append(',');
            sb.append("Name");
            sb.append('\n');
            sb.append("1");
            sb.append(',');
            sb.append("Sophie Simon");
            sb.append('\n');
            writer.write(sb.toString());
            System.out.println("done!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


*/






}

}
