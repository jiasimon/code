package com.sjia.Leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RobotReturnOrigin {
    // #657 https://leetcode.com/problems/robot-return-to-origin/

    // Runtime: 7 ms, faster than 46.91% of Java online submissions for Robot Return to Origin.
    //Memory Usage: 39.3 MB, less than 87.86% of Java online submissions for Robot Return to Origin.
 /*
    public boolean judgeCircle(String moves) {
        if (moves.length() %2 ==1) return false;
        int x=0, y=0;
        for (int i=0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') y++;
            else if (moves.charAt(i) == 'D') y--;
            else if (moves.charAt(i) == 'L') x--;
            else if (moves.charAt(i) == 'R') x++;
        }
        return x==0 && y==0;
    }*/


    public boolean judgeCircle(String moves) {
        if (moves.length() %2 ==1) return false;
        int x=0, y=0;
        char[] tmp = moves.toCharArray();
        for (int i=0; i < moves.length(); i++) {
            if (tmp[i] == 'U') y++;
            else if (tmp[i] == 'D') y--;
            else if (tmp[i] == 'L') x--;
            else if (tmp[i] == 'R') x++;
        }
        return x==0 && y==0;
    }


    // Use Stream failed
/*    public boolean judgeCircle(String moves) {
        Map<String, Long> charCount = IntStream.range(0, moves.length())
                .mapToObj(i -> moves.substring(i, i + 1))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return charCount.get("U")==charCount.get("D") &&
                charCount.get("L")==charCount.get("R");
    }*/


}
