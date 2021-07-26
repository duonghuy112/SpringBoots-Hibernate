DROP SCHEMA IF EXISTS `hb-01-one-to-one`;
CREATE SCHEMA `hb-01-one-to-one`;

USE `hb-01-one-to-one`;

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE `instructor_detail` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`chanel` VARCHAR(45),
	`hooby` VARCHAR(45),
    PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(45),
	`last_name` VARCHAR(45),
    `email` VARCHAR(45),
    `instructor_detail_id` INT(11),
    PRIMARY KEY(`id`),
    KEY `FK_DETAIL_idx` (`instructor_detail_id`),
    CONSTRAINT `FK_Detail` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`)
    ON UPDATE NO ACTION ON DELETE NO ACTION
);