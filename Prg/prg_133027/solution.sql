-- 코드를 입력하세요
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이
-- 큰 순서대로 상위 3개의 맛을 조회
SELECT j.FLAVOR
FROM (
     SELECT FLAVOR, SUM(TOTAL_ORDER) AS TSUM
     FROM JULY
     GROUP BY FLAVOR
) j
JOIN FIRST_HALF h ON h.FLAVOR = j.FLAVOR
ORDER BY (h.TOTAL_ORDER + j.TSUM) desc
LIMIT 3
;