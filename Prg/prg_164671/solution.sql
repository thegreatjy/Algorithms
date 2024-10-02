-- 코드를 입력하세요
-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
SELECT concat('/home/grep/src/', f.BOARD_ID, '/', f.FILE_ID, f.FILE_NAME, f.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE f
JOIN (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS desc
    LIMIT 1
) b ON f.BOARD_ID = b.BOARD_ID
ORDER BY f.FILE_ID desc
;