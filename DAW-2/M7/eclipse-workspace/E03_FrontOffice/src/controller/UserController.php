<?php
namespace controller;

use model\User;
use model\UserModel;
use view\UserView;
use view\HomeView;

class UserController extends Controller {
    private $user;
    private $userModel;
    
    public function __construct(User $param = null) {
        parent::__construct();
        $this->user = (is_null($param)) ? new User(null, "", "", "", "", "", "") : $param;
        $this->userModel = new UserModel();
    }
    
    public function login() {
        $frmErrors = array();
        $logged = false;
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmEmail = $this->sanitize($_POST["email"]);
            $frmPassword = $this->sanitize($_POST["password"]);
            
            if (strlen($frmEmail) == 0) {
                $frmErrors["email1"] = "Has d'introduir un email.";
                $frmEmail = "";
            } else if (!filter_var($frmEmail, FILTER_VALIDATE_EMAIL)) {
                $frmErrors["email2"] = "Format de l'email invàlid.";
                $frmEmail = "";
            }
            
            if (strlen($frmPassword) == 0) {
                $frmErrors["password1"] = "Has d'introduir una contrasenya.";
                $frmPassword = "";
            }

            $this->user = new User("", "", "", $frmEmail, $frmPassword, "", "");
            
            if (empty($frmErrors)) {
                $user = $this->userModel->getByEmailAndPassword($this->user->getEmail(), $this->user->getPassword());
                if ($user != null) {
                    $_SESSION["login"] = true;
                    $_SESSION["user_id"] = $user->getId();
                    HomeView::show();
                    $logged = true;
                } else {
                    $error = "L'email i/o la contrasenya són incorrectes.";
                }
            }
        }
        
        if (!$logged) {
            UserView::login($this->user, "", $error, $frmErrors);
        }
    }
    
    public function logout() {
        session_destroy();
        header("Location: index.php");
        exit();
    }
    
    public function signup() {
        $frmErrors = array();
        $frmPassword2 = "";
        $created = false;
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmName = $this->sanitize($_POST["name"]);
            $frmSurname = $this->sanitize($_POST["surname"]);
            $frmEmail = $this->sanitize($_POST["email"]);
            $frmPassword = $this->sanitize($_POST["password"]);
            $frmPassword2 = $this->sanitize($_POST["password2"]);
            $frmPhone = $this->sanitize($_POST["phone"]);
            $frmDateOfBirth = $this->sanitize($_POST["dateOfBirth"]);

            if (strlen($frmName) == 0) {
                $frmErrors["name1"] = "Has d'introduir un nom.";
                $frmName = "";
            } else if (strlen($frmName) > 50) {
                $frmErrors["name2"] = "S'ha superat la mida, màxim 50 caràcters.";
                $frmName = "";
            }

            if (strlen($frmSurname) == 0) {
                $frmErrors["surname1"] = "Has d'introduir un cognom.";
                $frmSurname = "";
            } else if (strlen($frmSurname) > 50) {
                $frmErrors["surname2"] = "S'ha superat la mida, màxim 50 caràcters.";
                $frmSurname = "";
            }

            if (strlen($frmEmail) == 0) {
                $frmErrors["email1"] = "Has d'introduir un email.";
                $frmEmail = "";
            } else if (strlen($frmSurname) > 50) {
                $frmErrors["email2"] = "S'ha superat la mida, màxim 50 caràcters.";
                $frmSurname = "";
            } else if (!filter_var($frmEmail, FILTER_VALIDATE_EMAIL)) {
                $frmErrors["email3"] = "Format de l'email invàlid.";
                $frmEmail = "";
            }

            if (strlen($frmPassword) == 0) {
                $frmErrors["password1"] = "Has d'introduir una contrasenya.";
                $frmPassword = "";
            } else if (strlen($frmSurname) > 50) {
                $frmErrors["password2"] = "S'ha superat la mida, màxim 50 caràcters.";
                $frmSurname = "";
            } else if (strlen($frmPassword) < 8) {
                $frmErrors["password3"] = "La contrasenya ha de tenir 8 caràcters com a mínim.";
                $frmPassword = "";
            }

            if (strlen($frmPassword2) == 0) {
                $frmErrors["password21"] = "Has de confirmar la contrasenya.";
                $frmPassword2 = "";
            } else if ($frmPassword != $frmPassword2) {
                $frmErrors["password22"] = "Les contrasenyes no coincideixen.";
                $frmPassword2 = "";
            }

            if (!preg_match("/^[0-9]{9}$/", $frmPhone)) {
                $frmErrors["phone1"] = "Format de número de telèfon invàlid.";
                $frmPhone = "";
            }

            if (!$this->verifyData($frmDateOfBirth, "/", 0)) {
                $frmErrors["dateOfBirth1"] = "Format de data de naixement invàlid.";
                $frmDateOfBirth = "";
            }
            
            $this->user = new User(null, $frmName, $frmSurname, $frmEmail, $frmPassword, $frmPhone, $frmDateOfBirth);
            
            if (empty($frmErrors)) {
                $result = $this->userModel->create($this->user);
                if ($result) {
                    $this->user = new User("", "", "", "", "", "", "");
                    $ok = "L'usuari s'ha registrat correctament.";
                    UserView::login($this->user, $ok, "");
                    $created = true;
                } else {
                    $error = "Hi ha hagut un error en el registre de l'usuari.";
                }
            }
        }
        
        if (!$created) {
            UserView::signup($this->user, $frmPassword2, $error, $frmErrors);
        }
    }
    
    public function modify() {
        $modified = false;
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmName = $this->sanitize($_POST["name"]);
            $frmSurname = $this->sanitize($_POST["surname"]);
            $frmEmail = $this->sanitize($_POST["email"]);
            $frmPassword = $this->sanitize($_POST["password"]);
            $frmPhone = $this->sanitize($_POST["phone"]);
            $frmDateOfBirth = $this->sanitize($_POST["dateOfBirth"]);

            if (strlen($frmName) == 0) {
                $frmErrors["name1"] = "Has d'introduir un nom.";
                $frmName = "";
            } else if (strlen($frmName) > 50) {
                $frmErrors["name2"] = "S'ha superat la mida, màxim 50 caràcters.";
                $frmName = "";
            }
            
            if (strlen($frmSurname) == 0) {
                $frmErrors["surname1"] = "Has d'introduir un cognom.";
                $frmSurname = "";
            } else if (strlen($frmSurname) > 50) {
                $frmErrors["surname2"] = "S'ha superat la mida, màxim 50 caràcters.";
                $frmSurname = "";
            }
            
            if (strlen($frmEmail) == 0) {
                $frmErrors["email1"] = "Has d'introduir un email.";
                $frmEmail = "";
            } else if (strlen($frmSurname) > 50) {
                $frmErrors["email2"] = "S'ha superat la mida, màxim 50 caràcters.";
                $frmSurname = "";
            } else if (!filter_var($frmEmail, FILTER_VALIDATE_EMAIL)) {
                $frmErrors["email3"] = "Format de l'email invàlid.";
                $frmEmail = "";
            }
            
            if (strlen($frmPassword) == 0) {
                $frmErrors["password1"] = "Has d'introduir una contrasenya.";
                $frmPassword = "";
            } else if (strlen($frmSurname) > 50) {
                $frmErrors["password2"] = "S'ha superat la mida, màxim 50 caràcters.";
                $frmSurname = "";
            } else if (strlen($frmPassword) < 8) {
                $frmErrors["password3"] = "La contrasenya ha de tenir 8 caràcters com a mínim.";
                $frmPassword = "";
            }
            
            if (!preg_match("/^[0-9]{9}$/", $frmPhone)) {
                $frmErrors["phone1"] = "Format de número de telèfon invàlid.";
                $frmPhone = "";
            }
            
            if (!$this->verifyData($frmDateOfBirth, "/", 0)) {
                $frmErrors["dateOfBirth1"] = "Format de data de naixement invàlid.";
                $frmDateOfBirth = "";
            }
            
            $this->user = new User($_SESSION["user_id"], $frmName, $frmSurname, $frmEmail, $frmPassword, $frmPhone, $frmDateOfBirth);
            
            if (empty($frmErrors)) {
                $result = $this->userModel->update($this->user);
                if ($result) {
                    $this->user = $this->userModel->getById($this->user->getId());
                    $ok = "L'usuari s'ha modificat correctament.";
                    UserView::modify($this->user, $ok, "");
                    $modified = true;
                } else {
                    $error = "Hi ha hagut un error en la modificació de l'usuari.";
                }
            }
        }
        
        if (isset($_SESSION["login"]) && $_SESSION["login"] === true && isset($_SESSION["user_id"]) && !$modified) {
            $this->user = $this->userModel->getById($_SESSION["user_id"]);
            UserView::modify($this->user, "", $error, $frmErrors);
        }
    }
}
