<?php
class GuestBookModel {
    private $config;
    private $parser;
    private $llibre;

    
    public function __construct() {
        $this->config = new Configuracio();
        $this->parser = new XmlParser($this->config->getRutaDelGuestBook());
    }
    
    public function getLlibre() {

        $Llibre = $this->parser->readFile();
        
        $elementNumero = 1;
        
        while (($registreActual = $this->parser->getElement("REGISTRE", $Llibre, $elementNumero)) !== false) {
            $comentari = new Comentari();
            $comentari->setData($this->parser->getDada("DATA",$this->parser->getElement("DATA", $registreActual, 1)));
            $comentari->setNom($this->parser->getDada("NOM",$this->parser->getElement("NOM", $registreActual, 1)));
            $comentari->setPais(ucwords($this->parser->getDada("PAIS",$this->parser->getElement("PAIS", $registreActual, 1))));
            $comentari->setExperiencia($this->parser->convertirExperiencia($this->parser->getDada("EXPERIENCIA",$this->parser->getElement("EXPERIENCIA", $registreActual, 1))));
            $comentari->setComentari($this->parser->getDada("COMENTARI",$this->parser->getElement("COMENTARI", $registreActual, 1)));

            $aLlibre[] = $comentari;
            $elementNumero++;
        }
        
        return $aLlibre;
    }
    
    public function setComentari($com) {
        // No hi ha errors en les dades rebudes.
        $sLlibre = substr(file_get_contents($this->config->getRutaDelGuestBook()),0,-13);
        
        $sLlibre .= "<REGISTRE><DATA>".$com->getData()['mday']."/".$com->getData()['mon']."/".$com->getData()['year']."</DATA>\n";
        $sLlibre .= "<NOM>".$com->getNom()."</NOM>\n";
        $sLlibre .= "<MAIL>".$com->getEmail()."</MAIL>\n";
        $sLlibre .= "<PAIS>".$com->getPais()."</PAIS>\n";
        $sLlibre .= "<EXPERIENCIA>".$com->getExperiencia()."</EXPERIENCIA>";
        $sLlibre .= "<COMENTARI>".$com->getComentari()."</COMENTARI>\n";
        $sLlibre .= "</REGISTRE> \n </REGISTRES>";
        
        $res = file_put_contents($this->config->getRutaDelGuestBook(), $sLlibre, FILE_APPEND);
        if ($res === false) {
            throw new Exception ("Error al escribir en el archivo del libro de visitas.");
        }
        
        //$this->parser->grabaLlibre($sLlibre);        
    }
}