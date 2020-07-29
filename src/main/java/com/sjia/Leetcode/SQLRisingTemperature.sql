#197. Rising Temperature
#https://leetcode.com/problems/rising-temperature/


#Runtime: 828 ms, faster than 20.56% of MySQL online submissions for Rising Temperature.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rising Temperature.

select w2.Id
from Weather w1, Weather w2
where DATEDIFF(w2.RecordDate, w1.RecordDate) = 1
and w2.Temperature > w1.Temperature;


