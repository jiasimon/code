package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeople1282 {
    // #1282. Group the People Given the Group Size They Belong To  https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

    /*
    There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.

    You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.

    Return a list of groups such that each person i is in a group of size groupSizes[i].

    Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.

    Input: groupSizes = [3,3,3,3,3,1,3]     Output: [[5],[0,1,2],[3,4,6]]

    Input: groupSizes = [2,1,3,3,3,2]       Output: [[1],[0,5],[2,3,4]]


     */



    // 7 ms, 55.15%; 44.9 MB, 9.6%
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        // Iterate through the people and group them by their group size
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            // If the group doesn't exist in the map, create it
            groupMap.putIfAbsent(size, new ArrayList<>());

            // Add the person to the group
            groupMap.get(size).add(i);

            // If the group size equals the size, add it to the result and reset the group
            if (groupMap.get(size).size() == size) {
                result.add(groupMap.get(size));
                groupMap.put(size, new ArrayList<>());
            }
        }

        return result;
    }



    public List<List<Integer>> groupThePeople_getOrDefault(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        // Iterate through the people and group them by their group size
        for (int i = 0; i < groupSizes.length; i++) {
            int tmp = groupSizes[i];

            List<Integer> list = groupMap.getOrDefault(tmp, new ArrayList<>());
            list.add(i);
            groupMap.put(tmp, list);


            // If the group size equals the size, add it to the result and reset the group
            if (groupMap.get(tmp).size() == tmp) {
                result.add(groupMap.get(tmp));
                groupMap.put(tmp, new ArrayList<>());
            }
        }

        return result;
    }


    public static void main(String[] args) {
        GroupPeople1282 solution = new GroupPeople1282();
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> groups = solution.groupThePeople_getOrDefault(groupSizes);
        System.out.println("Grouped People: " + groups);
    }


}
