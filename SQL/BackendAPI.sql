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
 catalog boolean default False,
 foreign key (orderID)
	references Orders (orderID)
 );

insert into Orders(orderID, Accepted, Deleted) values (1, false, false);
insert into Items (item_name, Price, SKU, Quantity, orderID) values ("fishing rod", 29.99, 123456789, 3, 1);
insert into Items (item_name, Price, SKU, Quantity, orderID) values ("playstation", 299.99, 11111111, 1, 1);

select * from Orders;

select * from bankDB.Items where orderID = 1;