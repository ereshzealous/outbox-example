START TRANSACTION;

INSERT INTO users (full_name, email, mobile_number, gender) values ('Tom Cruise', 'tom.cruise@gmail.com', '+919160012345', 'Male');
INSERT INTO users (full_name, email, mobile_number, gender) values ('John Wick', 'john.wick@hotmail.com', '+919160012346', 'Male');
INSERT INTO users (full_name, email, mobile_number, gender) values ('Jason Bourne', 'jason.bourne@gmail.com', '+919160012347', 'Male');
INSERT INTO users (full_name, email, mobile_number, gender) values ('Black Widow', 'black.widow@gmail.com', '+919160012348', 'Female');
INSERT INTO users (full_name, email, mobile_number, gender) values ('Harley Quinn', 'harley.quinn@gmail.com', '+919160012340', 'Female');

COMMIT;
