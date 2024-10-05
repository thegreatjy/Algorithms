-- 코드를 작성해주세요
-- 각 분기(QUARTER)별 분화된 대장균의 개체의 총 수(ECOLI_COUNT)
SELECT
    (concat(
            CASE
                WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN 1 AND 3 THEN '1'
        WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN 4 AND 6 THEN '2'
        WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN 7 AND 9 THEN '3'
        ELSE '4'
    END
    , 'Q')

        ) AS QUARTER,
    (COUNT(ID)) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY QUARTER asc
;