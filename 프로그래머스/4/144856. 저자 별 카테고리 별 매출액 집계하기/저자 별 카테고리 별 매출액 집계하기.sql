select book.author_id, author.author_name, category, sum(price * sales) as total_sales
from book
join author on author.author_id = book.author_id
join book_sales on book.book_id = book_sales.book_id
where year(sales_date) = 2022 and month(sales_date) = 1
group by author_id, category
order by author_id, category desc;