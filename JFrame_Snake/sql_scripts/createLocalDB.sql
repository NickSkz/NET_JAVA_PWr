DROP DATABASE IF EXISTS `java_snake`;
CREATE DATABASE `java_snake`;
USE `java_snake`;

SET NAMES utf8 ;

CREATE TABLE `entries`(
`entry_id` INT NOT NULL AUTO_INCREMENT,
`nickname` VARCHAR(999) NOT NULL,
`points` INT,
`time` INT,
`overall` INT, 
`date` DATETIME,
PRIMARY KEY(`entry_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE USER 'USER'@localhost IDENTIFIED BY 'user1';
GRANT ALL PRIVILEGES ON java_snake.* TO 'USER'@'localhost';