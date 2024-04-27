package com.sjia.Leetcode;

public class MyCircularQueue {
    // #622. Design Circular Queue  https://leetcode.com/problems/design-circular-queue/description/
    /*
    MyCircularQueue(k) Initializes the object with the size of the queue to be k.
    int Front() Gets the front item from the queue. If the queue is empty, return -1.
    int Rear() Gets the last item from the queue. If the queue is empty, return -1.
    boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
    boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
     */


        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyCircularQueue(int k) {
            capacity = k;
            queue = new int[k];
            front = -1;
            rear = -1;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : queue[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : queue[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }


    public static void main(String[] args) {
        // Test Case
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println("Test Case 1:");
        System.out.println("enQueue(1): " + circularQueue.enQueue(1)); // Output: true
        System.out.println("enQueue(2): " + circularQueue.enQueue(2)); // Output: true
        System.out.println("enQueue(3): " + circularQueue.enQueue(3)); // Output: true
        System.out.println("enQueue(4): " + circularQueue.enQueue(4)); // Output: false
        System.out.println("Rear: " + circularQueue.Rear()); // Output: 3
        System.out.println("isFull(): " + circularQueue.isFull()); // Output: true
        System.out.println("deQueue(): " + circularQueue.deQueue()); // Output: true
        System.out.println("enQueue(4): " + circularQueue.enQueue(4)); // Output: true
        System.out.println("Rear: " + circularQueue.Rear()); // Output: 4
    }
}
