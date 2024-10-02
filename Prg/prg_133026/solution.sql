-- 코드를 입력하세요
-- 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을
-- 총주문량이 작은 순서대로 조회
SELECT i.INGREDIENT_TYPE, (SUM(f.TOTAL_ORDER)) AS TOTAL_ORDER
FROM FIRST_HALF f
JOIN ICECREAM_INFO i ON i.FLAVOR = f.FLAVOR
GROUP BY i.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER asc
;