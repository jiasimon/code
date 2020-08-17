package com.sjia.Leetcode;

public class RobotReturnOrigin {
    // #657 https://leetcode.com/problems/robot-return-to-origin/

    // Runtime: 7 ms, faster than 46.91% of Java online submissions for Robot Return to Origin.
    //Memory Usage: 39.3 MB, less than 87.86% of Java online submissions for Robot Return to Origin.
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
    }


}
