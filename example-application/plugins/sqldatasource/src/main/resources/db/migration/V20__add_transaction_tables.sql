-- Start numbering for phase 2 from 30 so that any remaining changes for phase 1 can come in between in production

create table ORIGINATOR_STATS (
	ID varchar(50) not null,
	PERIOD date not null,
	FK_ORIGINATOR char(9) not null,
	MONTHLY bit not null,
	BIM_OTP_TRANS int(9) not null,
	PERSON_CERT int(9) not null,
	EMPLOYEE_CERT int(9) not null,
	MOBILE_CERT int(9) not null,
	
	primary key(ID),
	constraint FK_STATS_ORIGINATOR foreign key (FK_ORIGINATOR) references ORIGINATOR(ID),
		
);

create index ORIGINATOR_STAT_PERIOD on ORIGINATOR_STATS (PERIOD, FK_ORIGINATOR, MONTHLY); 

create view MNTH_ORG_STATS as select * from ORIGINATOR_STATS where MONTHLY = 1;
create view DLY_ORG_STATS as select * from ORIGINATOR_STATS where MONTHLY = 0;

create table MERCHANT_TRANSACTIONS (
	ID varchar(100) not null,
	PERIOD date not null,
	FK_MERCHANT varchar(30) not null,
	MONTHLY bit not null,
	ADD_INF_ACT_NO int(9) not null,
	ADD_INF_ORG_NO int(9) not null,
	ADD_INF_SSN int(9) not null,
	EMP_MER_AUT int(9) not null,
	EMP_MER_SIG int(9) not null,
	MER_EMP_AUT int(9) not null,
	MER_EMP_SIG int(9) not null,
	MER_MER_AUT int(9) not null,
	MER_MER_SIG int(9) not null,
	MOB_MER_AUT int(9) not null,
	MOB_MER_SIG int(9) not null,
	MER_MOB_AUT int(9) not null,
	MER_MOB_SIG int(9) not null,
	MER_PER_AUT int(9) not null,
	MER_PER_SIG int(9) not null,
	PER_MER_AUT int(9) not null,
	PER_MER_SIG int(9) not null,

	primary key(ID),
	constraint FK_TRANS_MERCHANT foreign key (FK_MERCHANT) references MERCHANT(ID),
	
);

create index MERCHANT_TRANSACTION_PERIOD on MERCHANT_TRANSACTIONS (PERIOD, FK_MERCHANT, MONTHLY); 

create view DLY_MERCH_TRANS as select * from MERCHANT_TRANSACTIONS where MONTHLY = 0;
create view MNTH_MERCH_TRANS as select * from MERCHANT_TRANSACTIONS where MONTHLY = 1;

