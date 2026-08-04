with recursive ecoli as(
    
    select 
        id,
        parent_id, 
        1 as dth
    from ecoli_data
    where parent_id is null
    
    union all
    
    select
        c.id, 
        c.parent_id, 
        p.dth+1 as dth
    from ecoli_data c   
    inner join ecoli p on c.parent_id = p.id   
) 
select count(*), dth as generation
from ecoli
where not exists (
    select 1 from ecoli s
    where ecoli.id = s.parent_id
)
group by generation





