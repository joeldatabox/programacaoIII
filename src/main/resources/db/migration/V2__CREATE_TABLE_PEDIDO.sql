DROP TABLE IF EXISTS `Pedido`;
CREATE TABLE `Pedido` (
  `id`      BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cliente` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKav7cu1dpqe44dptxja9ibyfev` (`cliente`),
  CONSTRAINT `FKav7cu1dpqe44dptxja9ibyfev` FOREIGN KEY (`cliente`) REFERENCES `pessoa` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;