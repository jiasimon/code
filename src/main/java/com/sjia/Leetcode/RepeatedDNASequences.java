package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    // #187. Repeated DNA Sequences     https://leetcode.com/problems/repeated-dna-sequences/description/
    /*
    The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

    For example, "ACGAATTCCG" is a DNA sequence.
    Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

    Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"   Output: ["AAAAACCCCC","CCCCCAAAAA"]
    Input: s = "AAAAAAAAAAAAA"      Output: ["AAAAAAAAAA"]
     */


    // 22ms, 52.08% ; 51.79mb, 79.24%
    // double HashSet
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeat = new HashSet<>();

        for (int i=0; i<=s.length() - 10; i++) {
            String dnaSeq = s.substring(i, i+10);
            if(seen.contains(dnaSeq)) {
                repeat.add(dnaSeq);
            } else {
                seen.add(dnaSeq);
            }
        }
        return new ArrayList<>(repeat);

    }



    public static void main(String[] args) {
        RepeatedDNASequences solution = new RepeatedDNASequences();

        // Test case
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedSequences = solution.findRepeatedDnaSequences(s);
        System.out.println("Repeated DNA Sequences: " + repeatedSequences);  // Expected output: ["AAAAACCCCC", "CCCCCAAAAA"]
    }


}
