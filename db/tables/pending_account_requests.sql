DROP TABLE IF EXISTS `pending_account_requests`;

CREATE TABLE `pending_account_requests`(
  `request_id`  VARCHAR(50),
  `made_at`     DATETIME,
  `cv_path`     VARCHAR(300),
  `status`      VARCHAR(8),
  PRIMARY KEY (`request_id`)
);