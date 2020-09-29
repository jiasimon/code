package com.sjia.Leetcode;

import java.util.Arrays;

public class ReorderLogFiles {
    // #937 https://leetcode.com/problems/reorder-data-in-log-files/
    // Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    // Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]



    // Runtime: 5 ms, faster than 74.48% of Java online submissions for Reorder Data in Log Files.
    //Memory Usage: 39.6 MB, less than 87.82% of Java online submissions for Reorder Data in Log Files.
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] tmpA = a.split(" ", 2);
            String[] tmpB = b.split(" ", 2);

            boolean isDigitA = Character.isDigit(tmpA[1].charAt(0));
            boolean isDigitB = Character.isDigit(tmpB[1].charAt(0));

            if (isDigitA && isDigitB) {
                return 0;
            } else if (!isDigitA && !isDigitB) {
                int comp = tmpA[1].compareTo(tmpB[1]);
                if (comp != 0) return comp;
                else return tmpA[0].compareTo(tmpB[0]);
            } else if (isDigitA && !isDigitB ) {
                return 1;
            } else  return -1;

        });
        return logs;
    }


}
