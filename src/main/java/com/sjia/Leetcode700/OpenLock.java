package com.sjia.Leetcode700;

import java.util.*;

public class OpenLock {
    // #752. Open the Lock      https://leetcode.com/problems/open-the-lock/description/
    /*
    Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"     Output: 6
    Input: deadends = ["8888"], target = "0009"     Output: 1
     */

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String next : getNextStates(current)) {
                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        if (next.equals(target)) return steps;
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNextStates(String state) {
        List<String> nextStates = new ArrayList<>();
        char[] chars = state.toCharArray();
        for (int i = 0; i < 4; i++) {
            char originalChar = chars[i];
            // Turn wheel forward
            chars[i] = originalChar == '9' ? '0' : (char) (originalChar + 1);
            nextStates.add(new String(chars));
            // Turn wheel backward
            chars[i] = originalChar == '0' ? '9' : (char) (originalChar - 1);
            nextStates.add(new String(chars));
            // Restore original character
            chars[i] = originalChar;
        }
        return nextStates;
    }

    public static void main(String[] args) {
        OpenLock solution = new OpenLock();
        String[] deadends1 = {"0201","0101","0102","1212","2002"};
        String target1 = "0202";
        System.out.println(solution.openLock(deadends1, target1)); // Output: 6

        String[] deadends2 = {"8888"};
        String target2 = "0009";
        System.out.println(solution.openLock(deadends2, target2)); // Output: 1

        String[] deadends3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";
        System.out.println(solution.openLock(deadends3, target3)); // Output: -1
    }


}
