SELECT C.CAR_ID, C.CAR_TYPE,((1-0.01*(replace(D.DISCOUNT_RATE,"%",""))) * C.daily_fee * 30) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS C
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS D
ON C.CAR_TYPE = D.CAR_TYPE
WHERE (c.car_id NOT IN (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where (
        (start_date <= '2022-11-01' and end_date > '2022-11-01') or
        (start_date >= '2022-11-01' and start_date <= '2022-11-30') 
    )))
AND (c.car_type in ('SUV','세단'))
AND (((1-0.01*(replace(D.DISCOUNT_RATE,"%",""))) * C.daily_fee * 30)  >= 500000 
     and 
     (((1-0.01*(replace(D.DISCOUNT_RATE,"%",""))) * C.daily_fee * 30)  < 2000000))
AND (D.DURATION_TYPE = '30일 이상')
order by fee desc, c.car_type, c.car_id desc



