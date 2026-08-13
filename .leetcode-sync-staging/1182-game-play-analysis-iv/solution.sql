# Write your MySQL query statement below
SELECT ROUND(COUNT(Sub.player_id) / COUNT(DISTINCT A.player_id), 2) AS fraction
FROM Activity A LEFT JOIN
(
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
) SUB
    ON A.player_id = Sub.player_id AND A.event_date = DATE_ADD(Sub.first_date, INTERVAL 1 DAY);
