package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseSchedule3 {
    // #630. Course Schedule III    https://leetcode.com/problems/course-schedule-iii/

    /*
    There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.

    You will start on the 1st day and you cannot take two or more courses simultaneously.

    Return the maximum number of courses that you can take.

    Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]     Output: 3
    Input: courses = [[1,2]]        Output: 1
    Input: courses = [[3,2],[4,3]]  Output: 0

    1 <= courses.length <= 10000
    1 <= durationi, lastDayi <= 10000

     */


    // sort deadline, maxHeap duration
    // 32 ms, 80.44%; 53.8 MB,86.75%
    public int scheduleCourse(int[][] courses) {
        // Sort courses by their deadlines (ascending order)
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Use a max heap to track the courses that have been taken
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int currentTime = 0; // Current time spent

        for (int[] course : courses) {
            int duration = course[0];
            int deadline = course[1];

            // If we have enough time, add the course to the max heap
            if (currentTime + duration <= deadline) {
                maxHeap.offer(duration);
                currentTime += duration;
            }
            // If not, replace the course with the longest duration if it exists and is longer than the current course
            else if (!maxHeap.isEmpty() && maxHeap.peek() > duration) {
                int longestDuration = maxHeap.poll();
                maxHeap.offer(duration);
                currentTime = currentTime - longestDuration + duration;
            }
        }

        return maxHeap.size();
    }

    public int scheduleCourse_PriorityQueue(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // Sort courses by their deadlines

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int deadline = course[1];

            if (time + duration <= deadline) {
                pq.offer(duration);
                time += duration;
            } else if (!pq.isEmpty() && pq.peek() > duration) {
                time += duration - pq.poll();
                pq.offer(duration);
            }
        }

        return pq.size();
    }


    public static void main(String[] args) {
        CourseSchedule3 solution = new CourseSchedule3();
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int maxCourses = solution.scheduleCourse(courses);
        System.out.println("Maximum Courses That Can Be Taken: " + maxCourses); // Output: 3
    }


}
