#595. Big Countries
#https://leetcode.com/problems/big-countries/

#Runtime: 293 ms, faster than 62.86% of MySQL online submissions for Big Countries.
select name,  population, area
from World
where World.area > 3000000 OR World.population >25000000 ;


#Runtime: 361 ms, faster than 29.05% of MySQL online submissions for Big Countries.
select name,  population, area
from World
where World.area > 3000000
UNION
select name,  population, area
from World
where World.population >25000000 ;

