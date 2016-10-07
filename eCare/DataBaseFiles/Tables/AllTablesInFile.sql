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
-- Table structure for table `AccessLevel`
--

DROP TABLE IF EXISTS `AccessLevel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AccessLevel` (
  `accessLevel_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`accessLevel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AccessLevel`
--

LOCK TABLES `AccessLevel` WRITE;
/*!40000 ALTER TABLE `AccessLevel` DISABLE KEYS */;
INSERT INTO `AccessLevel` VALUES (1,'userAvailable'),(2,'userBanned'),(3,'Manager');
/*!40000 ALTER TABLE `AccessLevel` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `Contract`
--

DROP TABLE IF EXISTS `Contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contract` (
  `contract_id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(45) NOT NULL,
  `tariff_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `isBlocked` binary(1) NOT NULL,
  `blockedByAdmin` binary(1) DEFAULT NULL,
  `whoBlocked_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `fk_Contract_Tariff1_idx` (`tariff_id`),
  KEY `fk_Contract_User1_idx` (`user_id`),
  CONSTRAINT `fk_Contract_Tariff1` FOREIGN KEY (`tariff_id`) REFERENCES `Tariff` (`tariff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contract_User1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contract`
--

LOCK TABLES `Contract` WRITE;
/*!40000 ALTER TABLE `Contract` DISABLE KEYS */;
INSERT INTO `Contract` VALUES (1,'214189',2,5,'1','1',NULL),(2,'214190',6,2,'0','0',NULL),(3,'214191',1,3,'0','0',NULL),(4,'214192',2,2,'0','0',NULL),(5,'214194',1,3,'1','1',NULL),(6,'214195',1,3,'0','0',NULL),(7,'214199',1,17,'0','0',NULL),(9,'89062477476',6,1,'0','0',NULL),(10,'2121',1,3,'0','0',NULL);
/*!40000 ALTER TABLE `Contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JoinOptions`
--

DROP TABLE IF EXISTS `JoinOptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JoinOptions` (
  `joinOptions_id` int(11) NOT NULL AUTO_INCREMENT,
  `tariffOption_id` int(11) NOT NULL DEFAULT '0',
  `tariffOption_id1` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`joinOptions_id`,`tariffOption_id`,`tariffOption_id1`),
  KEY `fk_TariffOption_has_TariffOption_TariffOption2_idx` (`tariffOption_id1`),
  KEY `fk_TariffOption_has_TariffOption_TariffOption1_idx` (`tariffOption_id`),
  CONSTRAINT `fk_TariffOption_has_TariffOption_TariffOption2` FOREIGN KEY (`tariffOption_id1`) REFERENCES `TariffOption` (`tariffOption_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JoinOptions`
--

LOCK TABLES `JoinOptions` WRITE;
/*!40000 ALTER TABLE `JoinOptions` DISABLE KEYS */;
INSERT INTO `JoinOptions` VALUES (2,0,1),(1,0,2);
/*!40000 ALTER TABLE `JoinOptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tariff`
--

DROP TABLE IF EXISTS `Tariff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tariff` (
  `tariff_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`tariff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tariff`
--

LOCK TABLES `Tariff` WRITE;
/*!40000 ALTER TABLE `Tariff` DISABLE KEYS */;
INSERT INTO `Tariff` VALUES (1,'base',50),(2,'gb1',50),(3,'gb2',100),(4,'call1',50),(5,'call2',150),(6,'unlim',200);
/*!40000 ALTER TABLE `Tariff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TariffOption`
--

DROP TABLE IF EXISTS `TariffOption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TariffOption` (
  `tariffOption_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `connectionPrice` double DEFAULT NULL,
  PRIMARY KEY (`tariffOption_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TariffOption`
--

LOCK TABLES `TariffOption` WRITE;
/*!40000 ALTER TABLE `TariffOption` DISABLE KEYS */;
INSERT INTO `TariffOption` VALUES (1,'basic',50,0),(2,'addbg1',100,50),(3,'addgb2',150,100),(4,'addcall1',50,0),(5,'addcall2',150,100),(7,'new',10,10),(8,'test1',10,10),(9,'test2',20,20);
/*!40000 ALTER TABLE `TariffOption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TariffRules`
--

DROP TABLE IF EXISTS `TariffRules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TariffRules` (
  `tariffRules_id` int(11) NOT NULL,
  `tariff_id` int(11) NOT NULL,
  `possibleTariffOption_id` int(11) NOT NULL,
  PRIMARY KEY (`tariffRules_id`),
  KEY `fk_TariffRules_Tariff1_idx` (`tariff_id`),
  KEY `fk_TariffRules_TariffOption1_idx` (`possibleTariffOption_id`),
  CONSTRAINT `fk_TariffRules_Tariff1` FOREIGN KEY (`tariff_id`) REFERENCES `Tariff` (`tariff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TariffRules_TariffOption1` FOREIGN KEY (`possibleTariffOption_id`) REFERENCES `TariffOption` (`tariffOption_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TariffRules`
--

LOCK TABLES `TariffRules` WRITE;
/*!40000 ALTER TABLE `TariffRules` DISABLE KEYS */;
/*!40000 ALTER TABLE `TariffRules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `secondName` varchar(45) NOT NULL,
  `birthdayData` varchar(45) NOT NULL,
  `passport` varchar(45) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `balance` double NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `accessLevel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_User_AccessLevel1_idx` (`accessLevel_id`),
  CONSTRAINT `fk_User_AccessLevel1` FOREIGN KEY (`accessLevel_id`) REFERENCES `AccessLevel` (`accessLevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Ivan','Ivanov','08.10.1990','pass1','msk',0,'a@2.ru','b33fbec460bc69adc9e11096820d085f',1),(2,'Petr','Petrov','05.05.1995','pass2','nn',0,'b@b.ru','ced391e3f62664fb7ba2c76da4f20fd0',3),(3,'Ilya','Kirillov','12.11.1950','pass3','dzr',0,'c@b.ru','fd42e679d255ac283058ea7385002b8e',1),(4,'Artem','Ivanov','07.10.1990','pass4','msk',0,'d@b.ru','041e8f747bd683184cab2f3f158f9cba',1),(5,'Kirill','Ivanov','18.11.1999','pass5','ny',0,'e@b.ru','ac0d7fab6ce98dcbb6d9ff10ecd0eb17',1),(7,'Petr','Ivanov','08.10.2000','123','spb',0,'a@b.ru','5fc45feba51bb8356415fa07433399c1',1),(17,'temp','temp','08.10.2015','pasport','spb',0,'tem@temp.ru','cd7dcde13c1640e945adedcfc116fbe2',1),(21,'art','kar','08.10.2012','pass','spb',0,'art@kar.ru','8a8557aeb039eca26a0e5c427e06135a',1);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2016-10-08  1:53:39
