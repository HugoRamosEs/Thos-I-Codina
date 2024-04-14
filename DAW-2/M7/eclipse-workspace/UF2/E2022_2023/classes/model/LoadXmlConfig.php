<?php

class LoadXmlConfig {
    public $host;
    public $user;
    public $password;
    public $dataBase;
    public $options;
    
    public static function loadFromXml($filePath) {
        $xml = simplexml_load_file($filePath);
        $config = new LoadXmlConfig();
        
        $config->host = (string)$xml->host;
        $config->user = (string)$xml->user;
        $config->password = (string)$xml->password;
        $config->dataBase = (string)$xml->database;
        $config->options = (string)$xml->options;
        
        return $config;
    }
    
    // Mètode per afegir l'atribut sgbd de forma dinàmica
    public function addSgbdAttribute($sgbd) {
        $this->sgbd = $sgbd;
    }
    
    /**
     * COMO USARLO EN EL INDEX.PHP
     * $config = Config::loadFromXml($filePath);
     * $config->addSgbdAttribute("mysql");
     */
}

