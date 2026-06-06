-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, count(*) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(START_DATE) in (8, 9, 10) AND (car_id in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where month(start_date) in (8,9,10)
    group by car_id
    having count(*) >= 5
))
GROUP BY CAR_ID, MONTH(START_DATE)
HAVING RECORDS > 0
ORDER BY MONTH, CAR_ID DESC
