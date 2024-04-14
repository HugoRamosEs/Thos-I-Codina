<?php
class User {
    private $_id;
    private $_email;
    private $_password;
    private $_tipusIdent;
    private $_numeroIdent;
    private $_nom;
    private $_cognoms;
    private $_sexe;
    private $_datanaixement;
    private $_adreca;
    private $_codiPostal;
    private $_poblacio;
    private $_provincia;
    private $_telefon;
    private $_imatge;
    private $_status;
    private $_navegador;
    private $_plataforma;
    private $_dataCreacio;
    private $_dataDarrerAcces;
    
     
    public function __construct() {
    }
    
    /**
     * @return mixed
     */
    public function getId()    {
        return $this->_id;
    }

    /**
     * @return mixed
     */
    public function getEmail()   {
        return $this->_email;
    }

    /**
     * @return mixed
     */
    public function getPassword()    {
        return $this->_password;
    }

    /**
     * @return mixed
     */
    public function getTipusIdent()    {
        return $this->_tipusIdent;
    }

    /**
     * @return mixed
     */
    public function getNumeroIdent()    {
        return $this->_numeroIdent;
    }

    /**
     * @return mixed
     */
    public function getNom()    {
        return $this->_nom;
    }

    /**
     * @return mixed
     */
    public function getCognoms()    {
        return $this->_cognoms;
    }

    /**
     * @return mixed
     */
    public function getSexe()    {
        return $this->_sexe;
    }

    /**
     * @return mixed
     */
    public function getDatanaixement()    {
        return $this->_datanaixement;
    }

    /**
     * @return mixed
     */
    public function getAdreca()   {
        return $this->_adreca;
    }

    /**
     * @return mixed
     */
    public function getCodiPostal()    {
        return $this->_codiPostal;
    }

    /**
     * @return mixed
     */
    public function getPoblacio()    {
        return $this->_poblacio;
    }

    /**
     * @return mixed
     */
    public function getProvincia()    {
        return $this->_provincia;
    }

    /**
     * @return mixed
     */
    public function getTelefon()    {
        return $this->_telefon;
    }

    /**
     * @return mixed
     */
    public function getImatge()    {
        return $this->_imatge;
    }

    /**
     * @return mixed
     */
    public function getStatus()    {
        return $this->_status;
    }

    /**
     * @return mixed
     */
    public function getNavegador() {
        return $this->_navegador;
    }

    /**
     * @return mixed
     */
    public function getPlataforma() {
        return $this->_plataforma;
    }

    /**
     * @return mixed
     */
    public function getDataCreacio() {
        return $this->_dataCreacio;
    }

    /**
     * @return mixed
     */
    public function getDataDarrerAcces() {
        return $this->_dataDarrerAcces;
    }

    /**
     * @param mixed $_id
     */
    public function setId($id) {
        $this->_id = $id;
    }

    /**
     * @param mixed $_email
     */
    public function setEmail($email) {
        $this->_email = $email;
    }

    /**
     * @param mixed $_password
     */
    public function setPassword($password) {
        $this->_password = $password;
    }

    /**
     * @param mixed $_tipusIdent
     */
    public function setTipusIdent($tipusIdent) {
        $this->_tipusIdent = $tipusIdent;
    }

    /**
     * @param mixed $_numeroIdent
     */
    public function setNumeroIdent($numeroIdent) {
        $this->_numeroIdent = $numeroIdent;
    }

    /**
     * @param mixed $_nom
     */
    public function setNom($nom) {
        $this->_nom = $nom;
    }

    /**
     * @param mixed $_cognoms
     */
    public function setCognoms($cognoms) {
        $this->_cognoms = $cognoms;
    }

    /**
     * @param mixed $_sexe
     */
    public function setSexe($sexe) {
        $this->_sexe = $sexe;
    }

    /**
     * @param mixed $_datanaixement
     */
    public function setDatanaixement($datanaixement) {
        $this->_datanaixement = $datanaixement;
    }

    /**
     * @param mixed $_adreca
     */
    public function setAdreca($adreca) {
        $this->_adreca = $adreca;
    }

    /**
     * @param mixed $_codiPostal
     */
    public function setCodiPostal($codiPostal) {
        $this->_codiPostal = $codiPostal;
    }

    /**
     * @param mixed $_poblacio
     */
    public function setPoblacio($poblacio) {
        $this->_poblacio = $poblacio;
    }

    /**
     * @param mixed $_provincia
     */
    public function setProvincia($provincia) {
        $this->_provincia = $provincia;
    }

    /**
     * @param mixed $_telefon
     */
    public function setTelefon($telefon) {
        $this->_telefon = $telefon;
    }

    /**
     * @param mixed $_imatge
     */
    public function setImatge($imatge) {
        $this->_imatge = $imatge;
    }

    /**
     * @param mixed $_status
     */
    public function setStatus($status) {
        $this->_status = $status;
    }

    /**
     * @param mixed $_navegador
     */
    public function setNavegador($navegador) {
        $this->_navegador = $navegador;
    }

    /**
     * @param mixed $_plataforma
     */
    public function setPlataforma($plataforma) {
        $this->_plataforma = $plataforma;
    }

    /**
     * @param mixed $_dataCreacio
     */
    public function setDataCreacio($dataCreacio) {
        $this->_dataCreacio = $dataCreacio;
    }

    /**
     * @param mixed $_dataDarrerAcces
     */
    public function setDataDarrerAcces($dataDarrerAcces) {
        $this->_dataDarrerAcces = $dataDarrerAcces;
    }

    
    
}