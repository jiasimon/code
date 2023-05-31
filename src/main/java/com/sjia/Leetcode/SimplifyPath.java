package com.sjia.Leetcode;

import java.util.Stack;

public class SimplifyPath {
    //  #71. Simplify Path  https://leetcode.com/problems/simplify-path/
    /*
    In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

    The canonical path should have the following format:

    The path starts with a single slash '/'.
    Any two directories are separated by a single slash '/'.
    The path does not end with a trailing '/'.
    The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
    Return the simplified canonical path.
     */

    // Input: path = "/home/"  Output: "/home"
    // Input: path = "/../"   Output: "/"
    // Input: path = "/home//foo/"  Output: "/home/foo"



    // need revisit
    public static String simplifyPath(String path) {
        // Split the input path by '/'
        String[] directories = path.split("/");

        // Create a stack to hold the directories
        Stack<String> stack = new Stack<>();

        // Process each directory
        for (String dir : directories) {
            // Ignore empty and current directory (".") entries
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }
            // Go up one level if encountering a parent directory ("..")
            else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // Push valid directory names into the stack
            else {
                stack.push(dir);
            }
        }

        // Build the simplified path by joining the directories from the stack
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/");
            simplifiedPath.append(dir);
        }

        // Handle the case where the simplified path is empty
        if (simplifiedPath.length() == 0) {
            simplifiedPath.append("/");
        }

        return simplifiedPath.toString();
    }

    public static void main(String[] args) {
        String path1 = "/home/";
        System.out.println("Simplified path: " + simplifyPath(path1)); // Output: "/home"

        String path2 = "/a/./b/../../c/";
        System.out.println("Simplified path: " + simplifyPath(path2)); // Output: "/c"

        String path3 = "/../";
        System.out.println("Simplified path: " + simplifyPath(path3)); // Output: "/"

        String path4 = "/home//foo/";
        System.out.println("Simplified path: " + simplifyPath(path4)); // Output: "/home/foo"

        String path5 = "//.";
        System.out.println("Simplified path: " + simplifyPath(path5)); // Output: "/



    }


}
