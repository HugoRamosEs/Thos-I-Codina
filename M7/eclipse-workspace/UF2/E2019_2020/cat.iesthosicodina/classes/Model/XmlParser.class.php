<?php

class XmlParser {
    private $_file;
    
    public function __construct($param){
        if (!$this->_file = fopen($param,"r+")) {
            throw new MyWebPageException(3001, "El fitxer no s'ha pogut crear correctament.");
        }
    }
    
    public function __destruct() {
        fclose($this->_file);
    }
    
    public function readFile() {
        $sLlibre = "";
        while(!feof($this->_file)) {
            $sLlibre .= fgets($this->_file);
        }
 
        return $sLlibre;
    }
    
    public function convertirExperiencia ($codi) {
        $experiencies = ["D" => "Dolenta", "R" => "Regular", "B" => "Bona", "MB" => "Molt Bona"];
        if (isset($experiencies["$codi"])) {
            $valor = $experiencies["$codi"];
        } else {
            $valor = false;
        }
        return $valor;
    }
    
    public function getElement($etiqueta, $text, $elementNumero) {
        $element = true;
        $elementEnElQueEstic = 1;
        $numeroDeCaracter = 0;
        $etiquetaInici = "<$etiqueta>";
        $etiquetaFinal = "</$etiqueta>";
        
        
        while (($element != false) && ($elementEnElQueEstic++ <= $elementNumero)) {
            $posicioDiniciDElement = strpos($text, $etiquetaInici, $numeroDeCaracter);
            if ($posicioDiniciDElement === false) {
                $element = false;
            } else {
                $posicioDeFinalDElement = strpos($text, $etiquetaFinal, $posicioDiniciDElement) + strlen($etiquetaFinal);
                $element = substr($text, $posicioDiniciDElement, $posicioDeFinalDElement-$posicioDiniciDElement);
            }
            $numeroDeCaracter = $posicioDeFinalDElement;
        }
        
        return $element;
    }
    
    public function getDada($element, $text) {
        $iniciDElement = "<$element>";
        $finalDElement = "</$element>";
        
        $posicioDiniciDElement = strpos($text, $iniciDElement, $numeroDeCaracter) + strlen($iniciDElement);
        if ($posicioDiniciDElement === false) {
            $element = false;
        } else {
            $posicioDeFinaDElement = strpos($text, $finalDElement, $posicioDiniciDElement);
            $element = substr($text, $posicioDiniciDElement, $posicioDeFinaDElement-$posicioDiniciDElement);
        }
        
        return $element;
    }
    
    public function grabaLlibre($text) {
        try {
            $res = fwrite($_file, $text);
        } catch (Exception $ex) {
            throw new MyWebPageException(4001, "error escriptura del fitxer");
        }
    }
    
    
}