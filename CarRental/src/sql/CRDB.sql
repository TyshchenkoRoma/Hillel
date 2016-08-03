 CREATE DATABASE CRDB;
 use CRDB;

 CREATE TABLE Car ( Model   VARCHAR(20), Color  VARCHAR(20), Description VARCHAR(20),  YearOfManufacture INT, YearOfManufacture INT, Rent_price INT, Id INT);
 CREATE TABLE Administrator ( FirstName   VARCHAR(20), SecondName VARCHAR(20), id_client INT);
 CREATE TABLE Clients ( FirstName   VARCHAR(20), SecondName VARCHAR(20), age int, id int);

 INSERT INTO Car(Model, Color, Description, YearOfManufacture, Rent_price, id) VALUES ( 'Renault11', 'RED', 'Description for renault 11', 1986, 100,2 );
 INSERT INTO Car(Model, Color, Description, YearOfManufacture, Rent_price, id) VALUES ( 'Mers 160A', 'DARK', 'Description for meren', 1999, 200,3 );
 INSERT INTO Car(Model, Color, Description, YearOfManufacture, Rent_price, id) VALUES ( 'Lanos', 'BLUE', 'Description for lanos', 2011, 150,4 );