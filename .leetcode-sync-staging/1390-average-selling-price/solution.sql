# Write your MySQL query statement below
select P.product_id, if(sum(U.units) > 0, round((sum(P.price * U.units) / sum(U.units)), 2), 0) as average_price 
    from Prices as P left join UnitsSold as U 
    on P.product_id = U.product_id AND U.purchase_date between P.start_date and P.end_date
    group by P.product_id;
