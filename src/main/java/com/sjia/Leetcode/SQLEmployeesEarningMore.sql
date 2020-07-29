
#181 https://leetcode.com/problems/employees-earning-more-than-their-managers/

select a.Name as Employee
From Employee a right outer join Employee b
On a.ManagerId = b.Id
Where a.Salary > b.Salary



SELECT
     a.NAME AS Employee
FROM Employee AS a JOIN Employee AS b
     ON a.ManagerId = b.Id
     AND a.Salary > b.Salary;


select e.Name as Employee
from Employee e, Employee m
where e.ManagerId is not NULL and
e.ManagerId = m.ID and e.Salary > m.Salary
