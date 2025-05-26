-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: coderhouse
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `tipo de gama`
--

DROP TABLE IF EXISTS `tipo de gama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo de gama` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tipo de gama` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo de gama`
--

LOCK TABLES `tipo de gama` WRITE;
/*!40000 ALTER TABLE `tipo de gama` DISABLE KEYS */;
INSERT INTO `tipo de gama` VALUES (1,'Gama baja'),(2,'Gama media'),(3,'Gama alta'),(5,'Gama-media'),(6,'Gama alta'),(7,'Gama baja'),(8,'Gama media'),(9,'Gama alta'),(10,'Gama baja'),(11,'Gama media'),(12,'Gama alta'),(13,'Gama baja'),(14,'Gama media'),(15,'Gama alta'),(16,'Gama baja'),(17,'Gama media'),(18,'Gama alta'),(19,'Gama baja'),(20,'Gama media'),(21,'Gama alta'),(22,'Gama baja'),(23,'Gama media'),(24,'Gama alta'),(25,'Gama media-baja'),(26,'Gama media-alta'),(27,'Gama baja'),(28,'Gama media'),(29,'Gama alta'),(30,'Gama baja'),(31,'Gama media'),(32,'Gama alta'),(33,'Gama baja'),(34,'Gama media'),(35,'Gama alta'),(36,'Gama baja'),(37,'Gama media'),(38,'Gama alta'),(39,'Gama baja'),(40,'Gama media'),(41,'Gama alta'),(42,'Gama baja'),(43,'Gama media'),(44,'Gama alta'),(45,'Gama baja'),(46,'Gama media'),(47,'Gama alta'),(48,'Gama baja'),(49,'Gama media'),(50,'Gama alta'),(51,'Gama baja'),(52,'Gama media'),(53,'Gama alta'),(54,'Gama baja'),(55,'Gama media'),(56,'Gama alta');
/*!40000 ALTER TABLE `tipo de gama` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-25 17:10:48
