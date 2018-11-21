DROP TABLE IF EXISTS `course`;

CREATE TABLE `course`(
  `course_id`               VARCHAR(50) NOT NULL,
  `owner_id`                VARCHAR(50) NOT NULL,
  `name`                    VARCHAR(150),
  `category`                VARCHAR(20),
  `description`             VARCHAR(400),
  `created_at`              DATETIME,
  `price`                   DECIMAL(20, 1),
  `number_of_registrations` BIGINT UNSIGNED,
  PRIMARY KEY (`course_id`),
  CONSTRAINT fk_course_user FOREIGN KEY (`owner_id`) REFERENCES `user`(`user_id`)
);