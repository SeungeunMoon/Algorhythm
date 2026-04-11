-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', f.board_id, '/', f.file_id,f.file_name,f.file_ext) as file_path
FROM USED_GOODS_BOARD AS B
JOIN USED_GOODS_FILE AS F
ON B.BOARD_ID = F.BOARD_ID
where b.views = (
    select  max(views) 
    from USED_GOODS_BOARD
)
order by f.file_id desc