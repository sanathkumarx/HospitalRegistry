CREATE TABLE `Patient` (
	`patID` int NOT NULL AUTO_INCREMENT,
	`patName` varchar(50) NOT NULL,
	`patMobile` numeric(15) NOT NULL,
	`patPassword` varchar(20) NOT NULL,
	`patLocation` varchar(20) NOT NULL,
	PRIMARY KEY (`patID`)
);

CREATE TABLE `Doctor` (
	`docID` int NOT NULL AUTO_INCREMENT,
	`docName` varchar(50) NOT NULL,
	`docMobile` numeric(15) NOT NULL,
	`docPassword` varchar(20) NOT NULL,
	`docLocation` varchar(20) NOT NULL,
	`docSpecialization` varchar(20) NOT NULL,
	`docDays` int NOT NULL,
	PRIMARY KEY (`docID`)
);

CREATE TABLE `Appointment` (
	`appID` int NOT NULL AUTO_INCREMENT,
	`patID` int NOT NULL,
	`docID` int NOT NULL,
	`appDate` DATE NOT NULL,
	`appStatus` bool NOT NULL,
	PRIMARY KEY (`appID`)
);

CREATE TABLE `Reports` (
	`repID` int NOT NULL AUTO_INCREMENT,
	`appID` int NOT NULL,
	`techID` int NOT NULL,
	`repStatus` bool NOT NULL,
	`testName` varchar(50) NOT NULL,
	PRIMARY KEY (`repID`)
);

CREATE TABLE `Technician` (
	`techID` int NOT NULL AUTO_INCREMENT,
	`techName` varchar(30) NOT NULL,
	`techMobile` numeric(15) NOT NULL,
	`techPassword` varchar(30) NOT NULL,
	PRIMARY KEY (`techID`)
);

ALTER TABLE `Appointment` ADD CONSTRAINT `Appointment_fk0` FOREIGN KEY (`patID`) REFERENCES `Patient`(`patID`);

ALTER TABLE `Appointment` ADD CONSTRAINT `Appointment_fk1` FOREIGN KEY (`docID`) REFERENCES `Doctor`(`docID`);

ALTER TABLE `Reports` ADD CONSTRAINT `Reports_fk0` FOREIGN KEY (`appID`) REFERENCES `Appointment`(`appID`);

ALTER TABLE `Reports` ADD CONSTRAINT `Reports_fk1` FOREIGN KEY (`techID`) REFERENCES `Technician`(`techID`);

