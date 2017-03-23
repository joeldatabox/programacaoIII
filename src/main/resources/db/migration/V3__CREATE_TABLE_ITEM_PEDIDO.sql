DROP TABLE IF EXISTS `PedidoItem`;
CREATE TABLE `PedidoItem` (
  `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
  `valorTotal` DECIMAL(19, 2)      DEFAULT NULL,
  `pedido`     BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdp5g6hcl4hh7p0aouh1ii7yid` (`pedido`),
  CONSTRAINT `FKdp5g6hcl4hh7p0aouh1ii7yid` FOREIGN KEY (`pedido`) REFERENCES `Pedido` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;