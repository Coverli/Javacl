CREATE DATABASE LoginCase;

USE LoginCase;

CREATE TABLE USER (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR (32) UNIQUE NOT NULL,
    password VARCHAR (32) NOT NULL
);

INSERT INTO USER VALUES (1, 'cl', '123');