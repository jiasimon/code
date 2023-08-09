package com.sjia.Leetcode;

public class ReverseString {
    // #344. Reverse String https://leetcode.com/problems/reverse-string/


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse String.
    //Memory Usage: 46.7 MB, less than 15.45% of Java online submissions for Reverse String.
    public void reverseString(char[] s) {
        if (s==null || s.length==0) return;
        int left=0, right =s.length-1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }

    }


    // sb.reverse
    public String reverseString_StringBuilder(char[] s) {
        if (s==null || s.length==0) return "";
         String tmp = String.valueOf(s);
         StringBuilder sb = new StringBuilder(tmp);
         return sb.reverse().toString();
    }



    public void reverseString_recursive(char[] s) {
        int i = 0;
        int j = s.length - 1;
        solveSwap(s, i, j);
    }

    // recursive
    public void solveSwap(char[] s, int i, int j){
        if(i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        solveSwap(s, ++i, --j);
    }



    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString_recursive(s);
        System.out.println(s); // Output: "olleh"
    }


}
