<?php
class UserController extends Controller {
    private $user;   
    
    public function __construct() {
        parent::__construct();
    }
    
    public function logIn() {
        $vista = new UserView();
        $vista->setBody("plantilles/login.php");
        
       
        $this->user = new User();
        $this->user->setEmail($sUsuari);
        $this->user->setPassword($sContrasenya);
        
        if ($sEmail == "") {
            $errorsDetectats["email"] = "l'email és una dada obligatòria, si us plau indica-la.";
        } else {
            if (!$this->esEmail($sEmail)) {
                $errorsDetectats["email"] = "l'email no té un format adient.";
                unset($sEmail);
            }
        }
        
        if (($sPassword == "") || ($cPassword == "")) {
            $errorsDetectats["pass"] = "El password és una dada obligatòria, si us plau indica-la.";
        } else {
            if ($sPassword != $cPassword) {
                $errorsDetectats["cpass"] = "La repetició del password no correspon amb el password entrat.";
            }
        }
        
        if (!isset($errorsDetectats)) {
            $mUsuari = new UserModel();
            if (!is_null($oUsuari = $mUsuari->getUser($sUsuari, $sContrasenya))) {
                $this->activaUsuari($oUsuari);
                return;
            } else {
                $errorsDetectats = $mUsuari->getErrors();
                $vista->setErrorsDetectats($errorsDetectats);
                $vista->setUser($this->user);
            }
        } else {
            $vista->setErrorsDetectats($errorsDetectats);
            $vista->setUser($this->user);
        }
        $vista->show();
        exit;
        
        
    }
    
    public function activaUsuari($usuari) {           
        $_SESSION['usuari'] = $usuari->getNom();
        $_SESSION['img'] = $usuari->getImatge();
    }
    
    public function registre() {
        $vista = new UserView();
        $vista->setBody("plantilles/register.php");
        
        $this->user = new User();
        $sNavegador = substr($_SERVER["HTTP_USER_AGENT"], 0, strpos($_SERVER["HTTP_USER_AGENT"], "("));
        $iniciCadena = strpos($_SERVER["HTTP_USER_AGENT"], "(") + 1;
        $finalCadena = strpos($_SERVER["HTTP_USER_AGENT"], ")") - 1;
        $sPlataforma = substr($_SERVER["HTTP_USER_AGENT"], $iniciCadena, $finalCadena - $iniciCadena);
        $this->user->setNavegador($sNavegador);
        $this->user->setPlataforma($sPlataforma);
        $this->user->setStatus(0);
        
        $sEmail = $this->sanitize($_POST["email"],1);
        $sPassword = $this->sanitize($_POST["pass"],0);
        $cPassword = $this->sanitize($_POST["cpass"],0);
        
        $sTipus = $this->sanitize($_POST["tipus"],2);
        $sDni = $this->sanitize($_POST["dni"],2);
        $sNom =  $this->sanitize($_POST["nom"],1);
        $sCognoms = $this->sanitize($_POST["cognoms"],1);
        $sSexe = $this->sanitize($_POST["sexe"],2);
        $dNaixement = $this->sanitize($_POST["naixement"],0);
        
        $sAdreca = $this->sanitize($_POST["adreca"],1);
        $sCP = $this->sanitize($_POST["cp"],0);
        $sPoblacio= $this->sanitize($_POST["poblacio"],1);
        $sProvincia = $this->sanitize($_POST["provincia"],1);
        $sTelefon = $this->sanitize($_POST["telefon"],0);
        
        if ($sEmail == "") {
            $errorsDetectats["email"] = "l'email és una dada obligatòria, si us plau indica-la.";
        } else {
            if (!$this->esEmail($sEmail)) {
                $errorsDetectats["email"] = "l'email no té un format adient.";
                unset($sEmail);
            }
        }
        
        if (($sPassword == "") || ($cPassword == "")) {
            $errorsDetectats["pass"] = "El password és una dada obligatòria, si us plau indica-la.";
        } else {
            if ($sPassword != $cPassword) {
                $errorsDetectats["cpass"] = "La repetició del password no correspon amb el password entrat.";
            }
        }
        
        if (!$this->esTipus($sTipus)) {
            $errorsDetectats["tipus"] = "Hi ha algun error amb el tipus";
            unset($sTipus);
        }
        
        if ($sDni == "") {
            $errorsDetectats["dni"] = "El dni és una dada obligatòria, si us plau indica-la.";
        } else {
            if (($sTipus!="pas") && (!$this->validarNif($sDni))) {
                $errorsDetectats["dni"] = "El dni no té un format correcte.";
                unset($sDni);
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
        
        if ($sCognoms == "") {
            $errorsDetectats["cognoms"] = "El nom és una dada obligatòria, si us plau indica-la.";
        } else {
            if (!$this->esNom($sCognoms)) {
                $errorsDetectats["cognoms"] = "Els cognoms no tenen un format correcte.";
                unset($sCognoms);
            }
        }
        
        if (!$this->esSexe($sSexe)) {
            $errorsDetectats["sexe"] = "Hi ha hagut algun problema amb la seleccio de sexe.";
            unset($sSexe);
        }
        
        if (($sCP != "") && (!$this->esCodiPostal($sCP))) {
            $errorsDetectats["cp"] = "Els codi postal no correspon a cap població.";
            unset($esCodiPostal);
        }
        
        if (($sProvincia != "") && (!$this->esProvincia($sProvincia))) {
            $errorsDetectats["provincia"] = "La provincia no és una de les espanyoles.";
            unset($sProvincia);
        }
        
        if (($sTelefon != "") && (!$this->esTelefon($sTelefon))) {
            $errorsDetectats["telefon"] = "El format del telèfon no és correcte.";
            unset($sTelefon);
        }
        
        $this->user->setEmail($sEmail);
        $this->user->setPassword($sPassword);
        $this->user->setTipusIdent($sTipus);
        $this->user->setNumeroIdent($sDni);
        $this->user->setNom($sNom);
        $this->user->setCognoms($sCognoms);
        $this->user->setSexe($sSexe);
        $this->user->setDatanaixement($dNaixement);
        $this->user->setAdreca($sAdreca);
        $this->user->setCodiPostal($sCP);
        $this->user->setPoblacio($sPoblacio);
        $this->user->setProvincia($sProvincia);
        $this->user->setTelefon($sTelefon);
        
        //Hi ha algun tipus d'error en el formulari d'entrada de dades.
        //No segueixo fetificant.
        if (!isset($errorsDetectats)) {
            //No hi ha errors de formulari.....
            //Verifico la pujada de la foto.
            
            if ($_FILES['imatge']['error'] == 0) {                              //Si hi ha foto ....
                $imatge = 		$_FILES['imatge']['tmp_name'];				  	//carreguem el nom temporal del fitxer
                $nomOriginal = 	$_FILES['imatge']['name'];						//carreguem el nom original
                $sImatge = $nomOriginal;
                $tamany= 		$_FILES['imatge']['size']; 						//carreguem el tamany del fitxer en bytes
                $error= 		$_FILES['imatge']['error']; 					//carreguem el tamany del fitxer en bytes
                $tipus= 		$_FILES['imatge']['type']; 						//carreguem el tipus mime del fitxer en bytes
                
                if ($error ===0) {
                    $aNom = explode('.',$nomOriginal);								// Busquem l'extensió del fitxer
                    $aNomLong = count($aNom);										// ens diu quants elements té l'array
                    $sExtensio = strtolower($aNom[--$aNomLong]);
                    
                    // Verifiquem si hi ha errors en la pujada del fitxer:
                    if( in_array($sExtensio, $this->getConfiguracio()->getFormatsImatgesPermesos()) ){							// format incorrecte per extensió
                        if ( in_array ($tipus, $this->getConfiguracio()->getMimesImatgesPermesos()) ) {	                			// format incorrecte per mime
                            if ($tamany > 2097152) {												// tamany massa gran
                                $errorsDetectats["imatge"] = "Error2013 - Tamany excessiu del fitxer";
                            } else {
                                $nomNou = microtime(true).'_'.$nomOriginal;				// Afegim l'hora per fer un fitxer únic
                                $rutaNova = $this->getConfiguracio()->getDirectoriDePujades().$nomNou;				// Afegim el path al nom del fitxer
                                $result = move_uploaded_file($imatge , $rutaNova);		// Movem el fitxer a la carpeta
                                
                                if (!$result){
                                    $errorsDetectats["imatge"] = "Error2014 - Problemes al moure el fitxer definitiu";
                                }
                            }
                        } else {
                            $errorsDetectats["imatege"] = "Error2012 - El format intern del fitxer no està permés";
                        }
                    } else {
                        $errorsDetectats["imatge"] = "Error2011 - Tipus de fitxer amb extensió no permesa";
                    }
                } else {
                    // Si s'ha intentat pujar un fitxer però ha donat error.
                    // Si no s'ha pujat.... tot ok
                    if ($_FILES['imatge']['error'] != 4) {
                        $errorsDetectats["imatge"] = "Error2010 - Mo ha pujat el fitxer. Error: " . $error;
                    }
                }
            }
            
            $this->user->setImatge($rutaNova);
            
            if (!isset($errorsDetectats)) { 
                // No hi han errors, puc grabar les dades a la BBDD
                $mUsuari = new UserModel();
                if ($mUsuari->esEmailUnic($sEmail)) {
                    if (!is_null($idDelRegistreInsertat=$mUsuari->saveUser($this->user))) {
                        $this->enviaMail($sEmail, $sNom, $idDelRegistreInsertat);
                        header("Location: index.php?pg=100&reg=$idDelRegistreInsertat");
                        exit;
                    } else {
                        $errorsDetectats = $mUsuari->getErrors();
                    }
                } else {
                    $errorsDetectats['email'] = "Ja existeix el mai a la nastra Base de Dades";
                }
            }
        }
        if (isset($errorsDetectats)) {
            $errorsDetectats["error"] = "S'ha detectat algun tipus d'error. Revisa les dades introduides.";
            $this->errorsDetectats = $errorsDetectats;
            $vista->setErrorsDetectats($errorsDetectats);
            $vista->setUser($this->user);
            $vista->show();
            exit;
        }        
    }
    
    public function confirmaUsuari($codi) {
        $usModel = new UserModel();
        $usModel->activa($this->sanitize($codi, 0));
        $_SESSION['paginaActual'] = 1;
    }
    
    public function crearContrasenya() {
        define("LONG", 12);
        
        $validos = "abcdefghijklmnopqrstuvwxyz0123456789-_#$%&@";
        $totalValidos = strlen($validos)-1;
        
        $strPassword = "";
        for ($i=0; $i < LONG ; $i++) {
            $valorAleatorio = rand(0,$totalValidos);
            $strPassword .= $validos[$valorAleatorio];
        }
        return $strPassword;
    }
    
    public function generarPassword($nivellDeSeguretat) {
        $passwordGenerat = "";
        $caractersValidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXYZ0123456789-_#$%&@";
        $caractersExpecials = array("-","_","#","$","%","&","@");
        $passwordCompleixRestriccions = false;
        $conteMajuscules = false;
        $conteMinuscules = false;
        $conteNumeros = false;
        $conteCaractesEspecials = false;
        
        
        //Calculem la longitut del password segons les estriccions imposades.
        switch ($nivellDeSeguretat) {
            case 0:
                $longitutDelPassword = mt_rand(4,10);
                break;
            case 1:
            case 2:
                $longitutDelPassword = mt_rand(8,20);
                break;
        }
        
        while ((!$passwordCompleixRestriccions)) {
            //Escullo una letra aleatroriament
            $lletraEscollidaAleatoriament = $caractersValidos[mt_rand(0,strlen($caractersValidos)-1)];
            
            $passwordGenerat .= $lletraEscollidaAleatoriament;
            
            if (preg_match("/[A-Z]/", $lletraEscollidaAleatoriament) === 1) {
                $conteMajuscules = true;
            } elseif (preg_match("/[a-z]/", $lletraEscollidaAleatoriament) === 1) {
                $conteMinuscules = true;
            } elseif (preg_match("/[0-9]/", $lletraEscollidaAleatoriament) === 1) {
                $conteNumeros = true;
            } elseif (in_array($lletraEscollidaAleatoriament, $caractersExpecials)) {
                $conteCaractesEspecials = true;
            }
            
            if (strlen($passwordGenerat) >= $longitutDelPassword) {
                // Ja hem generat el password de la longitut que volimem.
                // Verifiquem les seves característiques
                switch ($nivellDeSeguretat) {
                    case 0:
                        // tindrà la longitut dessitjada, per tant ja puc acabar
                        $passwordCompleixRestriccions = true;
                        break;
                    case 1:
                        // Si te majúscula, minúscula i número, ja puc acabar. En cas contrari torno a començar.
                        if ($conteMajuscules && $conteMinuscules && $conteNumeros) {
                            $passwordCompleixRestriccions = true;
                        } else {
                            $passwordGenerat = "";
                        }
                        break;
                    case 2:
                        // Si te majúscula, minúscula, número i caràcter escecial, ja puc acabar. En cas contrari torno a començar.
                        if ($conteMajuscules && $conteMinuscules && $conteNumeros && $conteCaractesEspecials) {
                            $passwordCompleixRestriccions = true;
                        } else {
                            $passwordGenerat = "";
                        }
                        break;
                }
                
            }
            
        }
        
        return $passwordGenerat;
    }
    
    public function esTipus($dadaAVerificar) {
        $tipusValids = array ("NIF", "NIE", "PAS");
        if (in_array($dadaAVerificar, $tipusValids) ) {
            $esCorrecte = true;
        } else {
            $esCorrecte = false;
        }
        return $esCorrecte;
    }
    public function esSexe($dadaAVerificar) {
        $tipusValids = array ("H", "D");
        if (in_array($dadaAVerificar, $tipusValids) ) {
            $esCorrecte = true;
        } else {
            $esCorrecte = false;
        }
        return $esCorrecte;
    }
    
    public function validarNif ($nif) {
        $nif = strtoupper($nif);
        $lletresValides = "TRWAGMYFPDXBNJZSQVHLCKE";
        $nifCorrecte = FALSE;
        
        if ((strlen($nif)== 9) && (strpos("XYZ0123456789",$nif[0])!==false)) {
            $numero = substr($nif, 0, 8);
            $numero = str_replace(array('X', 'Y', 'Z'), array(0, 1, 2), $numero);
            
            if(substr($nif, -1, 1) == substr($lletresValides, $numero % 23, 1)) {
                $nifCorrecte = TRUE;
            }
        }
        return $nifCorrecte;
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
    
    public function esCodiPostal($codiPostalAVerificar) {
        if ((strlen($codiPostalAVerificar) == 5) && (is_numeric($codiPostalAVerificar))) {
            $esCP = true;
        } else {
            $esCP = false;
        }
        return $esCP;
    }
    
    public function esProvincia($provinciaAVerificar) {
        $provincias = array('alava', 'arava','albacete','alacant','alicante','almería','asturias','avila','badajoz','barcelona','burgos','cáceres',
            'cádiz','cantabria','castelló','castellón','ciudad real','córdoba','la coruña','cuenca','girona','gerona','granada','guadalajara',
            'guipuzkoa','guipúzcoa','huelva','huesca','illes balears','islas baleares','jaén','león','lleida','lérida','lugo','madrid','málaga','murcia','navarra',
            'orense','palencia','las palmas','pontevedra','la rioja','salamanca','segovia','sevilla','soria','tarragona',
            'santa cruz de tenerife','teruel','toledo','valència','valencia','valladolid','bizkaia','vizcaya','zamora','zaragoza');
        if (in_array($provinciaAVerificar,$provincias)) {
            $esUnProvincia = true;
        } else {
            $esUnProvincia = false;
        }
        return $esUnProvincia;
    }
    
    public function esTelefon($telefonAVerificar) {
        if ((strlen($telefonAVerificar)== 9) && (is_numeric($telefonAVerificar)) ) {
            $esTelefon = true;
        } else {
            $esTelefon = false;
        }
        return $esTelefon;
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
    
    public function enviaMail($frm_nom, $frm_email, $cod) {
        // procés 'enviament del e-meil de confirmació.
        $hdr="MIME-Version: 1.0\n";
        $hdr.="Content-type: text/html; charset=iso-8859-1\n";
        $hdr.="Content-Transfer-Encoding: 8bit\n";
        $hdr.="X-Priority: 1\n";
        $hdr.="X-MSMail-Priority: High\n";
        $hdr.="From: \"My Web\" <theverybest@myweb.cat>\n";
        
        $bod.="<body style='margin:0px;'>\n<center>\n<table cellpadding='0' cellspacing='0' width='1024'>\n<tr>\n<td>\n<table cellpadding='0' cellspacing='0' width='685' height='144'>\n<tr>\n<td width='685' background='http://localhost/img/tituloemail.jpg'>\n</td>\n\n\n</tr>\n</table>\n</td>\n</tr>\n<tr>\n<td bgcolor='#FFFFFF' width='1024'>\n";
        
        $bod.="<table cellpadding='10' cellspacing='0'><tr><td><font size='3'>Bienvingut/da ".$frm_nom.",\n<p>\nEt donem la benvinguda de nou i volem agrair-te la confiança que has dipositat en nosaltres.\n<p>\nA continuaci&#243; pulsa aquest enllaç per poder completar el teu registre i activar el teu compte:\n<p>\n<a href='http://localhost/php/confirmacio.php?tipo=conf&cod=".$cod."'>http://localhost/confirmacio/index.php?tipo=conf&cod=".$cod."</a>\n<p>\n";
        
        $bod.="Gracies per tot i per qualsevol dubte et pots dirigir a info@myweb.cat\n<p>\n<p>\nAtentament,\n<p>\nEquip de MyWeb\n";
        $bod.="</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n</center>\n";
        $bod.="</body>\n</html>\n";
        
        // @mail($frm_email,"Alta en MyWeb",$bod,$hdr);
    }
    
    public function getUser() {
        return $this->user;
    }

    public function setUser($user) {
        $this->user = $user;
    }

    
    
    
    
}