-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.14 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.0.0.4530
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных school
DROP DATABASE IF EXISTS `school`;
CREATE DATABASE IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `school`;


-- Дамп структуры для таблица school.address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `house` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы school.address: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT IGNORE INTO `address` (`id`, `city`, `street`, `house`) VALUES
	(1, 'St.Pete', '13 line VO', 12),
	(2, 'Voronezh', 'Lenina', 10),
	(3, 'Ekaterinburg', 'Mira', 22);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


-- Дамп структуры для таблица school.js_entrance_test
DROP TABLE IF EXISTS `js_entrance_test`;
CREATE TABLE IF NOT EXISTS `js_entrance_test` (
  `id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы school.js_entrance_test: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `js_entrance_test` DISABLE KEYS */;
INSERT IGNORE INTO `js_entrance_test` (`id`, `student_id`, `note`) VALUES
	(1, 1, 111),
	(2, 1, 80),
	(3, 1, 90);
/*!40000 ALTER TABLE `js_entrance_test` ENABLE KEYS */;


-- Дамп структуры для таблица school.js_lection
DROP TABLE IF EXISTS `js_lection`;
CREATE TABLE IF NOT EXISTS `js_lection` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы school.js_lection: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `js_lection` DISABLE KEYS */;
INSERT IGNORE INTO `js_lection` (`id`, `name`, `date`) VALUES
	(1, 'JPA', '2014-03-18'),
	(2, 'BLogging', '2014-03-18'),
	(4, 'JSF', '2014-03-18');
/*!40000 ALTER TABLE `js_lection` ENABLE KEYS */;


-- Дамп структуры для таблица school.js_schedule
DROP TABLE IF EXISTS `js_schedule`;
CREATE TABLE IF NOT EXISTS `js_schedule` (
  `lecture_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  KEY `FK_LECTURE` (`lecture_id`),
  KEY `FK_STUDENT` (`student_id`),
  CONSTRAINT `FK_LECTURE` FOREIGN KEY (`lecture_id`) REFERENCES `js_lection` (`id`),
  CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) REFERENCES `js_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы school.js_schedule: ~11 rows (приблизительно)
/*!40000 ALTER TABLE `js_schedule` DISABLE KEYS */;
INSERT IGNORE INTO `js_schedule` (`lecture_id`, `student_id`) VALUES
	(1, 1),
	(2, 1),
	(2, 2),
	(4, 2),
	(4, 2),
	(4, 2),
	(4, 2),
	(4, 2),
	(4, 2),
	(4, 2),
	(4, 2);
/*!40000 ALTER TABLE `js_schedule` ENABLE KEYS */;


-- Дамп структуры для таблица school.js_schools
DROP TABLE IF EXISTS `js_schools`;
CREATE TABLE IF NOT EXISTS `js_schools` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы school.js_schools: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `js_schools` DISABLE KEYS */;
INSERT IGNORE INTO `js_schools` (`id`, `name`) VALUES
	(1, 'Java School 1');
/*!40000 ALTER TABLE `js_schools` ENABLE KEYS */;


-- Дамп структуры для таблица school.js_student
DROP TABLE IF EXISTS `js_student`;
CREATE TABLE IF NOT EXISTS `js_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SCHOOL` (`school_id`),
  KEY `FK_ADDRESS` (`address_id`),
  CONSTRAINT `FK_ADDRESS` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SCHOOL` FOREIGN KEY (`school_id`) REFERENCES `js_schools` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы school.js_student: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `js_student` DISABLE KEYS */;
INSERT IGNORE INTO `js_student` (`id`, `first_name`, `last_name`, `date_of_birth`, `school_id`, `address_id`) VALUES
	(1, '1', 'Buloff', '2014-03-17', 1, 1),
	(2, 'Vasya', 'Pupkin', '2014-03-18', 1, 2),
	(3, 'Fedor', 'Gaykin', '2014-03-17', 1, 3),
	(4, 'Fedor', 'Sumkin', '2014-03-18', 1, NULL),
	(5, 'Fedor ', 'Baggins', '2014-03-18', 1, NULL);
/*!40000 ALTER TABLE `js_student` ENABLE KEYS */;


-- Дамп структуры для таблица school.js_users
DROP TABLE IF EXISTS `js_users`;
CREATE TABLE IF NOT EXISTS `js_users` (
  `id` int(11) NOT NULL,
  `login` varchar(50) DEFAULT NULL,
  `padawan` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PADAWAN` (`padawan`),
  CONSTRAINT `FK_PADAWAN` FOREIGN KEY (`padawan`) REFERENCES `js_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы school.js_users: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `js_users` DISABLE KEYS */;
INSERT IGNORE INTO `js_users` (`id`, `login`, `padawan`, `type`) VALUES
	(1, 'abulov', 5, 1),
	(2, 'dshulgin', 2, 1),
	(3, 'sputay', 3, 2),
	(4, 'bragin', 4, 2);
/*!40000 ALTER TABLE `js_users` ENABLE KEYS */;


-- Дамп структуры для таблица school.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы school.user: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT IGNORE INTO `user` (`id`, `name`, `birthdate`) VALUES
	(1, 'Andrey', '2014-03-17'),
	(2, 'Vasya', '2014-03-21'),
	(3, 'Petya', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
