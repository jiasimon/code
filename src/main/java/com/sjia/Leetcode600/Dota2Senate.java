package com.sjia.Leetcode600;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    // #649. Dota2 Senate   https://leetcode.com/problems/dota2-senate/description/
    /*
    The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

    Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".

    Input: senate = "RD"    Output: "Radiant"
    The first senator comes from Radiant and he can just ban the next senator's right in round 1.
    And the second senator can't exercise any rights anymore since his right has been banned.
    And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.

    Input: senate = "RDD"   Output: "Dire"
    The first senator comes from Radiant and he can just ban the next senator's right in round 1.
    And the second senator can't exercise any rights anymore since his right has been banned.
    And the third senator comes from Dire and he can ban the first senator's right in round 1.
    And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
     */

    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll();
            int direIndex = dire.poll();

            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + senate.length());
            } else {
                dire.offer(direIndex + senate.length());
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }


    public static void main(String[] args) {
        Dota2Senate solution = new Dota2Senate();

        // Test Case
        String senate = "RD";
        System.out.println("Test Case 1: " + solution.predictPartyVictory(senate)); // Output: "Radiant"
    }

}
