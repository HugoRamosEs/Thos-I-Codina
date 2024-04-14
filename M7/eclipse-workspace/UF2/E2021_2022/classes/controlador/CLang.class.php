<?php
class CLang extends Controller {
    private $activeLanguage;
    private $traduccions;

    /**
     * Constructor que verifica si està definida la cookie "lang" en el sistema client.
     * Si no està definida, defineix una per defecte: "ca"
     * Si està definida la cookie la emmagatzema a l'atribut.
     * 
     * En tots dos casos, cridarà a dispatch per carregar l'objecte de negoci
     * $traduccions;
     */
    public function __construct() {
        parent::__construct();
        if (isset($_COOKIE["lang"])) {
            $this->activeLanguage = $_COOKIE["lang"];
        } else {
            $this->activeLanguage = "ca";
            setcookie("lang","ca",time()+3600);
        }
    }
    
    public function dispatch() {
        if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET["lang"])) {
            $possibleLangauages=array("es", "gb", "de", "ca");
            $getLanguage=$this->sanitize($_GET['lang']);
            if (in_array($getLanguage,$possibleLangauages)) {
                $this->activeLanguage=$getLanguage;
                setcookie("lang",$this->activeLanguage);
            }
        }
        $mLang = new MLang();
        $this->traduccions = $mLang->getText($this->activeLanguage);
    }
    
    public function getTraduccions() {
        return $this->traduccions;
    }
}

