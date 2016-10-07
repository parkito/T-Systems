-- MySQL dump 10.13  Distrib 5.7.15, for Linux (x86_64)
--
-- Host: localhost    Database: operator
-- ------------------------------------------------------
-- Server version	5.7.15-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `impossibleOtions`
--

DROP TABLE IF EXISTS `impossibleOtions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impossibleOtions` (
  `impossibleOtions_id` int(11) NOT NULL AUTO_INCREMENT,
  `tariffOption_id` int(11) NOT NULL DEFAULT '0',
  `tariffOption_id1` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`impossibleOtions_id`,`tariffOption_id`,`tariffOption_id1`),
  KEY `fk_TariffOption_has_TariffOption_TariffOption4_idx` (`tariffOption_id1`),
  KEY `fk_TariffOption_has_TariffOption_TariffOption3_idx` (`tariffOption_id`),
  CONSTRAINT `fk_TariffOption_has_TariffOption_TariffOption4` FOREIGN KEY (`tariffOption_id1`) REFERENCES `TariffOption` (`tariffOption_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impossibleOtions`
--

LOCK TABLES `impossibleOtions` WRITE;
/*!40000 ALTER TABLE `impossibleOtions` DISABLE KEYS */;
INSERT INTO `impossibleOtions` VALUES (3,0,1),(3,0,2),(1,0,3),(2,0,3);
/*!40000 ALTER TABLE `impossibleOtions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-08  1:52:19
