DROP PROCEDURE IF EXISTS insert_user;

--TODO: Refactor insert_user().
DELIMITER $$
CREATE PROCEDURE insert_user(
  email         VARCHAR(150),
  input_password      VARCHAR(150),
  role_level    TINYINT(3) UNSIGNED,
  full_name     VARCHAR(150),
  gender        BIT,
  date_of_birth DATE,
  telephone     VARCHAR(11),
  address       VARCHAR(50),
  bio           VARCHAR(500)
)
BEGIN
  DECLARE id             VARCHAR(50);
  DECLARE joined_at      DATETIME;
  DECLARE balance        DECIMAL(20, 1)     DEFAULT 0;
  DECLARE reputation     MEDIUMINT UNSIGNED DEFAULT 0;
  DECLARE penalty_count  TINYINT UNSIGNED   DEFAULT 0;
  DECLARE duplicate      TINYINT UNSIGNED;
  dup_id_check: WHILE(TRUE) DO
	  CALL generate_uuid(24, id);
    SET id = CONCAT('u_', id);
    SET joined_at = NOW();
	  SELECT COUNT(`user_id`) INTO duplicate
	  FROM `user`
	  WHERE `user_id` = id;
	  IF (duplicate = 0) THEN
		  SELECT("Duplication not found! Performing INSERT");
      INSERT INTO `user` VALUES (
			  id,
        email,
        input_password,
        role_level,
			  full_name,
        gender,
        date_of_birth,
        telephone,
        address,
        bio,
        joined_at,
        balance,
        reputation,
        penalty_count
			);
		  LEAVE dup_id_check;
	  ELSE
		  SELECT("Duplication found!");
      SET id = NULL;
	  END IF;
	END WHILE;
END$$
DELIMITER ;