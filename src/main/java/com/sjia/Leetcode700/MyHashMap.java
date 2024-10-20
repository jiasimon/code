package com.sjia.Leetcode700;

import java.util.LinkedList;

public class MyHashMap {
    // #706. Design HashMap     https://leetcode.com/problems/design-hashmap/description/


    private static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 1000;  // Number of buckets
    private LinkedList<Pair>[] buckets;

    // Constructor: Initialize the array of buckets
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to map a key to a bucket index
    private int hash(int key) {
        return key % SIZE;
    }

    // Put a key-value pair into the map
    public void put(int key, int value) {
        int bucketIndex = hash(key);
        LinkedList<Pair> bucket = buckets[bucketIndex];

        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;  // Update value if key exists
                return;
            }
        }
        bucket.add(new Pair(key, value));  // Add new key-value pair
    }

    // Get the value associated with the key
    public int get(int key) {
        int bucketIndex = hash(key);
        LinkedList<Pair> bucket = buckets[bucketIndex];

        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;  // Key not found
    }

    // Remove the key and its associated value
    public void remove(int key) {
        int bucketIndex = hash(key);
        LinkedList<Pair> bucket = buckets[bucketIndex];

        for (Pair pair : bucket) {
            if (pair.key == key) {
                bucket.remove(pair);
                return;
            }
        }
    }

}
