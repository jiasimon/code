package com.sjia;

public class MyTest {

    public static void main(String[] args) {
        float sum = 0;
        for (int i=0; i< 1000; i++ ) {
            sum +=0.1;
        }
        System.out.println("sum is " + sum);
        System.out.println(System.getenv("OUTPUT_PATH"));

        String myinput = "Todayissunny";

    }
}
