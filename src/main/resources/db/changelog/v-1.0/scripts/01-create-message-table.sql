CREATE TABLE IF NOT EXISTS cassette.message (
id INT NOT NULL AUTO_INCREMENT,
message_body_path VARCHAR(300) NOT NULL,
send_time DATETIME NULL,
topic VARCHAR(300) NULL,
broker_id INT NOT NULL,
message_status_id INT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_message_broker
FOREIGN KEY (broker_id)
REFERENCES cassette.broker (id)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT fk_message_message_status
FOREIGN KEY (message_status_id)
REFERENCES cassette.message_status (id)
ON DELETE SET NULL
ON UPDATE CASCADE)
ENGINE = InnoDB;
