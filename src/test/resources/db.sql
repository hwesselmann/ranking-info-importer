CREATE TABLE RANKING (
  ID bigint auto_increment,
  DTBID varchar(255),
  RANKINGPERIOD date,
  LASTNAME varchar(255),
  FIRSTNAME varchar(255),
  POINTS varchar(255),
  RANKINGPOSITION integer,
  NATIONALITY varchar(255),
  FEDERATION varchar(255),
  CLUB varchar(255),
  AGEGROUP varchar(10),
  YOBRANKINGS boolean,
  OVERALLRANKING boolean,
  ENDOFYEARRANKING boolean
  );
