select r.rest_id, r.rest_name, r.food_type, r.favorites, r.address, round(avg(review_score),2)
from rest_info r
join rest_review v on r.rest_id = v.rest_id
where substring(r.address,1,2) = '서울'
group by r.rest_id
order by avg(review_score) desc, r.favorites desc;
