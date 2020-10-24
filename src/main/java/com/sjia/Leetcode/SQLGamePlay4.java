package com.sjia.Leetcode;

public class SQLGamePlay4 {
    // #550 https://leetcode.com/problems/game-play-analysis-iv/


    /*
select round(sum(case when t1.event_date = t2.first_event+1 then 1 else 0 end)/count(distinct t1.player_id), 2) as fraction
from Activity as t1 inner join
    (select player_id, min(event_date) as first_event
    from Activity
    group by player_id) as t2
on t1.player_id = t2.player_id
     */



    /*
Write an SQL query that reports the fraction of players that logged in again on the day after the day they first logged in,
rounded to 2 decimal places. In other words, you need to count the number of players that logged in for at least two consecutive days starting from their first login date, then divide that number by the total number of players.
     */
}
