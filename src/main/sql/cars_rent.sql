-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cars_rent
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `regNumber` varchar(45) NOT NULL,
  `status` enum('IDLE','IN_USE','IN_MAINTAINANCE','WRITTEN_OFF') NOT NULL DEFAULT 'IDLE',
  `cars_spec_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`cars_spec_id`),
  KEY `fk_cars_cars_info1_idx` (`cars_spec_id`),
  CONSTRAINT `fk_cars_cars_info1` FOREIGN KEY (`cars_spec_id`) REFERENCES `cars_specification` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (1,'ла231з','IDLE',3),(2,'щц923ц','IDLE',4),(3,'со195ч','WRITTEN_OFF',2),(4,'кс710у','IDLE',7),(5,'ог198п','IDLE',2),(6,'яо825ч','IDLE',9),(7,'те395у','IDLE',10),(8,'лу045с','IN_MAINTAINANCE',15),(9,'сс777с','IDLE',1),(10,'уи428ц','IN_MAINTAINANCE',5),(11,'зч264а','IDLE',4);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars_specification`
--

DROP TABLE IF EXISTS `cars_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars_specification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `year_made` smallint(6) NOT NULL,
  `pricePerDay` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars_specification`
--

LOCK TABLES `cars_specification` WRITE;
/*!40000 ALTER TABLE `cars_specification` DISABLE KEYS */;
INSERT INTO `cars_specification` VALUES (1,'Ford','Mustang',2015,130),(2,'Hyundai','Solaris',2013,50),(3,'Hyundai','Solaris',2011,45),(4,'Audi','A4',2018,100),(5,'BMW','X1',2015,90),(7,'Audi','Q3',2014,80),(8,'Kia','Optima',2015,76),(9,'Kia','Rio',2018,80),(10,'Kia','Rio',2012,50),(11,'Fiat','Albea',2013,67),(12,'Toyota','Land Cruiser L200',2019,200),(13,'Mercedes','C-class',2017,140),(14,'Seat','Leon',2012,85),(15,'Skoda','Yeti',2010,55),(16,'Ford','Kuga',2017,59),(17,'Renault','Duster',2015,65);
/*!40000 ALTER TABLE `cars_specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `users_id` int(11) NOT NULL,
  `cars_id` int(11) NOT NULL,
  `status` enum('IN_WAITING','APPROVED','DENIED','CANCELED_BY_USER') NOT NULL DEFAULT 'IN_WAITING',
  `price_per_day` double NOT NULL,
  `total_price` double NOT NULL,
  `add_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orders_users_idx` (`users_id`),
  KEY `fk_orders_car_fleet1_idx` (`cars_id`),
  CONSTRAINT `fk_orders_car_fleet1` FOREIGN KEY (`cars_id`) REFERENCES `cars` (`id`),
  CONSTRAINT `fk_orders_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2019-08-29','2019-09-01',8,4,'DENIED',80,320,NULL),(3,'2019-08-30','2019-09-06',14,11,'APPROVED',100,800,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `secondName` varchar(45) DEFAULT NULL,
  `role` enum('ADMIN','CLIENT') NOT NULL DEFAULT 'CLIENT',
  `status` enum('ACTIVE','BLOCKED','DELETED') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (8,'ivan','','Иван','Нифедов','CLIENT','ACTIVE'),(9,'andrew','','Андрей','Леонов','CLIENT','ACTIVE'),(10,'str123','','Олег','Киреев','CLIENT','ACTIVE'),(11,'george1','','Георгий','Титов','CLIENT','ACTIVE'),(12,'kill_bill','','Квентин','Тарантино','CLIENT','ACTIVE'),(13,'super_god','',NULL,NULL,'ADMIN','ACTIVE'),(14,'perq777','','Петр','Фишер','CLIENT','ACTIVE'),(15,'rabbit_me','','Роман','Хлебов','CLIENT','BLOCKED'),(16,'real_thug69','','Сергей','Полежайкин','CLIENT','ACTIVE'),(19,'second_manager','',NULL,NULL,'ADMIN','ACTIVE'),(20,'igorIgor','','Игорь','Великий','CLIENT','ACTIVE');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-28 11:40:44
