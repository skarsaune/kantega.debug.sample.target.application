-- V5 had inserted data in AGGREGATOR table in a different way for CAGroup than for the other (the columns where swapped)
-- V7_1 did not take this into account, and did not insert an external id for CAGroup

UPDATE AGGREGATOR SET EXTERNAL_ID='CAGroup' WHERE AGGREGATOR_TYPE='CAGroup';
