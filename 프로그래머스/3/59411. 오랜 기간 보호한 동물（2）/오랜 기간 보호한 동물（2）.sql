select
    animal_id,
    name
from (
    select 
        o.animal_id,
        o.name, row_number() over (order by datediff(o.datetime, i.datetime) desc) as rnk
    from animal_outs o
    left join animal_ins i on i.animal_id = o.animal_id
) sub
where rnk <= 2
order by rnk