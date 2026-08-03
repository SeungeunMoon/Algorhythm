SELECT distinct
    car_id, 
    case 
        when exists (
            select 1
            from CAR_RENTAL_COMPANY_RENTAL_HISTORY sub
            where sub.car_id = main.car_id
                and start_date <= '2022-10-16' and end_date >= '2022-10-16'
        ) then '대여중'
        else '대여 가능'
    end as availability
from CAR_RENTAL_COMPANY_RENTAL_HISTORY main
order by car_id desc
