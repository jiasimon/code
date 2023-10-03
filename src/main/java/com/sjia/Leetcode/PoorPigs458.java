package com.sjia.Leetcode;

public class PoorPigs458 {
    // #458. Poor Pigs      https://leetcode.com/problems/poor-pigs/

    /*
    Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time.

    Input: buckets = 4, minutesToDie = 15, minutesToTest = 15       Output: 2
    Explanation: We can determine the poisonous bucket as follows:
    At time 0, feed the first pig buckets 1 and 2, and feed the second pig buckets 2 and 3.
    At time 15, there are 4 possible outcomes:
    - If only the first pig dies, then bucket 1 must be poisonous.
    - If only the second pig dies, then bucket 3 must be poisonous.
    - If both pigs die, then bucket 2 must be poisonous.
    - If neither pig dies, then bucket 4 must be poisonous.
     */



    // failed 17/18  (125, 1, 4)
    public int poorPigs_math(int buckets, int minutesToDie, int minutesToTest) {
        int k = minutesToTest/minutesToDie;
        return (int) Math.ceil(Math.log(buckets) / Math.log(k + 1));

    }


    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int testsPerPig = minutesToTest / minutesToDie + 1;

        while (Math.pow(testsPerPig, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }


    public static void main(String[] args) {
        PoorPigs458 solution = new PoorPigs458();
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;

        int pigsNeeded = solution.poorPigs_math(buckets, minutesToDie, minutesToTest);
        System.out.println("Pigs needed: " + pigsNeeded); // Output: 5

        int pigsNeeded2 = solution.poorPigs_math(125, 1, 4);
        System.out.println("Pigs needed poorPigs_math: " + pigsNeeded2);
        pigsNeeded2 = solution.poorPigs(125, 1, 4);
        System.out.println("Pigs needed pow: " + pigsNeeded2); // Output: 3   instead of 4
    }
}
