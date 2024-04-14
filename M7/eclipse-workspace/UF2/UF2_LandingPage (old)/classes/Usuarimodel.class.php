<?php

class UsuariModel implements Crudable {
    const FILE = "docs/llibre-de-visites.xml";
    private $file;
    
    public function __construct() {
        $this->file = file_get_contents(self::FILE);
    }
    
    public function create($usuari){
        $llibre = "";
        if (!file_exists(self::FILE)) {
            $llibre .= "<REGISTRES>";
        }
        $llibre .= substr($this->file, 0, -13);
        $llibre .= "\n    <REGISTRE>\n        <NOM>$usuari->nom</NOM>\n        <MAIL>$usuari->mail</MAIL>\n        <OPCIO>$usuari->opcio</OPCIO>\n";
        $llibre .= "        <COMENTARI>$usuari->msg</COMENTARI>\n";
        $llibre .= "        <DATA>".$usuari->data['mday']."/".$usuari->data['mon']."/".$usuari->data['year']."</DATA>\n    </REGISTRE> \n";
        $llibre .= "</REGISTRES>";
        
        if ($file = fopen(self::FILE, "w")) {
            if (!fwrite($file, $llibre)) {
                throw new Exception("El fitxer no deixa escriure.");
            }
            fclose($file);
        } else {
            throw new Exception("No s'ha pogut obrir el fitxer per emmagatzemar informació.");
        }
    }
    
    public function read($usuari){
        $xml = simplexml_load_file(self::FILE);
        if ($xml) {
            $registres = [];
            foreach ($xml->REGISTRE as $registre) {
                $registreDades = [];        
                foreach ($registre as $dada) {
                    array_push($registreDades, (string)$dada);
                }
                array_push($registres, $registreDades);        
            }
            return array_reverse($registres);
        } else {
            throw new Exception("Error al carregar l'arxiu XML.");
        }
    }
    
    public function update($usuari){
        
    }
    
    public function delete($usuari){
        
    } 
}

?>