#196. Delete Duplicate Emails
#https://leetcode.com/problems/delete-duplicate-emails/submissions/

# Runtime: 2122 ms, faster than 47.87% of MySQL online submissions for Delete Duplicate Emails.
delete p2
from Person p1, Person p2
where p1.Email = p2.Email and p2.Id > p1.Id;

