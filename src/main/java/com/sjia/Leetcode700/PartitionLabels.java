package com.sjia.Leetcode700;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    // #763. Partition Labels https://leetcode.com/problems/partition-labels/description/
    /*
    Input: s = "ababcbacadefegdehijhklij"     Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".

    Input: s = "eccbbbbdec"   Output: [10]

    1 <= s.length <= 500
    s consists of lowercase English letters.
     */

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];

        // Step 1: Record the last occurrence index for each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Initialize variables to track the end of the current partition
        int partitionEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            // Update the end of the current partition
            partitionEnd = Math.max(partitionEnd, lastIndex[s.charAt(i) - 'a']);

            // If we reach the end of the current partition, add its size to the result
            if (i == partitionEnd) {
                result.add(partitionEnd - (result.isEmpty() ? 0 : result.get(result.size() - 1)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        System.out.println(result); // Output: [9, 7, 8]   copilot code get wrong answer[8, 7, 16]
    }

}
