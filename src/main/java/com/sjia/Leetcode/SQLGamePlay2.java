package com.sjia.Leetcode;

public class SQLGamePlay2 {
    // #512    https://leetcode.com/problems/game-play-analysis-ii/

    /*


    select distinct player_id, device_id
    from Activity
    where (player_id, event_date ) in
    SELECT player_id, device_id MIN( event_date)
    FROM Activity
    GROUP BY player_id )


    # can we use below
    select distinct player_id, device_id
    From (
    SELECT player_id, device_id MIN( event_date)
        FROM Activity
        GROUP BY player_id )
    ) tmp
    Where  player_id = tmp.player_id
    And device_id = tmp.device_id


     */





    /*
    Write a SQL query that reports the device that is first logged in for each player.
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
(player_id, event_date) is the primary key of this table.

Result table:
+-----------+-----------+
| player_id | device_id |
+-----------+-----------+
| 1         | 2         |
| 2         | 3         |
| 3         | 1         |
+-----------+-----------+


     */

}
