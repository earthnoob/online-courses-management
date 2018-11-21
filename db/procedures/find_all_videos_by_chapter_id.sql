DROP PROCEDURE IF EXISTS find_all_videos_by_chapter_id;

DELIMITER $$
CREATE PROCEDURE find_all_videos_by_chapter_id(
  ch_id VARCHAR(50)
)
BEGIN
  SELECT *
  FROM `video`
  WHERE `chapter_id` = CONCAT("ch_", ch_id);
END$$
DELIMITER ;