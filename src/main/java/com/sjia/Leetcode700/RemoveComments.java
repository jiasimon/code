package com.sjia.Leetcode700;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    // #722. Remove Comments    https://leetcode.com/problems/remove-comments/description/
    /*
    Tracking Comment State:

        Use a boolean inBlock to determine if the parser is inside a block comment.

    Iterating Over Lines:

        Process each line one character at a time.
        If inside a block comment, look for the end of the block ().
        If not inside a block comment:
        Look for the start of a line comment (//).
        Look for the start of a block comment ().
     */

    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder currentLine = new StringBuilder();

        for (String line : source) {
            int i = 0;
            if (!inBlock) currentLine.setLength(0); // Reset currentLine if not in a block

            while (i < line.length()) {
                if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    // Start of block comment
                    inBlock = true;
                    i += 2;
                } else if (inBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    // End of block comment
                    inBlock = false;
                    i += 2;
                } else if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    // Start of line comment
                    break;
                } else if (!inBlock) {
                    // Normal code outside comments
                    currentLine.append(line.charAt(i));
                    i++;
                } else {
                    // Inside block comment, just skip
                    i++;
                }
            }

            // Add the current line to result if not in a block and it has content
            if (!inBlock && currentLine.length() > 0) {
                result.add(currentLine.toString());
            }
        }

        return result;
    }


    public static void main(String[] args) {
        RemoveComments solution = new RemoveComments();

        // Test Case 1
        String[] source1 = {
                "/*Test program */",
                "int main() {",
                "  // variable declaration ",
                "  int a, b, c;",
                "  /* This is a test",
                "     multiline",
                "     comment for",
                "     testing */",
                "  a = b + c;",
                "}"
        };
        System.out.println(solution.removeComments(source1));
        // Output: ["int main() {", "  int a, b, c;", "  a = b + c;", "}"]

        // Test Case 2
        String[] source2 = {
                "a/*comment",
                "line",
                "more_comment*/b"
        };
        System.out.println(solution.removeComments(source2));
        // Output: ["ab"]

        // Test Case 3
        String[] source3 = {
                "class Test {",
                "  // single line comment",
                "  int x = 0; /* inline comment */",
                "  int y = 1;",
                "  /* block comment */",
                "  int z = 2;",
                "}"
        };
        System.out.println(solution.removeComments(source3));
        // Output: ["class Test {", "  int x = 0;", "  int y = 1;", "  int z = 2;", "}"]
    }


}
