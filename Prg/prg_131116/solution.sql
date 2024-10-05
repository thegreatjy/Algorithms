-- 코드를 입력하세요
-- 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회
-- 식품분류가 '과자', '국', '김치', '식용유'
SELECT p.CATEGORY, (j.MAX_P) AS MAX_PRICE, p.PRODUCT_NAME
FROM FOOD_PRODUCT p
JOIN
(
    SELECT CATEGORY, MAX(PRICE) AS MAX_P
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
) j ON p.CATEGORY = j.CATEGORY
WHERE p.PRICE = j.MAX_P
ORDER BY MAX_PRICE desc
;