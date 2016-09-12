-- PRODUCT_TYPE table

create table PRODUCT_TYPE (
	ID int not null,
	NAME nvarchar(500) not null,
	primary key(ID) 
) ;

insert into PRODUCT_TYPE (ID, NAME) values (0, 'Unknown');
insert into PRODUCT_TYPE (ID, NAME) values (1, 'Basis');
insert into PRODUCT_TYPE (ID, NAME) values (2, 'BankAxxess');
insert into PRODUCT_TYPE (ID, NAME) values (3, 'B2B');

alter table MERCHANT add FK_PRODUCT_TYPE int default 0;
alter table MERCHANT add constraint FK_PRODUCT_TYPE_PRODUCT_TYPE foreign key (FK_PRODUCT_TYPE) references PRODUCT_TYPE(ID);

