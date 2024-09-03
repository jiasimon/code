package com.sjia.Leetcode600;

import java.util.*;

public class TopKFrequentWords {
    // #692. Top K Frequent Words   https://leetcode.com/problems/top-k-frequent-words/description/
    /*
    Input: words = ["i","love","leetcode","i","love","coding"], k = 2
    Output: ["i","love"]

    1 <= words.length <= 500
    1 <= words[i].length <= 10
    words[i] consists of lowercase English letters.

     */

    // using a HashMap to count the frequencies of each word,
    // and then using a priority queue (min-heap) to keep track of the top k frequent words.
    // Finally, the result is sorted by frequency and lexicographically as required.


    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a min-heap to maintain the top k frequent words
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) ->
                freqMap.get(w1).equals(freqMap.get(w2)) ? w2.compareTo(w1) : freqMap.get(w1) - freqMap.get(w2)
        );

        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 3: Extract the words from the heap and reverse the order to get the correct result
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }


    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();

        // Test Case 1
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.topKFrequent(words1, k1)); // Expected output: [i, love]

        // Test Case 2
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println("Test Case 2: " + solution.topKFrequent(words2, k2)); // Expected output: [the, is, sunny, day]

        // Test Case 3
        String[] words3 = {"apple", "banana", "apple", "apple", "orange", "banana", "banana"};
        int k3 = 2;
        System.out.println("Test Case 3: " + solution.topKFrequent(words3, k3)); // Expected output: [apple, banana]

        // Test Case 4
        String[] words4 = {"a", "b", "c", "a", "b", "a"};
        int k4 = 1;
        System.out.println("Test Case 4: " + solution.topKFrequent(words4, k4)); // Expected output: [a]

        // Test Case 5
        String[] words5 = {"coding", "coding", "leetcode", "leetcode", "leetcode", "code", "code", "code", "coding"};
        int k5 = 3;
        System.out.println("Test Case 5: " + solution.topKFrequent(words5, k5)); // Expected output: [code, coding, leetcode]
    }



}
