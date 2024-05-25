package com.sjia.Leetcode600;

public class RobotReturnToOrigin {
    // #657. Robot Return to Origin     https://leetcode.com/problems/robot-return-to-origin/description/
    /*
    You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).

    Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.

    Input: moves = "UD"     Output: true
    Input: moves = "LL"     Output: false

    1 <= moves.length <= 2 * 10^4
    moves only contains the characters 'U', 'D', 'L' and 'R'.
     */


    // mod, switch
    public boolean judgeCircle(String moves) {
        if (moves.length() %2 ==1) return false;
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        // Test cases
        RobotReturnToOrigin solution = new RobotReturnToOrigin();

        String moves1 = "UD";
        System.out.println("Test case 1: " + solution.judgeCircle(moves1));  // Expected output: true

        String moves2 = "LL";
        System.out.println("Test case 2: " + solution.judgeCircle(moves2));  // Expected output: false

        String moves3 = "RRDD";
        System.out.println("Test case 3: " + solution.judgeCircle(moves3));  // Expected output: false

        String moves4 = "LDRRLRUULR";
        System.out.println("Test case 4: " + solution.judgeCircle(moves4));  // Expected output: false
    }


}
