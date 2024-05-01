<?php
use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;

require_once __DIR__.'/vendor/autoload.php';
require_once __DIR__.'/config/config.php';

$entitiesPath = array(__DIR__.'/model');
$dev=true;

$config = Setup::createAnnotationMetadataConfiguration($entitiesPath,$dev);
$em = EntityManager::create($dbParams, $config);