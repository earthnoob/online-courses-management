DROP TABLE IF EXISTS `promotion`;

CREATE TABLE `promotion`(
  `promotion_id`  VARCHAR(50) NOT NULL,
  `course_id`     VARCHAR(50) NOT NULL,
  `created_by`    VARCHAR(50) NOT NULL,
  `discount_rate` TINYINT(3),
  `begins_at`     DATETIME,
  `ends_at`       DATETIME,
  PRIMARY KEY (`promotion_id`),
  CONSTRAINT fk_promotion_course FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`),
  CONSTRAINT fk_promotion_user FOREIGN KEY (`created_by`) REFERENCES `user`(`user_id`)
);