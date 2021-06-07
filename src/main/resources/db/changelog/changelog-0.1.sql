-- -----------------------------------------------------
-- Schema cassette
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cassette` DEFAULT CHARACTER SET utf8 ;
USE `cassette` ;

-- -----------------------------------------------------
-- Table `cassette`.`broker_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cassette`.`broker_type` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(128) NOT NULL,
`description` VARCHAR(255) NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cassette`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cassette`.`account` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(256) NOT NULL,
`password_hash` VARCHAR(512) NOT NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cassette`.`broker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cassette`.`broker` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(128) NOT NULL,
`address` VARCHAR(255) NOT NULL,
`description` VARCHAR(512) NULL,
`broker_type_id` INT NOT NULL,
`account_id` INT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `name_idx` (`name` ASC),
CONSTRAINT `fk_broker_broker_type`
FOREIGN KEY (`broker_type_id`)
REFERENCES `cassette`.`broker_type` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT `fk_broker_account`
FOREIGN KEY (`account_id`)
REFERENCES `cassette`.`account` (`id`)
ON DELETE SET NULL
ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cassette`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cassette`.`message_status` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(128) NOT NULL,
`code` INT NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `code_idx` (`code` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cassette`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cassette`.`message` (
`id` INT NOT NULL AUTO_INCREMENT,
`message_body_path` VARCHAR(300) NOT NULL,
`send_time` DATETIME NULL,
`topic` VARCHAR(300) NULL,
`broker_id` INT NOT NULL,
`message_status_id` INT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_message_broker`
FOREIGN KEY (`broker_id`)
REFERENCES `cassette`.`broker` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT `fk_message_message_status`
FOREIGN KEY (`message_status_id`)
REFERENCES `cassette`.`message_status` (`id`)
ON DELETE SET NULL
ON UPDATE CASCADE)
ENGINE = InnoDB;
