package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {
    // #388. Longest Absolute File Path     https://leetcode.com/problems/longest-absolute-file-path/description/

    /*
    Here, we have dir as the only directory in the root. dir contains two subdirectories, subdir1 and subdir2. subdir1 contains a file file1.ext and subdirectory subsubdir1. subdir2 contains a subdirectory subsubdir2, which contains a file file2.ext.
    dir
    ⟶ subdir1
    ⟶ ⟶ file1.ext
    ⟶ ⟶ subsubdir1
    ⟶ subdir2
    ⟶ ⟶ subsubdir2
    ⟶ ⟶ ⟶ file2.ext

    it will look like this: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext". Note that the '\n' and '\t' are the new-line and tab characters.

    Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"    Output: 20
    Explanation: We have only one file, and the absolute path is "dir/subdir2/file.ext" of length 20.

    Input: input = "a"      Output: 0
    Explanation: We do not have any files, just a single directory named "a".
     */


    // split '\n', path.lastIndexOf('\t') + 1
    // 0 ms, 100%; 40.2 MB, 88.43%
    /*
        "dir"
        "	subdir1"
    	"	subdir2"
    	"		file.ext"
     */
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] pathLengths = new int[paths.length + 1];
        int maxLength = 0;      // default 0 for no file

        for (String path : paths) {
            int level = path.lastIndexOf('\t') + 1;
            int len = path.length() - level;

            if (path.contains(".")) { // If it's a file
                maxLength = Math.max(maxLength, pathLengths[level] + len);
            } else { // If it's a directory
                pathLengths[level + 1] = pathLengths[level] + len + 1;
            }
        }

        return maxLength;
    }



    // stack ArrayDeque
    // 1 ms, 81.40%; 40.5 MB, 35.45%
    public int lengthLongestPath2(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] arr = input.split("\n");
        int maxLen = 0;
        int level;
        stack.push(0); //dummy default length
        for (String s: arr) {
            /*
            numOfTabs is the number of "\t", numOfTabs = 0
            when "\t" is not found, because s.lastIndexOf("\t") returns -1.
            So normally, the first parent "dir" have numOfTabs 0.
            */
            int numOfTabs = s.lastIndexOf("\t") + 1;
            /* Level is defined as numOfTabs + 1.
            For example, in "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext",
            dir is level 1, subdir1 and subdir2 are level 2, file.ext is level3
            */
            level = numOfTabs + 1;
            /*
            The following part of code is the case that we want to consider when there are
            several subdirectories in a same level. We want to remove
            the path length of the directory or the file of same level
            that we added during previous step, and calculate
            the path length of current directory or file that we are currently looking at.
            */
            while (level < stack.size()) stack.poll();
            int curLen = stack.peek() + s.length() - numOfTabs + 1;
            stack.push(curLen);
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1); //Only update the maxLen when a file is discovered,
            // And remove the "/" at the end of file
        }
        return maxLen;
    }



    public static void main(String[] args) {
        LongestAbsoluteFilePath solution = new LongestAbsoluteFilePath();
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        int maxLength = solution.lengthLongestPath(input);
        System.out.println("Length of the longest absolute path: " + maxLength); // Output: 20
    }

}
