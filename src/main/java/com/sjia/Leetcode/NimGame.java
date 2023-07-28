package com.sjia.Leetcode;

public class NimGame {
    // #292. Nim Game https://leetcode.com/problems/nim-game/   #forkid

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Nim Game.
    //Memory Usage: 36.4 MB, less than 9.65% of Java online submissions for Nim Game.
    public boolean canWinNim2(int n) {
        if (n%4 ==0 ) return false;
        else  return true;
    }


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Nim Game.
    //Memory Usage: 36.2 MB, less than 32.89% of Java online submissions for Nim Game.
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }


}
