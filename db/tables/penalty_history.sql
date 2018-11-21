DROP TABLE IF EXISTS `penalty_hstory`;

CREATE TABLE `penalty_history`(
  `penalty_id`     VARCHAR(50) NOT NULL,
  `made_by`        VARCHAR(50) NOT NULL,
  `target_user_id` VARCHAR(50) NOT NULL,
  `made_at`        DATETIME,
  `reason`         VARCHAR(50),
  PRIMARY KEY (`penalty_id`),
  CONSTRAINT fk_penalty_history_user FOREIGN KEY (`made_by`) REFERENCES `user`(`user_id`),
  CONSTRAINT fk_penalty_history_target FOREIGN KEY (`target_user_id`) REFERENCES `user`(`user_id`)
);