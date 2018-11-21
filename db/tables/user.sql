DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
  `user_id`       VARCHAR(50)  NOT NULL,
  `email`         VARCHAR(150) NOT NULL,
  `password`      VARCHAR(150),
  `role_level`    TINYINT UNSIGNED NOT NULL,
  `full_name`     VARCHAR(150) NOT NULL,
  `gender`        BIT(1),
  `date_of_birth` DATE,
  `telephone`     VARCHAR(11),
  `address`       VARCHAR(50),
  `bio`           VARCHAR(500),
  `joined_at`     DATETIME,
  `balance`       DECIMAL(20, 1),
  `reputation`    MEDIUMINT UNSIGNED,
  `penalty_count` TINYINT UNSIGNED,
  PRIMARY KEY (`user_id`, `email`),
  CONSTRAINT fk_user_role FOREIGN KEY `role_level` REFERENCES `role`(`role_level`)
);

INSERT INTO `user` VALUES(
  '111',
  'Banana Guy',
  1,
  '1999-01-01',
  '0123456789',
  '123 Fruit street, WA.',
  'banana.guy@fruitlands.com',
  '123',
  "I'm a banana.",
  '2018-10-15',
  1234.1,
  1000,
  0
);