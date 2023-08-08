package com.sjia.poc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Given an array of distinct integers.
    // The task is to count all the triplets such that sum of two elements equals the third element. Example 1: Input: arr[] = {1, 5, 3, 2} Output: 2
    // Explanation: There are 2 such triplets: {1,2,3} and {2,3,5} 1 + 2 = 3 and 3 +2 = 5

    // for  n^3  Arraylist<Integer>

    public static int getCount(int[] input) {
        Arrays.sort(input);
        int n = input.length;
        int res = 0;
        for ( int i =0 ; i < n -2 ; i++ )
            for ( int j=i+1; j < n-1; j++ )
                for (int k=j+1; k < n ; k++) {
                    if(input[k] == input[i] + input[j]) res++;
                }
        return res;


    }


    static List<List<Integer>> findTriplet(int arr[])
    {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        // sort the array
        Arrays.sort(arr);


        // two pointer
        for (int i = n - 1; i >= 0; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (arr[i] == arr[j] + arr[k]) {
                    res.add(Arrays.asList(arr[j], arr[k], arr[i]));
                    break;
                }
                else if (arr[i] > arr[j] + arr[k])
                    j++;
                else
                    k--;
            }
        }

        return res;
    }




    public static void main(String[] args) {
        int[] input = {1, 5, 3, 2};
        int result = getCount(input);
        System.out.println("The count is: " + result);

        int[] input2 = { 5, 32, 1, 7, 10, 50, 19, 21, 2 };
        List<List<Integer>> res2 = new ArrayList<>();
        res2 = findTriplet(input2);
        System.out.println( Arrays.toString(input2) + " The results are: " + res2);

    }


}
