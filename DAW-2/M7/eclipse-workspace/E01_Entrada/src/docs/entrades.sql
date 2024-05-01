-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-03-2017 a las 12:36:41
-- Versión del servidor: 5.5.54-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `entrades`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DATA`
--

CREATE TABLE IF NOT EXISTS `DATA` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DATA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `HORA` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `DATA`
--

INSERT INTO `DATA` (`id`, `DATA`, `HORA`) VALUES
(1, '15/04/2020', '21:30'),
(2, '15/04/2020', '21:30'),
(3, '16/04/2020', '21:30'),
(4, '17/04/2020', '21:30'),
(5, '18/04/2020', '21:30'),
(6, '21/04/2020', '21:30'),
(7, '23/04/2020', '21:30'),
(8, '26/04/2020', '21:30'),
(9, '27/04/2020', '21:30'),
(10, '28/04/2020', '21:30'),
(11, '30/04/2020', '21:30'),
(12, '04/04/2020', '21:30'),
(13, '06/04/2020', '21:30'),
(14, '07/04/2020', '21:30'),
(15, '10/04/2020', '21:30'),
(16, '11/04/2020', '21:30'),
(17, '12/04/2020', '21:30'),
(18, '14/04/2020', '21:30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ENTRADA`
--

CREATE TABLE IF NOT EXISTS `ENTRADA` (
  `event_id` int(11) DEFAULT NULL,
  `data_id` int(11) DEFAULT NULL,
  `loc_id` int(11) DEFAULT NULL,
  `zona_id` int(11) DEFAULT NULL,
  `pagament_id` int(11) DEFAULT NULL,
  `ID` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `FILA` int(11) NOT NULL,
  `BUTACA` int(11) NOT NULL,
  `DNI` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_F60C5C6E71F7E88B` (`event_id`),
  KEY `IDX_F60C5C6E37F5A13C` (`data_id`),
  KEY `IDX_F60C5C6E6505CAD1` (`loc_id`),
  KEY `IDX_F60C5C6E104EA8FC` (`zona_id`),
  KEY `IDX_F60C5C6E66C49110` (`pagament_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `ENTRADA`
--

INSERT INTO `ENTRADA` (`event_id`, `data_id`, `loc_id`, `zona_id`, `pagament_id`, `ID`, `FILA`, `BUTACA`, `DNI`) VALUES
(6, 3, 7, 1, 3, '24831FCTM11BP6', 1, 22, '22404871F'),
(6, 6, 7, 1, 6, '24831FPTR1178A', 14, 6, '74003871M'),
(6, 4, 7, 1, 4, '24831KMMT5YM14', 2, 1, '22404871F'),
(6, 2, 7, 1, 2, '24831KRGX5YM14', 1, 20, '44003603A'),
(6, 7, 7, 1, 7, '24831LLQ1224RT', 9, 20, '46007007K'),
(6, 1, 7, 1, 1, '24831VDKRB95CR', 1, 18, '44003603A'),
(6, 5, 7, 1, 5, '2483MZRT18RP24', 2, 3, '22404871F'),
(3, 3, 1, 1, 3, '55032FCTM11BP6', 1, 22, '22404871F'),
(3, 6, 1, 1, 6, '55032FPTR1178A', 14, 6, '74003871M'),
(3, 4, 1, 1, 4, '55032KMMT5YM14', 2, 1, '22404871F'),
(3, 2, 1, 1, 2, '55032KRGX5YM14', 1, 20, '44003603A'),
(3, 7, 1, 1, 7, '55032LLQ1224RT', 9, 20, '46007007K'),
(3, 1, 1, 1, 1, '55032VDKRB95CR', 1, 18, '44003603A'),
(3, 5, 1, 1, 5, '55032ZRT18RP24', 2, 3, '22404871F');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `EVENT`
--

CREATE TABLE IF NOT EXISTS `EVENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TITOL` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `SUTBITOL` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `IMATGE` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `EVENT`
--

INSERT INTO `EVENT` (`id`, `TITOL`, `SUTBITOL`, `IMATGE`) VALUES
(1, 'Marina Bbface & The Beatroots en el Jamboree Jazz Club', 'La banda Marina BBface & The Beatroots se consolidÃ³ como uno de los grupos de mÃ¡s refere', 'img/DSC_7423ret2baixa1.jpg'),
(2, 'Tete Montoliu 80 + 4', 'El gran Tete Montoliu estÃ¡ considerado como el mÃºsico mÃ¡s internacional de Jazz del paÃ', 'img/tete-concierto-210217.original.jpg'),
(3, 'Elefantes', 'Elefantes recorrerÃ¡ algunas de las Salas y Teatros mÃ¡s importantes de nuestra geografÃ­a', 'img/240303_logo_Foto_horizontal_para_Ticketea_claim.jpg'),
(4, 'Carlos Vives', '', 'img/258729_logo_Carlos_Vives_ticketea_claim.jpg'),
(5, 'IZARO', '', 'img/257415_logo_izaro_claim.jpg'),
(6, 'THE VERY BEST OF DIRE STRAITS', 'bROTHES iN bAND. dIRE sTRAITS. The Very Best of dIRE sTRAITS SHOW', '051214124520_theverybestinternet.jpeg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LOCALITZACIO`
--

CREATE TABLE IF NOT EXISTS `LOCALITZACIO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LLOC` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `ACRECA` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `LOCALITAT` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `LOCALITZACIO`
--

INSERT INTO `LOCALITZACIO` (`id`, `LLOC`, `ACRECA`, `LOCALITAT`) VALUES
(1, 'SALA BIKINI', 'L''illa Diagonal, L''Illia, Avinguda Diagonal, 547', '08029 Barcelona'),
(2, 'EL MOLINO', 'Carrer de Vila i VilÃ , 99', '08004 Barcelona'),
(3, 'SALA APOLO 2', 'Carrer Nou de la Rambla, 111', '08004 Barcelona'),
(4, 'Sala Rocksound', 'Carrer dels AlmogÃ vers, 116', '08018 Barcelona'),
(5, 'Continental Bar', 'Carrer de la ProvidÃ¨ncia, 32', '08024 Barcelona'),
(6, 'Sant Jordi Club', 'Passeig OlÃ­mpic, 5', '08038 Barcelona'),
(7, 'SALA BARTS', 'Av. del ParaÅ€lel, 62', '08001 Barcelona'),
(8, 'Razzmatazz', 'Carrer de Pamplona, 88', '08018 Barcelona'),
(9, 'Sala Jamboree ', 'PlaÃ§a Reial, 17', '08002 Barcelona'),
(10, 'Sala BÃ³veda', 'Carrer de Roc Boronat, 33', '08005 Barcelona'),
(11, 'Palau de la MÃºsica Catalana', 'Carrer del Palau de la MÃºsica, 4', '08003 Barcelona');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PAGAMENT`
--

CREATE TABLE IF NOT EXISTS `PAGAMENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `BANC` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `REF_EXTERNA` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `DATA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ESTAT` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=20 ;

--
-- Volcado de datos para la tabla `PAGAMENT`
--

INSERT INTO `PAGAMENT` (`id`, `BANC`, `REF_EXTERNA`, `DATA`, `ESTAT`) VALUES
(1, 'CAIXA BANK', '0078 BPD 843', '01/02/2020', 'CONFIRMAT'),
(2, 'CAIXA BANK', '0078 BPD 2529', '01/02/2020', 'CONFIRMAT'),
(3, 'CAIXA BANK', '0078 BPD 5901', '01/02/2020', 'CONFIRMAT'),
(4, 'CAIXA BANK', '0078 BPD 12645', '01/02/2020', 'CONFIRMAT'),
(5, 'CAIXA BANK', '0078 BPD 26133', '01/02/2020', 'CONFIRMAT'),
(6, 'CAIXA BANK', '0078 BPD 53109', '01/02/2020', 'CONFIRMAT'),
(7, 'CAIXA BANK', '0078 BPD 107061', '01/02/2020', 'CONFIRMAT'),
(8, 'CAIXA BANK', '0078 BPD 214965', '01/02/2020', 'CONFIRMAT'),
(9, 'CAIXA BANK', '0078 BPD 430773', '01/02/2020', 'CONFIRMAT'),
(10, 'CAIXA BANK', '0078 BPD 862389', '01/02/2020', 'CONFIRMAT'),
(11, 'CAIXA BANK', '0078 BPD 1725621', '01/02/2020', 'CONFIRMAT'),
(12, 'CAIXA BANK', '0078 BPD 3452085', '01/02/2020', 'CONFIRMAT'),
(13, 'CAIXA BANK', '0078 BPD 6905013', '01/02/2020', 'CONFIRMAT'),
(14, 'CAIXA BANK', '0078 BPD 13810869', '01/02/2020', 'CONFIRMAT'),
(15, 'CAIXA BANK', '0078 BPD 27622581', '01/02/2020', 'CONFIRMAT'),
(16, 'CAIXA BANK', '0078 BPD 55246005', '01/02/2020', 'CONFIRMAT'),
(17, 'CAIXA BANK', '0078 BPD 110492853', '01/02/2020', 'CONFIRMAT'),
(18, 'CAIXA BANK', '0078 BPD 220986549', '01/02/2020', 'CONFIRMAT'),
(19, 'CAIXA BANK', '0078 BPD 441973941', '01/02/2020', 'CONFIRMAT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ZONA`
--

CREATE TABLE IF NOT EXISTS `ZONA` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCIO` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `ZONA`
--

INSERT INTO `ZONA` (`id`, `DESCRIPCIO`) VALUES
(1, 'PLATEA'),
(2, 'PALCO'),
(3, 'PISTA'),
(4, 'ANFITEATRO'),
(5, 'ZONA VIP'),
(6, 'TRIBUNA');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ENTRADA`
--
ALTER TABLE `ENTRADA`
  ADD CONSTRAINT `FK_F60C5C6E104EA8FC` FOREIGN KEY (`zona_id`) REFERENCES `ZONA` (`id`),
  ADD CONSTRAINT `FK_F60C5C6E37F5A13C` FOREIGN KEY (`data_id`) REFERENCES `DATA` (`id`),
  ADD CONSTRAINT `FK_F60C5C6E6505CAD1` FOREIGN KEY (`loc_id`) REFERENCES `LOCALITZACIO` (`id`),
  ADD CONSTRAINT `FK_F60C5C6E66C49110` FOREIGN KEY (`pagament_id`) REFERENCES `PAGAMENT` (`id`),
  ADD CONSTRAINT `FK_F60C5C6E71F7E88B` FOREIGN KEY (`event_id`) REFERENCES `EVENT` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
