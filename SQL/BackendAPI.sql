/*******************************************************************************
   BankApplication Database
   Script: BackEndAPI.sql
   Description: Creates and populates the relevant database.
   DB Server: MySQL
   Author: Jerome Zhang
********************************************************************************/

/*
** Create Tables
*/

drop table if exists Items;
drop table if exists Orders;

create table Orders(
 KeyID serial primary key,
 orderID int unique,
 ShipDate timestamp,
 Accepted bool default False,
 Deleted bool default False
);

create table Items(
 KeyID serial primary key,
 item_name varchar(50) not null,
 Price numeric(10,2) not null,
 SKU numeric(9) unique not null,
 Quantity int,
 orderID int,
 catalog boolean default False
 );

/*
** Populate Tables
*/
insert into Orders(orderID, Accepted, Deleted) values (1, false, false);
insert into Items (item_name, Price, SKU, Quantity, orderID) values ("fishing rod", 29.99, 123456789, 3, 1);
insert into Items (item_name, Price, SKU, Quantity, orderID) values ("playstation", 299.99, 11111111, 1, 1);

-- testing 
insert into Orders(orderID, Accepted, Deleted) values (2, false, false);
insert into Items (item_name, Price, SKU, Quantity, orderID) values ("object1", 29.99, 999999999, 3, 2);
insert into Items (item_name, Price, SKU, Quantity, orderID) values ("object2", 299.99, 99999998, 1, 2);


select * from Orders;
-- delete from Orders where orderID=2;
-- select * from bankDB.Items where orderID = 1;