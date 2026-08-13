# Write your MySQL query statement below
SELECT ROUND(SUM(Sub.OD = D.customer_pref_delivery_date) * 100 / COUNT(*), 2) AS immediate_percentage
FROM 
(SELECT customer_id, MIN(order_date)AS OD FROM Delivery GROUP BY customer_id) Sub
INNER JOIN Delivery D
    ON Sub.customer_id = D.customer_id AND Sub.OD = D.order_date;
