<?php
$errorTitle = "títol de l'error que s'ha produït";
$detail = "S'hauria de donar informació detallada de l'error.... s'hauria d'explicar tant com es pugui la causa que ha generat l'error, i què ha de fer l'usuari per procedir a solventar-ho si és problema seu.";

$firstLetterDetail = $detail[0];
$detail = substr($detail, 1);

include "templates/common/html_head.php";
include "templates/common/header.php";
include "templates/common/navbar.php";
echo "</section></div>";
include "templates/body/error.php";
include "templates/common/footer.php";
include "templates/common/html_end.php";
?>