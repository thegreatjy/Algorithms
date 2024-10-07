-- 3;50-53
-- 코드를 입력하세요
-- 2022년 10월 5일에 등록된 중고거래 게시물
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
       (
           CASE
               WHEN STATUS = 'SALE' THEN '판매중'
               WHEN STATUS = 'RESERVED' THEN '예약중'
               WHEN STATUS = 'DONE' THEN '거래완료'
               END
           ) AS STATUS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID desc
;