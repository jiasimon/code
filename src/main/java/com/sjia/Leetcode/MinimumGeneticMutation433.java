package com.sjia.Leetcode;

import java.util.*;

public class MinimumGeneticMutation433 {
    // #433. Minimum Genetic Mutation   https://leetcode.com/problems/minimum-genetic-mutation/description/

    /*
    A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

    Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

    For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
    There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

    Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

    Note that the starting point is assumed to be valid, so it might not be included in the bank.

    Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]    Output: 1
    Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]  Output: 2

    0 <= bank.length <= 10
    startGene.length == endGene.length == bank[i].length == 8
    startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].

    compare to #127 word ladder

     */


    // BFS with Set visited
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }

        if (!bankSet.contains(end)) {
            return -1; // If the target gene is not in the bank, it's impossible to reach.
        }

        char[] validChars = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();

                if (currentGene.equals(end)) {
                    return mutations; // Found the target gene
                }

                char[] geneArray = currentGene.toCharArray();

                for (int j = 0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j];

                    for (char validChar : validChars) {
                        geneArray[j] = validChar;
                        String mutatedGene = new String(geneArray);

                        if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                            queue.offer(mutatedGene);
                            visited.add(mutatedGene);
                        }
                    }

                    geneArray[j] = originalChar; // Revert the change
                }
            }

            mutations++; // Increment the mutation count
        }

        return -1; // If no path to the target gene is found
    }



    public static void main(String[] args) {
        MinimumGeneticMutation433 solution = new MinimumGeneticMutation433();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int minMutations = solution.minMutation(start, end, bank);
        System.out.println("Minimum Genetic Mutation: " + minMutations); // Output: 1
    }




}
