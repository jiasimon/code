package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    // #210. Course Schedule II     https://leetcode.com/problems/course-schedule-ii/description/
    /*
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

    Input: numCourses = 2, prerequisites = [[1,0]]  Output: [0,1]
    Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]    Output: [0,2,1,3]

    refer to #207 Course Schedule

     */



    //  BFS TopSort.
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an adjacency list representation of the course dependencies
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];

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
            res[coursesTaken] = course;
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

        if (coursesTaken == numCourses) return res;
        else return new int[0];
    }

}
