package com.sjia.Leetcode;

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


    // split '\n', pathLengths[level + 1] = pathLengths[level] + len + 1
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


    public static void main(String[] args) {
        LongestAbsoluteFilePath solution = new LongestAbsoluteFilePath();
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        int maxLength = solution.lengthLongestPath(input);
        System.out.println("Length of the longest absolute path: " + maxLength); // Output: 20
    }

}
