package com.sjia.Leetcode;

public class SQLManagers5DirectReports {
    // #570 https://leetcode.com/problems/managers-with-at-least-5-direct-reports/

/*

select Name
from Employee E
where. E.Id in
(
select ManagerId
from Employee
group by ManagerId
having count() >=5
)



select E.Name
from
(
select ManagerId
from Employee
group by ManagerId
having count() >=5
) as tmp, Employee E
where tmp.ManagerId = E.Id



 */



    /*
    The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.
+------+----------+-----------+----------+
|Id    |Name 	  |Department |ManagerId |
+------+----------+-----------+----------+
|101   |John 	  |A 	      |null      |
|102   |Dan 	  |A 	      |101       |
|103   |James 	  |A 	      |101       |
|104   |Amy 	  |A 	      |101       |
|105   |Anne 	  |A 	      |101       |
|106   |Ron 	  |B 	      |101       |
+------+----------+-----------+----------+


+-------+
| Name  |
+-------+
| John  |
+-------+

     */
}
