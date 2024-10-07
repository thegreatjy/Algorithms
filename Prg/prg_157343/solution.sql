-- 코드를 입력하세요
-- '네비게이션' 옵션이 포함된 자동차 리스트를 출력
-- 3;49-50
SELECT CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS like '%네비게이션%'
ORDER BY CAR_ID desc
;