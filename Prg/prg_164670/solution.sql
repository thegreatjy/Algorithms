-- 코드를 입력하세요
-- 중고 거래 게시물을 3건 이상 등록한 사용자
-- 전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력되도록 해주시고,
-- 전화번호의 경우 xxx-xxxx-xxxx 같은 형태로 하이픈 문자열(-)을 삽입
SELECT u.USER_ID, u.NICKNAME,
(concat(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2)) AS '전체주소',
(concat(substring(TLNO, 1, 3), '-', substring(TLNO, 4, 4), '-', substring(TLNO, 8, 4))) AS '전화번호'
FROM USED_GOODS_USER u
JOIN USED_GOODS_BOARD b ON b.WRITER_ID = u.USER_ID
GROUP BY USER_ID
HAVING COUNT(BOARD_ID) >= 3
ORDER BY USER_ID desc
;