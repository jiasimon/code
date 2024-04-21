package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFile {
    // #609. Find Duplicate File in System  https://leetcode.com/problems/find-duplicate-file-in-system/description/

    /*
    A group of duplicate files consists of at least two files that have the same content.

    A single directory info string in the input list has the following format:

    The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

    "directory_path/file_name.txt"

    Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
    Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

    Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
    Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]

     */


    // map.putIfAbsent(content, new ArrayList<>());
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToFiles = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String directory = parts[0];
            for (int i = 1; i < parts.length; i++) {
                String[] fileParts = parts[i].split("\\(");
                String fileName = fileParts[0];
                String content = fileParts[1].substring(0, fileParts[1].length() - 1);
                String fullPath = directory + "/" + fileName;
                contentToFiles.putIfAbsent(content, new ArrayList<>());
                contentToFiles.get(content).add(fullPath);
            }
        }

        List<List<String>> duplicates = new ArrayList<>();
        for (List<String> fileList : contentToFiles.values()) {
            if (fileList.size() > 1) {
                duplicates.add(fileList);
            }
        }

        return duplicates;
    }


    public static void main(String[] args) {
        FindDuplicateFile solution = new FindDuplicateFile();

        // Test Case
        String[] paths = {
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"
        };
        List<List<String>> result = solution.findDuplicate(paths);
        for (List<String> group : result) {
            System.out.println("Duplicate group:");
            for (String file : group) {
                System.out.println(file);
            }
            System.out.println();
        }
    }

}
