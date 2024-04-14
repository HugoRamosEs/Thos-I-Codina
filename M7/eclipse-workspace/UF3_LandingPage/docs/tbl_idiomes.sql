-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Temps de generació: 21-03-2023 a les 20:08:33
-- Versió del servidor: 8.0.32-0ubuntu0.22.04.2
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

-- --------------------------------------------------------

DROP TABLE IF EXISTS `tbl_traduccions`;
DROP TABLE IF EXISTS `tbl_idiomes`;

--
-- Estructura de la taula `tbl_idiomes`
--

CREATE TABLE `tbl_idiomes` (
  `id` bigint UNSIGNED NOT NULL,
  `iso` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `imatge` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `actiu` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Bolcament de dades per a la taula `tbl_idiomes`
--

INSERT INTO `tbl_idiomes` VALUES 
(33,'cat','uploads/1713083656242.png',1,'2024-04-14 08:34:16','2024-04-14 08:34:16'),
(34,'de','uploads/1713083737825.png',1,'2024-04-14 08:35:37','2024-04-14 08:35:37'),
(35,'es','uploads/1713083794760.png',1,'2024-04-14 08:36:34','2024-04-14 08:36:34'),
(36,'fr','uploads/1713083875994.png',1,'2024-04-14 08:37:55','2024-04-14 08:37:55'),
(37,'gb','uploads/1713084000111.png',1,'2024-04-14 08:40:00','2024-04-14 08:40:00');

-- --------------------------------------------------------

--
-- Estructura de la taula `tbl_traduccions`
--

CREATE TABLE `tbl_traduccions` (
  `id` bigint UNSIGNED NOT NULL,
  `variable` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `idioma_id` bigint UNSIGNED NOT NULL,
  `valor` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Bolcament de dades per a la taula `tbl_traduccions`
--

INSERT INTO `tbl_traduccions` VALUES 
(665,'cat',38,'Català','2024-04-14 08:34:16','2024-04-14 08:34:16'),
(666,'cat',39,'Katalanisch','2024-04-14 08:35:37','2024-04-14 08:42:07'),
(667,'de',39,'Deutsch','2024-04-14 08:35:37','2024-04-14 08:35:37'),
(668,'de',38,'Alemany','2024-04-14 08:35:37','2024-04-14 08:41:06'),
(669,'de',40,'Alemán','2024-04-14 08:36:34','2024-04-14 08:42:59'),
(670,'cat',40,'Catalán','2024-04-14 08:36:34','2024-04-14 08:42:59'),
(671,'es',40,'Español','2024-04-14 08:36:34','2024-04-14 08:42:59'),
(672,'es',39,'Spanisch','2024-04-14 08:36:34','2024-04-14 08:42:07'),
(673,'es',38,'Espanyol','2024-04-14 08:36:34','2024-04-14 08:41:06'),
(674,'es',41,'Espagnol','2024-04-14 08:37:55','2024-04-14 08:43:41'),
(675,'de',41,'Allemand','2024-04-14 08:37:55','2024-04-14 08:37:55'),
(676,'cat',41,'Catalan','2024-04-14 08:37:55','2024-04-14 08:37:55'),
(677,'fr',41,'Français','2024-04-14 08:37:55','2024-04-14 08:37:55'),
(678,'fr',40,'Francés','2024-04-14 08:37:55','2024-04-14 08:42:59'),
(679,'fr',39,'Französisch','2024-04-14 08:37:55','2024-04-14 08:42:07'),
(680,'fr',38,'Francès','2024-04-14 08:37:55','2024-04-14 08:41:06'),
(681,'fr',42,'French','2024-04-14 08:40:00','2024-04-14 08:40:00'),
(682,'es',42,'Spanish','2024-04-14 08:40:00','2024-04-14 08:40:00'),
(683,'de',42,'German','2024-04-14 08:40:00','2024-04-14 08:40:00'),
(684,'cat',42,'Catalan','2024-04-14 08:40:00','2024-04-14 08:40:00'),
(685,'gb',42,'English','2024-04-14 08:40:00','2024-04-14 08:40:00'),
(686,'gb',41,'Anglais','2024-04-14 08:40:00','2024-04-14 08:43:41'),
(687,'gb',40,'Inglés','2024-04-14 08:40:00','2024-04-14 08:42:59'),
(688,'gb',39,'Englisch','2024-04-14 08:40:00','2024-04-14 08:42:07'),
(689,'gb',38,'Anglès','2024-04-14 08:40:00','2024-04-14 08:41:06');

-- --------------------------------------------------------

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `tbl_idiomes`
--
ALTER TABLE `tbl_idiomes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tbl_idiomes_iso_unique` (`iso`);

--
-- Índexs per a la taula `tbl_traduccions`
--
ALTER TABLE `tbl_traduccions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tbl_traduccions_idioma_id_foreign` (`idioma_id`);


--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `tbl_idiomes`
--
ALTER TABLE `tbl_idiomes`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT per la taula `tbl_traduccions`
--
ALTER TABLE `tbl_traduccions`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=690;

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `tbl_traduccions`
--
ALTER TABLE `tbl_traduccions`
  ADD CONSTRAINT `tbl_traduccions_idioma_id_foreign` FOREIGN KEY (`idioma_id`) REFERENCES `tbl_idiomes` (`id`);


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;