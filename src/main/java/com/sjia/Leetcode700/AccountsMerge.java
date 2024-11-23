package com.sjia.Leetcode700;

import java.util.*;

public class AccountsMerge {
    // #721. Accounts Merge     https://leetcode.com/problems/accounts-merge/description/
    /*
    Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
    Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
     */

    /*
    The problem is a graph connectivity problem:

    Treat each email as a node in the graph.
    Add edges between emails belonging to the same account.
    Use Union-Find (Disjoint Set Union) to find connected components (merged accounts).
    Group emails by their connected component and return the result.
     */

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Map each email to an ID
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int id = 0;

        // Assign unique IDs to emails and store their names
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                    emailToName.put(email, name);
                }
            }
        }

        // Initialize Union-Find
        UnionFind uf = new UnionFind(id);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                uf.union(emailToId.get(firstEmail), emailToId.get(account.get(i)));
            }
        }

        // Group emails by connected components
        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int rootId = uf.find(emailToId.get(email));
            components.computeIfAbsent(rootId, x -> new ArrayList<>()).add(email);
        }

        // Build the result
        List<List<String>> result = new ArrayList<>();
        for (List<String> emails : components.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            result.add(account);
        }

        return result;
    }

    // Union-Find Helper Class
    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }



    public static void main(String[] args) {
        AccountsMerge solution = new AccountsMerge();

        // Test Case 1
        List<List<String>> accounts1 = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        );
        System.out.println(solution.accountsMerge(accounts1));
        // Output: [["John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"],
        //          ["John", "johnnybravo@mail.com"],
        //          ["Mary", "mary@mail.com"]]

        // Test Case 2
        List<List<String>> accounts2 = Arrays.asList(
                Arrays.asList("Alice", "alice@mail.com", "alice123@mail.com"),
                Arrays.asList("Alice", "alice123@mail.com", "alice456@mail.com"),
                Arrays.asList("Bob", "bob@mail.com")
        );
        System.out.println(solution.accountsMerge(accounts2));
        // Output: [["Alice", "alice@mail.com", "alice123@mail.com", "alice456@mail.com"],
        //          ["Bob", "bob@mail.com"]]
    }


}
