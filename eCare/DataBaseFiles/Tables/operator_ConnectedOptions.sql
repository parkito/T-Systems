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
-- Table structure for table `ConnectedOptions`
--

DROP TABLE IF EXISTS `ConnectedOptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ConnectedOptions` (
  `connectedOptions_id` int(11) NOT NULL AUTO_INCREMENT,
  `tariffOption_id` int(11) NOT NULL,
  `contract_id` int(11) NOT NULL,
  PRIMARY KEY (`connectedOptions_id`,`tariffOption_id`,`contract_id`),
  KEY `fk_TariffOption_has_Contract_TariffOption1_idx` (`tariffOption_id`),
  KEY `fk_ConnectedOptions_Contract1_idx` (`contract_id`),
  CONSTRAINT `fk_ConnectedOptions_Contract1` FOREIGN KEY (`contract_id`) REFERENCES `Contract` (`contract_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TariffOption_has_Contract_TariffOption1` FOREIGN KEY (`tariffOption_id`) REFERENCES `TariffOption` (`tariffOption_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=791 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ConnectedOptions`
--

LOCK TABLES `ConnectedOptions` WRITE;
/*!40000 ALTER TABLE `ConnectedOptions` DISABLE KEYS */;
INSERT INTO `ConnectedOptions` VALUES (119,1,4),(125,1,5),(347,1,1),(353,1,9),(438,1,6),(338,2,2),(346,2,1),(354,2,9),(437,2,6),(789,4,3),(339,5,2),(788,5,3),(340,7,2),(436,7,6),(790,7,3);
/*!40000 ALTER TABLE `ConnectedOptions` ENABLE KEYS */;
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
