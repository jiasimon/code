package com.sjia.Leetcode;

public class SQLConsecutiveNumbers {
    // #180. Consecutive Numbers    https://leetcode.com/problems/consecutive-numbers/description/
    /*
    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | id          | int     |
    | num         | varchar |
    +-------------+---------+
    id is the primary key for this table.
    id is an autoincrement column.

Input:
Logs table:
+----+-----+
| id | num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
Output:
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
     */

    /*
SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
;
     */


}
