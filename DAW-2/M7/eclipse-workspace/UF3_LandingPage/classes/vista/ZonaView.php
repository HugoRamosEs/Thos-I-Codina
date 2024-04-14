<?php

class ZonaView extends View {
    public function __construct() {
        parent::__construct();
    }

    public function show($lang, $langTraduccions, $zones, $frmErrors, $zona = null) {
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $navIdiomes = $this->mostrarMenuIdiomes($lang, $langTraduccions);

        $formE = '<form id="form-entrada" action="" method="post">
                    <h2>Zona</h2>
                    <div class="fe-inputs">
                        <label for="descripcio">Descripció</label>
                        <input type="text" id="descripcio" name="descripcio" placeholder="Escriu una descripció..." value="' . ($zona ? $zona->descripcio : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["descripcio1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["descripcio2"] . '</span></div>
                        <div class="fe-sInputs">
                            <input type="submit" id="cancelar" name="cancelar" value="Cancelar">
                            <input type="submit" id="enviar" name="enviar" value="Enviar">
                        </div>
                    </div>
                </form>';

        $thead = '<table id="tEntrada"><thead><tr>';
        $th = array(
            "ID",
            "Descripció",
            ""
        );
        foreach ($th as $titol) {
            $thead .= "<th> $titol </th>";
        }
        $thead .= "</tr></thead>";

        $tbody = "<tbody>";
        foreach ($zones as $z) {
            $tbody .= '<tr>
                        <td>' . $z->id . '</td>
                        <td>' . $z->descripcio . '</td>
                        <td class="mInputs">
                            <a href="?Zona/show/'.$z->id.'"><img src="img/editar.png" alt="editar.img"/></a>
                            <a href="?Zona/delete/'.$z->id.'"><img src="img/eliminar.png" alt="eliminar.img"/></a>
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

