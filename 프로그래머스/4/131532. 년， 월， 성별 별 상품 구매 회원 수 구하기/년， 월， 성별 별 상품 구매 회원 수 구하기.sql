select year(SALES_DATE) as year, month(SALES_DATE) as month, gender, count(distinct o.user_id) as users
from online_sale o
join user_info u on o.user_id = u.user_id
where gender is not null
group by year(SALES_DATE), month(SALES_DATE), gender
order by year(SALES_DATE), month(SALES_DATE), gender