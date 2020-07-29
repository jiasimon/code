#182. Duplicate Emails
#https://leetcode.com/problems/duplicate-emails/

#Runtime: 351 ms, faster than 77.88% of MySQL online submissions for Duplicate Emails.
#Memory Usage: 0B, less than 100.00% of MySQL online submissions for Duplicate Emails.

select Email
from Person a
group by a.Email
having count(a.Email)>1;


#Runtime: 427 ms, faster than 50.87% of MySQL online submissions for Duplicate Emails.
#Memory Usage: 0B, less than 100.00% of MySQL online submissions for Duplicate Emails.

select distinct p1.Email
from Person as p1,Person as p2
where p1.Email =p2.Email and p1.Id!=p2.Id;