-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 08-02-2022 a las 18:07:52
-- Versión del servidor: 8.0.28-0ubuntu0.20.04.3
-- Versión de PHP: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `examen2022`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `form_lang`
--

CREATE TABLE `form_lang` (
  `idioma` varchar(2) NOT NULL,
  `camp` varchar(15) NOT NULL,
  `text` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `form_lang`
--

INSERT INTO `form_lang` (`idioma`, `camp`, `text`) VALUES
('ca', 'alemany', 'Alemany'),
('ca', 'angles', 'Anglés'),
('ca', 'benvinguts', 'Benvinguts'),
('ca', 'catala', 'Català'),
('ca', 'catalunya', 'Catalunya'),
('ca', 'escocia', 'Escòcia'),
('ca', 'espanyol', 'Espanyol'),
('ca', 'identificat', 'Identifica\'t'),
('ca', 'idioma', 'Idioma'),
('ca', 'islandia', 'Islàndia'),
('ca', 'title', 'Exàmen DAW2 M07 UF2 2021-2022'),
('de', 'alemany', 'Deutsch'),
('de', 'angles', 'Englisch'),
('de', 'benvinguts', 'Willkommen'),
('de', 'catala', 'katalanisch'),
('de', 'catalunya', 'Katalonien'),
('de', 'escocia', 'Schottland'),
('de', 'espanyol', 'Spanisch'),
('de', 'identificat', 'Identifizieren Sie sich'),
('de', 'idioma', 'Sprache'),
('de', 'islandia', 'Island'),
('es', 'alemany', 'Alemán'),
('es', 'angles', 'Inglés'),
('es', 'benvinguts', 'Bienvenidos'),
('es', 'catala', 'Catalán'),
('es', 'catalunya', 'Cataluña'),
('es', 'escocia', 'Escocia'),
('es', 'espanyol', 'Español'),
('es', 'identificat', 'Identifícate'),
('es', 'idioma', 'Idioma'),
('es', 'islandia', 'Islandia'),
('es', 'title', 'Examen DAW2 M07 UF2 2021-2022'),
('gb', 'alemany', 'German'),
('gb', 'angles', 'English'),
('gb', 'benvinguts', 'Wellcome'),
('gb', 'catala', 'Catalan'),
('gb', 'catalunya', 'Catalonia'),
('gb', 'escocia', 'Scotland'),
('gb', 'espanyol', 'Spanish'),
('gb', 'identificat', 'Log-in'),
('gb', 'idioma', 'Language'),
('gb', 'islandia', 'iceland'),
('gb', 'title', 'DAW2 Exam M07 UF2 2021-2022'),
('ge', 'titl', 'DAW2 Prüfung M07 UF2 2021-2022');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `form_lang`
--
ALTER TABLE `form_lang`
  ADD PRIMARY KEY (`idioma`,`camp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
