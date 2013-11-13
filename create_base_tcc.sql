SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`TipoEquipamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TipoEquipamento` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`TipoEquipamento` (
  `idTipoEquipamento` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idTipoEquipamento`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Equipamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Equipamento` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Equipamento` (
  `idEquipamento` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `idTipoEquipamento` INT NOT NULL ,
  PRIMARY KEY (`idEquipamento`, `idTipoEquipamento`) ,
  INDEX `fk_Equipamento_TipoEquipamento1_idx` (`idTipoEquipamento` ASC) ,
  CONSTRAINT `fk_Equipamento_TipoEquipamento1`
    FOREIGN KEY (`idTipoEquipamento` )
    REFERENCES `mydb`.`TipoEquipamento` (`idTipoEquipamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cliente` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `idade` INT(11) NOT NULL ,
  `sexo` CHAR(1) NOT NULL ,
  `data_nascimento` DATE NULL ,
  `rg` VARCHAR(15) NULL ,
  `cpf` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idCliente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TipoUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TipoUsuario` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`TipoUsuario` (
  `idTipoUsuario` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idTipoUsuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Usuario` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(45) NOT NULL ,
  `senha` VARCHAR(20) NOT NULL ,
  `idTipoUsuario` INT NOT NULL ,
  PRIMARY KEY (`idUsuario`, `idTipoUsuario`) ,
  INDEX `fk_Usuario_TipoUsuario1_idx` (`idTipoUsuario` ASC) ,
  CONSTRAINT `fk_Usuario_TipoUsuario1`
    FOREIGN KEY (`idTipoUsuario` )
    REFERENCES `mydb`.`TipoUsuario` (`idTipoUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Precos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Precos` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Precos` (
  `idPrecos` INT NOT NULL AUTO_INCREMENT ,
  `inicioValidadePreco` DATETIME NOT NULL ,
  `valorMonetario` DECIMAL(5,2) NOT NULL ,
  `fimValidadePreco` DATETIME NOT NULL ,
  PRIMARY KEY (`idPrecos`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Locacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Locacao` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Locacao` (
  `id_locacao` INT NOT NULL AUTO_INCREMENT ,
  `valorGasto` DECIMAL(5,2) NOT NULL ,
  `inicio_locacao` DATETIME NOT NULL ,
  `fim_locacao` DATETIME NOT NULL ,
  `idEquipamento` INT NOT NULL ,
  `idCliente` INT NOT NULL ,
  PRIMARY KEY (`id_locacao`, `idEquipamento`, `idCliente`) ,
  INDEX `fk_Locacao_Equipamento1_idx` (`idEquipamento` ASC) ,
  INDEX `fk_Locacao_Cliente1_idx` (`idCliente` ASC) ,
  CONSTRAINT `fk_Locacao_Equipamento1`
    FOREIGN KEY (`idEquipamento` )
    REFERENCES `mydb`.`Equipamento` (`idEquipamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Cliente1`
    FOREIGN KEY (`idCliente` )
    REFERENCES `mydb`.`Cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Precos_Equipamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Precos_Equipamento` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Precos_Equipamento` (
  `Equipamento_idEquipamento` INT NOT NULL ,
  `Precos_idPrecos` INT NOT NULL ,
  PRIMARY KEY (`Equipamento_idEquipamento`, `Precos_idPrecos`) ,
  INDEX `fk_Equipamento_has_Precos_Precos1_idx` (`Precos_idPrecos` ASC) ,
  INDEX `fk_Equipamento_has_Precos_Equipamento1_idx` (`Equipamento_idEquipamento` ASC) ,
  CONSTRAINT `fk_Equipamento_has_Precos_Equipamento1`
    FOREIGN KEY (`Equipamento_idEquipamento` )
    REFERENCES `mydb`.`Equipamento` (`idEquipamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipamento_has_Precos_Precos1`
    FOREIGN KEY (`Precos_idPrecos` )
    REFERENCES `mydb`.`Precos` (`idPrecos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Desconto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Desconto` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Desconto` (
  `id_desconto` INT NOT NULL AUTO_INCREMENT ,
  `porcentagem_desconto` INT NOT NULL ,
  `inicio_validade` DATETIME NOT NULL ,
  `fim_validade` DATETIME NOT NULL ,
  PRIMARY KEY (`id_desconto`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Desconto_Equipamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Desconto_Equipamento` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Desconto_Equipamento` (
  `Equipamento_idEquipamento` INT NOT NULL ,
  `Desconto_id_desconto` INT NOT NULL ,
  PRIMARY KEY (`Equipamento_idEquipamento`, `Desconto_id_desconto`) ,
  INDEX `fk_Equipamento_has_Desconto_Desconto1_idx` (`Desconto_id_desconto` ASC) ,
  INDEX `fk_Equipamento_has_Desconto_Equipamento1_idx` (`Equipamento_idEquipamento` ASC) ,
  CONSTRAINT `fk_Equipamento_has_Desconto_Equipamento1`
    FOREIGN KEY (`Equipamento_idEquipamento` )
    REFERENCES `mydb`.`Equipamento` (`idEquipamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipamento_has_Desconto_Desconto1`
    FOREIGN KEY (`Desconto_id_desconto` )
    REFERENCES `mydb`.`Desconto` (`id_desconto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Desconto_has_Equipamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Desconto_has_Equipamento` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Desconto_has_Equipamento` (
  `Desconto_id_desconto` INT NOT NULL ,
  `Equipamento_idEquipamento` INT NOT NULL ,
  PRIMARY KEY (`Desconto_id_desconto`, `Equipamento_idEquipamento`) ,
  INDEX `fk_Desconto_has_Equipamento_Equipamento1_idx` (`Equipamento_idEquipamento` ASC) ,
  INDEX `fk_Desconto_has_Equipamento_Desconto1_idx` (`Desconto_id_desconto` ASC) ,
  CONSTRAINT `fk_Desconto_has_Equipamento_Desconto1`
    FOREIGN KEY (`Desconto_id_desconto` )
    REFERENCES `mydb`.`Desconto` (`id_desconto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Desconto_has_Equipamento_Equipamento1`
    FOREIGN KEY (`Equipamento_idEquipamento` )
    REFERENCES `mydb`.`Equipamento` (`idEquipamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Contato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Contato` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Contato` (
  `idContato` INT NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(45) NOT NULL ,
  `telefone` VARCHAR(45) NOT NULL ,
  `skype` VARCHAR(45) NULL ,
  `facebook` VARCHAR(45) NULL ,
  `gtalk` VARCHAR(45) NULL ,
  `whatsapp` VARCHAR(45) NULL ,
  `ativo` TINYINT(1) NULL ,
  `idCliente` INT NOT NULL ,
  `idUsuario` INT NOT NULL ,
  PRIMARY KEY (`idContato`, `idCliente`, `idUsuario`) ,
  INDEX `fk_Contato_Cliente1_idx` (`idCliente` ASC) ,
  INDEX `fk_Contato_Usuario1_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_Contato_Cliente1`
    FOREIGN KEY (`idCliente` )
    REFERENCES `mydb`.`Cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contato_Usuario1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `mydb`.`Usuario` (`idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
