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
-- Table structure for table `coches`
--

DROP TABLE IF EXISTS `coches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coches` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `marca` varchar(255) NOT NULL,
  `modelo` int NOT NULL,
  `gama_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlgwbedf68f6kjkk74y80r8yyo` (`gama_id`),
  CONSTRAINT `FKlgwbedf68f6kjkk74y80r8yyo` FOREIGN KEY (`gama_id`) REFERENCES `tipo de gama` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coches`
--

LOCK TABLES `coches` WRITE;
/*!40000 ALTER TABLE `coches` DISABLE KEYS */;
INSERT INTO `coches` VALUES (1,'Ferrari',1992,3),(2,'BMW',1992,1),(3,'Aston Martin',2000,2),(4,'Porsche',1980,3),(5,'Mercedes Benz',1985,2),(9,'Porsche',1980,NULL),(10,'Mercedes Benz',1985,NULL),(11,'Ferrari',1990,NULL),(12,'BMW',1992,NULL),(13,'Aston Martin',2000,3),(14,'Porsche',1980,NULL),(15,'Mercedes Benz',1985,3),(16,'Ferrari',1990,NULL),(17,'BMW',1992,NULL),(18,'Aston Martin',2000,NULL),(19,'Porsche',1980,NULL),(20,'Mercedes Benz',1985,NULL),(21,'Ferrari',1990,NULL),(22,'BMW',1992,NULL),(23,'Aston Martin',2000,NULL),(24,'Porsche',1980,NULL),(25,'Mercedes Benz',1985,NULL),(26,'Ferrari',1990,NULL),(27,'BMW',1992,NULL),(28,'Aston Martin',2000,NULL),(29,'Porsche',1980,NULL),(30,'Mercedes Benz',1985,NULL),(31,'Ferrari',1990,NULL),(32,'BMW',1992,NULL),(33,'Aston Martin',2000,NULL),(34,'Porsche',1980,NULL),(35,'Mercedes Benz',1985,NULL),(36,'Aston Martin',1982,1),(37,'Aston Martin',1982,1),(38,'Ferrari',1990,NULL),(39,'BMW',1992,NULL),(40,'Aston Martin',2000,NULL),(41,'Porsche',1980,NULL),(42,'Mercedes Benz',1985,NULL),(43,'Ferrari',1990,NULL),(44,'BMW',1992,NULL),(45,'Aston Martin',2000,NULL),(46,'Porsche',1980,NULL),(47,'Mercedes Benz',1985,NULL),(48,'Ferrari',1990,NULL),(49,'BMW',1992,NULL),(50,'Aston Martin',2000,NULL),(51,'Porsche',1980,NULL),(52,'Mercedes Benz',1985,NULL),(53,'Ferrari',1990,NULL),(54,'BMW',1992,NULL),(55,'Aston Martin',2000,NULL),(56,'Porsche',1980,NULL),(57,'Mercedes Benz',1985,NULL),(58,'Ferrari',1990,NULL),(59,'BMW',1992,NULL),(60,'Aston Martin',2000,NULL),(61,'Porsche',1980,NULL),(62,'Mercedes Benz',1985,NULL),(63,'Ferrari',1990,NULL),(64,'BMW',1992,NULL),(65,'Aston Martin',2000,NULL),(66,'Porsche',1980,NULL),(67,'Mercedes Benz',1985,NULL),(68,'Ferrari',1990,NULL),(69,'BMW',1992,NULL),(70,'Aston Martin',2000,NULL),(71,'Porsche',1980,NULL),(72,'Mercedes Benz',1985,NULL),(73,'Ferrari',1990,NULL),(74,'BMW',1992,NULL),(75,'Aston Martin',2000,NULL),(76,'Porsche',1980,NULL),(77,'Mercedes Benz',1985,NULL),(78,'Ferrari',1990,NULL),(79,'BMW',1992,NULL),(80,'Aston Martin',2000,NULL),(81,'Porsche',1980,NULL),(82,'Mercedes Benz',1985,NULL),(83,'Ferrari',1990,NULL),(84,'BMW',1992,NULL),(85,'Aston Martin',2000,NULL),(86,'Porsche',1980,NULL),(87,'Mercedes Benz',1985,NULL),(88,'Ferrari',1990,NULL),(89,'BMW',1992,NULL),(90,'Aston Martin',2000,NULL),(91,'Porsche',1980,NULL),(92,'Mercedes Benz',1985,NULL);
/*!40000 ALTER TABLE `coches` ENABLE KEYS */;
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
