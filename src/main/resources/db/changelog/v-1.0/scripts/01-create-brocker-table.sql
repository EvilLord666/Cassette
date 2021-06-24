CREATE TABLE IF NOT EXISTS cassette.broker (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(128) NOT NULL,
address VARCHAR(255) NOT NULL,
description VARCHAR(512) NULL,
broker_type_id INT NOT NULL,
account_id INT NULL,
PRIMARY KEY (id),
UNIQUE INDEX name_idx (name ASC),
CONSTRAINT fk_broker_broker_type
FOREIGN KEY (broker_type_id)
REFERENCES cassette.broker_type (id)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT fk_broker_account
FOREIGN KEY (account_id)
REFERENCES cassette.account (id)
ON DELETE SET NULL
ON UPDATE CASCADE)
ENGINE = InnoDB;