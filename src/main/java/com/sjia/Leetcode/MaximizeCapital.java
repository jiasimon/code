package com.sjia.Leetcode;

import java.util.PriorityQueue;

public class MaximizeCapital {
    // #502. IPO    https://leetcode.com/problems/ipo/

    /*
    Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

    You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

    Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

    Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

    The answer is guaranteed to fit in a 32-bit signed integer.

    Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
    Output: 4
    Explanation: Since your initial capital is 0, you can only start the project indexed 0.
    After finishing it you will obtain profit 1 and your capital becomes 1.
    With capital 1, you can either start the project indexed 1 or the project indexed 2.
    Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
    Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.

    Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
    Output: 6
     */


    class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }


    // PriorityQueue
    // 83 ms, 51.87%; 62.9 MB, 16.41%
    public int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
        int n = profits.length;

        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new Project(capital[i], profits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= W) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            W += maxProfitHeap.poll().profit;
        }

        return W;
    }

    public static void main(String[] args) {
        MaximizeCapital solution = new MaximizeCapital();

        int k = 2;
        int W = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        int maxCapital = solution.findMaximizedCapital(k, W, profits, capital);
        System.out.println("Maximum capital after investing in projects: " + maxCapital);
    }
}
