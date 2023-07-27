CREATE TABLE Account (
                         accountID int NOT NULL AUTO_INCREMENT,
                         customerID int DEFAULT NULL,
                         balance decimal(10,2) DEFAULT NULL,
                         currency varchar(3) DEFAULT NULL,
                         PRIMARY KEY (accountID)
);

CREATE TABLE Customer (
                          id int NOT NULL AUTO_INCREMENT,
                          name varchar(255) NOT NULL,
                          email varchar(255) DEFAULT NULL,
                          address varchar(2000) DEFAULT NULL,
                          dob date DEFAULT NULL,
                          phone varchar(100) DEFAULT NULL,
                          PRIMARY KEY (id)
);