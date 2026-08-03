select d.dept_id, d.dept_name_en, round(avg(sal))
from hr_employees h
join hr_department d on h.dept_id = d.dept_id
group by h.dept_id
order by avg(sal) desc