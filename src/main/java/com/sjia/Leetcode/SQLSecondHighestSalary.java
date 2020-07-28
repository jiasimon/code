package com.sjia.Leetcode;

public class SQLSecondHighestSalary {

    //#176  https://leetcode.com/problems/second-highest-salary/

/*
    select(
            select distinct Salary From Employee order by Salary desc limit 1 offset 1
    ) AS SecondHighestSalary;
    */

/*
    select max(Salary) SecondHighestSalary 
    from Employee
    where Salary < (select max(Salary) from Employee)*/

}
