package com.sjia.Leetcode;

import java.util.*;

public class RemoveInvalidParentheses {
    // #301. Remove Invalid Parentheses     https://leetcode.com/problems/remove-invalid-parentheses/
    /*
    Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

    Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

    Input: s = "()())()"    Output: ["(())()","()()()"]
    Input: s = "(a)())()"   Output: ["(a())()","(a)()()"]
    Input: s = ")("         Output: [""]


     */

    public List<String> removeInvalidParentheses_queue(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        Set<String> visited = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
        Queue<String> queue = new ArrayDeque<>();
        boolean found = false;
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (isValid(current)) {
                result.add(current);
                found = true;
            }
            if (found) {
                continue;
            }
// Generate all possible next strings by removing a parenthesis
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == '(' || current.charAt(i) == ')') {
                    String next = current.substring(0, i) + current.substring(i + 1);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return result;
    }


    // LinkedList, ArrayDeque
    // 51 ms, 70.75%; 44.4 MB, 47.83%
    public List<String> removeInvalidParentheses2(String s) {
        List <String> res = new ArrayList<>();
        if ( s == null || s.isEmpty() )  {
            return res;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        boolean found = false;

        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            if ( isValid(tmp) ) {
                res.add(tmp);
                found = true;
            }
            if(found) {
                continue;
            }

            for ( int i = 0; i < tmp.length(); i++ ) {
                if( tmp.charAt(i) == '(' || tmp.charAt(i) == ')' ) {
                    String next = tmp.substring(0,i) + tmp.substring(i+1);
                    if( visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }
        }

        return res;

    }


    // dfs, recursive
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        removeHelper(s, res, 0, 0, '(', ')');
        return res;
    }
    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                // Try removing one at each position, skipping duplicates
                for (int j = jStart; j <= i; j++)  {
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen)) {
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                    }
                }
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(')
            removeHelper(reversed, output, 0, 0, ')','(');
        else
            output.add(reversed);
    }



    private boolean isValid(String s) {
        int res = 0;

        for (char c: s.toCharArray()) {
            if ( c == '(') {
                res++;
            } else if ( c== ')' ) {
                res--;
                if (res < 0) {
                    return false;
                }
            }
        }

        return res == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();
        String s = "()())()";
        List<String> result = solution.removeInvalidParentheses(s);
        System.out.println(result); // Output: [(())(), ()()()]
    }



}
