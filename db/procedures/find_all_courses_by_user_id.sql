DROP PROCEDURE IF EXISTS find_all_courses_by_user_id;

DELIMITER $$
CREATE PROCEDURE find_all_courses_by_user_id(
  user_id VARCHAR(50)
)
BEGIN
  SELECT *
  FROM `course`
  WHERE `owner_id` = CONCAT('u_', user_id);
END$$
DELIMITER ;