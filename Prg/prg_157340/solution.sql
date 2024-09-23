-- 코드를 입력하세요
select CAR_ID,
       case
           when (sum(
                         CASE
                             WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' THEN 1
                             ELSE 0
                             END) > 0) then '대여중'
           else '대여 가능'
           end as AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID desc
;