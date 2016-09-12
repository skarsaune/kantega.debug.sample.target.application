-- Add columns needed for representing FOI ACL values from Nets --

alter table MERCHANT
add AC_ORGNR bit not null default 0;

alter table MERCHANT
add AC_ACCNR bit not null default 0;

alter table MERCHANT
add AC_SSN bit not null default 0;

alter table MERCHANT
add COUNTRY_CODES nvarchar(100) not null default '';