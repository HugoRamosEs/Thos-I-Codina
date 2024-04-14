<?php
class LanguageController extends Controller {
    private $idiomaDeLaPagina;
    private $fitxerDeTraduccions;
    
    public function __construct() {
        parent::__construct();
    
    //Verifiquem si si ha idioma definit.
        if (isset($_COOKIE['lang'])) {
            $this->idiomaDeLaPagina = Controller::sanitize($_COOKIE['lang'],0);
        } else {
            $this->idiomaDeLaPagina = parent::getConfiguracio()->IDIOMA_PER_DEFECTE;
        }
    
        $this->definexiFitxerDeTraduccions();
    }
    
    
    public function defineixIdiomaDeLaPagina($nouIdioma) {
        $idiomesDelFormulari = $this->getConfiguracio()->getIdiomesDelFormulari();
        foreach ($idiomesDelFormulari as $clau => $valor) {
            $idiomes [] = $clau;
        }
        
        if (in_array($nouIdioma, $idiomes))  {
            $this->idiomaDeLaPagina = $this->sanitize($nouIdioma,0);
            setcookie("lang", $this->idiomaDeLaPagina,time() + 60*60*24*30);
            $_COOKIE['lang'] = $this->idiomaDeLaPagina;
            $this->definexiFitxerDeTraduccions();
        }
    }
    
    public function definexiFitxerDeTraduccions() {
        $this->fitxerDeTraduccions = "languages/{$this->idiomaDeLaPagina}_traduccio.php";
    }
    
    public function generaHTML() {
        $html = "";
        if (isset($_COOKIE["lang"])) {
            foreach ($this->getConfiguracio()->getIdiomesDelFormulari() as $acronim => $idioma) {
                if ($_COOKIE["lang"] == $acronim) {
                    $html .= "<a href='?Language/setIdiomaDeLaPagina/$acronim'><img src='img/$acronim.png' alt='$idioma' align='right' height='25' width='25'/></a>";
                } else {
                    $html .= "<button type='submit' name='lang' value='$acronim'><img src='img/$acronim.png' alt='$idioma' align='right' heigth='25' width='25' /></button>";
                }
            }
        } else {
            foreach ($this->getConfiguracio()->getIdiomesDelFormulari() as $acronim => $idioma) {
                if ($acronim == $this->idiomaDeLaPagina) {
                    $html .= "<button type='submit' name='lang' value='$acronim' style='background-color:GRAY;'><img src='img/$acronim.png' alt='$idioma' align='right' heigth='25' width='25' /></button>";
                } else {
                    $html .= "<button type='submit' name='lang' value='$acronim'><img src='img/$acronim.png' alt='$idioma' align='right' heigth='25' width='25' /></button>";
                }
            }
        }
        
        return $html;
    }
    
    public function getIdiomaDeLaPagina()
    {
        return $this->idiomaDeLaPagina;
    }

    public function getFitxerDeTraduccions()
    {
        return $this->fitxerDeTraduccions;
    }

    public function setIdiomaDeLaPagina($idiomaDeLaPagina)
    {
        $this->idiomaDeLaPagina = $idiomaDeLaPagina;
    }

    public function setFitxerDeTraduccions($fitxerDeTraduccions)
    {
        $this->fitxerDeTraduccions = $fitxerDeTraduccions;
    }

    
    
    
    
}