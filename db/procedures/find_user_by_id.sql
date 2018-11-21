DROP PROCEDURE IF EXISTS find_user_by_id;

DELIMITER $$
CREATE PROCEDURE find_user_by_id(
  id VARCHAR(50)
)
BEGIN
  SELECT *
  FROM `user`
  WHERE user_id = CONCAT('u_', id);
END$$
DELIMITER ;