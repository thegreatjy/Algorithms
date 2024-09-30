-- 코드를 입력하세요
-- 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력
SELECT car.CAR_ID, car.CAR_TYPE, round(((car.DAILY_FEE * 30) * (100 - cast(replace(plan.DISCOUNT_RATE, '%', '') AS unsigned integer)) / 100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR car
JOIN (
    SELECT CAR_ID, count(
            CASE
                WHEN start_date <= '2022-11-30' AND end_date >= '2022-11-01' THEN 1
                ELSE NULL
                END
                   ) AS cnt
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    GROUP BY CAR_ID
    HAVING cnt = 0
) rent ON car.CAR_ID = rent.CAR_ID

JOIN (
    SELECT DURATION_TYPE, DISCOUNT_RATE, CAR_TYPE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE (CAR_TYPE = '세단' OR CAR_TYPE = 'SUV')
      AND DURATION_TYPE like '30%'
) plan ON car.CAR_TYPE = plan.CAR_TYPE

GROUP BY car.CAR_ID
HAVING 500000 <= FEE AND FEE <= 2000000

ORDER BY FEE desc, CAR_TYPE asc, CAR_ID desc
;