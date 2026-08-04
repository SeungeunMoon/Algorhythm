select 
    year(sales_date) as y, 
    month(sales_date) as m, 
    count(distinct o.user_id) as cnt,
    round(count(distinct o.user_id) / (select count(*) from user_info where year(joined) = 2021),1) as pr
from online_sale o
join user_info u on o.user_id = u.user_id
where year(u.joined) = 2021
group by year(sales_date), month(sales_date)
order by year(sales_date), month(sales_date)


