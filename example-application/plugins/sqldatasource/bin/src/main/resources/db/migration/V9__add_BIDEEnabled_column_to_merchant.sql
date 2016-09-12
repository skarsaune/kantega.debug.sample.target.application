-- Add columns needed for representing BIDE enabled flag from Nets --

alter table MERCHANT
add NIBE_ENABLED bit not null default 0;
