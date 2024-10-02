-- 코드를 입력하세요
-- 개는 이름에 'el'
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog'
AND lower(NAME) like '%el%'
ORDER BY NAME asc
;