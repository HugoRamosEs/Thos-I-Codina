<?php

class IdiomaController extends Controller {
    private $idioma;
    private $idiomaModel;
    private $traduccioModel;
    private $idiomaView;
    
    public function __construct(Idioma $param = null) {
        parent::__construct();
        $this->idioma = null;
        $this->idiomaModel = new IdiomaModel();
        $this->traduccioModel = new TraduccioModel();
        $this->idiomaView = new IdiomaView();
    }
    
    public function show(){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        }else {
            $lang = "cat";
        }
        
        $idiomes = $this->idiomaModel->read();
        
        $langTraduccions = $this->menuIdiomes($lang);
        
        $this->idiomaView->show($lang, $idiomes, $langTraduccions);
    }
    
    public function form($params){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        }else {
            $lang = "cat";
        }
        
        $frmErrors = array();
        $imgErrors = array();
        $frmSanititzats = array();
        $idiomes = $this->idiomaModel->read();
        
        $langTraduccions = $this->menuIdiomes($lang);
        
        if ($params !== null) {
            $this->idioma = $this->idiomaModel->getById(intval($params[0]));
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmImatge = $_FILES["imatge"];
            $frmIso = $this->sanitize($_POST["iso"]);
            $frmActiu = $this->sanitize($_POST["actiu"]);
            $frmVariablePropia = $this->sanitize($_POST["variable-propia"]);
            foreach ($idiomes as $i){
                $nom = 'frm' . ucfirst($i->getIso());
                ${$nom} = $this->sanitize($_POST[$i->getIso()]);
                $frmSanititzats[$nom] = ${$nom};
            }
            
            if ($params) {
                if (!empty($frmImatge["name"])){
                    $imatge = $this->verificarImatge($frmImatge, 2, $imgErrors, 1);
                }
            }else {
                $imatge = $this->verificarImatge($frmImatge, 2, $imgErrors, 0);
            }
            $frmErrors = array_merge($frmErrors, $imgErrors);
            if (strlen($frmIso) == 0){
                $frmErrors["iso1"] = "Has de posar un iso obligatoriament.";
                $frmIso = "";
            }else if (strlen($frmIso) > 3){
                $frmErrors["iso2"] = "Tamany d'entrada exedit.";
                $frmIso = "";
            }
            $opcions = ["0", "1"];
            if (!in_array($frmActiu, $opcions)) {
                $frmErrors["actiu"] = "Has de seleccionar una opció vàlida.";
                $frmActiu = "0";
            }
            if (strlen($frmVariablePropia) > 3000) {
                $frmErrors["variable-propia"] = "Tamany d'entrada exedit.";
                $frmVariablePropia = "";
            }
            foreach ($frmSanititzats as $nom => $valor) {
                if (strlen($valor) > 3000) {
                    $frmErrors["traduccio"] = "Tamany d'entrada exedit en una o més traduccions.";
                }
            }
            
            if ($params) {
                if (empty($frmErrors)) {
                    $data = date('Y-m-d H:i:s');
                    $this->idioma->setIso($frmIso);
                    $this->idioma->setActiu($frmActiu);
                    if (!empty($frmImatge["name"])){
                        $this->idioma->setImatge($imatge);
                    }
                    $this->idioma->setActiu(intval($frmActiu));
                    $this->idioma->setUpdated_at($data);
                    foreach ($this->idioma->getTraduccions() as $t){
                        $frmNom = "frm" . ucfirst($t->getVariable());
                        if (isset($frmSanititzats[$frmNom])) {
                            $valor = $frmSanititzats[$frmNom];
                            if ($valor !== $t->getValor()) {
                                $t->setValor($valor);
                                $t->setUpdated_at($data);
                                $this->traduccioModel->update($t);
                            }
                        }
                    }
                    $this->idiomaModel->update($this->idioma);
                    header("Location: index.php?Idioma/show");
                    exit();
                }
            }else {
                if (empty($frmErrors)) {
                    $data = date('Y-m-d H:i:s');
                    $this->idioma = new Idioma(null, $frmIso, $imatge, intval($frmActiu), $data, $data);
                    $idioma_id = $this->idiomaModel->create($this->idioma);
                    $this->idioma->setId($idioma_id);
                    
                    foreach ($idiomes as $idioma) {
                        if ($idioma->getId() !== $idioma_id) {
                            $iso = $idioma->getIso();
                            $frmNom = "frm" . ucfirst($iso);
                            if (isset($frmSanititzats[$frmNom])) {
                                $valor = $frmSanititzats[$frmNom];
                                $t = new Traduccio(null, $iso, $idioma_id, $valor, $data, $data);
                            }else {
                                $t = new Traduccio(null, $iso, $idioma_id, "", $data, $data);
                            }
                            $this->traduccioModel->create($t);
                        }
                    }
                    
                    $tPropia = new Traduccio(null, $frmIso, $idioma_id, $frmVariablePropia, $data, $data);
                    $this->traduccioModel->create($tPropia);

                    foreach ($idiomes as $idioma) {
                        if ($idioma->getId() !== $idioma_id) {
                            $tAltre = new Traduccio(null, $frmIso, $idioma->getId(), "", $data, $data);
                            $this->traduccioModel->create($tAltre);
                        }
                    }
                    
                    header("Location: index.php?Idioma/show");
                    exit();
                }
            }
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["cancelar"]))) {
            $this->idioma = null;
            header("Location: index.php?Idioma/show");
            exit();
        }
        
        $this->idiomaView->form($lang, $idiomes, $frmErrors, $langTraduccions, $this->idioma);
    }
    
    public function delete($params) {
        $idiomaGetById = $this->idiomaModel->getById(intval($params[0]));
        foreach ($idiomaGetById->getTraduccions() as $t){
            $this->traduccioModel->delete($t);
        }
        $this->idiomaModel->delete($idiomaGetById);
        header("Location: index.php?Idioma/show");
        exit();
    }
}

