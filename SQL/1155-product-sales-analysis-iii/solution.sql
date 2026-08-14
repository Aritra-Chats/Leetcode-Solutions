# Write your MySQL query statement below
SELECT S.product_id, Sub.first_year, S.quantity, S.price
FROM Sales S INNER JOIN (
    SELECT product_id, MIN(year) AS first_year
    FROM Sales
    GROUP BY product_id
) Sub
    ON Sub.product_id = S.product_id AND Sub.first_year = S.year;
