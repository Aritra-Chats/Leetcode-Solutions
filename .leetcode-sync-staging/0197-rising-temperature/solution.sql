# Write your MySQL query statement below
SELECT DISTINCT W1.id FROM Weather W1 JOIN Weather W2 
ON W2.recordDate = DATE_SUB(W1.recordDate, INTERVAL 1 DAY) 
WHERE W1.temperature > W2.temperature;
