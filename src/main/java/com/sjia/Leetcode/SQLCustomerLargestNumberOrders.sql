#586 Customer Placing the Largest Number of Orders
# https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/

# Query the customer_number from the orders table for the customer who has placed the largest number of orders.

select o.customer_number
from orders o
group by o.customer_number
order by count(1) desc
limit(1)


# multiple with same max number

SELECT customer_number
FROM orders
GROUP BY customer_number
HAVING COUNT(1) = (SELECT COUNT(1)
                   FROM orders
                   GROUP BY customer_number
                   ORDER BY COUNT(1) DESC
                   LIMIT 1)




The orders table is defined as follows:

| Column            | Type      |
|-------------------|-----------|
| order_number (PK) | int       |
| customer_number   | int       |
| order_date        | date      |
| required_date     | date      |
| shipped_date      | date      |
| status            | char(15)  |
| comment           | char(200) |

Sample Input
| order_number | customer_number | order_date | required_date | shipped_date | status | comment |
|--------------|-----------------|------------|---------------|--------------|--------|---------|
| 1            | 1               | 2017-04-09 | 2017-04-13    | 2017-04-12   | Closed |         |
| 2            | 2               | 2017-04-15 | 2017-04-20    | 2017-04-18   | Closed |         |
| 3            | 3               | 2017-04-16 | 2017-04-25    | 2017-04-20   | Closed |         |
| 4            | 3               | 2017-04-18 | 2017-04-28    | 2017-04-25   | Closed |         |

Sample Output

| customer_number |
|-----------------|
| 3               |