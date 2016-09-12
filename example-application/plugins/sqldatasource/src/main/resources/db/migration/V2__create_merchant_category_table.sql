-- Originator table 

create table MERCHANT_CATEGORY (
	ID int not null,
	NAME nvarchar(500) not null,
	primary key(ID) /*, Syntax not valid for SQL Server
	check( length(NAME) > 0 ) */
) ;
/* Syntax not valid for SQL Server
comment on table MERCHANT_CATEGORY is 'Allowed values for BankID merchant category';
comment on column MERCHANT_CATEGORY.ID is 'Numeric ID of merchant category';
comment on column MERCHANT_CATEGORY.NAME is 'Description of merchant category';
*/