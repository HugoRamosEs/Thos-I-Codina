<?php
    //error_reporting(E_ALL);
    //ini_set("display_errors", 1);
    include_once "common/language.php";
    include_once "common/funcions.php";
    
    $ok = "";
    if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
        $frmNom = sanitize($_POST["nom"]);
        $frmMail = sanitize($_POST["email"]);
        $frmMsg = sanitize($_POST["missatge"]);
    
        if (strlen($frmNom) == 0) {
            $errors["nom"] = "Nom no vàlid.";
        }
        if (! filter_var($frmMail, FILTER_VALIDATE_EMAIL)) {
            $errors["mail"] = "Email no vàlid.";
        }
        if (strlen($frmMsg) == 0) {
            $errors["missatge"] = "Has d'escriure un missatge.";
        }
    
        if (empty($errors)) {
            $llibre = "";
            if (! file_exists("docs/contacte.xml")) {
                $llibre .= "<REGISTRES>";
            }
            $data = getdate();
            $hora = date("H:i:s");
            $llibre .= substr(file_get_contents("docs/contacte.xml"), 0, - 13);
            $llibre .= "\n    <REGISTRE>\n        <NOM>$frmNom</NOM>\n        <MAIL>$frmMail</MAIL>\n";
            $llibre .= "        <COMENTARI>$frmMsg</COMENTARI>\n";
            $llibre .= "        <HORA>$hora</HORA>\n";
            $llibre .= "        <DATA>" . $data['mday'] . "/" . $data['mon'] . "/" . $data['year'] . "</DATA>\n    </REGISTRE> \n";
            $llibre .= "</REGISTRES>";
            if ($file = fopen("docs/contacte.xml", "w")) {
                if (! fputs($file, $llibre)) {
                    die("El fitxer no deixa escriure.");
                }
                fclose($file);
            } else {
                die("No s'ha pogut obrir el fitxer per emmagatzemar informació.");
            }
            unset($frmNom);
            unset($frmMail);
            unset($frmMsg);
            $ok = "El comentari s'ha enviat correctament.";
        }
    }
?>

<?php
    include "templates/head.tpl.php";
    include "templates/header.tpl.php";
    include "templates/main-contacte.tpl.php";
    include "templates/footer.tpl.php";
?>

