package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    // #207. Course Schedule    https://leetcode.com/problems/course-schedule/
    /*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.

    Input: numCourses = 2, prerequisites = [[1,0]]      Output: true
    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]    Output: false

     */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list representation of the course dependencies
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build the adjacency list and calculate the in-degree of each course
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacencyList.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }

        // Perform topological sort using BFS
        Queue<Integer> queue = new LinkedList<>();
        int coursesTaken = 0;

        // Enqueue all courses with an in-degree of 0
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;

            // Decrement the in-degree of each dependent course
            for (int dependentCourse : adjacencyList.get(course)) {
                inDegree[dependentCourse]--;
                // If the in-degree becomes 0, enqueue the dependent course
                if (inDegree[dependentCourse] == 0) {
                    queue.offer(dependentCourse);
                }
            }
        }

        return coursesTaken == numCourses;
    }

    // Test the code
    public static void main(String[] args) {
        // Test Case 1: Possible to finish all courses
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseSchedule solution = new CourseSchedule();
        boolean result1 = canFinish(numCourses1, prerequisites1);
        System.out.println("Is it possible to finish all courses? " + result1);

/*
        // Test Case 2: Not possible to finish all courses due to cycle
        int numCourses2 = 3;
        int[][] prerequisites2 = {{0, 1}, {1, 2}, {2, 0}};
        boolean result2 = canFinish(numCourses2, prerequisites2);
        System.out.println("Is it possible to finish all courses? " + result2);
        */
    }
}
