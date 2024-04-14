<?php

class Configuracio {
    private $paises;
    private $experiencies;
    private $idiomesDelFormulari;
    
    private $pagina;
    public const IDIOMA_PER_DEFECTE = "ca";
    
    private $directoriDePujades;
    private $formatsImatgesPermesos;
    private $mimesImatgesPermesos;

    private $sgbd;
    private $dbServidor;
    private $dbUsernamePerConsultes;
    private $dbUsernamePerAccions;
    private $dbPassword;
    private $dbBaseDeDades;
    
    private $rutaDelGuestBook;

    public function __construct() {
        require("php/variablesDeconfiguracio.php");
        
        $this->paises               = $paises;
        $this->experiencies         = $experiencies;
        $this->idiomesDelFormulari  = $idiomesDelFormulari;
        
        $this->pagina               = $pagina;
        
        $this->directoriDePujades   = $directoriDePujades;
        $this->formatsImatgesPermesos = $formatsImatgesPermesos;
        $this->mimesImatgesPermesos = $mimesImatgesPermesos;
        
        $this->sgbd = $sgbd;
        $this->dbServidor           = $dbServidor;
        $this->dbUsernamePerConsultes = $dbUsernamePerConsultes;
        $this->dbUsernamePerAccions = $dbUsernamePerAccions;
        $this->dbPassword           = $dbPassword;
        $this->dbBaseDeDades        = $dbBaseDeDades;
        
        $this->rutaDelGuestBook     = $rutaDelGuestBook;        
    }
    /**
     * @return mixed
     */
    public function getPaises()
    {
        return $this->paises;
    }

    /**
     * @return mixed
     */
    public function getExperiencies()
    {
        return $this->experiencies;
    }

    /**
     * @return mixed
     */
    public function getIdiomesDelFormulari()
    {
        return $this->idiomesDelFormulari;
    }

    /**
     * @return mixed
     */
    public function getPagina()
    {
        return $this->pagina;
    }

    /**
     * @return mixed
     */
    public function getDirectoriDePujades()
    {
        return $this->directoriDePujades;
    }

    /**
     * @return mixed
     */
    public function getFormatsImatgesPermesos()
    {
        return $this->formatsImatgesPermesos;
    }

    /**
     * @return mixed
     */
    public function getMimesImatgesPermesos()
    {
        return $this->mimesImatgesPermesos;
    }

    /**
     * @return mixed
     */
    public function getSgbd()
    {
        return $this->sgbd;
    }

    /**
     * @return mixed
     */
    public function getDbServidor()
    {
        return $this->dbServidor;
    }

    /**
     * @return mixed
     */
    public function getDbUsernamePerConsultes()
    {
        return $this->dbUsernamePerConsultes;
    }

    /**
     * @return mixed
     */
    public function getDbUsernamePerAccions()
    {
        return $this->dbUsernamePerAccions;
    }

    /**
     * @return mixed
     */
    public function getDbPassword()
    {
        return $this->dbPassword;
    }

    /**
     * @return mixed
     */
    public function getDbBaseDeDades()
    {
        return $this->dbBaseDeDades;
    }

    /**
     * @return mixed
     */
    public function getRutaDelGuestBook()
    {
        return $this->rutaDelGuestBook;
    }

    /**
     * @param mixed $paises
     */
    public function setPaises($paises)
    {
        $this->paises = $paises;
    }

    /**
     * @param mixed $experiencies
     */
    public function setExperiencies($experiencies)
    {
        $this->experiencies = $experiencies;
    }

    /**
     * @param mixed $idiomesDelFormulari
     */
    public function setIdiomesDelFormulari($idiomesDelFormulari)
    {
        $this->idiomesDelFormulari = $idiomesDelFormulari;
    }

    /**
     * @param mixed $pagina
     */
    public function setPagina($pagina)
    {
        $this->pagina = $pagina;
    }

    /**
     * @param mixed $directoriDePujades
     */
    public function setDirectoriDePujades($directoriDePujades)
    {
        $this->directoriDePujades = $directoriDePujades;
    }

    /**
     * @param mixed $formatsImatgesPermesos
     */
    public function setFormatsImatgesPermesos($formatsImatgesPermesos)
    {
        $this->formatsImatgesPermesos = $formatsImatgesPermesos;
    }

    /**
     * @param mixed $mimesImatgesPermesos
     */
    public function setMimesImatgesPermesos($mimesImatgesPermesos)
    {
        $this->mimesImatgesPermesos = $mimesImatgesPermesos;
    }

    /**
     * @param mixed $SGBD
     */
    public function setSgbd($sgbd)
    {
        $this->sgbd = $sgbd;
    }

    /**
     * @param mixed $dbServidor
     */
    public function setDbServidor($dbServidor)
    {
        $this->dbServidor = $dbServidor;
    }

    /**
     * @param mixed $dbUsernamePerConsultes
     */
    public function setDbUsernamePerConsultes($dbUsernamePerConsultes)
    {
        $this->dbUsernamePerConsultes = $dbUsernamePerConsultes;
    }

    /**
     * @param mixed $dbUsernamePerAccions
     */
    public function setDbUsernamePerAccions($dbUsernamePerAccions)
    {
        $this->dbUsernamePerAccions = $dbUsernamePerAccions;
    }

    /**
     * @param mixed $dbPassword
     */
    public function setDbPassword($dbPassword)
    {
        $this->dbPassword = $dbPassword;
    }

    /**
     * @param mixed $dbBaseDeDades
     */
    public function setDbBaseDeDades($dbBaseDeDades)
    {
        $this->dbBaseDeDades = $dbBaseDeDades;
    }

    /**
     * @param mixed $rutaDelGuestBook
     */
    public function setRutaDelGuestBook($rutaDelGuestBook)
    {
        $this->rutaDelGuestBook = $rutaDelGuestBook;
    }

    
}

