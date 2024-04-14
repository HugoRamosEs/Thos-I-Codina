<?php

class GuestBookController extends Controller {
    private $_comentari; 
    
    public function __construct() {
        parent::__construct();
        $this->_comentari = new Comentari();
    }
    
    public function getLlibre() {
        $mGuestBook = new GuestBookModel();
        $cLlibre = $mGuestBook->getLlibre();
        
        $elementNumero = 1;
        foreach ($cLlibre as $oComentari) {
            $aLlibre[$elementNumero]["qui"] = "El ".$oComentari->getData().", en ". $oComentari->getNom() ." (" . $oComentari->getPais() . ") va tenir una ". $oComentari->getExperiencia() . " experiència i va escriure:\n";
            $aLlibre[$elementNumero++]["que"] = $oComentari->getComentari() ;
            
        }

        return $aLlibre;
    }
    
    public function nouComentari() {
        $sEmail = $this->sanitize($_POST["email"],1);
        $sNom =  $this->sanitize($_POST["nom"],1);
        $sPais = $this->sanitize($_POST["pais"],0);
        $sExperiencia = $this->sanitize($_POST["experiencia"],2);
        $sComentari = $this->sanitize($_POST["comentari"],0);
        
        if ($sEmail == "") {
            $errorsDetectats["email"] = "l'email és una dada obligatòria, si us plau indica-la.";
        } else {
            if (!$this->esEmail($sEmail)) {
                $errorsDetectats["email"] = "l'email no té un format adient.";
                unset($sEmail);
            }
        }
        
        if ($sNom == "") {
            $errorsDetectats["nom"] = "El nom és una dada obligatòria, si us plau indica-la.";
        } else {
            if (!$this->esNom($sNom)) {
                $errorsDetectats["nom"] = "El nom no té un format correcte.";
                unset($sNom);
            }
        }
        
        if ($sPais == "") {
            $errorsDetectats["pais"] = "El pais és una dada obligatòria, si us plau indica-la.";
        } else {
            if (!$this->esPais($sPais)) {
                $errorsDetectats["pais"] = "El pais no té un format correcte.";
                unset($sPais);
            }
        }
        
        if ($sExperiencia == "") {
            $errorsDetectats["experiencia"] = "L'experieèncias és una dada obligatòria, si us plau indica-la.";
        } else {
            if (!$this->esExperiencia($sExperiencia)) {
                $errorsDetectats["experiencia"] = "L'Experienència no té un format correcte.";
                unset($sNom);
            }
        }
        
        if ($sComentari == "") {
            $errorsDetectats["comentari"] = "Hauries de deixar un comentari.";
        } else {
            if (!$this->esComentari($sComentari)) {
                $errorsDetectats["comentari"] = "Hi ha hagut algun problema amb el contingut del comentari.";
                unset($sComentari);
            }
        }
        
        $comentari = new Comentari();
        $comentari->setComentari($sComentari);
        $comentari->setData(getdate());
        $comentari->setExperiencia($sExperiencia);
        $comentari->setNom($sNom);
        $comentari->setPais($sPais);
        $comentari->setEmail($sEmail);
        
        if (isset($errorsDetectats)) {
            $errorsDetectats["error"] = "S'ha detectat algun tipus d'error. Revisa les dades introduides.";
            $this->_comentari = $comentari;
            return $errorsDetectats;
        } else {
            $moGB = new GuestBookModel();
            $moGB->setComentari($comentari);
            header('Location: ?pg=4');
            exit();
        }
    }
    
    
    
    public function esEmail($emailAVerificar) {
        if (filter_var($emailAVerificar,FILTER_VALIDATE_EMAIL)) {
            $esEmail = true;
        } else {
            $esEmail = false;
        }
        return $esEmail;
    }
    
    public function esNom($nomAValidar) {
        if (preg_match("/^[a-z ']*$/",$nomAValidar)) {
            $esNom = true;
        } else {
            $esNom = false;
        }
        return $esNom;
    }
    
    public function esExperiencia($experienciaAVerificar) {
        $experiencies = array('D', 'R','B','MB');
        if (in_array($experienciaAVerificar, $experiencies)) {
            $esUnaExperiencia = true;
        } else {
            $esUnaExperiencia = false;
        }
        return $esUnaExperiencia;
    }
    
    public function esPais($paisAVerificar) {
        $paises=array("Afganistán", "Akrotiri", "Albania", "Alemania", "Andorra", "Angola", "Anguila", "Antártida", "Antigua y Barbuda", "Antillas Neerlandesas", "Arabia Saudí", "Arctic Ocean", "Argelia", "Argentina", "Armenia", "Aruba", "Ashmore andCartier Islands", "Atlantic Ocean", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bahráin", "Bangladesh", "Barbados", "Bélgica", "Belice", "Benín", "Bermudas", "Bielorrusia", "Birmania Myanmar", "Bolivia", "Bosnia y Hercegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Chad", "Chile", "China", "Chipre", "Clipperton Island", "Colombia", "Comoras", "Congo", "Coral Sea Islands", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dhekelia", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "El Vaticano", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Gaza Strip", "Georgia", "Ghana", "Gibraltar", "Granada", "Grecia", "Groenlandia", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea Ecuatorial", "Guinea-Bissau", "Guyana", "Haití", "Honduras", "Hong Kong", "Hungría", "India", "Indian Ocean", "Indonesia", "Irán", "Iraq", "Irlanda", "Isla Bouvet", "Isla Christmas", "Isla Norfolk", "Islandia", "Islas Caimán", "Islas Cocos", "Islas Cook", "Islas Feroe", "Islas Georgia del Sur y Sandwich del Sur", "Islas Heard y McDonald", "Islas Malvinas", "Islas Marianas del Norte", "IslasMarshall", "Islas Pitcairn", "Islas Salomón", "Islas Turcas y Caicos", "Islas Vírgenes Americanas", "Islas Vírgenes Británicas", "Israel", "Italia", "Jamaica", "Jan Mayen", "Japón", "Jersey", "Jordania", "Kazajistán", "Kenia", "Kirguizistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macao", "Macedonia", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Man, Isle of", "Marruecos", "Mauricio", "Mauritania", "Mayotte", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montserrat", "Mozambique", "Namibia", "Nauru", "Navassa Island", "Nepal", "Nicaragua", "Níger", "Nigeria", "Niue", "Noruega", "Nueva Caledonia", "Nueva Zelanda", "Omán", "Pacific Ocean", "Países Bajos", "Pakistán", "Palaos", "Panamá", "Papúa-Nueva Guinea", "Paracel Islands", "Paraguay", "Perú", "Polinesia Francesa", "Polonia", "Portugal", "Puerto Rico", "Qatar", "Reino Unido", "República Centroafricana", "República Checa", "República Democrática del Congo", "República Dominicana", "Ruanda", "Rumania", "Rusia", "Sáhara Occidental", "Samoa", "Samoa Americana", "San Cristóbal y Nieves", "San Marino", "San Pedro y Miquelón", "San Vicente y las Granadinas", "Santa Helena", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Southern Ocean", "Spratly Islands", "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán", "Suecia", "Suiza", "Surinam", "Svalbard y Jan Mayen", "Tailandia", "Taiwán", "Tanzania", "Tayikistán", "TerritorioBritánicodel Océano Indico", "Territorios Australes Franceses", "Timor Oriental", "Togo", "Tokelau", "Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Unión Europea", "Uruguay", "Uzbekistán", "Vanuatu", "Venezuela", "Vietnam", "Wake Island", "Wallis y Futuna", "West Bank", "World", "Yemen", "Yibuti", "Zambia", "Zimbabue");
        if (in_array($paisAVerificar,$paises)) {
            $esUnPais = true;
        } else {
            $esUnPais = false;
        }
        return $esUnPais;
    }
    
    public function esComentari($comentariAVerificar) {
        $esUnComentari = true;
        
        return $esUnComentari;
    }
    public function getComentari()
    {
        return $this->_comentari;
    }

    public function setComentari($_comentari)
    {
        $this->_comentari = $_comentari;
    }

    
    
    
}