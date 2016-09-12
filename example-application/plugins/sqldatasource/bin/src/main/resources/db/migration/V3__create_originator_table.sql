-- Originator table 

create table ORIGINATOR (
	ID char(4) not null,
	NAME nvarchar(500) not null,
	FK_CAGROUP int,
	primary key(ID),
	constraint FK_ORIGINATOR_CAGROUP foreign key (FK_CAGROUP) references CAGROUP(ID) 
/*, syntax not valid for SQL Server
	check (length(ID) = 4 ),
	check (length(NAME) > 0 ), */ 
) ;
/* Not valid in SQL server
comment on table ORIGINATOR is 'BankID Originator / Utsteder';
comment on column ORIGINATOR.ID is 'ID of the Originator, 4 digit Norwegian Bankregister code';
comment on column ORIGINATOR.NAME is 'Name of the Originator';
*/