SELECT product_id, product_name, product_cd, category, price
from FOOD_PRODUCT
where price in (select max(price) from FOOD_PRODUCT);
