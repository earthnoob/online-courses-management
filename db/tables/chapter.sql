DROP TABLE IF EXISTS `chapter`;

CREATE TABLE `chapter`(
  `chapter_id`  VARCHAR(50) NOT NULL,
  `course_id`   VARCHAR(50) NOT NULL,
  `chapter_no`  TINYINT UNSIGNED,
  `name`        VARCHAR(100) NOT NULL,
  `description` VARCHAR(200),
  PRIMARY KEY (`chapter_id`),
  CONSTRAINT fk_chapter_course FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`)
);