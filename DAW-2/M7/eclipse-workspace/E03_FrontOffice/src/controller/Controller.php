<?php
namespace controller;

use Exception;

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
     * Permet verificar una data, amb el seu format corresponent.
     * @param mixed $data: Cadena que indica la data.
     * @param int $format:
     *      [0] DD/MM/YY.
     *      [1] YY/MM/DD.
     */
    public function verifyData($data, $simbol, $format = 0){
        $values = explode($simbol, $data);
        if (count($values) === 3){
            switch ($format){
                case 0:
                    if (checkdate($values[1], $values[0], $values[2])){
                        return true;
                    }
                    break;
                    
                case 1:
                    if (checkdate($values[2], $values[1], $values[0])){
                        return true;
                    }
                    break;
            }
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
    
    /**
     * Permet convertir un json en una entitat, una lista de d'entitats, especificades o un array amb missatges de resultat.
     *
     * @param string $json JSON a convertir.
     * @param string $entityName Nom de la classe de l'entitat.
     * @return mixed Un objecte de l'entitat, una array d'entitats o un array amb missatges de resultat.
     */
    public function parseResponse($json, $entityName) {
        $json = trim($json);
        $json = stripslashes($json);
        $dataArray = json_decode($json, true);
        
        if (json_last_error() != JSON_ERROR_NONE) {
            throw new Exception("Invalid JSON: ". json_last_error());
        }
        
        if (isset($dataArray["OK"]) || isset($dataArray["error"]) || isset($dataArray["errors"])) {
            return $dataArray;
        }
        
        $entityClass = "model\\" . $entityName;
        if (!class_exists($entityClass)) {
            throw new Exception("Class {$entityName} does not exist");
        }
        
        if (count($dataArray) == 1) {
            $entity = new $entityClass();
            foreach ($dataArray[0] as $key => $value) {
                $setter = "set" . ucfirst($key);
                if (method_exists($entity, $setter)) {
                    $entity->$setter($value);
                }
            }
            return $entity;
        } else {
            $entities = [];
            foreach ($dataArray as $data) {
                $entity = new $entityClass();
                foreach ($data as $key => $value) {
                    $setter = "set" . ucfirst($key);
                    if (method_exists($entity, $setter)) {
                        $entity->$setter($value);
                    }
                }
                $entities[] = $entity;
            }
            return $entities;
        }
    }
}
