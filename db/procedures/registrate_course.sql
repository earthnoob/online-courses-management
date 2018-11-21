DROP PROCEDURE IF EXISTS registrate_course;

--TODO: Owners shouldn't registrate to their own courses.
DELIMITER $$
CREATE PROCEDRE registrate_course(
  u_id VARCHAR(50),
  c_id VARCHAR(50)
)
BEGIN
  INSERT INTO `course_registrations` VALUES(
    CONCAT('u_', u_id),
    CONCAT('c_', c_id),
    NOW()
  );
END$$
DELIMITER ;