package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FairCandySwap {
    // #888 https://leetcode.com/problems/fair-candy-swap/

    // Runtime: 8 ms, faster than 98.25% of Java online submissions for Fair Candy Swap.
    //Memory Usage: 41.8 MB, less than 32.79% of Java online submissions for Fair Candy Swap.
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> setB = new HashSet<>();
        for (int i : A) sumA += i;
        for (int i : B) {
            setB.add(i);
            sumB += i;
        }
        int diff = (sumB - sumA) / 2;
        for (int i : A) {
            if (setB.contains(i + diff)) {
                return new int[]{i, i + diff};
            }
        }
        return new int[] {-1, -1};
    }


    // Stream sum
    // Runtime: 13 ms, faster than 55.60% of Java online submissions for Fair Candy Swap.
    //Memory Usage: 41.8 MB, less than 31.71% of Java online submissions for Fair Candy Swap.
/*    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> setB = new HashSet<>();
        int diff = (IntStream.of(B).sum() - IntStream.of(A).sum() ) / 2;
        for (int i: B) setB.add(i);
        for (int i : A) {
            if (setB.contains(i + diff)) {
                return new int[]{i, i + diff};
            }
        }
        return new int[] {-1};
    }*/




}
