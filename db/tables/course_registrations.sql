DROP TABLE IF EXISTS `course_registrations`;

CREATE TABLE `course_registrations`(
  `user_id`       VARCHAR(50) NOT NULL,
  `course_id`     VARCHAR(50) NOT NULL,
  `registered_at` DATETIME,
  PRIMARY KEY (`user_id`, `course_id`),
  CONSTRAINT fk_course_registrations_user FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`),
  CONSTRAINT fk_course_registrations_course FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`)
);