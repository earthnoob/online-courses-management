DROP PROCEDURE IF EXISTS insert_video;

DELIMITER $$
CREATE PROCEDURE insert_video(
  chap_id VARCHAR(50),
  name    VARCHAR(100)
)
BEGIN
  DECLARE vid_id   VARCHAR(50);
  DECLARE created_at DATETIME DEFAULT NOW();
  DECLARE view_count MEDIUMINT UNSIGNED DEFAULT 0;
  DECLARE duplicate  TINYINT;
  SET chap_id = CONCAT('ch_', chap_id);
  dup_id_check:  WHILE(TRUE) DO
    CALL generate_uuid(24, vid_id);
    SET vid_id = CONCAT('v_', vid_id);
    SELECT COUNT(`video_id`) INTO duplicate
    FROM `video`
    WHERE `video_id` = vid_id;
    IF (duplicate = 0) THEN
      INSERT INTO `video` VALUES (
        vid_id,
        chap_id,
        name,
        created_at,
        view_count
      );
    END IF;
    LEAVE dup_id_check;
  END WHILE;
END$$
DELIMITER ;