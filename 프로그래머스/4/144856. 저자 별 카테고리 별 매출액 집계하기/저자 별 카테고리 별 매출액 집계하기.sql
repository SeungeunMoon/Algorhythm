select a.author_id, author_name, category, sum(sales * price) as total_sales
from book_sales s
join book b on b.book_id = s.book_id
join author a on a.author_id = b.author_id
where year(sales_date) = 2022 and month(sales_date) = 1
group by author_id, category
order by author_id, category desc;