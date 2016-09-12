-- create reseller table

create table AGGREGATOR (
	ID int identity(1,1) primary key,
	NAME nvarchar(255),
	AGGREGATOR_TYPE varchar(16) not null
);


alter table MERCHANT add FK_AGGREGATOR int;
alter table MERCHANT add constraint FK_AGGREGATOR_AGGREGATOR foreign key (FK_AGGREGATOR) references AGGREGATOR(ID);

insert into AGGREGATOR (NAME, AGGREGATOR_TYPE) values ('BankID', 'BANKID');
insert into AGGREGATOR (NAME, AGGREGATOR_TYPE) values ('DIFI', 'DIFI');
insert into AGGREGATOR (AGGREGATOR_TYPE, NAME ) values ('CAGroup', 'Aggregate by CA group');
