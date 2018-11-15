CREATE TABLE `t_registrations` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	INDEX `IDX_ID` (`ID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
