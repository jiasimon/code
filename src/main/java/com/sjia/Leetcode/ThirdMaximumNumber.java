package com.sjia.Leetcode;

import java.util.*;

public class ThirdMaximumNumber {

    // #414. Third Maximum Number   https://leetcode.com/problems/third-maximum-number/

    /*
    Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
    Input: nums = [3,2,1]       Output: 1
    Input: nums = [1,2]         Output: 2
    Input: nums = [2,2,3,1]     Output: 1

    1 <= nums.length <= 10^4
    -2^31 <= nums[i] <= 2^31 - 1
     */





    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Third Maximum Number.
    //Memory Usage: 39.5 MB, less than 18.33% of Java online submissions for Third Maximum Number.

    // add flag for [1,2,-2147483648]
/*
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE, second =Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        boolean flag = true;
        for (int n : nums) {
            if ( n > first) {
                third = second;
                second =first;
                first = n;
            } else if ( n < first && n > second) {
                third = second;
                second = n;
            } else if ( n < second && n > third) {
                third = n;
            } else if ( n== Integer.MIN_VALUE) flag = false;
        }
        if ((third == Integer.MIN_VALUE && flag ) || third == second) return first;
        else return third;
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Third Maximum Number.
    //Memory Usage: 39.6 MB, less than 12.08% of Java online submissions for Third Maximum Number.
/*
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int n : nums) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n < first && n > second) {
                third = second;
                second = n;
            } else if (n < second && n > third) {
                third = n;
            }
        }
        if (third == Long.MIN_VALUE || third == second) return (int) first;
        else return (int) third;
    }*/


    // For  N th largest number
    // Runtime: 3 ms, faster than 59.96% of Java online submissions for Third Maximum Number.
    //Memory Usage: 39.7 MB, less than 10.83% of Java online submissions for Third Maximum Number.

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums) {
            if(pq.size() < 3 && !pq.contains(n)) {
                pq.add(n);
            } else if(!pq.contains(n) && n > pq.peek()) {
                pq.poll();
                pq.add(n);
            }
        }

        if(pq.size() < 3)
            while(pq.size() > 1)
                pq.poll();

        return pq.poll();
    }


    // Set to List , sort
    // 6 ms, 26.91%; 43.3 MB, 62.74%
    public int thirdMax_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for ( int n : nums) {
            set.add(n);
        }


        List<Integer> tmp = new ArrayList<Integer>(set);
        Collections.sort(tmp);
        if (tmp.size() < 3) {
            return tmp.get(tmp.size() - 1);
        } else {
            return tmp.get(tmp.size() - 3);
        }


    }


    // minHeap
    // 4 ms, 59.56%; 43.5 MB, 41.88%
    public int thirdMax_minHeap(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : nums) {
            if(minHeap.size() < 3 && !minHeap.contains(n)) {
                minHeap.add(n);
            } else if(!minHeap.contains(n) && n > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(n);
            }
        }

        if(minHeap.size() < 3)
            while(minHeap.size() > 1)
                minHeap.poll();

        return minHeap.poll();
    }



    public static void main(String[] args) {
        ThirdMaximumNumber solution = new ThirdMaximumNumber();
        int[] nums = {1,2,-2147483648};
        int thirdMax = solution.thirdMax(nums);
        System.out.println("Third maximum number: " + thirdMax);

        int[] nums2 = {1,1,-214783648};
        thirdMax = solution.thirdMax(nums2);
        System.out.println("Third maximum number: " + thirdMax);


        int[] nums3 = {1,-214783648,-214783648};
        thirdMax = solution.thirdMax(nums2);
        System.out.println("Third maximum number: " + thirdMax);


    }

}
