#183. Customers Who Never Order
#https://leetcode.com/problems/customers-who-never-order/

#Runtime: 983 ms, faster than 27.52% of MySQL online submissions for Customers Who Never Order.
#Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.

select c.name AS Customers
from Customers c left outer join Orders o
on c.Id = o.CustomerId
where o.id is null;


#Runtime: 489 ms, faster than 80.71% of MySQL online submissions for Customers Who Never Order.
#Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.

select c.name as 'Customers'
from customers c
where c.id not in
(
    select customerid from orders
);