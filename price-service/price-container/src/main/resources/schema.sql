drop table prices;

create table prices
(
    brand_id integer not null ,
    start_date timestamp not null ,
    end_date timestamp not null ,
    price_list integer not null ,
    product_id integer not null ,
    priority integer not null ,
    price double precision not null ,
    curr varchar(3) not null,
    primary key (price_list)
);