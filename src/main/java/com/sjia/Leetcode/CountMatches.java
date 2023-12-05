package com.sjia.Leetcode;

public class CountMatches {
    // #1688. Count of Matches in Tournament    https://leetcode.com/problems/count-of-matches-in-tournament/description/?envType=daily-question&envId=2023-12-05

    /*
    You are given an integer n, the number of teams in a tournament that has strange rules:

    If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
    If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
    Return the number of matches played in the tournament until a winner is decided.

    Input: n = 7        Output: 6
    Input: n = 14       Output: 13

    1 <= n <= 200
     */


    // simulation
    public int numberOfMatches(int n) {
        int matches = 0;

        while (n > 1) {
            if (n % 2 == 0) {
                matches += n / 2;
                n /= 2;
            } else {
                matches += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }

        return matches;
    }


    public static void main(String[] args) {
        CountMatches solution = new CountMatches();

        int n = 7;

        int totalMatches = solution.numberOfMatches(n);
        System.out.println("Total matches played in the tournament: " + totalMatches);
    }
}
