select * from offices;
select * from cities;
select * from hotels;
select * from tours;
select * from price_lists;
select o.name, o.adress, o.phone_number, o.FIO, t.type,pr.cost
                    from price_lists pr
                    inner join tours t on pr.tour_id =t.tour_id
                    inner join offices o on t.office_name = o.name
                    where date = "2018-07-23"


