package com.sjia.Leetcode;

import java.util.*;

public class EvaluateDivision {
    // #399. Evaluate Division  https://leetcode.com/problems/evaluate-division/description/

    /*
    You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

    You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

    Return the answers to all queries. If a single answer cannot be determined, return -1.0.

    Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

    Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.


    Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
    Explanation:
    Given: a / b = 2.0, b / c = 3.0
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
    return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
    note: x is undefined => -1.0
     */


    // revisit
    // 2ms, 21.62%; 40.9 MB, 87.36%
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            results[i] = evaluateQuery(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }

        return results;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, value);

            graph.putIfAbsent(to, new HashMap<>());
            graph.get(to).put(from, 1.0 / value);
        }

        return graph;
    }

    private double evaluateQuery(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            return -1.0;
        }

        if (from.equals(to)) {
            return 1.0;
        }

        visited.add(from);
        for (Map.Entry<String, Double> neighbor : graph.get(from).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double subResult = evaluateQuery(graph, neighbor.getKey(), to, visited);
                if (subResult != -1.0) {
                    return neighbor.getValue() * subResult;
                }
            }
        }

        visited.remove(from);
        return -1.0;
    }


    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        double[] results = solution.calcEquation(equations, values, queries);

        System.out.println("Results of queries:");
        for (double result : results) {
            System.out.println(result);
        }
    }

}
