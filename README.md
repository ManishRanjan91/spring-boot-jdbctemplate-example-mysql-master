create database
______________________
CREATE DATABASE testdb;

create table in database
______________________
use testdb;
CREATE TABLE traningCenter
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    centerName VARCHAR(255),
    centerCode VARCHAR(255),
    address VARCHAR(255),
    studentCapacity VARCHAR(255),
    coursesOffered BIGINT,
    contactEmail VARCHAR(255),
    contactPhone VARCHAR(255),
    creaytedOn timestamp default now()
);

run project
___________________

mvn spring-boot:run