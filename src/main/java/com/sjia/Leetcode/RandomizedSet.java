package com.sjia.Leetcode;

import java.util.*;

public class RandomizedSet {
    // 380. Insert Delete GetRandom O(1)    https://leetcode.com/problems/insert-delete-getrandom-o1/description/

    /*
    Implement the RandomizedSet class:

    RandomizedSet() Initializes the RandomizedSet object.
    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
    You must implement the functions of the class such that each function works in average O(1) time complexity.

     */

    Map<Integer, Integer> map;
    ArrayList<Integer> nums;

    Random random ;


    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if (res) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;

    }

    // {1,2, 4, 7}
    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        if ( !res) {
            return false;
        }
        int index = map.get(val);
        if ( index < nums.size() -1 ) {
            int last = nums.get(nums.size() -1 );
            nums.set(index, last);
            map.put(last, index);
        }
        map.remove(val);
        nums.remove(nums.size() -1);
        return true;


    }

    public int getRandom() {
        return nums.get( random.nextInt(nums.size()) );

    }


    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();

        System.out.println(randomSet.insert(1)); // true
        System.out.println(randomSet.remove(2)); // false
        System.out.println(randomSet.insert(2)); // true
        System.out.println(randomSet.getRandom()); // 1 or 2
        System.out.println(randomSet.remove(1)); // true
        System.out.println(randomSet.insert(2)); // false
        System.out.println(randomSet.getRandom()); // 2
    }



}
