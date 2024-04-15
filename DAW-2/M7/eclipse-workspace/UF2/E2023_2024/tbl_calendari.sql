-- phpMyAdmin SQL Dump
-- version 5.2.1-2.fc39
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 25-01-2024 a las 07:12:27
-- Versión del servidor: 8.0.35
-- Versión de PHP: 8.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `myweb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_calendari`
--

CREATE TABLE `tbl_calendari` (
  `id` int NOT NULL,
  `nom` varchar(250) NOT NULL,
  `des_de` date NOT NULL,
  `a` date DEFAULT NULL,
  `etiqueta` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tbl_calendari`
--

INSERT INTO `tbl_calendari` (`id`, `nom`, `des_de`, `a`, `etiqueta`) VALUES
(1, 'Examen M07 UF2', '2024-01-31', NULL, '17:00'),
(2, 'Entrega de la Pràctica M03 E10 Escacs', '2024-02-04', NULL, '23:55'),
(5, 'Examen M03 UF5', '2024-02-06', NULL, '16:15'),
(6, 'Vacances.... podeu descansar', '2024-02-12', '2024-02-18', 'All day');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_calendari`
--
ALTER TABLE `tbl_calendari`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_calendari`
--
ALTER TABLE `tbl_calendari`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

SELECT * FROM `tbl_calendari`;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
