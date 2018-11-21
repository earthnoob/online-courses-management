DROP TABLE IF EXISTS `login_history`;

CREATE TABLE `login_history`(
  `login_id`        VARCHAR(50) NOT NULL,
  `session_id`      VARCHAR(50) NOT NULL,
  `user_id`         VARCHAR(50) NOT NULL,
  `logged_in_at`    DATETIME,
  `logged_out_at`   DATETIME,
  `ip_address`      BINARY(16),
  `is_logged_out`   BIT(1),
  PRIMARY KEY (`login_id`),
  CONSTRAINT fk_login_history FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`)
);