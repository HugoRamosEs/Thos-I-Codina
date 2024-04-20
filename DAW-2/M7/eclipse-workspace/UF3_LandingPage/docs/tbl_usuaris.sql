-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Temps de generació: 07-12-2022 a les 08:39:27
-- Versió del servidor: 8.0.31-0ubuntu0.22.04.1
-- Versió de PHP: 8.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `myweb`
--

DROP DATABASE IF EXISTS myweb;
CREATE DATABASE IF NOT EXISTS myweb CHARACTER SET utf8 COLLATE utf8_general_ci;
USE myweb;

-- --------------------------------------------------------

--
-- Estructura de la taula `tbl_usuaris`
--

DROP TABLE if exists `tbl_usuaris`;

CREATE TABLE `tbl_usuaris` (
  `id` int NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `tipusIdent` varchar(10) NOT NULL,
  `numeroIdent` varchar(15) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `cognoms` varchar(30) NOT NULL,
  `sexe` varchar(4) NOT NULL,
  `naixement` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `adreca` varchar(100) DEFAULT NULL,
  `codiPostal` varchar(5) DEFAULT NULL,
  `poblacio` varchar(40) DEFAULT NULL,
  `provincia` varchar(40) DEFAULT NULL,
  `telefon` varchar(12) DEFAULT NULL,
  `imatge` varchar(200) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '0' COMMENT ' 0: pendent 1:confirmat 2:administradors',
  `navegador` varchar(50) NOT NULL,
  `plataforma` varchar(50) NOT NULL,
  `dataCreacio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dataDarrerAcces` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Bolcament de dades per a la taula `tbl_usuaris`
--

INSERT INTO `tbl_usuaris` VALUES
(6444,'admin@gmail.com','Admin123','Nif','12345678Z','Admin','Admin','Home','01/01/1999',
'Carrer de la Flor, 23','08001','Barcelona','Barcelona','666666666','uploads/1713085361065.png',
1,'Chrome','Linux','2024-04-14 09:02:42','2024-04-14 09:02:41');

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `tbl_usuaris`
--

ALTER TABLE `tbl_usuaris`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `tbl_usuaris` (Modificado por la practica de las entradas).
--
/*
- MODIFICACION HECHA POR PROBLEMAS CON EL SCRIPT DE LA SIGUIENTE PRÁCTICA
ALTER TABLE `tbl_usuaris`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6430;
*/

ALTER TABLE `tbl_usuaris`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6445;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;