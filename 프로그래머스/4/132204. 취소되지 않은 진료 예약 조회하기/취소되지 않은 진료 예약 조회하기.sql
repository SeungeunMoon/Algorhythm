select apnt_no, pt_name, p.pt_no, d.mcdp_cd, dr_name, apnt_ymd
from appointment as a
join patient as p on a.pt_no = p.pt_no
join doctor as d on a.mddr_id = d.dr_id
where apnt_ymd like '2022-04-13%' and APNT_CNCL_YN = 'N'
order by apnt_ymd