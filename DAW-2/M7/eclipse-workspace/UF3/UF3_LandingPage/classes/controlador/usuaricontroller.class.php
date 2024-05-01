<?php

class UsuariController extends Controller {
    private $usuari;
    
    public function __construct(Contacte $param = null){
        parent::__construct();
        $this->usuari = (is_null($param)) ? new Usuari("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "") : $param;
    }
    
    public function login(){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        
        $langTraduccions = $this->menuIdiomes($lang);
        
        $correcte = false;
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmEmail = $this->sanitize($_POST["email"], 1);
            $frmPassword = $this->sanitize($_POST["password"]);
            
            if (!filter_var($frmEmail, FILTER_VALIDATE_EMAIL)) {
                $frmErrors["email1"] = "Email no vàlid.";
                $frmEmail = "";
            }
            if (strlen($frmPassword) == 0) {
                $frmErrors["password1"] = "La contrasenya no pot estar buida.";
                $frmPassword = "";
            }
            
            $this->usuari = new Usuari($frmEmail, $frmPassword, "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            
            if (empty($frmErrors)) {
                $usuariModel = new UsuariModel();
                $dadesUsuari = $usuariModel->read($this->usuari);
                if($dadesUsuari != null){
                    if ($dadesUsuari["status"] == 1 || $dadesUsuari["status"] == 2){
                        // $_SESSION["email"] = $dadesUsuari["email"];
                        // $_SESSION["password"] = $dadesUsuari["password"];
                        // $_SESSION["status"] = $dadesUsuari["status"];
                        $_SESSION["login"] = true;
                        $_SESSION["imatge"] = $dadesUsuari["imatge"];
                        $vHome = new HomeView();
                        $vHome->show($lang, $langTraduccions, $errors);
                        $correcte = true;
                    }else{
                        $frmErrors["status"] = "El compte no està activat.";
                    }
                }else{
                    $frmErrors["db"] = "L'email i/o la contrasenya no son correctes.";
                }
            }
        }
        
        if (!$correcte){
            $vUsuari = new UsuariView();
            $vUsuari->login($lang, $langTraduccions, $this->usuari, $frmErrors); 
        }
    }
    
    public function logout(){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        session_destroy();
        header("Location: index.php");
        exit();
    }
    
    public function signup(){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        
        $langTraduccions = $this->menuIdiomes($lang);
        
        $correcte = false;
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmEmail = $this->sanitize($_POST["email"], 1);
            $frmPassword = $this->sanitize($_POST["password"]);
            $frmPassword2 = $this->sanitize($_POST["password2"]);
            $frmTipusIdent = $this->sanitize($_POST["tipusIdent"], 3);
            $frmNumeroIdent = $this->sanitize($_POST["numeroIdent"]);
            $frmNom = $this->sanitize($_POST["nom"], 4);
            $frmCognoms = $this->sanitize($_POST["cognoms"], 4);
            $frmNaixement = $this->sanitize($_POST["naixement"]);
            $frmSexe = $this->sanitize($_POST["sexe"], 3);
            $frmAdreca = $this->sanitize($_POST["adreca"]);
            $frmCodiPostal = $this->sanitize($_POST["codiPostal"]);
            $frmPoblacio = $this->sanitize($_POST["poblacio"], 3);
            $frmProvincia = $this->sanitize($_POST["provincia"], 3);
            $frmTelefon = $this->sanitize($_POST["telefon"]);
            $frmImatge = $_FILES["imatge"];
            $frmNavegador = $this->obtenirNavegador();
            $frmPlataforma = $this->obtenirPlataforma();
            
            if (!filter_var($frmEmail, FILTER_VALIDATE_EMAIL)) {
                $frmErrors["email"] = "Email no vàlid.";
                $frmEmail = "";
            }
            if (strlen($frmPassword) == 0) {
                $frmErrors["password1"] = "La contrasenya no pot estar buida.";
                $frmPassword = "";
            }elseif (strlen($frmPassword) < 8){
                $frmErrors["password2"] = "La contrasenya ha de tenir com a mínim 8 caràcters.";
                $frmPassword = "";
            }elseif (!preg_match("/[a-zA-Z]/", $frmPassword)){
                $frmErrors["password3"] = "La contrasenya ha de tenir com a mínim 1 lletra.";
                $frmPassword = "";
            }elseif (!preg_match("/\d/", $frmPassword)){
                $frmErrors["password4"] = "La contrasenya ha de tenir com a mínim 1 número.";
                $frmPassword = "";
            }
            if ($frmPassword2 !== $frmPassword){
                $frmErrors["password5"] = "Les contrasenyes no coincideixen.";
                $frmPassword2 = "";
            }
            $identificadors = ["Nif", "Nie", "Pasaport"];
            if (empty($frmTipusIdent) || !in_array($frmTipusIdent, $identificadors)) {
                $frmErrors["tipusIdent"] = "Has de seleccionar una opció vàlida.";
                $frmTipusIdent = "";
            }
            if (strlen($frmNumeroIdent) == 0){
                $frmErrors["numeroIdent1"] = "El número identificador es obligatori.";
                $frmNumeroIdent = "";
            }elseif ($this->validarNumeroIdent($frmTipusIdent, $frmNumeroIdent) == false){
                $frmErrors["numeroIdent2"] = "Número identificador invàlid.";
                $frmNumeroIdent = "";
            }
            if (strlen($frmNom) == 0) {
                $frmErrors["nom"] = "Has de posar un nom obligatoriament.";
                $frmNom = "";
            }
            if (strlen($frmCognoms) == 0) {
                $frmErrors["cognoms"] = "Has de posar al menys un cognom obligatoriament.";
                $frmCognoms = "";
            }
            if (strlen($frmNaixement) == 0){
                $frmErrors["naixement1"] = "La data de naixement es obligatoria.";
                $frmNaixement = "";
            }elseif ($this->validarData($frmNaixement) == false){
                $frmErrors["naixement2"] = "Data de naixement invàlida.";
                $frmNaixement = "";
            }
            $opcions = ["Home", "Dona"];
            if (empty($frmSexe) || !in_array($frmSexe, $opcions)) {
                $frmErrors["sexe"] = "Has de seleccionar una opció vàlida.";
                $frmSexe = "";
            }
            if (!preg_match('/^[0-9]{5,5}([- ]?[0-9]{4,4})?$/', $frmCodiPostal) && !strlen($frmCodiPostal) == 0) {
                $frmErrors["codiPostal"] = "Codi postal invàlid.";
                $frmCodiPostal = "";
            }
            $provinciesEsp = ["", "Alava", "Albacete", "Alicante", "Almeria", "Asturias", "Avila", "Badajoz", "Barcelona", "Burgos", "Caceres", "Cadiz", "Cantabria", "Castellon", "Ciudad Real", "Cordoba", "Cuenca", "Gerona", "Granada", "Guadalajara", "Guipuzcoa", "Huelva", "Huesca", "Islas Balears", "Jaen", "La Coruña", "La Rioja", "Las Palmas", "Leon", "Lerida", "Lugo", "Madrid", "Malaga", "Murcia", "Navarra", "Orense", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"];
            if (!in_array($frmProvincia, $provinciesEsp)){
                $frmErrors["provincia"] = "Has de seleccionar una opció vàlida.";
                $frmProvincia = "";
            }
            if (!preg_match("/^\d{9}$/", $frmTelefon) && !empty($frmTelefon)) {
                $frmErrors["telefon"] = "Telèfon invàlid.";
                $frmTelefon = "";
            }
            if (empty($frmImatge)) {
                $frmErrors["imatge1"] = "Has d'incloure una imatge.";
            }else {
                $extensions = ["jpg", "jpeg", "png", "gif", "webp"];
                $mimes = ["image/jpeg", "image/png", "image/gif", "image/webp"];
                $extensio = pathinfo($frmImatge["name"], PATHINFO_EXTENSION);
                if (isset($frmImatge["tmp_name"]) && !empty($frmImatge["tmp_name"])) {
                    $mime = mime_content_type($frmImatge["tmp_name"]);
                    if (!in_array($extensio, $extensions)) {
                        $frmErrors["imatge2"] = "La imatge no té una extensió permessa.";
                    }
                    if (!in_array($mime, $mimes)) {
                        $frmErrors["imatge3"] = "La imatge no té un mime permès.";
                    }
                    if (filesize($frmImatge["tmp_name"]) > 2097152) {
                        $frmErrors["imatge4"] = "El tamany de l'imatge excedeix els 2MB.";
                    }
                }else {
                    $frmErrors["imatge1"] = "Has d'incloure una imatge.";
                }
            }
            
            $extensio = pathinfo($frmImatge["name"], PATHINFO_EXTENSION);
            $tempsMs = round(microtime(true) * 1000);
            $img = "uploads/$tempsMs.$extensio";
            move_uploaded_file($frmImatge["tmp_name"], __DIR__ . "/../../$img");
            
            $this->usuari = new Usuari($frmEmail, $frmPassword, $frmTipusIdent, $frmNumeroIdent, $frmNom, $frmCognoms, $frmSexe, $frmNaixement, $frmAdreca, $frmCodiPostal, $frmPoblacio, $frmProvincia, $frmTelefon, $img, $frmNavegador, $frmPlataforma); 
            
            if (empty($frmErrors)) {
                $usuariModel = new UsuariModel();
                $lastId = $usuariModel->create($this->usuari);
                $vUsuari = new UsuariView();
                $vUsuari->confirm($lang, $langTraduccions, $this->usuari, $lastId); 
                $this->usuari = new Usuari("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                $correcte = true;
            }
        }
        
        if (!$correcte){
            $vUsuari = new UsuariView();
            $vUsuari->signup($lang, $langTraduccions, $this->usuari, $frmErrors, $frmPassword2);
        }
    }
    
    public function confirm($params){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        }else {
            $lang = "cat";
        }
        
        $langTraduccions = $this->menuIdiomes($lang);
        
        $usuariModel = new UsuariModel();
        $usuariModel->update($params[0]);
        $vUsuari = new UsuariView();
        $vUsuari->active($lang, $langTraduccions);
    }
    
    private function validarNumeroIdent($tipusIdent, $numeroIdent){
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
    
    private function validarData($data){
        $valors = explode("/", $data);
        if(count($valors) == 3 && checkdate($valors[1], $valors[0], $valors[2])){
            return true;
        }
        return false;
    }
    
    private function obtenirNavegador() {
        $http_user = $this->sanitize($_SERVER["HTTP_USER_AGENT"]);
        $navegadors = [
            "/Chrome/i" => "Chrome",
            "/Firefox/i" => "Firefox",
            "/Safari/i" => "Safari",
            "/MSIE|Trident/i" => "Explorer",
            "/Opera/i" => "Opera",
        ];
        foreach ($navegadors as $patro => $nom) {
            if (preg_match($patro, $http_user)) {
                return $nom;
            }
        }
        return "Desconegut";
    }
    
    private function obtenirPlataforma() {
        $http_user = $this->sanitize($_SERVER["HTTP_USER_AGENT"]);
        $plataformes = [
            "/Windows NT/i" => "Windows",
            "/Mac/i" => "MacOS",
            "/Linux/i" => "Linux",
            "/iPhone/i" => "iOS",
            "/iPad/i" => "iOS",
            "/Android/i" => "Android",
        ];
        foreach ($plataformes as $patro => $nom) {
            if (preg_match($patro, $http_user)) {
                return $nom;
            }
        }
        return "Desconeguda";
    }
}

