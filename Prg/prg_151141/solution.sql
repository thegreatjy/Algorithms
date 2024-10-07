-- 코드를 입력하세요
-- 3;53 - 4;28
-- -자동차 종류가 '트럭'
-- 대여 기록 별로 대여 금액(컬럼명: FEE)을 구하여 대여 기록 ID와 대여 금액 리스트를 출력
SELECT HISTORY_ID,
       ROUND(c.DAILY_FEE * DIFF * (100-IFNULL(DISCOUNT_RATE, 0))/100, 0) AS FEE
FROM (
         SELECT HISTORY_ID, CAR_ID, DATEDIFF(END_DATE, START_DATE) + 1 AS DIFF,
                CASE
                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 7 THEN NULL
                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 30 THEN '7일 이상'
                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 90 THEN '30일 이상'
                    ELSE '90일 이상'
                    END DURATION_TYPE
         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
     ) h
         JOIN CAR_RENTAL_COMPANY_CAR c ON c.CAR_ID = h.CAR_ID
         LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
                   ON d.DURATION_TYPE = h.DURATION_TYPE AND d.CAR_TYPE = c.CAR_TYPE

WHERE c.CAR_TYPE = '트럭'

ORDER BY FEE desc, HISTORY_ID desc
;