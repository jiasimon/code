package com.sjia.Leetcode;

import java.util.*;

public class ReconstructItinerary332 {
    // #332. Reconstruct Itinerary      https://leetcode.com/problems/reconstruct-itinerary/?envType=daily-question&envId=2023-09-14

    /*
    You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

    All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

    For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

    Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
    Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.

    Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
    Output: ["JFK","MUC","LHR","SFO","SJC"]
     */


    // Map<String, PriorityQueue<String>>, computeIfAbsent
    // 5 ms, 96.93%; 44.4 MB, 68.11%
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> res = new ArrayList<>();

        // Build the graph from the ticket edges
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        // Start the DFS from the "JFK" airport
        dfs("JFK", graph, res);

        // Reverse the result to get the lexicographically smallest itinerary
        Collections.reverse(res);

        return res;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport, graph, result);
        }

        // Add the airport to the result after processing its destinations
        result.add(airport);
    }




    public static void main(String[] args) {
        ReconstructItinerary332 solution = new ReconstructItinerary332();
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );

        List<String> itinerary = solution.findItinerary(tickets);
        System.out.println("Reconstructed Itinerary: " + itinerary);
    }

}
