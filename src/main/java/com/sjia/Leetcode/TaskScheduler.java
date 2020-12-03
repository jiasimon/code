package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskScheduler {
    // #621 https://leetcode.com/problems/task-scheduler/   #fb

    // there is a non-negative integer n that represents the cooldown period
    // between two same tasks (the same letter in the array)

    // Input: tasks = ["A","A","A","B","B","B"], n = 2  Output: 8
    // A -> B -> idle -> A -> B -> idle -> A -> B
    //There is at least 2 units of time between any two same tasks.

    // Input: tasks = ["A","A","A","B","B","B"], n = 0  Output: 6

    // Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
    // Output: 16
    // A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A

    // 1 <= task.length <= 104
    // tasks[i] is upper-case English letter.
    // The integer n is in the range [0, 100]



    //  char count array, sort it,  Math.max(tasks.length , (count[25]-1)*(n+1) + 25-i)
    // Runtime: 2 ms, faster than 99.59% of Java online submissions for Task Scheduler.
    // Memory Usage: 40.5 MB, less than 29.35% of Java online submissions for Task Scheduler.
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char t: tasks) {
            count[t - 'A']++;
        }
        Arrays.sort(count);
        int i=25;
        for ( i=25; i>=0; i--) {
            if (count[i] != count[25]) break;
        }

        return Math.max(tasks.length , (count[25]-1)*(n+1) + 25-i);

    }

    // Runtime: 3 ms, faster than 55.12% of Java online submissions for Task Scheduler.
    // Memory Usage: 40.4 MB, less than 49.74% of Java online submissions for Task Scheduler.
    public int leastInterval2(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        char[] testData = { 'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        TaskScheduler solution = new TaskScheduler();
        int result = solution.leastInterval(testData, n);





        System.out.printf("testData %s TaskScheduler  is %s \n", Arrays.toString(testData),result);
    }



}
