CREATE TABLE `ROLE`  (
  `ID` VARCHAR(50) NOT NULL,
  `NAME` VARCHAR(50) NOT NULL,
  `DESCRIPTION` VARCHAR(100) NOT NULL,
  `CREATED_AT` DATETIME NULL DEFAULT NULL,
  `UPDATED_AT` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `USER`  (
    `ID` VARCHAR(50) NOT NULL,
    `EMAIL` VARCHAR(50) NOT NULL,
    `PHONE` VARCHAR(50),
    `USERNAME` VARCHAR(50) NOT NULL,
    `FULL_NAME` VARCHAR(50) NOT NULL,
    `PASSWORD` VARCHAR(100) NOT NULL,
    `ENABLED` bit NOT NULL,
    `EMAIL_VERIFIED` bit NOT NULL,
    `CREATED_AT` DATETIME NULL DEFAULT NULL,
    `UPDATED_AT` DATETIME NULL DEFAULT NULL,
    PRIMARY KEY (`ID`) ,
    UNIQUE INDEX `UNIQUE_EMAIL`(`EMAIL`) ,
    UNIQUE INDEX `UNIQUE_USERNAME`(`USERNAME`)
);

CREATE TABLE `USER_ROLE`  (
  `USER_ID` VARCHAR(50) NOT NULL,
  `ROLE_NAME` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`USER_ID`, `ROLE_NAME`)
);
