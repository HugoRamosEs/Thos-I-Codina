<?php

class UserController extends Controlador {
    private $user;
    
    public function __construct(User $param=null){
        parent::__construct();
        $this->user = (is_null($param)) ? new User() : $param;
    }
 
    public function login() {
        if ($_SERVER['REQUEST_METHOD']=='POST' && (isset($_POST['Login']))) {
            $frmNom = $this->sanitize($_POST['nom']);
            $frmCts = $this->sanitize($_POST['contrasenya']);
            
            if (strlen($frmNom)==0) {
                $this->user->errorsDetectats['nom'] = "l'usuari és obligatori";
            }
            if (strlen($frmCts)==0) {
                $this->user->errorsDetectats['nom'] = "la contrasenya és obligatòria";
            }
            $this->user->setEmail($frmNom);
            
            $mUser = new UserModel();
            if (($usuari = $mUser->getByEmail($this->user))==null) {
                $this->user->errorsDetectats['nom'] = "No existeix l'usuari a la base de dades";
            } else {
                $this->user = $usuari;
                if ($this->user->getPassword() != $frmCts) {
                    $this->user->errorsDetectats['nom'] = "La contrasenya no és correcte";
                } else {
                    if ($this->user->getStatus() == 0) {
                        $this->user->errorsDetectats['nom'] = "Verifica el teu mail per activar el compte";
                    } else {
                        $_SESSION['logged'] = true;
                        $_SESSION['img'] = $usuari->getImatge();
                        $this->user = new User();
                    }
                }
            }
            
        }
        $vLogIn = new LogInView();
        $vLogIn->show($this->user);    
    }
    
    public function register() {
        if ($_SERVER['REQUEST_METHOD']=='POST' && (isset($_POST['submit']))) {
            $errorsDetectats=$this->validaDadesRegistre();
            if (isset($errorsDetectats)) {
                $this->errorsDetectats["error"] = "S'ha detectat algun tipus d'error. Revisa les dades introduides.";
                $vUser=new RegisterView();
                $vUser->show($this->user);
            } else {
                $sNom=$this->user->getNom();
                $sCognoms=$this->user->getCognoms();
                $idDelRegistreInsertat=$this->user->getId();
                
                $titol = "Procès finalitzat correctament";
                $missatge = "Benvolgut/da $sNom $sCognoms<br>
    Ens complau donar-te la benvinguda a la nova aplicació mòbil de residents des de la qual podràs realitzar el pagament mitjançant un telèfon smartphone quan estacionis el teu vehicle a la teva zona de resident de l’AREA de Barcelona sense la necessitat d’anar al parquímetre.<br>
    Per procedir a l’activació del compte has de prémer el següent <a href='?user/confirmacio/$idDelRegistreInsertat'>enllaç</a>.<br>
    Recorda que pots obtenir ajuda i tota la informació sobre el funcionament de l’aplicació mòbil ONaparcar Residents accedint a la secció preguntes freqüents i que en cas d’ incidència ens ho pots notificar mitjançant el formulari de suport tècnic.<br>
    <br>
    Atentament, ";
                $vError=new ErrorView();
                $vError->showOk($titol,$missatge);
            }
        }
        $vLogIn = new RegisterView();
        $vLogIn->show($this->user);    
    }
    
    private function validaDadesRegistre() {
        $this->user = new User();
        $this->user->setEmail($this->sanitize($_POST["email"], 1));
        $this->user->setPassword($this->sanitize($_POST["pass"], 0), $this->sanitize($_POST["cpass"], 0));
        
        $this->user->setTipusIdent($this->sanitize($_POST["tipus"], 2));
        $this->user->setNumeroIdent($this->sanitize($_POST["dni"], 2));
        $this->user->setNom($this->sanitize($_POST["nom"], 1));
        $this->user->setCognoms($this->sanitize($_POST["cognoms"], 1));
        $this->user->setSexe($this->sanitize($_POST["sexe"], 2));
        $this->user->setDatanaixement($this->sanitize($_POST["naixement"], 0));
        
        $this->user->setAdreca($this->sanitize($_POST["adreca"], 1));
        $this->user->setCodiPostal($this->sanitize($_POST["cp"], 0));
        $this->user->setPoblacio($this->sanitize($_POST["poblacio"], 1));
        $this->user->setProvincia($this->sanitize($_POST["provincia"], 1));
        $this->user->setTelefon($this->sanitize($_POST["telefon"], 0));
        
        $iniciCadena = strpos($_SERVER["HTTP_USER_AGENT"], "(") + 1;
        $finalCadena = strpos($_SERVER["HTTP_USER_AGENT"], ")") - 1;
        
        $this->user->setNavegador(substr($_SERVER["HTTP_USER_AGENT"], 0, strpos($_SERVER["HTTP_USER_AGENT"], "(")));
        $this->user->setPlataforma(substr($_SERVER["HTTP_USER_AGENT"], $iniciCadena, $finalCadena - $iniciCadena)  );
        
        if ($this->user->errorsDetectats===null) {
            $this->user->setImatge($this->sanitize($_FILES['imatge']['name'],0));
        }

        $mUsuari = new UserModel();
        if (!$mUsuari->isEmailUnic($this->user)) {
            $this->user->errorsDetectats["email"] = "Aquest email ja existeix a la meva base de dades<br>";
        }
        
        if ($this->user->errorsDetectats===null) {
            if (is_array($res = $mUsuari->save($this->user))) {
                $this->user->errorsDetectats[] = $res;
            } else {
                $this->user->setId($res);
            }
        }
        
        return $this->user->errorsDetectats;
    }
    
    public function confirmacio($param) {
        if (!isset($param)) {
            throw new Exception("Falten dades per la confirmació");
        }
        $this->user=new User();
        $this->user->setId($param[0]);
        
        $mUser = new UserModel();
        $errorsDetectats=$mUser->confirma($this->user);
        
        $vError=new ErrorView();
        if (isset($errorsDetectats)) {
            $vError->showMessage("Procès finalitzat amb errors", "El procès de verificació ha produït un error: <br> {$errorsDetectats["baseDades"]}");
        } else {
            $vError->showOk("Procès finalitzat correctament","El procès de registre ha finacilitzat amb éxit, el mail està validat.<br>Ara ja podràs accedir a la noastra àrea privada.<br><br>Moltes gràcies<br>");
        }
    }
    
    public function logout() {
        $_SESSION['logged']=false;
        unset ($_SESSION['img']);
        header("Location: index.php");
        exit;
    }
}

