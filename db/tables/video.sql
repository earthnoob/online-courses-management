DROP TABLE IF EXISTS `video`;

CREATE TABLE `video`(
  `video_id`   VARCHAR(50) NOT NULL,
  `chapter_id` VARCHAR(50) NOT NULL,
  `name`       VARCHAR(100),
  `created_at` DATETIME,
  `view_count` MEDIUMINT UNSIGNED,
  PRIMARY KEY (`video_id`),
  CONSTRAINT fk_video_chapter FOREIGN KEY (`chapter_id`) REFERENCES `chapter`(`chapter_id`)
);
