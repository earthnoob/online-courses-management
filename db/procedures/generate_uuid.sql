--TODO: Continue with generate_uuid().

DROP PROCEDURE IF EXISTS generate_uuid;

DELIMITER $$
CREATE PROCEDURE generate_uuid(
  string_length      TINYINT,
  OUT generated_uuid VARCHAR(50)
)
BEGIN
  DECLARE iteration_count TINYINT UNSIGNED DEFAULT 0;
  DECLARE temp            CHAR(1);
  IF (generated_uuid IS NULL) THEN SET generated_uuid = '';
  END IF;
  IF (string_length IS NULL) THEN SET string_length = 24;
  END IF;
  WHILE(iteration_count < string_length) DO
    SET temp = CONVERT(CHAR(FLOOR(RAND() * (57 - 48 + 1) + 48)), CHAR(1));
    SET generated_uuid = CONCAT(generated_uuid, temp);
    SET iteration_count = iteration_count + 1;
  END WHILE;
END$$
DELIMITER ;