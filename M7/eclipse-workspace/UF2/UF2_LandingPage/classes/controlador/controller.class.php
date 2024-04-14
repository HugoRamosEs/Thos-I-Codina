<?php

class Controller {
    public function __construct(){}
    
    /**
     * Permet sanititzar un string que es rep per una petició.
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
        }else {
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
     * Permet verificar una data, amb el seu format corresponent.
     * @param mixed $data: Cadena que indica la data.
     * @param int $format:
     *      [0] DD/MM/YY.
     *      [1] YY/MM/DD.
     */
    
    public function verificarData($data, $simbol, $format = 0){
        $valors = explode($simbol, $data);
        if (count($valors) === 3){
            switch ($format){
                case 0:
                    if (checkdate($valors[1], $valors[0], $valors[2])){
                        return true;
                    }
                    break;
                    
                case 1:
                    if (checkdate($valors[2], $valors[1], $valors[0])){
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
    
    /**
     * Permet verificar una hora, amb el seu format corresponent.
     * @param mixed $data: Cadena que indica la hora.
     * @param int $format:
     *      [0] HH/MM/SS.
     *      [1] HH/SS.
     */
    
    public function verificarHora($hora, $format = 0) {
        $valors = explode(":", $hora);
        if (count($valors) >= 2 && count($valors) <= 3) {
            switch ($format) {
                case 0:
                    if (count($valors) === 3 && is_numeric($valors[0]) && is_numeric($valors[1]) && is_numeric($valors[2])) {
                        if (($valors[0] >= 0 && $valors[0] <= 23) && ($valors[1] >= 0 && $valors[1] <= 59) && ($valors[2] >= 0 && $valors[2] <= 59)) {
                            return true;
                        }
                    }
                    break;
                case 1:
                    if (count($valors) === 2 && is_numeric($valors[0]) && is_numeric($valors[1])) {
                        if (($valors[0] >= 0 && $valors[0] <= 23) && ($valors[1] >= 0 && $valors[1] <= 59)) {
                            return true;
                        }
                    }
                    break;
            }
        }
        return false;
    }
    
    
    /**
     * Permet verificar una imatge, amb el seu tamany, mime i extensio. A més si tot es correcte mou l'arxiu al directori final.
     * @param mixed $frmImatge: Imatge pujada per l'usuari
     * @param int $tamany: Tamany màxim d'imatge
     * @param array $frmErrors: Array dels errors.
     * @param int $opcio: 
     *      [0] Imatge obligatoria.
     *      [1] Imatge no obligatoria. 
     * @return string
     */
    
    public function verificarImatge($frmImatge, $tamany, &$frmErrors, $opcio = 0) {
        switch ($opcio) {
            case 0:
                if (empty($frmImatge)) {
                    $frmErrors["imatge1"] = "Has d'incloure una imatge.";
                } else {
                    $extensions = ["jpg", "jpeg", "png", "gif", "webp"];
                    $mimes = ["image/jpeg", "image/png", "image/gif", "image/webp"];
                    $extensio = pathinfo($frmImatge["name"], PATHINFO_EXTENSION);
                    $bytes = $tamany * 1024 * 1024;
                    if (isset($frmImatge["tmp_name"]) && !empty($frmImatge["tmp_name"])) {
                        $mime = mime_content_type($frmImatge["tmp_name"]);
                        if (!in_array($extensio, $extensions)) {
                            $frmErrors["imatge2"] = "La imatge no té una extensió permessa.";
                        }
                        if (!in_array($mime, $mimes)) {
                            $frmErrors["imatge3"] = "La imatge no té un mime permès.";
                        }
                        if (filesize($frmImatge["tmp_name"]) > $bytes) {
                            $frmErrors["imatge4"] = "El tamany de l'imatge excedeix els " . $tamany . "MB.";
                        }
                    } else {
                        $frmErrors["imatge1"] = "Has d'incloure una imatge.";
                    }
                }
                
                if (empty($frmErrors)) {
                    $extensio = pathinfo($frmImatge["name"], PATHINFO_EXTENSION);
                    $tempsMs = round(microtime(true) * 1000);
                    $img = "uploads/$tempsMs.$extensio";
                    move_uploaded_file($frmImatge["tmp_name"], __DIR__ . "/../../$img");
                    return $img;
                }
                break;
                
            case 1:
                $extensions = ["jpg", "jpeg", "png", "gif", "webp"];
                $mimes = ["image/jpeg", "image/png", "image/gif", "image/webp"];
                $extensio = pathinfo($frmImatge["name"], PATHINFO_EXTENSION);
                $bytes = $tamany * 1024 * 1024;
                if (isset($frmImatge["tmp_name"]) && !empty($frmImatge["tmp_name"])) {
                    $mime = mime_content_type($frmImatge["tmp_name"]);
                    if (!in_array($extensio, $extensions)) {
                        $frmErrors["imatge2"] = "La imatge no té una extensió permessa.";
                    }
                    if (!in_array($mime, $mimes)) {
                        $frmErrors["imatge3"] = "La imatge no té un mime permès.";
                    }
                    if (filesize($frmImatge["tmp_name"]) > $bytes) {
                        $frmErrors["imatge4"] = "El tamany de l'imatge excedeix els " . $tamany . "MB.";
                    }
                }
                
                if (empty($frmErrors)) {
                    $extensio = pathinfo($frmImatge["name"], PATHINFO_EXTENSION);
                    $tempsMs = round(microtime(true) * 1000);
                    $img = "uploads/$tempsMs.$extensio";
                    move_uploaded_file($frmImatge["tmp_name"], __DIR__ . "/../../$img");
                    return $img;
                }
                break;
        }
    }
    
    public function verificarNumeroIdent($tipusIdent, $numeroIdent){
        if ($tipusIdent === "Nif"){
            $lletra = substr($numeroIdent, -1);
            $numeros = substr($numeroIdent, 0, -1);
            if (!substr("TRWAGMYFPDXBNJZSQVHLCKE", $numeros%23, 1) == $lletra && strlen($lletra) == 1 && strlen ($numeros) == 8){
                return false;
            }
            return true;
        }elseif ($tipusIdent === "Nie"){
            $lletraInicial = substr($numeroIdent, 0, 1);
            $lletraFinal = substr($numeroIdent - 1);
            $numeros = substr($numeroIdent, 1, 7);
            if ($lletraInicial != "X" || $lletraInicial != "Y" || $lletraInicial != "Z") {
                return false;
            }
            if (!substr("TRWAGMYFPDXBNJZSQVHLCKE", $numeros%23, 1) == $lletraFinal){
                return false;
            }
            return true;
        }elseif ($tipusIdent === "Pasaport"){
            if (!preg_match("/^[A-Z]{1}[0-9]{7}$/", $numeroIdent)){
                return false;
            }
            return true;
        }else{
            return "Tipus d'identificador invàlid.";
        }
    }
}
    
