-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bicicletas
-- ------------------------------------------------------
-- Server version	8.0.31

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

--
-- Table structure for table `administrador`
--

CREATE DATABASE bicicletas;
USE bicicletaras; 

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `AdId` int unsigned NOT NULL AUTO_INCREMENT,
  `AdNombre` varchar(30) DEFAULT NULL,
  `AdApellidos` varchar(45) DEFAULT NULL,
  `AdTipo` enum('empleado','jefe','gerente') NOT NULL,
  `AdSalario` int DEFAULT NULL,
  `AdFechaEntrada` date NOT NULL,
  `AdContraseña` varchar(64) NOT NULL,
  PRIMARY KEY (`AdId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'SuperAdmin','Administracion','gerente',1000,'2023-04-28','001950a7e5beb1c3f6b31bd4f55ea3660305c260f0db5ad8ed2e13811a0c95b5'),(2,'BMFlexing Shop','Administrador','gerente',0,'2023-05-04','001950a7e5beb1c3f6b31bd4f55ea3660305c260f0db5ad8ed2e13811a0c95b5');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bicicleta`
--

DROP TABLE IF EXISTS `bicicleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bicicleta` (
  `BiId` int unsigned NOT NULL AUTO_INCREMENT,
  `BiNombre` varchar(50) NOT NULL,
  `BiPrecio` int unsigned NOT NULL,
  `BiRuedas` int unsigned NOT NULL,
  `BiShock` int unsigned NOT NULL,
  `BiHorquilla` int unsigned NOT NULL,
  `BiCuadro` int unsigned NOT NULL,
  `BiFrenos` int unsigned NOT NULL,
  PRIMARY KEY (`BiId`),
  KEY `fk_pieza_idx` (`BiRuedas`,`BiShock`,`BiHorquilla`,`BiCuadro`,`BiFrenos`),
  KEY `bicicleta_recambios_Horquilla_fk` (`BiHorquilla`),
  KEY `bicicleta_recambios_Cuadro_fk` (`BiCuadro`),
  KEY `bicicleta_recambios_Frenos_fk` (`BiFrenos`),
  KEY `bicicleta_recambios_ReId_fk2` (`BiShock`),
  CONSTRAINT `bicicleta_recambios_Cuadro_fk` FOREIGN KEY (`BiCuadro`) REFERENCES `recambios` (`ReId`),
  CONSTRAINT `bicicleta_recambios_Frenos_fk` FOREIGN KEY (`BiFrenos`) REFERENCES `recambios` (`ReId`),
  CONSTRAINT `bicicleta_recambios_Horquilla_fk` FOREIGN KEY (`BiHorquilla`) REFERENCES `recambios` (`ReId`),
  CONSTRAINT `bicicleta_recambios_ReId_fk` FOREIGN KEY (`BiRuedas`) REFERENCES `recambios` (`ReId`),
  CONSTRAINT `bicicleta_recambios_ReId_fk2` FOREIGN KEY (`BiShock`) REFERENCES `recambios` (`ReId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bicicleta`
--

LOCK TABLES `bicicleta` WRITE;
/*!40000 ALTER TABLE `bicicleta` DISABLE KEYS */;
INSERT INTO `bicicleta` VALUES (2,'Giant aluminum 2018',4250,13,14,9,10,7),(3,'Sworks ',5500,1,2,3,4,5);
/*!40000 ALTER TABLE `bicicleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `FacId` int unsigned NOT NULL AUTO_INCREMENT,
  `FacImporte` int unsigned NOT NULL,
  `FacCliente` int unsigned NOT NULL,
  `FacEmpleado` int unsigned NOT NULL,
  `FacNombreArticulo` varchar(120) DEFAULT NULL,
  `FacTipo` enum('recambio','bicicleta') DEFAULT NULL,
  PRIMARY KEY (`FacId`),
  KEY `fk_cliente_idx` (`FacCliente`),
  KEY `fk_empleado_idx` (`FacEmpleado`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`FacCliente`) REFERENCES `usuario` (`UsId`),
  CONSTRAINT `fk_empleado` FOREIGN KEY (`FacEmpleado`) REFERENCES `administrador` (`AdId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (2,1000,1,1,'CUCUCU','recambio'),(5,1200,1,1,'sacac','recambio');
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recambios`
--

DROP TABLE IF EXISTS `recambios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recambios` (
  `ReId` int unsigned NOT NULL AUTO_INCREMENT,
  `ReNombre` varchar(65) NOT NULL,
  `RePrecio` int unsigned NOT NULL,
  `ReTipo` enum('ruedas','shock','horquilla','cuadro','frenos') NOT NULL,
  PRIMARY KEY (`ReId`),
  UNIQUE KEY `ReNombre_UNIQUE` (`ReNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recambios`
--

LOCK TABLES `recambios` WRITE;
/*!40000 ALTER TABLE `recambios` DISABLE KEYS */;
INSERT INTO `recambios` VALUES (1,'Mavic Ksyrium Elite',799,'ruedas'),(2,'Shimano XTR',299,'frenos'),(3,'RockShox SID Ultimate',899,'horquilla'),(4,'Specialized S-Works',2399,'cuadro'),(5,'Fox Float DPX2',499,'shock'),(6,'Zipp 404 Firecrest',999,'ruedas'),(7,'SRAM Code RSC',599,'frenos'),(8,'Shimano SLX M7100',229,'frenos'),(9,'RockShox Pike Ultimate',949,'horquilla'),(10,'Giant Reign',1299,'cuadro'),(11,'Shimano Dura-Ace',1499,'ruedas'),(13,'Mavic Crossmax Elite',799,'ruedas'),(14,'Fox Float DPX1',599,'shock'),(15,'Fox 34 Factory',999,'horquilla'),(16,'Super Deluxe RCT',335,'shock'),(17,'Marzocchi Bomber CR',305,'shock'),(18,'Yt Tues Core 4',3200,'cuadro'),(19,'Mondraker Summun RR',2499,'cuadro'),(20,'Manillar to guapo',100,'shock');
/*!40000 ALTER TABLE `recambios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `UsId` int unsigned NOT NULL AUTO_INCREMENT,
  `UsNombre` varchar(40) NOT NULL,
  `UsContraseña` varchar(64) NOT NULL,
  `UsPago` enum('Credito','Debito','PayPal') DEFAULT NULL,
  `UsFechaCuenta` date DEFAULT NULL,
  PRIMARY KEY (`UsId`),
  UNIQUE KEY `UsId_UNIQUE` (`UsId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Prueba','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','PayPal','2023-04-27'),(2,'Manolo','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','PayPal','2023-04-27'),(3,'Manolin','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','Debito','2023-04-27'),(4,'Yeison','afc73ffb3c195e82b97d8782d4c9766bfab8cd9bbeb7b58ae05399d4bf8a71a5','Credito','2023-04-27'),(5,'Admin','001950a7e5beb1c3f6b31bd4f55ea3660305c260f0db5ad8ed2e13811a0c95b5','Credito','2023-04-27'),(6,'ad','001950a7e5beb1c3f6b31bd4f55ea3660305c260f0db5ad8ed2e13811a0c95b5','Credito','2023-04-28'),(7,'Hell','001950a7e5beb1c3f6b31bd4f55ea3660305c260f0db5ad8ed2e13811a0c95b5','Credito','2023-04-28');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-05 13:51:35
