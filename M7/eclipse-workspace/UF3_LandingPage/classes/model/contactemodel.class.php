<?php

class ContacteModel implements Crudable {
    const FILE = "docs/contacte.xml";
    private $file;
    
    public function __construct(){
        $this->file = file_get_contents(self::FILE);
    }
    
    public function create($contacte){
        $llibre = "";
        if (!file_exists(self::FILE)) {
            $llibre .= "<REGISTRES>";
        }
        $llibre .= substr($this->file, 0, -13);
        $llibre .= "\n    <REGISTRE>\n        <NOM>$contacte->nom</NOM>\n        <MAIL>$contacte->mail</MAIL>\n";
        $llibre .= "        <COMENTARI>$contacte->msg</COMENTARI>\n";
        $llibre .= "        <HORA>".$contacte->data['hours'].":".$contacte->data['minutes'].":".$contacte->data['seconds']."</HORA>\n";
        $llibre .= "        <DATA>".$contacte->data['mday']."/".$contacte->data['mon']."/".$contacte->data['year']."</DATA>\n    </REGISTRE> \n";
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
    
    public function read($contacte){}

    public function update($contacte){}

    public function delete($contacte){}
    
}