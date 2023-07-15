package com.sjia.Leetcode;

public class SQLNthHighestSalary {
    // #177. Nth Highest Salary     https://leetcode.com/problems/nth-highest-salary/

    /*
    Input:
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
n = 2
Output:
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
     */


    /*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M=N-1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT M, 1


  );
END


// Why it is syntax error when delete the declare part and insert N - 1 into query statement
// because LIMIT cannot recognize expressions with arithmetic operators. You have to do the math before LIMIT


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N-1;
  RETURN (
      SELECT DISTINCT(salary) from Employee order by salary DESC
      LIMIT 1 OFFSET N

  );
END

     */



}
