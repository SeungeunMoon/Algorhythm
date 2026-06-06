-- 코드를 입력하세요
SELECT MCDP_CD AS 진료과코드, COUNT(*) as 5월예약건수
FROM APPOINTMENT
where month(apnt_ymd) = 5
GROUP BY mcdp_cd
ORDER BY 5월예약건수, 진료과코드