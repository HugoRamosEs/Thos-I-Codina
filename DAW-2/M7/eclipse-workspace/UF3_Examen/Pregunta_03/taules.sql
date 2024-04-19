-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: examenM07UF3_2023
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE examenM07UF3_2023;
USE examenM07UF3_2023;

--
-- Table structure for table `DATA`
--

DROP TABLE IF EXISTS `DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DATA` (
  `id` int NOT NULL AUTO_INCREMENT,
  `DATA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `HORA` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATA`
--

LOCK TABLES `DATA` WRITE;
/*!40000 ALTER TABLE `DATA` DISABLE KEYS */;
/*!40000 ALTER TABLE `DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENTRADA`
--

DROP TABLE IF EXISTS `ENTRADA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENTRADA` (
  `event_id` int DEFAULT NULL,
  `data_id` int DEFAULT NULL,
  `loc_id` int DEFAULT NULL,
  `zona_id` int DEFAULT NULL,
  `pagament_id` int DEFAULT NULL,
  `ID` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `FILA` int NOT NULL,
  `BUTACA` int NOT NULL,
  `DNI` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_F60C5C6E71F7E88B` (`event_id`),
  KEY `IDX_F60C5C6E37F5A13C` (`data_id`),
  KEY `IDX_F60C5C6E6505CAD1` (`loc_id`),
  KEY `IDX_F60C5C6E104EA8FC` (`zona_id`),
  KEY `IDX_F60C5C6E66C49110` (`pagament_id`),
  CONSTRAINT `FK_F60C5C6E104EA8FC` FOREIGN KEY (`zona_id`) REFERENCES `ZONA` (`id`),
  CONSTRAINT `FK_F60C5C6E37F5A13C` FOREIGN KEY (`data_id`) REFERENCES `DATA` (`id`),
  CONSTRAINT `FK_F60C5C6E6505CAD1` FOREIGN KEY (`loc_id`) REFERENCES `LOCALITZACIO` (`id`),
  CONSTRAINT `FK_F60C5C6E66C49110` FOREIGN KEY (`pagament_id`) REFERENCES `PAGAMENT` (`id`),
  CONSTRAINT `FK_F60C5C6E71F7E88B` FOREIGN KEY (`event_id`) REFERENCES `EVENT` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENTRADA`
--

LOCK TABLES `ENTRADA` WRITE;
/*!40000 ALTER TABLE `ENTRADA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ENTRADA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT`
--

DROP TABLE IF EXISTS `EVENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EVENT` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TITOL` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `SUTBITOL` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `IMATGE` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT`
--

LOCK TABLES `EVENT` WRITE;
/*!40000 ALTER TABLE `EVENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `EVENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOCALITZACIO`
--

DROP TABLE IF EXISTS `LOCALITZACIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LOCALITZACIO` (
  `id` int NOT NULL AUTO_INCREMENT,
  `LLOC` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `ACRECA` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `LOCALITAT` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOCALITZACIO`
--

LOCK TABLES `LOCALITZACIO` WRITE;
/*!40000 ALTER TABLE `LOCALITZACIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `LOCALITZACIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAGAMENT`
--

DROP TABLE IF EXISTS `PAGAMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PAGAMENT` (
  `id` int NOT NULL AUTO_INCREMENT,
  `BANC` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `REF_EXTERNA` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `DATA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ESTAT` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAGAMENT`
--

LOCK TABLES `PAGAMENT` WRITE;
/*!40000 ALTER TABLE `PAGAMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `PAGAMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ZONA`
--

DROP TABLE IF EXISTS `ZONA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ZONA` (
  `id` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCIO` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ZONA`
--

LOCK TABLES `ZONA` WRITE;
/*!40000 ALTER TABLE `ZONA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ZONA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-20 17:40:39

