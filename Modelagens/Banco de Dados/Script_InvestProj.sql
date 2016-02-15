-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_InvestProj
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_InvestProj
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_InvestProj` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `db_InvestProj` ;

-- -----------------------------------------------------
-- Table `db_InvestProj`.`tbl_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_InvestProj`.`tbl_usuarios` (
  `usr_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `usr_nome` VARCHAR(60) NOT NULL,
  `usr_email` VARCHAR(100) NOT NULL,
  `usr_nascimento` DATE NOT NULL,
  `usr_senha` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`usr_id`),
  UNIQUE INDEX `usr_email_UNIQUE` (`usr_email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_InvestProj`.`tbl_projetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_InvestProj`.`tbl_projetos` (
  `prj_id` INT UNSIGNED NOT NULL,
  `prj_usr_id` INT UNSIGNED NOT NULL,
  `prj_nome` VARCHAR(60) NOT NULL,
  `prj_descricao` LONGTEXT NULL,
  `prj_inicio` DATE NOT NULL,
  `prj_duracao` INT NULL,
  `prj_fim` DATE NULL,
  `prj_status` VARCHAR(20) NOT NULL,
  `prj_despesa` DECIMAL(15,2) NULL,
  `prj_ganho` DECIMAL(15,2) UNSIGNED NULL,
  `prj_lucro` DECIMAL(15,2) NULL,
  PRIMARY KEY (`prj_id`, `prj_usr_id`),
  INDEX `fk_tbl_projetos_tbl_usuarios_idx` (`prj_usr_id` ASC),
  UNIQUE INDEX `prj_nome_UNIQUE` (`prj_nome` ASC),
  CONSTRAINT `fk_tbl_projetos_tbl_usuarios`
    FOREIGN KEY (`prj_usr_id`)
    REFERENCES `db_InvestProj`.`tbl_usuarios` (`usr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_InvestProj`.`tbl_acoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_InvestProj`.`tbl_acoes` (
  `aco_id` INT UNSIGNED NOT NULL,
  `aco_usr_id` INT UNSIGNED NOT NULL,
  `aco_nome` VARCHAR(60) NOT NULL,
  `aco_quantidade` INT UNSIGNED NULL,
  `aco_preco_medio` DECIMAL(15,2) NULL,
  PRIMARY KEY (`aco_id`, `aco_usr_id`),
  INDEX `fk_tbl_acoes_tbl_usuarios1_idx` (`aco_usr_id` ASC),
  CONSTRAINT `fk_tbl_acoes_tbl_usuarios1`
    FOREIGN KEY (`aco_usr_id`)
    REFERENCES `db_InvestProj`.`tbl_usuarios` (`usr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_InvestProj`.`tbl_investimentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_InvestProj`.`tbl_investimentos` (
  `inv_id` INT UNSIGNED NOT NULL,
  `inv_aco_id` INT UNSIGNED NOT NULL,
  `inv_aco_usr_id` INT UNSIGNED NOT NULL,
  `inv_data` DATE NULL,
  `inv_quantidade` INT UNSIGNED NOT NULL,
  `inv_valor` DECIMAL(15,2) UNSIGNED NOT NULL,
  `inv_custos` DECIMAL(15,2) NULL,
  `inv_total` DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (`inv_id`, `inv_aco_id`, `inv_aco_usr_id`),
  INDEX `fk_tbl_investimentos_tbl_acoes1_idx` (`inv_aco_id` ASC, `inv_aco_usr_id` ASC),
  CONSTRAINT `fk_tbl_investimentos_tbl_acoes1`
    FOREIGN KEY (`inv_aco_id` , `inv_aco_usr_id`)
    REFERENCES `db_InvestProj`.`tbl_acoes` (`aco_id` , `aco_usr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
