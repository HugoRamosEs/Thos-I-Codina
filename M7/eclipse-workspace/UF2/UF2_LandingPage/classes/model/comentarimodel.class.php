<?php

class ComentariModel implements Crudable {
    const FILE = "docs/llibre-de-visites.xml";
    private $file;
    
    public function __construct() {
        $this->file = file_get_contents(self::FILE);
    }
    
    public function create($comentari){
        $llibre = "";
        if (!file_exists(self::FILE)) {
            $llibre .= "<REGISTRES>";
        }
        $llibre .= substr($this->file, 0, -13);
        $llibre .= "\n    <REGISTRE>\n        <NOM>$comentari->nom</NOM>\n        <MAIL>$comentari->mail</MAIL>\n        <OPCIO>$comentari->opcio</OPCIO>\n";
        $llibre .= "        <COMENTARI>$comentari->msg</COMENTARI>\n";
        $llibre .= "        <DATA>".$comentari->data['mday']."/".$comentari->data['mon']."/".$comentari->data['year']."</DATA>\n    </REGISTRE> \n";
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
    
    public function read($comentari = null){
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
    
    public function update($comentari){}
    
    public function delete($comentari){} 
}

?>