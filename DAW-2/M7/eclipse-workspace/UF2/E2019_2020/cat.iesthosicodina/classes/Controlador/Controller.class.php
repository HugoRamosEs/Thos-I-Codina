<?php

class Controller {
    private $_config;

    public function __construct(){
        $this->_config = new Configuracio();        
    }
    
    
    /**
     * Neteja un string, reemplaçant espais en blanc i alguns altres caracters per guions.
     *
     * Limita la sortida a caràcters alfanumérics, underscore (_) i guions (-).
     * Els espais en blanc es converteixen en guions.
     *
     * @param string $string L'String que es vol netejar
     * @return string L'String netejat.
     */
    public static function sanitize ($stringANetejar, $convertirAlowercase){
        if (empty($stringANetejar)) {
            $stringANetejar = "";
        } else {
            $stringANetejar = htmlspecialchars(stripslashes(trim($stringANetejar, '-')));
            $stringANetejar = strip_tags($stringANetejar);
            // Preserve escaped octets.
            $stringANetejar = preg_replace('|%([a-fA-F0-9][a-fA-F0-9])|', '---$1---', $stringANetejar);
            // Remove percent signs that are not part of an octet.
            $stringANetejar = str_replace('%', '', $stringANetejar);
            // Restore octets.
            $stringANetejar = preg_replace('|---([a-fA-F0-9][a-fA-F0-9])---|', '%$1', $stringANetejar);
            
            switch ($convertirAlowercase) {
                
                case 1:
                    if (function_exists('mb_strtolower')) {
                        $stringANetejar = mb_strtolower($stringANetejar, 'UTF-8');
                    } else {
                        $stringANetejar = strtolower($stringANetejar);
                    }
                    break;
                case 2:
                    if (function_exists('mb_strtoupper')) {
                        $stringANetejar = mb_strtoupper($stringANetejar, 'UTF-8');
                    } else {
                        $stringANetejar = strtoupper($stringANetejar);
                    }
                    break;
            }
            
            // $stringANetejar = preg_replace('/[^%a-z0-9 _-]/', '', $stringANetejar);
            // $stringANetejar = preg_replace('/\s+/', '-', $stringANetejar);
            // $stringANetejar = preg_replace('|-+|', '-', $stringANetejar);
        }
        return $stringANetejar;
    }   
    
    public function getConfiguracio() {
        return $this->_config;
    }
    
}

