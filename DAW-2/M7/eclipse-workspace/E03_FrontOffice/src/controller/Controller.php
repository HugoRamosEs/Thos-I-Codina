<?php
namespace controller;

class Controller {
    public $entityManager;
    
    public function __construct(){
        require __DIR__ . "/../../config/config.php";
        require __DIR__ . "/../bootstrap.php";
        $this->entityManager = $entityManager;
    }
    
    /**
     * Permet sanititzar un string que es rep per una petició.
     * 
     * @param mixed $string: Cadena a la que volem eliminar els caràcters perillosos.
     * @param int $convertir:
     *      [0] No converir.
     *      [1] Convertir la cadena a mínúscules.
     *      [2] Convertir la cadena a MAJÚSCULES.
     *      [3] Convertir la cadena a UC (primera majúscula, resta minúscula).
     *      [4] Convertir la cadena a UC per paraules (estil nom).
     */
    function sanitize($string, $convertir = 0){
        if (strlen($string) == 0) {
            $string = "";
        } else {
            $string = trim($string);
            $string = htmlspecialchars(stripslashes(trim($string, '-')));
            $string = strip_tags($string);
            $string = preg_replace('|%([a-fA-F0-9][a-fA-F0-9])|', '---$1---', $string);
            $string = str_replace('%', '', $string);
            $string = preg_replace('|---([a-fA-F0-9][a-fA-F0-9])---|', '%$1', $string);
            
            switch ($convertir) {
                case 1:
                    $string = strtolower($string);
                    break;
                case 2:
                    $string = strtoupper($string);
                    break;
                case 3:
                    $string = strtolower($string);
                    $string[0] = strtoupper($string[0]);
                    break;
                case 4:
                    $string = strtolower($string);
                    $string[0] = strtoupper($string[0]);
                    $inici = 0;
                    while ($pos = strpos($string, " ", $inici)) {
                        $inici = $pos+1;
                        $string[$inici] = strtoupper($string[$inici]);
                    }
                    break;
            }
        }
        return $string;
    }
    
    /**
     * Permet verificar un dni.
     * 
     * @param string $dni
     * @return boolean
     */
    public function verifyDni($dni){
        $letter = substr($dni, -1);
        $numbers = substr($dni, 0, -1);
        if (substr("TRWAGMYFPDXBNJZSQVHLCKE", $numbers % 23, 1) == $letter && strlen($letter) == 1 && strlen($numbers) == 8){
            return true;
        }
        
        return false;
    }
    
    /**
     * Permet convertir un objecte o un array d'objectes en un array o array de arrays.
     * 
     * @param array|object $result
     * @return array|NULL[]
     */
    function parseResult($result) {
        $resultArray = array();
        
        if ($result === null || empty($result)) {
            return $resultArray;
        }
        
        if (is_object($result)) {
            $resultArray[] = $result->parseToArray();
        } else if (is_array($result)) {
            foreach ($result as $item) {
                $resultArray[] = $item->parseToArray();
            }
        }
        
        return $resultArray;
    }
}

