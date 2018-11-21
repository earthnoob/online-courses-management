DROP TABLE IF EXISTS `role`;

CREATE TABLE `role`(
  `role_level`  TINYINT UNSIGNED NOT NULL,
  `description` VARCHAR(10),
  PRIMARY KEY (`role_level`)
);

INSERT INTO `role` VALUES
(0, "Admin"), (1, "Teacher"), (2, "User");