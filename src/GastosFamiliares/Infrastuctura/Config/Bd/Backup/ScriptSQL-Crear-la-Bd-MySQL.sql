
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema finanzasfamiliaresdbV2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `finanzasfamiliaresdbV2` ;

-- -----------------------------------------------------
-- Schema finanzasfamiliaresdbV2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `finanzasfamiliaresdbV2` DEFAULT CHARACTER SET utf8 ;
USE `finanzasfamiliaresdbV2` ;

-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Aportes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Aportes` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Aportes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor` FLOAT NOT NULL,
  `fecha` DATE NULL,
  `gasto_id` INT NOT NULL,
  `miembro_id` VARCHAR(20) NOT NULL,
  `ingreso_id` INT NOT NULL,
  `bolsa_de_ahorro_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Aportes_Gastos1`
    FOREIGN KEY (`gasto_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Gastos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aportes_Miembros1`
    FOREIGN KEY (`miembro_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Miembros` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aportes_Ingresos1`
    FOREIGN KEY (`ingreso_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Ingresos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aportes_Bolsas_de_Ahorros1`
    FOREIGN KEY (`bolsa_de_ahorro_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Bolsas_de_Ahorros` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Aportes_Gastos1_idx` ON `finanzasfamiliaresdbV2`.`Aportes` (`gasto_id` ASC)  ;

CREATE INDEX `fk_Aportes_Miembros1_idx` ON `finanzasfamiliaresdbV2`.`Aportes` (`miembro_id` ASC)  ;

CREATE INDEX `fk_Aportes_Ingresos1_idx` ON `finanzasfamiliaresdbV2`.`Aportes` (`ingreso_id` ASC)  ;

CREATE INDEX `fk_Aportes_Bolsas_de_Ahorros1_idx` ON `finanzasfamiliaresdbV2`.`Aportes` (`bolsa_de_ahorro_id` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Bolsas_de_Ahorros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Bolsas_de_Ahorros` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Bolsas_de_Ahorros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NULL,
  `monto_ideal` FLOAT NOT NULL,
  `proposito` VARCHAR(50) NULL,
  `fecha_registro` DATETIME NULL,
  `familia_id` INT NOT NULL,
  `Miembros_usuario_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Bolsas_de_Ahorros_Familias1`
    FOREIGN KEY (`familia_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Familias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bolsas_de_Ahorros_Miembros1`
    FOREIGN KEY (`Miembros_usuario_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Miembros` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Bolsas_de_Ahorros_Familias1_idx` ON `finanzasfamiliaresdbV2`.`Bolsas_de_Ahorros` (`familia_id` ASC)  ;

CREATE INDEX `fk_Bolsas_de_Ahorros_Miembros1_idx` ON `finanzasfamiliaresdbV2`.`Bolsas_de_Ahorros` (`Miembros_usuario_id` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Categorias` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Categorias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `icono` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `nombre_UNIQUE` ON `finanzasfamiliaresdbV2`.`Categorias` (`nombre` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Categorias_gastos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Categorias_gastos` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Categorias_gastos` (
  `gasto_id` INT NOT NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`gasto_id`, `categoria_id`),
  CONSTRAINT `fk_Gastos_has_Categorias_Gastos1`
    FOREIGN KEY (`gasto_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Gastos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gastos_has_Categorias_Categorias1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Gastos_has_Categorias_Categorias1_idx` ON `finanzasfamiliaresdbV2`.`Categorias_gastos` (`categoria_id` ASC)  ;

CREATE INDEX `fk_Gastos_has_Categorias_Gastos1_idx` ON `finanzasfamiliaresdbV2`.`Categorias_gastos` (`gasto_id` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Familias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Familias` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Familias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(70) NOT NULL,
  `numero_telefonico` VARCHAR(30) NULL,
  `direccion` VARCHAR(255) NULL,
  `email` VARCHAR(70) NULL,
  `usuario_creador_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Familias_Usuarios1`
    FOREIGN KEY (`usuario_creador_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `email_UNIQUE` ON `finanzasfamiliaresdbV2`.`Familias` (`email` ASC)  ;

CREATE INDEX `fk_Familias_Usuarios1_idx` ON `finanzasfamiliaresdbV2`.`Familias` (`usuario_creador_id` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Fuentes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Fuentes` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Fuentes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `icono` VARCHAR(2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `nombre_UNIQUE` ON `finanzasfamiliaresdbV2`.`Fuentes` (`nombre` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Gastos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Gastos` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Gastos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `valor` INT NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `fecha_registro` DATETIME NULL,
  `miembro_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Gastos_Miembros1`
    FOREIGN KEY (`miembro_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Miembros` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Gastos_Miembros1_idx` ON `finanzasfamiliaresdbV2`.`Gastos` (`miembro_id` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Ingresos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Ingresos` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Ingresos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `valor` FLOAT NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `fecha_registro` DATETIME NULL,
  `fuente_id` INT NOT NULL,
  `miembro_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Ingresos_Fuentes1`
    FOREIGN KEY (`fuente_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Fuentes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ingresos_Miembros1`
    FOREIGN KEY (`miembro_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Miembros` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Ingresos_Fuentes1_idx` ON `finanzasfamiliaresdbV2`.`Ingresos` (`fuente_id` ASC)  ;

CREATE INDEX `fk_Ingresos_Miembros1_idx` ON `finanzasfamiliaresdbV2`.`Ingresos` (`miembro_id` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Miembros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Miembros` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Miembros` (
  `segundo_nombre` VARCHAR(30) NOT NULL,
  `segundo_apellido` VARCHAR(50) NOT NULL,
  `genero` VARCHAR(15) NULL DEFAULT 'Masculino',
  `fecha_nacimiento` DATE NULL,
  `numeroTelefonico` VARCHAR(30) NULL,
  `ocupacion` VARCHAR(50) NULL,
  `rol_familia` VARCHAR(20) NOT NULL DEFAULT 'Usuario',
  `usuario_id` VARCHAR(20) NOT NULL,
  `familia_id` INT NOT NULL,
  PRIMARY KEY (`usuario_id`),
  CONSTRAINT `fk_Miembros_Usuarios`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Miembros_Familias1`
    FOREIGN KEY (`familia_id`)
    REFERENCES `finanzasfamiliaresdbV2`.`Familias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Miembros_Usuarios_idx` ON `finanzasfamiliaresdbV2`.`Miembros` (`usuario_id` ASC)  ;

CREATE INDEX `fk_Miembros_Familias1_idx` ON `finanzasfamiliaresdbV2`.`Miembros` (`familia_id` ASC)  ;


-- -----------------------------------------------------
-- Table `finanzasfamiliaresdbV2`.`Usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finanzasfamiliaresdbV2`.`Usuarios` ;

CREATE TABLE IF NOT EXISTS `finanzasfamiliaresdbV2`.`Usuarios` (
  `id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `nombre` VARCHAR(30) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `rol` VARCHAR(20) NOT NULL,
  `email` VARCHAR(70) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `email_UNIQUE` ON `finanzasfamiliaresdbV2`.`Usuarios` (`email` ASC)  ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
