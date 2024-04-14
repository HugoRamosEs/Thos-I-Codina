<?php

class LocalitzacioView extends View {
    public function __construct() {
        parent::__construct();
    }

    public function show($lang, $langTraduccions, $localitzacions, $frmErrors, $localitzacio = null) {
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $navIdiomes = $this->mostrarMenuIdiomes($lang, $langTraduccions);

        $formE = '<form id="form-entrada" action="" method="post">
                    <h2>Localització</h2>
                    <div class="fe-inputs">
                        <label for="lloc">Lloc</label>
                        <input type="text" id="lloc" name="lloc" placeholder="Escriu un lloc..." value="' . ($localitzacio ? $localitzacio->lloc : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["lloc1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["lloc2"] . '</span></div>
                        <label for="adreca">Adreça</label>
                        <input type="text" id="adreca" name="adreca" placeholder="Escriu una adreça..." value="' . ($localitzacio ? $localitzacio->adreca : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["adreca1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["adreca2"] . '</span></div>
                        <label for="localitat">Localitat</label>
                        <input type="text" id="localitat" name="localitat" placeholder="Escriu una localitat..." value="' . ($localitzacio ? $localitzacio->localitat : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["localitat1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["localitat2"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["localitat3"] . '</span></div>
                        <div class="fe-sInputs">
                            <input type="submit" id="cancelar" name="cancelar" value="Cancelar">
                            <input type="submit" id="enviar" name="enviar" value="Enviar">
                        </div>
                    </div>
                </form>';

        $thead = '<table id="tEntrada"><thead><tr>';
        $th = array(
            "ID",
            "Lloc",
            "Adreca",
            "Localitat",
            ""
        );
        foreach ($th as $titol) {
            $thead .= "<th> $titol </th>";
        }
        $thead .= "</tr></thead>";

        $tbody = "<tbody>";
        foreach ($localitzacions as $l) {
            $tbody .= '<tr>
                        <td>' . $l->id . '</td>
                        <td>' . $l->lloc . '</td>
                        <td>' . $l->adreca . '</td>
                        <td>' . $l->localitat . '</td>
                        <td class="mInputs">
                            <a href="?Localitzacio/show/'.$l->id.'"><img src="img/editar.png" alt="editar.img"/></a>
                            <a href="?Localitzacio/delete/'.$l->id.'"><img src="img/eliminar.png" alt="eliminar.img"/></a>
                        </td>
                       </tr>';
        }
        $tbody .= "<tbody></table>";
        $taulaE = $thead . $tbody;

        include "templates/head.tpl.php";
        include "templates/header-entrada.tpl.php";
        include "templates/main-entrada.tpl.php";
        include "templates/footer.tpl.php";
    }
}

