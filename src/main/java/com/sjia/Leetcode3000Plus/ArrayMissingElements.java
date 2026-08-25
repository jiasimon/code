package com.sjia.Leetcode3000Plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMissingElements {
    // #3731. Find Missing Elements https://leetcode.com/problems/find-missing-elements/description/
    /*
    Input: nums = [1,4,2,5]     Output: [3]
    Input: nums = [5,1]         Output: [2,3,4]

    2 <= nums.length <= 100
    1 <= nums[i] <= 100
     */



    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        for (int i=0; i < nums.length-1; i++) {
            for (int j=nums[i]+1; j< nums[i+1]; j++) {
                res.add(j);
            }
        }
        return res;
    }


    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {


        ArrayMissingElements solution = new ArrayMissingElements();

        testTypicalCase(solution);
        testNoGaps(solution);
//        testEmptyArray(solution);
//        testSingleElement(solution);
//        testUnsortedInput(solution);
//        testDuplicateValues(solution);
//        testNegativeNumbers(solution);
//        testLargeGap(solution);
//        testTwoElementsNoGap(solution);
//        testResultIsSortedAscending(solution);

        System.out.println("\n----------------------------------");
        System.out.println("Passed: " + passed + ", Failed: " + failed);
        System.out.println("----------------------------------");

        if (failed > 0) {
            System.exit(1);
        }
    }

    private static void testTypicalCase(ArrayMissingElements solution) {
        int[] nums = {1, 3, 6, 8};
        List<Integer> expected = Arrays.asList(2, 4, 5, 7);
        List<Integer> actual = solution.findMissingElements(nums);
        check("typicalCase_multipleGaps", expected, actual);
    }

    private static void testNoGaps(ArrayMissingElements solution) {
        int[] nums = {5, 6, 7, 8, 9};
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = solution.findMissingElements(nums);
        check("noGaps_consecutiveIntegers", expected, actual);
    }

    // --- simple assertion helper ---
    private static void check(String testName, List<Integer> expected, List<Integer> actual) {
        if (expected.equals(actual)) {
            passed++;
            System.out.println("[PASS] " + testName);
        } else {
            failed++;
            System.out.println("[FAIL] " + testName);
            System.out.println("        expected: " + expected);
            System.out.println("        actual:   " + actual);
        }
    }

}
