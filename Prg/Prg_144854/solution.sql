SELECT b.book_id, a.author_name, date_format(b.published_date, "%Y-%m-%d")
from book as b
join author as a on a.author_id = b.author_id
where b.category in ("경제")
order by b.published_date asc;
