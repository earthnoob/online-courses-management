DROP TABLE IF EXISTS `account_lockdowns`;

CREATE TABLE `account_lockdowns`(
  `lockdown_id`    VARCHAR(50) NOT NULL,
  `user_id`        VARCHAR(50) NOT NULL,
  `locked_down_at` DATETIME,
  `state`          VARCHAR(8) NOT NULL,
  PRIMARY KEY (`lockdown_id`),
  CONSTRAINT fk_account_lockdowns FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`)
);