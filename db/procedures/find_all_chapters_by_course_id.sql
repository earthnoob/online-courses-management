DROP PROCEDURE IF EXISTS find_all_chapters_by_course_id;

DELIMITER $$
CREATE PROCEDURE find_all_chapters_by_course_id(
  c_id VARCHAR(50)
)
BEGIN
  SELECT *
  FROM `chapter`
  WHERE `course_id` = CONCAT('c_', c_id);
END$$
DELIMITER ;