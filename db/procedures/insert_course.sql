-- TODO: Create trigger to check for foreign key constraints on colunm `owner_id`.
DROP PROCEDURE IF EXISTS insert_course;

DELIMITER $$
CREATE PROCEDURE insert_course(
  o_id        VARCHAR(50),
  name        VARCHAR(150),
  category    VARCHAR(20),
  description VARCHAR(400),
  price       DECIMAL(20, 1)
)
BEGIN
  DECLARE c_id                    VARCHAR(50);
  DECLARE created_at              DATETIME;
  DECLARE number_of_registrations BIGINT     UNSIGNED DEFAULT 0;
  DECLARE duplicate               TINYINT    UNSIGNED DEFAULT 0;
  SET o_id = CONCAT('u_', o_id);
  dup_id_check: WHILE(TRUE) DO
    CALL generate_uuid(24, c_id);
    SET c_id = CONCAT('c_', c_id);
    SELECT COUNT(`course_id`) INTO duplicate
    FROM `course`
    WHERE `course_id` = c_id
    AND `owner_id` = o_id;
    IF (duplicate = 0) THEN
      SET created_at = NOW();
      INSERT INTO `course` VALUES(
        c_id,
        o_id,
        name,
        category,
        description,
        created_at,
        price,
        number_of_registrations
      );
    END IF;
    LEAVE dup_id_check;
  END WHILE;
END$$
DELIMITER ;