-- CAGROUP table 

create table CAGROUP (
	ID int not null,
	DNAME nvarchar(160) not null,
	primary key(ID) /*, Syntax not valid for SQL Server
	check( length(NAME) > 0 ) */
) ;
/* Syntax not valid for SQL Server
comment on column CAGROUP.ID is 'Numeric ID of CAGroup';
comment on column CAGROUP.DNAME is 'Distinguished name of CA Group';
*/