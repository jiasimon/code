package com.sjia.Leetcode;

public class PalindromeValidIgnore {

    // #125. Valid Palindrome https://leetcode.com/problems/valid-palindrome/ #fb
    // ValidPalindrome

    // considering only alphanumeric characters and ignoring cases.
    // Here we define empty string as valid palindrome



    // two pointers
    // Runtime: 4 ms, faster than 41.16% of Java online submissions for Valid Palindrome.
    //Memory Usage: 38.4 MB, less than 99.98% of Java online submissions for Valid Palindrome.
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if ( Character.isLetterOrDigit(c) ) sb.append(Character.toLowerCase(c));
        }
        String tmp = sb.toString();
        int i=0, j=tmp.length()-1;
        while(i < j) {
            if(tmp.charAt(i) != tmp.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }



    public boolean isPalindrome4(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }


    // Runtime: 37 ms, faster than 14.21% of Java online submissions for Valid Palindrome.
    //Memory Usage: 44.8 MB, less than 5.01% of Java online submissions for Valid Palindrome.

    // another run
    //Runtime: 24 ms, faster than 24.65% of Java online submissions for Valid Palindrome.
    //Memory Usage: 40.2 MB, less than 14.17% of Java online submissions for Valid Palindrome.

    public boolean isPalindrome3(String s) {
        String filterStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String revertStr = new StringBuilder(filterStr).reverse().toString();
        return filterStr.equals(revertStr) ;
    }


    // Runtime: 11 ms, faster than 31.09% of Java online submissions for Valid Palindrome.
    //Memory Usage: 40.9 MB, less than 12.38% of Java online submissions for Valid Palindrome.

/*
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }*/



    public static void main(String[] args) {

        //String testData  = " a  ";
        //String testData  = "This is ht";
        String testData  = "race a car";
//        String testData  = "A man, a plan, a canal: Panama";
        PalindromeValidIgnore solution = new PalindromeValidIgnore();

        boolean result = solution.isPalindrome(testData);

        System.out.printf(" input %s isPalindrome: %b ", testData, result);

        String s1 = "A man, a plan, a canal: Panama";
        boolean result1 = solution.isPalindrome(s1);
        System.out.printf(" input %s isPalindrome: %b ", s1, result1);

    }

}
