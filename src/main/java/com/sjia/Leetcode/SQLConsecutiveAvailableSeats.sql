#603 Consecutive Available Seats
# https://leetcode.com/problems/consecutive-available-seats/


#Cross join 2 cinema tables to iterate all possible seat pairs

select distinct seat_id
from cinema c1, cinema c2
where c1.free = 1
and c2.free = 1
and ( c1.seat_id = c2.seat_id + 1 or c1.seat_id = c2.seat_id - 1 )
order by seat_id



Several friends at a cinema ticket office would like to reserve consecutive available seats.
Can you help to query all the consecutive available seats order by the seat_id
using the following cinema table?

| seat_id | free |
|---------|------|
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |


| seat_id |
|---------|
| 3       |
| 4       |
| 5       |

