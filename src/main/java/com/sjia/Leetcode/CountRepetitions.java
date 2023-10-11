package com.sjia.Leetcode;

public class CountRepetitions {
    // #466. Count The Repetitions      https://leetcode.com/problems/count-the-repetitions/description/

    /*
    We define str = [s, n] as the string str which consists of the string s concatenated n times.

    For example, str == ["abc", 3] =="abcabcabc".
    We define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1.

    For example, s1 = "abc" can be obtained from s2 = "abdbec" based on our definition by removing the bolded underlined characters.
    You are given two strings s1 and s2 and two integers n1 and n2. You have the two strings str1 = [s1, n1] and str2 = [s2, n2].

    Return the maximum integer m such that str = [str2, m] can be obtained from str1.

    Input: s1 = "acb", n1 = 4, s2 = "ab", n2 = 2        Output: 2
    Input: s1 = "acb", n1 = 1, s2 = "acb", n2 = 1       Output: 1

    1 <= s1.length, s2.length <= 100
    s1 and s2 consist of lowercase English letters.
    1 <= n1, n2 <= 10^6
     */


    // Brute force, TLE
    public int getMaxRepetitions(String s1, int n1, String s2, int n2)
    {
        int index = 0, repeat_count = 0;
        int s1_size = s1.length(), s2_size = s2.length();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1_size; j++) {
                if (s1.charAt(j) == s2.charAt(index))
                    ++index;
                if (index == s2_size) {
                    index = 0;
                    ++repeat_count;
                }
            }
        }
        return repeat_count / n2;
    }



    public static void main(String[] args) {
        CountRepetitions solution = new CountRepetitions();
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;

        int maxRepetitions = solution.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println("Max Repetitions: " + maxRepetitions); // Output: 2
    }


}
