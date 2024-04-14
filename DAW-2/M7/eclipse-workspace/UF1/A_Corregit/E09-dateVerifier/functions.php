<?php
/**
 * Funció que verifica si es tracta 'una any de traspàs.
 * @param $any
 * @return boolean - true si és any de trasàs, false si no ho és
 */
function leapYear($any=NULL) {
    $year = ($any==NULL)? date('Y') : $year;
    return ( ($year%4 == 0 && $year%100 != 0) || $year%400 == 0 );
}
/**
 * Funció que verifica si es tracta 'una any de traspàs.
 * equivalent a l'anterior però fent servir la funció checkdate php
 * @param $any
 * @return boolean - true si és any de trasàs, false si no ho és
 */
function anyDeTraspas($any=NULL) {
    return checkdate(2, 29, ($any==NULL)? date('Y') : $any);
}

/**
 * Funció per verificar la validessa d'una data de naixement.
 * @param $date - data en format DD/MM/AAAA o DD-MM-AAAA
 * @return boolean - true si la data és vàlida, i false si no ho és.
 */
function dateVerifier($date) {
    // Verificació del format
    // Contem el número de barres / o guions - i ha de ser 2.
    $aparicionsBarra = substr_count($date, "/");
    $aparicionsGuio = substr_count($date, "-");
    
    // Si un dels dos apareix dues vegades.... seguim verificant
    // en cas contrari.... no és correcte
    if ($aparicionsBarra==2 || $aparicionsGuio==2) {
        $arrayData = ($aparicionsBarra==2) ? explode("/", $date) : explode("-", $date);
        if (count($arrayData)==3) {
            //Verifiquem l'any
            $any = intval($arrayData[2]);
            if ($any>=1900 && $any<=date("Y")) {
                //Verifiquem el mes
                $mes = intval($arrayData[1]);
                if ($mes>0 && $mes<13) {
                    $dia = intval($arrayData[0]);
                    if ($dia>=1 && $dia<=31) {
                        switch ($dia) {
                        case 31:
                            $messos = array(1,3,5,7,8,10,12);
                            $resultat = in_array($mes, $messos);
                            break;
                        case 30:
                            $resultat = ($mes!=2);
                            break;
                        case 29:
                            $resultat = !(mes==2 && leapYear($any));
                            break;
                        default:
                            $resultat=true;
                        }
                    } else{
                        $resultat=false;
                    }
                } else {
                    $resultat=false;
                }
            } else {
                $resultat=false;
            }
        } else {
            $resultat=false;
        }
    } else {
        $resultat=false;
    }
    return $resultat;    
}