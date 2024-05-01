-- phpMyAdmin SQL Dump
-- version 5.2.1-2.fc39
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 11-03-2024 a las 16:09:00
-- Versión del servidor: 8.0.35
-- Versión de PHP: 8.2.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `M07UF3Examen2024`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estudis`
--

CREATE TABLE `tbl_estudis` (
  `id` int NOT NULL,
  `any` int NOT NULL,
  `titol` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcio` varchar(600) COLLATE utf8mb4_general_ci NOT NULL,
  `usuari_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_estudis`
--

INSERT INTO `tbl_estudis` (`id`, `any`, `titol`, `descripcio`, `usuari_id`) VALUES
(1, 2011, 'MÀSTER FORMACIÓ PROFESSORAT (TECNOLOGIA) - U.P.C.', '<p>El màster universitari en Formació del Professorat d\'Educació Secundària Obligatòria i \r\n            Batxillerat, Formació Professional i Ensenyament d\'Idiomes té com objectiu principal, proporcionar \r\n            la formació  pedagògica i didàctica necessària per exercir la docència en l\'Educació Secundària \r\n            Obligatòria, Batxillerat i Formació Professional específica.</p>', 1),
(2, 2010, 'FIRST CERTIFICATE IN ENGLISH (B2)', '<p>Una titulació B2 First demostra que tens les habilitats lingüístiques per viure i \r\n            treballar de manera autònoma en un país de parla anglesa o estudiar els cursos impartits en anglès.', 1),
(5, 2009, 'ENGINYERIA TÈCNICA EN INFORMÀTICA DE GESTIÓ - U.A.B.', '<p>El grau en Enginyeria Informàtica té com a objectiu formar professionals experts \r\n            en informàtica que tinguin una visió global de la tecnologia que els permeti analitzar, dissenyar, \r\n            desenvolupar i implantar sistemes informàtics per a diversos entorns i situacions, adaptant-se als \r\n            canvis i a les innovacions tecnològiques.</p>', 1),
(6, 1990, 'CERTIFICAT NIVELL INTERMEDI ANGLÈS - Quart curs (E.O.I.)', '<p>Les escoles oficials d’idiomes (EOI) són centres públics d’ensenyament d’idiomes moderns, \r\n            no universitaris, que imparteixen els ensenyaments especialitzats regulats per la LOE.<p></p>Les \r\n            escoles oficials d’idiomes també gestionen les certificacions acadèmiques corresponents a aquests \r\n            ensenyaments especialitzats. Aquestes certificacions són reconegudes arreu de l’Estat espanyol, \r\n            són les úniques oficials, i es poden obtenir tant en convocatòria oficial com en convocatòria lliure.</p>', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_experiencia`
--

CREATE TABLE `tbl_experiencia` (
  `id` int NOT NULL,
  `periode` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `empresa` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `carrec` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcio` varchar(600) COLLATE utf8mb4_general_ci NOT NULL,
  `usuari_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_experiencia`
--

INSERT INTO `tbl_experiencia` (`id`, `periode`, `empresa`, `carrec`, `descripcio`, `usuari_id`) VALUES
(1, '2023-2024', 'INSTITUT THOS I CODINA (Mataró)', 'DAW - Tutor 1er', '<p>Professor de DAW: mòduls M05 i M02 a primer i M03 i M07 a segon</p><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tincidunt purus sit amet tincidunt sollicitudin. Phasellus ut sem ac eros elementum finibus non at erat. </p>', 1),
(2, '2022-2023', 'INSTITUT THOS I CODINA (Mataró)', 'DAW - Tutor 1er', '<p>Professor de DAW: mòduls M05 a primer i M03, M07 i Projecte a segon</p><p>Professor de SMiX: mòduls M05 a primer</p><p>Suspendisse maximus ligula sit amet nunc congue, vitae molestie erat tristique. Aliquam posuere lacus sit amet dui consequat commodo.</p>', 1),
(3, '2021-2022', 'INSTITUT THOS I CODINA (Mataró)', 'DAW - Tutor 1er', '<p>Professor de DAW: mòduls M05 a primer i M03, M07 i Projecte a segon.</p><p>ullam neque lectus, porttitor at nulla non, mollis tincidunt urna. Nullam sed nisi imperdiet, sodales elit vitae, pellentesque urna. In malesuada nisi vitae commodo bibendum. Nam commodo quis lectus non scelerisque. Etiam maximus elit a urna lacinia mattis. </p>', 1),
(4, '2020-2021', 'INSTITUT THOS I CODINA (Mataró)', 'Cap de departament', '<p>Professor de DAW: mòduls M05 i M04 a primer i M03, M07 a segon.</p><p>Curabitur viverra sem nibh, porttitor vehicula erat sagittis accumsan. Nunc nisl leo, congue congue rhoncus vitae, consequat id elit. Cras nec libero in diam maximus commodo. Duis nec elementum magna, quis finibus est. </p>', 1),
(5, '2019-2020', 'INSTITUT THOS I CODINA (Mataró)', 'Cap de seminari', '<p>Professor de DAW: mòduls M05 i M04 a primer i M03, M07 a segon.</p><p>Maecenas massa libero, varius id volutpat a, ornare ac neque. Proin sollicitudin pellentesque nulla, et sodales augue euismod vel. Maecenas aliquam ac mi nec scelerisque.</p>', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_habilitats`
--

CREATE TABLE `tbl_habilitats` (
  `id` int NOT NULL,
  `categoria` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `valoracio` int NOT NULL,
  `usuari_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_habilitats`
--

INSERT INTO `tbl_habilitats` (`id`, `categoria`, `valoracio`, `usuari_id`) VALUES
(1, 'HTML5', 5, 1),
(2, 'CSS3', 5, 1),
(3, 'PHP', 5, 1),
(4, 'Java', 5, 1),
(5, 'Python ', 4, 1),
(6, 'C++', 5, 1),
(7, 'Photoshop', 5, 1),
(8, 'Domios', 3, 1),
(9, 'Bootstrap', 3, 1),
(10, 'Workpress', 4, 1),
(11, 'Woocommerce', 4, 1),
(12, 'Javascript', 3, 1),
(13, 'Illustrator', 4, 1),
(14, 'Hosting', 4, 1),
(15, 'Mysql', 5, 1),
(16, 'OracleDB', 5, 1),
(17, 'Prestashop', 4, 1),
(18, 'Joomla!', 4, 1),
(19, 'SEO', 3, 1),
(20, 'Ajax', 3, 1),
(21, 'VisualBasic', 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_info`
--

CREATE TABLE `tbl_info` (
  `id` int NOT NULL,
  `codi` text COLLATE utf8mb4_general_ci NOT NULL,
  `fa` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `dada` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `usuari_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_info`
--

INSERT INTO `tbl_info` (`id`, `codi`, `fa`, `dada`, `usuari_id`) VALUES
(1, 'codepen', 'fa-codepen', 'codepen.io/ToniAgular', 1),
(2, 'mail', 'fa-envelope', 'toni.aguilar@iesthosicodina.cat', 1),
(5, 'instagram', 'fa-instagram', 'instagram.com/ToniAguilar', 1),
(6, 'facebook', 'fa-facebook', 'ToniAgular', 1),
(7, 'twitter', 'fa-twitter', 'twitter.com/toniagiular', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuaris`
--

CREATE TABLE `tbl_usuaris` (
  `id` int NOT NULL,
  `nom` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `cognom` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcio` varchar(600) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_usuaris`
--

INSERT INTO `tbl_usuaris` (`id`, `nom`, `cognom`, `descripcio`) VALUES
(1, 'Toni', 'Aguilar', '<p>Soc Juan Antonio Aguilar Amo, professor de l\'Institut Thos i Codina \ni he preparat aquest examen perque puguis desmostrar-me tot el que saps fer.</p>\n<p>Em considero una persona autodidacta, amb moltes inquietuds, molt polida i ordenada \nquant als meus codis es refereix i també molt perfecionista amb la meva feina.</p>\n<p>M\'agrada el tracte amb la gent i sobretot ensenyar i transmetre coneixement</p>');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_estudis`
--
ALTER TABLE `tbl_estudis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_susari` (`usuari_id`);

--
-- Indices de la tabla `tbl_experiencia`
--
ALTER TABLE `tbl_experiencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fr_usuari` (`usuari_id`);

--
-- Indices de la tabla `tbl_habilitats`
--
ALTER TABLE `tbl_habilitats`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuari` (`usuari_id`);

--
-- Indices de la tabla `tbl_info`
--
ALTER TABLE `tbl_info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuari2` (`usuari_id`);

--
-- Indices de la tabla `tbl_usuaris`
--
ALTER TABLE `tbl_usuaris`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_estudis`
--
ALTER TABLE `tbl_estudis`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tbl_experiencia`
--
ALTER TABLE `tbl_experiencia`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tbl_habilitats`
--
ALTER TABLE `tbl_habilitats`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `tbl_info`
--
ALTER TABLE `tbl_info`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tbl_usuaris`
--
ALTER TABLE `tbl_usuaris`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_estudis`
--
ALTER TABLE `tbl_estudis`
  ADD CONSTRAINT `fk_susari` FOREIGN KEY (`usuari_id`) REFERENCES `tbl_usuaris` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `tbl_experiencia`
--
ALTER TABLE `tbl_experiencia`
  ADD CONSTRAINT `fr_usuari` FOREIGN KEY (`usuari_id`) REFERENCES `tbl_usuaris` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `tbl_habilitats`
--
ALTER TABLE `tbl_habilitats`
  ADD CONSTRAINT `fk_usuari` FOREIGN KEY (`usuari_id`) REFERENCES `tbl_usuaris` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `tbl_info`
--
ALTER TABLE `tbl_info`
  ADD CONSTRAINT `fk_usuari2` FOREIGN KEY (`usuari_id`) REFERENCES `tbl_usuaris` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

