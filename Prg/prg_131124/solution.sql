-- 코드를 입력하세요
-- 8;19 -
-- 리뷰 가장 많이 작성 회원의 리뷰 조회
-- REVIEW_DATE의 데이트 포맷이 예시와 동일해야 정답처리 됩니다.
-- 8;42-47
-- 나중에 limit1 없이 다시 풀기 rank()

SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE m
         JOIN REST_REVIEW r ON r.MEMBER_ID = m.MEMBER_ID
         JOIN (
    SELECT MEMBER_ID, COUNT(REVIEW_ID) AS CNT
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY CNT desc
        LIMIT 1
) a ON a.MEMBER_ID = r.MEMBER_ID

ORDER BY REVIEW_DATE asc, REVIEW_TEXT asc
;