drop table SHOP_PRODUCT;
select * from SHOP_PRODUCT;

create table shop_product(
  id varchar2(40) primary key ,
  productName varchar2(20) not null ,
  price number(7,2),
  picpath varchar2(40),
  discription varchar2(40)
);