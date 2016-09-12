-- Merchant table 

create table MERCHANT (
	ID varchar(30) not null,
	COMMON_NAME nvarchar(80) not null,
	ORGANISATION_NAME nvarchar(80) not null,
	ORGANISATION_NUMBER varchar(20) not null,
	FK_ORIGINATOR char(4) not null,
	ACCOUNT_NUMBER nvarchar(80),
	SOCIAL_SECURITY_NUMBER nvarchar(80),
	ORGANIZATION_NUMBER nvarchar(80),
	MOBILE_ACCESS bit not null,
	STATUS nvarchar(100) not null,
	CA_DN nvarchar(160),
	AUTH_CER varbinary(max),
	SIGN_CER varbinary(max),
	PUBLISH_CATEGORY nvarchar(500),
	STATUS_TIME datetime,
	FIRST_ACTIVATED datetime,
	CERT_EXPIRY datetime,
	FK_MERCHANT_CATEGORY int,
	
	primary key(ID),
	constraint FK_MERCHANT_ORIGINATOR foreign key (FK_ORIGINATOR) references ORIGINATOR(ID),
	constraint FK_MERCHANT_MERCHANT_CATEGORY foreign key (FK_MERCHANT_CATEGORY) references MERCHANT_CATEGORY(ID)
) ;
