package com.sjia.Leetcode;

import java.util.Random;

public class RandomPointInCircle {
    // #478. Generate Random Point in a Circle  https://leetcode.com/problems/generate-random-point-in-a-circle/description/

    /*
    Given the radius and the position of the center of a circle, implement the function randPoint which generates a uniform random point inside the circle.

    Implement the Solution class:

    Solution(double radius, double x_center, double y_center) initializes the object with the radius of the circle radius and the position of the center (x_center, y_center).
    randPoint() returns a random point inside the circle. A point on the circumference of the circle is considered to be in the circle. The answer is returned as an array [x, y].

    Input
    ["Solution", "randPoint", "randPoint", "randPoint"]
    [[1.0, 0.0, 0.0], [], [], []]
    Output
    [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]

    0 < radius <= 10^8
    -10^7 <= x_center, y_center <= 10^7
     */

    private double radius;
    private double xCenter;
    private double yCenter;
    private Random random;

    public RandomPointInCircle(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.random = new Random();
    }

    // use x=sqrt(rand(len))*cos(rand(degree)) instead of rand(len)*cos(rand(degree))
    // Math.PI, 
    public double[] randPoint() {
        double angle = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(random.nextDouble()) * radius; // Random radius within the circle

        double x = xCenter + r * Math.cos(angle);
        double y = yCenter + r * Math.sin(angle);

        return new double[]{x, y};
    }

    public static void main(String[] args) {
        RandomPointInCircle solution = new RandomPointInCircle(1.0, 0.0, 0.0);

        double[] randomPoint = solution.randPoint();
        System.out.println("Random Point: (" + randomPoint[0] + ", " + randomPoint[1] + ")");
    }


}
