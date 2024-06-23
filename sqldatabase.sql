-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.21-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for temanbaik
CREATE DATABASE IF NOT EXISTS `temanbaik` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `temanbaik`;

-- Dumping structure for table temanbaik.teman
CREATE TABLE IF NOT EXISTS `teman` (
  `idteman` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `telp` varchar(15) DEFAULT NULL,
  `jk` enum('Laki-Laki','Perempuan','') DEFAULT '',
  PRIMARY KEY (`idteman`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table temanbaik.teman: ~4 rows (approximately)
REPLACE INTO `teman` (`idteman`, `nama`, `alamat`, `telp`, `jk`) VALUES
	(1, 'Wayan Aruni', 'Jl. Saja susah Kok Bisa?', '08877666', 'Laki-Laki'),
	(2, 'Made Aruni', 'Jl. Saja susah katanya', '08877666', 'Perempuan'),
	(3, 'Nyoman Aruni', 'Jl. Saja susah cuk', '08877666', 'Perempuan'),
	(4, 'Ketut Aruni', 'Jl. Saja Susah susah gampang', '09898989', 'Laki-Laki');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
