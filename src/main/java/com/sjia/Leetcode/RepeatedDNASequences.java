package com.sjia.Leetcode;

import java.util.*;

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


    // !seen.add(dnaSeq)
    // 20ms , 66.05%; 52.29mb, 27.16%
    public List<String> findRepeatedDnaSequencesDoubleSets(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeat = new HashSet<>();

        for (int i=0; i<=s.length() - 10; i++) {
            String dnaSeq = s.substring(i, i+10);
            if (!seen.add(dnaSeq)) {
                repeat.add(dnaSeq);
            }
        }
        return new ArrayList<>(repeat);
    }


    // HashMap
    public List<String> findRepeatedDnaSequencesHashMap(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i + 10 <= s.length(); i++) {
            String seq = s.substring(i, i + 10);
            int count = map.getOrDefault(seq, 0);
            if (count == 1) res.add(seq);
            map.put(seq, count+1);
        }
        return res;
    }

    public static void main(String[] args) {
        RepeatedDNASequences solution = new RepeatedDNASequences();

        // Test case
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedSequences = solution.findRepeatedDnaSequencesDoubleSets(s);
        System.out.println("Repeated DNA Sequences: " + repeatedSequences);  // Expected output: ["AAAAACCCCC", "CCCCCAAAAA"]
    }


}
