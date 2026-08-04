with rnk_table as (
    select
        row_number() over (partition by category order by price desc) as rnk,
        category,
        price,
        product_name
    from food_product
)
select 
    category,
    price as max_price,
    product_name
from rnk_table
where rnk = 1
and category in ('과자','국','김치','식용유')
order by price desc