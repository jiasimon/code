package com.sjia.Leetcode;

public class FindOriginalArrayPrefixXor2433 {
    // #2433. Find The Original Array of Prefix Xor https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/?envType=daily-question&envId=2023-10-31

    /*
    You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:

    pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
    Note that ^ denotes the bitwise-xor operation.

    It can be proven that the answer is unique.

    Input: pref = [5,2,0,3,1]       Output: [5,7,2,3,2]
    Explanation: From the array [5,7,2,3,2] we have the following:
    - pref[0] = 5.
    - pref[1] = 5 ^ 7 = 2.
    - pref[2] = 5 ^ 7 ^ 2 = 0.
    - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
    - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.

    Input: pref = [13]      Output: [13]

    1 <= pref.length <= 10^5
    0 <= pref[i] <= 10^6
     */


    
    // pref[1] = res[0] ^ res[1];   pref[0] ^ pref[1] = pref[0] ^ res[0] ^ res[1]
    // pref[2] = res[0] ^ res[1] ^ res[2];   pref[2] = pref[1] ^ res[2];
    // pref[1] ^ pref[2] = pref[1] ^ pref[1] ^ res[2]; res[2] = pref[1] ^ pref[2]
    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];

        res[0] = pref[0];
        for (int i = 1; i < res.length; ++i)
            res[i] = pref[i] ^ pref[i - 1];

        return res;

    }


}
