<?php
class GuestBookView extends Vista {
    private $_config;
    private $_llibre;
    private $_html;
    private $_comentari;
    
    public function __construct($e=null) {
        parent::__construct();
        $this->_config = new Configuracio();
        $this->_comentari = new Comentari();
        if (!is_null($e)) {
            $this->_llibre = $e;
            $this->_html = $this->html();
        }
    }
    
    public function getLlibre()  {
        return $this->_llibre;
    }

    public function setLlibre($_llibre)  {
        $this->_llibre = $_llibre;
    }
    
    public function html() {
        $sLlibre = "";
        $contador = 1;
        foreach (array_reverse($this->_llibre) as $registre){
            if ($contador <= 10) {
                $sLlibre .= "<textarea readonly class='llarg'>" . $registre["qui"] . $registre["que"] . "</textarea> \n";
            }
            $contador +=1;
        }
        return $sLlibre;
    }
    
    public function getExperiencies() {
        $html = "";
        foreach ($this->_config->getExperiencies() as $codi => $text ) {
            $selected = (is_null($this->getComentari()->getExperiencia())) ? "MB" : $this->getComentari()->getExperiencia();
            if ($selected == $codi) {
                $html .= "<input type='radio' name='experiencia' value='$codi' checked>$text \n";
            } else {
                $html .= "<input type='radio' name='experiencia' value='$codi'>$text \n";
            }
         }
         return $html;
         
    }

    public function getPaisos() {
        $html="";
        foreach ($this->_config->getPaises() as $sPais) {
            $selected =(is_null($this->getComentari()->getPais())) ? "España" : $this->getComentari()->getPais();
            if ($selected == $sPais) {
                $html .= "<option value='$sPais' selected>$sPais</option>";
            } else {
                $html .= "<option value='$sPais' >$sPais</option>";
            }
        }
        return $html;
        
    }
    
    public function getHtml() {
        return $this->_html;
    }
    public function getComentari() {
        return $this->_comentari;
    }    
    public function setComentari($e) {
        $this->_comentari = $e;
    }

     
}