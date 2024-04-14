<?php
class VError extends View {

    public function __construct() {
        parent::__construct();
    }
    
    /**
     * Mostra els detall dels error produits.
     * @param String $errorTitle títol de l'error que s'ha produït
     * @param String $detail S'hauria de donar informació detallada de l'error.... s'hauria d'explicar tant com es pugui la causa que ha generat l'error, i què ha de fer l'usuari per procedir a solventar-ho si és problema seu.
     */
    public function show(String $errorTitle, String $detail) {
        $active["main"]=true;
         
        $firstLetterDetail = $detail[0];
        $detail = substr($detail, 1);
        
        include "templates/common/html_head.php";
        include "templates/common/header.php";
        include "templates/common/navbar.php";
        include "templates/common/title.php";
        echo "</section></div>";
        include "templates/body/error.php";
        include "templates/common/footer.php";
        include "templates/common/html_end.php";        
    }
}

