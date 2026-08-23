# Write your MySQL query statement below
SELECT c.category, COUNT(a.account_id) AS accounts_count
FROM (
    SELECT "Low Salary" AS category
    UNION ALL 
    SELECT "Average Salary"
    UNION ALL
    SELECT "High Salary"
) c LEFT JOIN (
    SELECT account_id, 
    CASE
        WHEN income < 20000 THEN "Low Salary"
        WHEN income <= 50000 THEN "Average Salary"
        ELSE "High Salary"
    END AS category
    FROM Accounts
) a
    ON a.category = c.category
GROUP BY c.category;
