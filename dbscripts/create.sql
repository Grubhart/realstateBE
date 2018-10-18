CREATE TABLE HOME
(
    ID int NOT NULL,
    state_name varchar(20),
    stateAbr varchar(10),
    specialOffer boolean,
    street_address varchar(200),
    city varchar(20),
    zip_code varchar(7)
);
CREATE UNIQUE INDEX HOME_ID_HOME_uindex ON HOME (ID);
