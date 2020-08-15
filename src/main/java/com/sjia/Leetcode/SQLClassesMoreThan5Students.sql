#596. Classes More Than 5 Students
# https://leetcode.com/problems/classes-more-than-5-students/


# Runtime: 321 ms, faster than 57.80% of MySQL online submissions for Classes More Than 5 Students.
select class
from courses
group by class
having count(distinct student) >=5 ;
