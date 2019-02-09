CREATE DATABASE `hospitalregistry`;

USE `hospitalregistry`;

CREATE TABLE `Patient` (
	`patMobile` numeric(15) NOT NULL,
	`patName` varchar(50) NOT NULL,
	`patPassword` varchar(20) NOT NULL,
	`patLocation` varchar(20) NOT NULL,
	PRIMARY KEY (`patMobile`)
);

CREATE TABLE `Doctor` (
	`docMobile` numeric(15) NOT NULL,
	`docName` varchar(50) NOT NULL,
	`docPassword` varchar(20) NOT NULL,
	`docLocation` varchar(20) NOT NULL,
	`docSpecialization` varchar(20) NOT NULL,
	`docDays` int NOT NULL,
	PRIMARY KEY (`docMobile`)
);

CREATE TABLE `Appointment` (
	`appID` int NOT NULL AUTO_INCREMENT,
	`patMobile` numeric(15) NOT NULL,
	`docMobile` numeric(15) NOT NULL,
	`appDate` DATE NOT NULL,
	`appStatus` bool NOT NULL,
	PRIMARY KEY (`appID`)
);

CREATE TABLE `Reports` (
	`repID` int NOT NULL AUTO_INCREMENT,
	`appID` int NOT NULL,
	`techMobile` numeric(15) NOT NULL,
	`testName` varchar(50) NOT NULL,
	`repStatus` bool NOT NULL,
	`path` varchar(100),
	PRIMARY KEY (`repID`)
);

CREATE TABLE `Technician` (
	`techMobile` numeric(15) NOT NULL,
	`techName` varchar(30) NOT NULL,
	`techPassword` varchar(30) NOT NULL,
	PRIMARY KEY (`techMobile`)
);

ALTER TABLE `Appointment` ADD CONSTRAINT `Appointment_fk0` FOREIGN KEY (`patMobile`) REFERENCES `Patient`(`patMobile`);

ALTER TABLE `Appointment` ADD CONSTRAINT `Appointment_fk1` FOREIGN KEY (`docMobile`) REFERENCES `Doctor`(`docMobile`);

ALTER TABLE `Reports` ADD CONSTRAINT `Reports_fk0` FOREIGN KEY (`appID`) REFERENCES `Appointment`(`appID`);

ALTER TABLE `Reports` ADD CONSTRAINT `Reports_fk1` FOREIGN KEY (`techMobile`) REFERENCES `Technician`(`techMobile`);

