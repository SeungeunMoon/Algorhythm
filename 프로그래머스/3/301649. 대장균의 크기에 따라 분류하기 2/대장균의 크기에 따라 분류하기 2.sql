with subecoli as(
    select 
        id,
        ntile(4) over (order by size_of_colony desc) as part
    from ecoli_data
)  
select 
    id,
    case 
        when part = 1 then 'CRITICAL'
        when part = 2 then 'HIGH'
        when part = 3 then 'MEDIUM'
        when part = 4 then 'LOW'
    end as colony_name  
from subecoli
order by id;

