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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-08  1:52:20
