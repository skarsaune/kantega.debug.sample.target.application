-- add EXTERNAL_ID field to AGGREGATOR --
UPDATE AGGREGATOR SET EXTERNAL_ID='BankID' WHERE NAME='BankID';
UPDATE AGGREGATOR SET EXTERNAL_ID='DIFI' WHERE NAME='DIFI';
UPDATE AGGREGATOR SET EXTERNAL_ID='CAGroup' WHERE NAME='CAGroup';
