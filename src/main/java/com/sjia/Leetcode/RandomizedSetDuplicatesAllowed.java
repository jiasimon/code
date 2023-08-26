package com.sjia.Leetcode;

import java.util.*;

public class RandomizedSetDuplicatesAllowed {
    // #381. Insert Delete GetRandom O(1) - Duplicates allowed
    // https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/

    /*
    RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also reporting a random element.

    You must implement the functions of the class such that each function works on average O(1) time complexity.

    Note: The test cases are generated such that getRandom will only be called if there is at least one item in the RandomizedCollection.

    -2^31 <= val <= 2^31 - 1
     */


    private List<Integer> nums;
    private Map<Integer, List<Integer>> numIndices;
    private Random rand;

    public RandomizedSetDuplicatesAllowed() {
        nums = new ArrayList<>();
        numIndices = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean containsVal = numIndices.containsKey(val);
        if (!containsVal) {
            numIndices.put(val, new ArrayList<>());
        }

        numIndices.get(val).add(nums.size());
        nums.add(val);
        return !containsVal;
    }

    public boolean remove(int val) {
        if (!numIndices.containsKey(val)) {
            return false;
        }

        int lastNum = nums.get(nums.size() - 1);
        if (lastNum == val) {
            numIndices.get(val).remove(numIndices.get(val).size() - 1);
        } else {
            int indexToRemove = numIndices.get(val).remove(numIndices.get(val).size() - 1);
            numIndices.get(lastNum).remove(numIndices.get(lastNum).size() - 1);
            numIndices.get(lastNum).add(indexToRemove);
            nums.set(indexToRemove, lastNum);
        }

        if (numIndices.get(val).isEmpty()) {
            numIndices.remove(val);
        }

        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(nums.size());
        return nums.get(randomIndex);
    }


    public static void main(String[] args) {
        RandomizedSetDuplicatesAllowed randomCollection = new RandomizedSetDuplicatesAllowed();

/*
        System.out.println(randomCollection.insert(1)); // true
        System.out.println(randomCollection.insert(1)); // false
        System.out.println(randomCollection.insert(2)); // true
        System.out.println(randomCollection.getRandom()); // 1 or 2
        System.out.println(randomCollection.remove(1)); // true
        System.out.println(randomCollection.getRandom()); // 1 or 2

*/


        System.out.println(randomCollection.insert(1)); // true
        System.out.println(randomCollection.insert(1)); // true
        System.out.println(randomCollection.insert(1)); // true
        System.out.println(randomCollection.insert(2)); // true
        System.out.println(randomCollection.insert(2)); // true

        System.out.println(randomCollection.getRandom()); // 1 or 2

        System.out.println(randomCollection.remove(1)); // true
        System.out.println(randomCollection.remove(1)); // true
        System.out.println(randomCollection.getRandom()); // 1 or 2

        System.out.println(randomCollection.remove(2)); // true
        System.out.println(randomCollection.remove(1)); // true
        System.out.println(randomCollection.remove(2)); // true
        System.out.println(randomCollection.getRandom()); // 1 or 2


    }


}
