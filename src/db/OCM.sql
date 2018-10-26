-- TODO: Implement required procedures.

DROP DATABASE `online-courses-management`;
CREATE DATABASE `online-courses-management`;
ALTER DATABASE `online-courses-management` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `online-courses-management`;

CREATE TABLE `user`(
  `user_id`       VARCHAR(50)  NOT NULL,
  `full_name`     VARCHAR(150) NOT NULL,
  `gender`        BIT(1),
  `date_of_birth` DATE,
  `telephone`     VARCHAR(11),
  `address`       VARCHAR(50),
  `email`         VARCHAR(150),
  `bio`           VARCHAR(500),
  `joined_at`     DATETIME,
  `balance`       DECIMAL(20, 1),
  `reputation`    MEDIUMINT UNSIGNED,
  `penalty_count` TINYINT UNSIGNED,
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `course`(
  `course_id`               VARCHAR(50) NOT NULL,
  `owner_id`                VARCHAR(50) NOT NULL,
  `category`                VARCHAR(20),
  `description`             VARCHAR(400),
  `created_at`              DATETIME,
  `price`                   DECIMAL(20, 1),
  `number_of_registrations` BIGINT UNSIGNED,
  PRIMARY KEY (`course_id`),
  CONSTRAINT fk_course_user FOREIGN KEY (`owner_id`) REFERENCES `user`(`user_id`)
);

CREATE TABLE `course_registrations`(
  `user_id`       VARCHAR(50) NOT NULL,
  `course_id`     VARCHAR(50) NOT NULL,
  `registered_at` DATETIME,
  PRIMARY KEY (`user_id`, `course_id`),
  CONSTRAINT fk_course_registrations_user FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`),
  CONSTRAINT fk_course_registrations_course FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`)
);

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

CREATE TABLE `chapter`(
  `chapter_id`  VARCHAR(50) NOT NULL,
  `course_id`   VARCHAR(50) NOT NULL,
  `name`        VARCHAR(100) NOT NULL,
  `description` VARCHAR(200),
  PRIMARY KEY (`chapter_id`),
  CONSTRAINT fk_chapter_course FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`)
);

CREATE TABLE `video`(
  `video_id`   VARCHAR(50) NOT NULL,
  `chapter_id` VARCHAR(50) NOT NULL,
  `name`       VARCHAR(100),
  `view_count` MEDIUMINT UNSIGNED,
  PRIMARY KEY (`video_id`),
  CONSTRAINT fk_video_chapter FOREIGN KEY (`chapter_id`) REFERENCES `chapter`(`chapter_id`)
);

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

CREATE TABLE `transaction_history`(
  `transaction_id` VARCHAR(50) NOT NULL,
  `client_id`      VARCHAR(50) NOT NULL,
  `target_id`      VARCHAR(50) NOT NULL,
  `committed_at`   DATETIME,
  `amount`         DECIMAL(20, 1),
  `status`         VARCHAR(10),
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT fk_transaction_history_client FOREIGN KEY (`client_id`) REFERENCES `user`(`user_id`),
  CONSTRAINT fk_transaction_history_target FOREIGN KEY (`target_id`) REFERENCES `user`(`user_id`)
);

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

CREATE TABLE `account_lockdowns`(
  `lockdown_id`    VARCHAR(50) NOT NULL,
  `user_id`        VARCHAR(50) NOT NULL,
  `locked_down_at` DATETIME,
  `state`          VARCHAR(8) NOT NULL,
  PRIMARY KEY (`lockdown_id`),
  CONSTRAINT fk_account_lockdowns FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`)
);