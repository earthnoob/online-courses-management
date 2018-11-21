-- TODO: Add trigger on insert for chapter_no(by using COUNT(`chapter_id`)) and course_id
DROP PROCEDURE IF EXISTS insert_chapter;

DELIMITER $$
CREATE PROCEDURE insert_chapter(
  c_id        VARCHAR(50),
  name        VARCHAR(100),
  description VARCHAR(200)
)
BEGIN
  DECLARE chap_id    VARCHAR(50);
  DECLARE chap_no    TINYINT UNSIGNED DEFAULT 0;
  DECLARE duplicate  TINYINT;
  SET c_id = CONCAT('c_', c_id);
  SELECT COUNT(*) INTO chap_no
  FROM `chapter`
  WHERE `course_id` = c_id;
  SET chap_no = chap_no + 1;
  dup_id_check: WHILE(TRUE) DO
    CALL generate_uuid(24, chap_id);
    SET chap_id = CONCAT('ch_', chap_id);
    SELECT COUNT(`chapter_id`) INTO duplicate
    FROM `chapter`
    WHERE `chapter_id` = chap_id;
    IF (duplicate = 0) THEN
      INSERT INTO `chapter` VALUES(
        chap_id,
        c_id,
        chap_no,
        name,
        description
      );
    END IF;
    LEAVE dup_id_check;
  END WHILE;
END$$
DELIMITER ;