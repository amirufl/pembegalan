CREATE TABLE `lokasi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kota` varchar(10) DEFAULT NULL,
  `hari` varchar(6) DEFAULT NULL,
  `waktu` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
