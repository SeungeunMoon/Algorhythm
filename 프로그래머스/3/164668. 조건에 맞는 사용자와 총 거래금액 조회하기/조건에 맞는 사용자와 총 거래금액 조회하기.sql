select b.writer_id, u.nickname, sum(b.price)
from used_goods_board as b
join used_goods_user as u
on b.writer_id = u.user_id
where b.status = "DONE"
group by b.writer_id
having sum(b.price) >= 700000
order by sum(b.price)
