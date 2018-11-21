DROP TABLE `transaction_history`;

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