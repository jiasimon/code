package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagValidator {
    // #591. Tag Validator      https://leetcode.com/problems/tag-validator/description/

    /*
    Given a string representing a code snippet, implement a tag validator to parse the code and return whether it is valid.
     */

    // gpt failed on testString1
    public boolean isValid_gpt_failed(String code) {
        Stack<String> stack = new Stack<>();

        Pattern pattern = Pattern.compile("<(\\/?[A-Z]{1,9})>");
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            String tag = matcher.group(1);

            if (!stack.isEmpty() && stack.peek().equals(tag)) {
                if (tag.startsWith("/")) {
                    stack.pop(); // Closing tag found
                } else {
                    return false; // Opening tag found after another opening tag
                }
            } else if (tag.startsWith("/")) {
                return false; // Closing tag without matching opening tag
            } else {
                stack.push(tag); // Push opening tag to stack
            }
        }

        return stack.isEmpty() && matcher.hitEnd();
    }


    public boolean isValid(String code) {
        if (code.charAt(0) != '<' || code.charAt(code.length() - 1) != '>')
            return false;

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < code.length(); ++i) {
            int closeIndex = 0;
            if (stack.isEmpty() && containsTag)
                return false;
            if (code.charAt(i) == '<') {
                // It's inside a tag, so check if it's a cdata.
                if (!stack.isEmpty() && code.charAt(i + 1) == '!') {
                    closeIndex = code.indexOf("]]>", i + 2);
                    if (closeIndex < 0 || !isValidCdata(code.substring(i + 2, closeIndex)))
                        return false;
                } else if (code.charAt(i + 1) == '/') { // the end tag
                    closeIndex = code.indexOf('>', i + 2);
                    if (closeIndex < 0 || !isValidTagName(stack, code.substring(i + 2, closeIndex), true))
                        return false;
                } else { // the start tag
                    closeIndex = code.indexOf('>', i + 1);
                    if (closeIndex < 0 || !isValidTagName(stack, code.substring(i + 1, closeIndex), false))
                        return false;
                }
                i = closeIndex;
            }
        }

        return stack.isEmpty() && containsTag;
    }

    private boolean containsTag = false;

    private boolean isValidCdata(final String s) {
        return s.indexOf("[CDATA[") == 0;
    }

    private boolean isValidTagName(Deque<String> stack, String tagName, boolean isEndTag) {
        if (tagName.isEmpty() || tagName.length() > 9)
            return false;

        for (final char c : tagName.toCharArray())
            if (!Character.isUpperCase(c))
                return false;

        if (isEndTag)
            return !stack.isEmpty() && stack.pop().equals(tagName);

        containsTag = true;
        stack.push(tagName);
        return true;
    }


    // Test case
    public static void main(String[] args) {
        TagValidator solution = new TagValidator();

        String testString1 = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        String testString2 = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>";
        String testString3 = "<A>  <B> </A>   </B>";
        String testString4 = "<DIV>  div tag is not closed  <DIV>";
        String testString5 = "<DIV>  unmatched <  </DIV>";

        System.out.println("Test Case 1: " + solution.isValid(testString1)); // Output: true
        System.out.println("Test Case 2: " + solution.isValid(testString2)); // Output: false
        System.out.println("Test Case 3: " + solution.isValid(testString3)); // Output: false
        System.out.println("Test Case 4: " + solution.isValid(testString4)); // Output: false
        System.out.println("Test Case 5: " + solution.isValid(testString5)); // Output: false
    }
}
