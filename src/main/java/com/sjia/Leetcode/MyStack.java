package com.sjia.Leetcode;


import java.util.LinkedList;
import java.util.Queue;

// Double Queues
public class MyStack {
    // #225. Implement Stack using Queues   https://leetcode.com/problems/implement-stack-using-queues/

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;


    }

    // Removes the element on top of the stack and returns that element.
    public int pop() {
        return queue1.poll();

    }

    // Get the top element.
    public int top() {
        return  queue1.peek();
    }

    // Returns whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }




    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Pop: " + stack.pop()); // Output: 3
        System.out.println("Top element: " + stack.top()); // Output: 2
        System.out.println("Is empty: " + stack.empty()); // Output: false
    }

}
