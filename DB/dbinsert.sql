-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbinsertvr
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbinsertvr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbinsertvr` DEFAULT CHARACTER SET utf8 ;
USE `dbinsertvr` ;

-- -----------------------------------------------------
-- Table `dbinsertvr`.`correo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbinsertvr`.`correo` (
  `idCorreo` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreCorreo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idCorreo`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

USE `dbinsertvr` ;

-- -----------------------------------------------------
-- procedure sp_insert_correo
-- -----------------------------------------------------

DELIMITER $$
USE `dbinsertvr`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_correo`(
	out p_estado varchar(200),
    p_nombreCorreo varchar(50)
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
	BEGIN
	rollback;
	set p_estado='Error';
END;
	start transaction;
	set p_estado=null;
	insert into correo (nombreCorreo)
	values (p_nombreCorreo);
	set p_estado ='ok';
	commit;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_list_correo
-- -----------------------------------------------------

DELIMITER $$
USE `dbinsertvr`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_list_correo`()
BEGIN
	select idCorreo,nombreCorreo
    from correo;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
