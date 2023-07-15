package com.sjia.Leetcode;

public class SQLSecondHighestSalary {

    //#176. Second Highest Salary  https://leetcode.com/problems/second-highest-salary/
    /*
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
In SQL, id is the primary key column for this table.
Find the second highest salary from the Employee table. If there is no second highest salary, return null (return None in Pandas).

Input:
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
Output:
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
     */

/*
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary;



要想获取第二高，需要排序，使用 order by（默认是升序 asc，即从小到大），若想降序则使用关键字 desc

如果有多个相同的数据，使用关键字 distinct 去重

判断临界输出，如果不存在第二高的薪水，查询应返回 null，使用 ifNull（查询，null）方法

起别名，使用关键字 as ...

因为去了重，又按顺序排序，使用 limit（）方法，查询第二大的数据，即第二高的薪水，即 limit(1,1) （因为默认从0开始，所以第一个1是查询第二大的数，第二个1是表示往后显示多少条数据，这里只需要一条）


    */

/*
    select max(Salary) SecondHighestSalary 
    from Employee
    where Salary < (select max(Salary) from Employee)*/

}
