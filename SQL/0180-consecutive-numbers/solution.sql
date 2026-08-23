# Write your MySQL query statement below
SELECT DISTINCT L1.num AS ConsecutiveNums
FROM Logs L1
INNER JOIN Logs L2
    ON L1.num = L2.num AND L2.id = L1.id + 1
INNER JOIN Logs L3
    ON L3.num = L2.num AND L3.id = L2.id + 1;
