package com.sjia.Leetcode;

public class SQLGamePlay3 {
    // #534 https://leetcode.com/problems/game-play-analysis-iii/

    // Write an SQL query that reports for each player and date,
    // how many games played so far by the player. the total number of games played by the player until that date.



    /*
select t1.player_id, t1.event_date, sum(t2.games_played) as games_played_so_far
from Activity as t1 inner join Activity as t2
on t1.player_id = t2.player_id
where t1.event_date >= t2.event_date
group by t1.player_id, t1.event_date

     */




    /*
    Activity table:
+-----------+-----------+------------+--------------+
| player_id | device_id | event_date | games_played |
+-----------+-----------+------------+--------------+
| 1         | 2         | 2016-03-01 | 5            |
| 1         | 2         | 2016-05-02 | 6            |
| 1         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+

Result table:
+-----------+------------+---------------------+
| player_id | event_date | games_played_so_far |
+-----------+------------+---------------------+
| 1         | 2016-03-01 | 5                   |
| 1         | 2016-05-02 | 11                  |
| 1         | 2017-06-25 | 12                  |
| 3         | 2016-03-02 | 0                   |
| 3         | 2018-07-03 | 5                   |
+-----------+------------+---------------------+
     */

}
