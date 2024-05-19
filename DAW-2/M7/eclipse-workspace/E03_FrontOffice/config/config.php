<?php

use model\DbConfig;

// Configuració de l'aplicació
// Accés a la base de dades
$dbConfig = DbConfig::getInstance();

$dbParams = [
	"driver" =>	$dbConfig->getDriver(),
	"host" =>	$dbConfig->getHost(),
	"dbname" =>	$dbConfig->getDbname(),
	"user" =>	$dbConfig->getUser(),
	"password" => $dbConfig->getPassword()
];

// Estem en mode de desenvolupament?
$dev = true;
