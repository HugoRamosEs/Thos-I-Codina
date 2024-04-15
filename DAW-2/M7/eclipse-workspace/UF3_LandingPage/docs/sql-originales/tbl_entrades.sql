-- phpMyAdmin SQL Dump
-- version 5.2.1-2.fc39
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 17-12-2023 a las 09:47:44
-- Versión del servidor: 8.0.35
-- Versión de PHP: 8.2.13

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
-- Estructura de tabla para la tabla `rel_concerts`
--

CREATE TABLE `rel_concerts` (
  `esdeveniment_id` int NOT NULL,
  `data_id` int NOT NULL,
  `localitzacio_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `rel_concerts`
--

INSERT INTO `rel_concerts` (`esdeveniment_id`, `data_id`, `localitzacio_id`) VALUES
(3, 1, 1),
(6, 1, 7),
(3, 2, 1),
(6, 2, 7),
(3, 3, 1),
(6, 3, 7),
(3, 4, 1),
(6, 4, 7),
(3, 5, 1),
(6, 5, 7),
(3, 6, 1),
(6, 6, 7),
(3, 7, 1),
(6, 7, 7),
(3, 23, 9),
(14, 23, 3),
(7, 29, 9),
(13, 71, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_data`
--

CREATE TABLE `tbl_data` (
  `id` int NOT NULL,
  `data` date NOT NULL,
  `hora` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Volcado de datos para la tabla `tbl_data`
--

INSERT INTO `tbl_data` (`id`, `data`, `hora`) VALUES
(1, '2024-04-15', '21:30'),
(2, '2024-04-15', '21:30'),
(3, '2024-04-16', '21:30'),
(4, '2024-04-17', '21:30'),
(5, '2024-04-18', '21:30'),
(6, '2024-04-21', '21:30'),
(7, '2024-04-23', '21:30'),
(8, '2024-04-26', '21:30'),
(9, '2024-04-27', '21:30'),
(10, '2024-04-28', '21:30'),
(11, '2024-04-30', '21:30'),
(12, '2024-04-04', '21:30'),
(13, '2024-04-06', '21:30'),
(14, '2024-04-07', '21:30'),
(15, '2024-04-10', '21:30'),
(16, '2024-04-11', '21:30'),
(17, '2024-04-12', '21:30'),
(18, '2024-04-14', '21:30'),
(21, '2023-01-14', '17:00'),
(22, '2024-01-02', '17:00'),
(23, '2024-01-02', '21:30'),
(24, '2024-01-03', '21:30'),
(25, '2024-01-04', '21:30'),
(26, '2024-01-05', '21:30'),
(27, '2024-01-06', '21:30'),
(28, '2024-01-07', '21:30'),
(29, '2024-01-08', '21:30'),
(30, '2024-01-09', '21:30'),
(31, '2024-01-10', '21:30'),
(32, '2024-01-11', '21:30'),
(33, '2024-01-12', '21:30'),
(34, '2024-01-13', '21:30'),
(35, '2024-01-14', '21:30'),
(36, '2024-01-15', '21:30'),
(37, '2024-01-16', '21:30'),
(38, '2024-01-17', '21:30'),
(39, '2024-01-18', '21:30'),
(40, '2024-01-19', '21:30'),
(41, '2024-01-20', '21:30'),
(42, '2024-01-21', '21:30'),
(43, '2024-01-22', '21:30'),
(44, '2024-01-23', '21:30'),
(45, '2024-01-24', '21:30'),
(46, '2024-01-25', '21:30'),
(47, '2024-01-26', '21:30'),
(48, '2024-01-27', '21:30'),
(49, '2024-02-01', '21:30'),
(50, '2024-02-02', '21:30'),
(51, '2024-02-03', '21:30'),
(52, '2024-02-04', '21:30'),
(53, '2024-02-05', '21:30'),
(54, '2024-02-06', '21:30'),
(55, '2024-02-07', '21:30'),
(56, '2024-02-08', '21:30'),
(57, '2024-02-09', '21:30'),
(58, '2024-02-10', '21:30'),
(59, '2024-02-11', '21:30'),
(60, '2024-02-12', '21:30'),
(61, '2024-02-13', '21:30'),
(62, '2024-02-14', '21:30'),
(63, '2024-02-15', '21:30'),
(64, '2024-02-16', '21:30'),
(65, '2024-02-17', '21:30'),
(66, '2024-02-18', '21:30'),
(67, '2024-02-19', '21:30'),
(68, '2024-02-20', '21:30'),
(69, '2024-02-21', '21:30'),
(70, '2024-02-22', '21:30'),
(71, '2024-02-23', '21:30'),
(72, '2024-02-24', '21:30'),
(73, '2024-02-25', '21:30'),
(74, '2024-02-26', '21:30'),
(75, '2024-02-27', '21:30'),
(77, '2024-03-02', '21:30'),
(78, '2024-03-03', '21:30'),
(79, '2024-03-04', '21:30'),
(80, '2024-03-05', '21:30'),
(81, '2024-03-06', '21:30'),
(82, '2024-03-07', '21:30'),
(83, '2024-03-08', '21:30'),
(84, '2024-03-09', '21:30'),
(85, '2024-03-10', '21:30'),
(86, '2024-03-11', '21:30'),
(87, '2024-03-12', '21:30'),
(88, '2024-03-13', '21:30'),
(89, '2024-03-14', '21:30'),
(90, '2024-03-15', '21:30'),
(91, '2024-03-16', '21:30'),
(92, '2024-03-17', '21:30'),
(93, '2024-03-18', '21:30'),
(94, '2024-03-19', '21:30'),
(95, '2024-03-20', '21:30'),
(96, '2024-03-21', '21:30'),
(97, '2024-03-22', '21:30'),
(98, '2024-03-23', '21:30'),
(99, '2024-03-24', '21:30'),
(100, '2024-03-25', '21:30'),
(101, '2024-03-26', '21:30'),
(102, '2024-03-27', '21:30'),
(103, '2023-01-01', '21:30'),
(104, '2023-01-02', '21:30'),
(105, '2023-01-03', '21:30'),
(106, '2023-01-04', '21:30'),
(107, '2023-01-05', '21:30'),
(108, '2023-01-06', '21:30'),
(109, '2023-01-07', '21:30'),
(110, '2023-01-08', '21:30'),
(111, '2023-01-09', '21:30'),
(113, '2023-01-11', '21:30'),
(114, '2023-01-12', '21:30'),
(115, '2023-01-13', '21:30'),
(116, '2023-01-14', '21:30'),
(117, '2023-01-15', '21:30'),
(118, '2023-01-16', '21:30'),
(119, '2023-01-17', '21:30'),
(120, '2023-01-18', '21:30'),
(121, '2023-01-19', '21:30'),
(122, '2023-01-20', '21:30'),
(123, '2023-01-21', '21:30'),
(124, '2023-01-22', '21:30'),
(125, '2023-01-23', '21:30'),
(126, '2023-01-24', '21:30'),
(127, '2023-01-25', '21:30'),
(128, '2023-01-26', '21:30'),
(129, '2023-01-27', '21:30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_entrada`
--

CREATE TABLE `tbl_entrada` (
  `esdeveniment_id` int DEFAULT NULL,
  `data_id` int DEFAULT NULL,
  `loc_id` int DEFAULT NULL,
  `zona_id` int DEFAULT NULL,
  `pagament_id` int DEFAULT NULL,
  `id` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `fila` int NOT NULL,
  `butaca` int NOT NULL,
  `dni` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Volcado de datos para la tabla `tbl_entrada`
--

INSERT INTO `tbl_entrada` (`esdeveniment_id`, `data_id`, `loc_id`, `zona_id`, `pagament_id`, `id`, `fila`, `butaca`, `dni`) VALUES
(13, 71, 12, 3, 62, '14547GLW96HS3', 12, 2, '41005681Q'),
(3, 5, 9, 4, 66, '17481FXX00FE2', 3, 12, '41005681Q'),
(13, 71, 12, 7, 63, '18349PUH37UL6', 2, 3, '41005681Q'),
(6, 3, 7, 1, 58, '24831FCTM11BP6', 1, 22, '44003603A'),
(6, 6, 7, 1, 61, '24831FPTR1178A', 14, 6, '18400251K'),
(6, 4, 7, 1, 4, '24831KMMT5YM14', 2, 1, '22404871F'),
(6, 2, 7, 1, 2, '24831KRGX5YM14', 1, 20, '44003603A'),
(6, 7, 7, 1, 7, '24831LLQ1224RT', 9, 20, '46007007K'),
(6, 1, 7, 1, 1, '24831VDKRB95CR', 1, 18, '44003603A'),
(6, 5, 7, 1, 5, '2483MZRT18RP24', 2, 3, '22404871F'),
(14, 23, 3, 3, 51, '38117LIJ55IL5', 1, 1, '41005681Q'),
(3, 23, 9, 2, 56, '45266NKO89VB8', 5, 5, '44003603a'),
(13, 71, 12, 7, 64, '50706MVV90MF2', 2, 3, '41005681Q'),
(7, 29, 9, 6, 65, '52999UQK55IQ0', 1, 1, '44003603A'),
(14, 23, 3, 3, 54, '54842CHE17HR6', 1, 1, '41005681Q'),
(3, 3, 1, 1, 3, '55032FCTM11BP6', 1, 22, '22404871F'),
(3, 6, 1, 1, 6, '55032FPTR1178A', 14, 6, '74003871M'),
(3, 4, 1, 1, 4, '55032KMMT5YM14', 2, 1, '22404871F'),
(3, 2, 1, 1, 2, '55032KRGX5YM14', 1, 20, '44003603A'),
(3, 7, 1, 1, 7, '55032LLQ1224RT', 9, 20, '46007007K'),
(3, 1, 1, 1, 1, '55032VDKRB95CR', 1, 18, '44003603A'),
(3, 5, 1, 1, 5, '55032ZRT18RP24', 2, 3, '22404871F'),
(14, 23, 3, 3, 53, '59447JTW23VV8', 1, 1, '41005681Q'),
(7, 29, 9, 2, 55, '71948ESM54TX9', 3, 3, '41005681Q'),
(14, 23, 3, 3, 52, '82083FYQ20AM4', 1, 1, '41005681Q'),
(14, 23, 3, 3, 50, '98239SAT32WU0', 1, 1, '41005681Q');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_esdeveniment`
--

CREATE TABLE `tbl_esdeveniment` (
  `id` int NOT NULL,
  `titol` char(90) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `subtitol` text COLLATE utf8mb4_unicode_520_ci,
  `dates` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `imatge` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Volcado de datos para la tabla `tbl_esdeveniment`
--

INSERT INTO `tbl_esdeveniment` (`id`, `titol`, `subtitol`, `dates`, `imatge`) VALUES
(1, 'Marina Bbface &amp; The Beatroots en el Jamboree Jazz Club', 'La banda Marina BBface &amp; The Beatroots se consolidó como uno de los grupos de más refererentes', '2022 Desembre', 'uploads/DSC_7423ret2baixa1.jpg'),
(2, 'Tete Montoliu 80 + 4', 'El gran Tete Montoliu está considerado como el músico más internacional de Jazz del país', '2023 Gener', 'uploads/tete-concierto-210217.original.jpg'),
(3, 'Elefantes', 'Elefantes recorrerá algunas de las Salas y Teatros más importantes de nuestra geografía', '2023 Agost', 'uploads/240303_logo_Foto_horizontal_para_Ticketea_claim.jpg'),
(4, 'Carlos Vives', '', '2023 Desembre', 'uploads/258729_logo_Carlos_Vives_ticketea_claim.jpg'),
(5, 'IZARO', '', '2024 Febrer', 'uploads/257415_logo_izaro_claim.jpg'),
(6, 'THE VERY BEST OF DIRE STRAITS', 'bROTHES iN bAND. dIRE sTRAITS. The Very Best of dIRE sTRAITS SHOW', '2024 Juny', 'uploads/051214124520_theverybestinternet.jpeg'),
(7, 'Bruce Springsteen &amp; E Street Band', 'Gira europea 2024', '2024 Juny', 'https://www.doctormusic.com/upload/events/395m.jpg'),
(11, 'Vicco - Guitar 24', 'El nombre de Vicco llegó al gran público con su impresionante participación en el Benidorm Fest de 2023.', '2024 Maig', 'uploads/1701799431.5217_vicco-min.jpg'),
(12, 'Rozalén', 'Rozalén, una de las cantautoras más destacadas de España, ha conquistado el corazón de su audiencia con su mezcla única de folk, pop y letras cargadas de profundidad emocional y social.', '2024 Maig', 'uploads/1701799487.8971_image.jpg'),
(13, 'Maná', 'Maná es un grupo de rock latino que se fundó el año 1986 en Guadalajara (México).', '2024 Juny', 'uploads/1701799596.5339_mana-generica-tour-espana.jpg'),
(14, 'Alejandro Sanz', 'Alejandro Sanz culminará su tour tras dos años consecutivos en los escenarios, y más de un 1.000.000 de seguidores desde su inicio en octubre del 2021, bajo el nombre de La Gira, renombrado SANZ en Vivo en su segunda etapa.', '2023 Desembre', 'uploads/1701799735.5121_00-00088Wi.jpg'),
(15, 'Noche de Beatles', 'Noche de Beatles es un tributo homenaje a los Beatles. En esta ocasión el grupo vuelve a repetir en la sala Luz de Gas.', '2024 Juny', 'https://www.atrapalo.com/common/photo/event/4/8/8/5611/1531010/si_372_0.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_localitzacio`
--

CREATE TABLE `tbl_localitzacio` (
  `id` int NOT NULL,
  `lloc` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `adreca` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `localitat` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Volcado de datos para la tabla `tbl_localitzacio`
--

INSERT INTO `tbl_localitzacio` (`id`, `lloc`, `adreca`, `localitat`) VALUES
(1, 'SALA BIKINI', 'L&#039;illa Diagonal, L&#039;Illa, Avinguda Diagonal, 547', '08029 Barcelona'),
(2, 'EL MOLINO', 'Carrer de Vila i Vilà, 99', '08004 Barcelona'),
(3, 'SALA APOLO 2', 'Carrer Nou de la Rambla, 111', '08004 Barcelona'),
(4, 'Sala Rocksound', 'Carrer dels Almogàvers, 116', '08018 Barcelona'),
(5, 'Continental Bar', 'Carrer de la Providència, 32', '08024 Barcelona'),
(6, 'Sant Jordi Club', 'Passeig Olímpic, 5', '08038 Barcelona'),
(7, 'SALA BARTS', 'Av. del Paral.lel, 62', '08001 Barcelona'),
(8, 'Razzmatazz', 'Carrer de Pamplona, 88', '08018 Barcelona'),
(9, 'Sala Jamboree', 'Plaça Reial, 17', '08002 Barcelona'),
(10, 'Sala Bóveda', 'Carrer de Roc Boronat, 33', '08005 Barcelona'),
(11, 'Palau de la Música Catalana', 'Carrer del Palau de la Música, 4', '08003 Barcelona'),
(12, 'Estadi Olímpic de Montjuïc Lluís Companys', 'Passeig Olímpic, 15-17', '08038 Barcelona'),
(13, 'CLAP Mataró', 'Serra i Moret 4', '08302 Mataró'),
(14, 'El Club  Mataró', 'Batista i Roca 61', '08302 Mataró'),
(15, 'Sala Foment Mataroní', 'Nou 11', '08302 Mataró'),
(16, 'Sala Republic', 'Via Sèrgia 88', '08302 Mataró'),
(17, 'Sala Duba', 'Bautista i Roca 25', '08302 Mataró');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_pagament`
--

CREATE TABLE `tbl_pagament` (
  `id` int NOT NULL,
  `banc` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `ref_externa` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `data` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `estat` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Volcado de datos para la tabla `tbl_pagament`
--

INSERT INTO `tbl_pagament` (`id`, `banc`, `ref_externa`, `data`, `estat`) VALUES
(1, '3025', '0078 BPD 843', '01/02/2020', 'CONFIRMAT'),
(2, '0235', '0078 BPD 2529', '01/02/2020', 'CONFIRMAT'),
(3, '2095', '0078 BPD 5901', '01/02/2020', 'CONFIRMAT'),
(4, '2080', '0078 BPD 12645', '01/02/2020', 'CONFIRMAT'),
(5, '0128', '0078 BPD 26133', '01/02/2020', 'CONFIRMAT'),
(6, '2100', '0078 BPD 53109', '01/02/2020', 'CONFIRMAT'),
(7, '0136', '0078 BPD 107061', '01/02/2020', 'CONFIRMAT'),
(8, '0019', '0078 BPD 214965', '01/02/2020', 'CONFIRMAT'),
(9, '0019', '0078 BPD 430773', '01/02/2020', 'CONFIRMAT'),
(10, '0241', '0078 BPD 862389', '01/02/2020', 'CONFIRMAT'),
(11, '0136', '0078 BPD 1725621', '01/02/2020', 'CONFIRMAT'),
(12, '0162', '0078 BPD 3452085', '01/02/2020', 'CONFIRMAT'),
(13, '0019', '0078 BPD 6905013', '01/02/2020', 'CONFIRMAT'),
(14, '0188', '0078 BPD 13810869', '01/02/2020', 'CONFIRMAT'),
(15, '2000', '0078 BPD 27622581', '01/02/2020', 'CONFIRMAT'),
(16, '0182', '0078 BPD 55246005', '01/02/2020', 'CONFIRMAT'),
(17, '0182', '0078 BPD 110492853', '01/02/2020', 'CONFIRMAT'),
(18, '2100', '0078 BPD 220986549', '01/02/2020', 'CONFIRMAT'),
(19, '2100', '0078 BPD 441973941', '01/02/2020', 'CONFIRMAT'),
(22, '0049', 'FGSD 54456SDF4 5', '01/01/2023', 'CONFIRMAT'),
(23, '1465', 'SDFG 654 DAFG06 564FG', '01/12/2024', 'CONFIRMAT'),
(24, '0241', '0241 ORU 274', '12/12/2023', 'PENDENT'),
(25, '0229', '0229 YIZ 79', '12/12/2023', 'PENDENT'),
(26, '0128', '0128 HKC 155', '12/12/2023', 'PENDENT'),
(27, '1568', '1568 LGC 6724', '12/12/2023', 'PENDENT'),
(28, '1544', '1544 SOV 164', '12/12/2023', 'PENDENT'),
(29, '0188', '0188 VQV 50', '12/12/2023', 'PENDENT'),
(30, '0188', '0188 AEF 8', '12/12/2023', 'PENDENT'),
(31, '3035', '3035 KYI 8549', '12/12/2023', 'PENDENT'),
(32, '2080', '2080 BPM 451534', '12/12/2023', 'PENDENT'),
(33, '0049', '0049 ISQ 484932', '12/12/2023', 'PENDENT'),
(34, '2080', '2080 QVR 3591', '12/12/2023', 'PENDENT'),
(35, '3035', '3035 XRJ 34', '12/12/2023', 'PENDENT'),
(36, '0003', '0003 VQE 7', '12/12/2023', 'PENDENT'),
(37, '0182', '0182 BEM 723', '12/12/2023', 'PENDENT'),
(38, '0234', '0234 VUK 124', '12/12/2023', 'PENDENT'),
(39, '1544', '1544 WBE 84', '12/12/2023', 'PENDENT'),
(40, '0188', '0188 DQM 679', '12/12/2023', 'PENDENT'),
(41, '0049', '0049 VUU 85', '12/12/2023', 'PENDENT'),
(42, '3058', '3058 SGV 98322', '12/12/2023', 'PENDENT'),
(43, '2095', '2095 NFM 01', '12/12/2023', 'PENDENT'),
(44, '2080', '2080 CIM 437', '12/12/2023', 'PENDENT'),
(45, '0019', '0019 CVG 626', '12/12/2023', 'PENDENT'),
(46, '0083', '0083 FYD 6', '12/12/2023', 'PENDENT'),
(47, '1544', '1544 CMJ 73', '12/12/2023', 'PENDENT'),
(48, '3035', '3035 ZVB 5', '12/12/2023', 'PENDENT'),
(49, '1568', '1568 QLV 7297', '12/12/2023', 'PENDENT'),
(50, '0162', '0162 TCH 413', '12/12/2023', 'PENDENT'),
(51, '1544', '1544 LJF 21', '12/12/2023', 'PENDENT'),
(52, '0229', '0229 MEA 547', '12/12/2023', 'PENDENT'),
(53, '0081', '0081 JHX 69', '12/12/2023', 'PENDENT'),
(54, '0019', '0019 AVS 1317', '12/12/2023', 'PENDENT'),
(55, '2085', '2085 HIG 58', '12/12/2023', 'PENDENT'),
(56, '0019', '0019 LDP 76', '12/12/2023', 'PENDENT'),
(57, '0078', '0078 BPD 5901', '12/12/2023', 'PENDENT'),
(58, '0078', '0078 BPD 5901', '12/12/2023', 'PENDENT'),
(59, '0078', '0078 BPD 53109', '12/12/2023', 'PENDENT'),
(60, '0078', '0078 BPD 53109', '12/12/2023', 'PENDENT'),
(61, '0078', '0078 BPD 53109', '12/12/2023', 'PENDENT'),
(62, '2100', '2100 XCX 081', '13/12/2023', 'PENDENT'),
(63, '0220', '0220 LLF 7991', '15/12/2023', 'WEB'),
(64, '2095', '2095 ZDV 4621', '15/12/2023', 'WEB'),
(65, '0136', '0136 BEH 73', '15/12/2023', 'WEB'),
(66, '3025', '3025 NAW 56', '15/12/2023', 'WEB'),
(67, '3025', '3025 NAW 56', '15/12/2023', 'CONFIRMAT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_zona`
--

CREATE TABLE `tbl_zona` (
  `id` int NOT NULL,
  `descripcio` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Volcado de datos para la tabla `tbl_zona`
--

INSERT INTO `tbl_zona` (`id`, `descripcio`) VALUES
(1, 'PLATEA'),
(2, 'PALC'),
(3, 'PISTA'),
(4, 'ANFITEATRE'),
(5, 'ZONA VIP'),
(6, 'TRIBUNA'),
(7, '1a GRADERIA'),
(8, '2a GRADERIA'),
(9, '3a GRADERIA'),
(10, 'ACCES 101'),
(11, 'ACCES 102'),
(18, 'ACCES 103'),
(26, 'ACCES 104');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `rel_concerts`
--
ALTER TABLE `rel_concerts`
  ADD PRIMARY KEY (`esdeveniment_id`,`data_id`,`localitzacio_id`),
  ADD KEY `data_id` (`data_id`),
  ADD KEY `localitzacio_id` (`localitzacio_id`);

--
-- Indices de la tabla `tbl_data`
--
ALTER TABLE `tbl_data`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_entrada`
--
ALTER TABLE `tbl_entrada`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idX_F60C5C6E71F7E88B` (`esdeveniment_id`),
  ADD KEY `idX_F60C5C6E37F5A13C` (`data_id`),
  ADD KEY `idX_F60C5C6E6505CAD1` (`loc_id`),
  ADD KEY `idX_F60C5C6E104EA8FC` (`zona_id`),
  ADD KEY `idX_F60C5C6E66C49110` (`pagament_id`);

--
-- Indices de la tabla `tbl_esdeveniment`
--
ALTER TABLE `tbl_esdeveniment`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_localitzacio`
--
ALTER TABLE `tbl_localitzacio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_pagament`
--
ALTER TABLE `tbl_pagament`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_usuaris`
--
ALTER TABLE `tbl_usuaris`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `tbl_zona`
--
ALTER TABLE `tbl_zona`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_data`
--
ALTER TABLE `tbl_data`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=137;

--
-- AUTO_INCREMENT de la tabla `tbl_esdeveniment`
--
ALTER TABLE `tbl_esdeveniment`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `tbl_localitzacio`
--
ALTER TABLE `tbl_localitzacio`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `tbl_pagament`
--
ALTER TABLE `tbl_pagament`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT de la tabla `tbl_usuaris`
--
ALTER TABLE `tbl_usuaris`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6445;

--
-- AUTO_INCREMENT de la tabla `tbl_zona`
--
ALTER TABLE `tbl_zona`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `rel_concerts`
--
ALTER TABLE `rel_concerts`
  ADD CONSTRAINT `rel_concerts_ibfk_1` FOREIGN KEY (`esdeveniment_id`) REFERENCES `tbl_esdeveniment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rel_concerts_ibfk_2` FOREIGN KEY (`data_id`) REFERENCES `tbl_data` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `rel_concerts_ibfk_3` FOREIGN KEY (`localitzacio_id`) REFERENCES `tbl_localitzacio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_entrada`
--
ALTER TABLE `tbl_entrada`
  ADD CONSTRAINT `FK_F60C5C6E104EA8FC` FOREIGN KEY (`zona_id`) REFERENCES `tbl_zona` (`id`),
  ADD CONSTRAINT `FK_F60C5C6E37F5A13C` FOREIGN KEY (`data_id`) REFERENCES `tbl_data` (`id`),
  ADD CONSTRAINT `FK_F60C5C6E6505CAD1` FOREIGN KEY (`loc_id`) REFERENCES `tbl_localitzacio` (`id`),
  ADD CONSTRAINT `FK_F60C5C6E66C49110` FOREIGN KEY (`pagament_id`) REFERENCES `tbl_pagament` (`id`),
  ADD CONSTRAINT `FK_F60C5C6E71F7E88B` FOREIGN KEY (`esdeveniment_id`) REFERENCES `tbl_esdeveniment` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
