<?php

class PagamentView extends View {
    public function __construct() {
        parent::__construct();
    }

    public function show($idioma, $pagaments, $frmErrors, $pagament = null) {
        $fitxer = "languages/{$idioma}_traduccions.php";
        require_once $fitxer;

        $formE = '<form id="form-entrada" action="" method="post">
                    <h2>Pagament</h2>
                    <div class="fe-inputs">
                        <label for="banc">Banc</label>
                        <input type="text" id="banc" name="banc" placeholder="Escriu un banc..." value="' . ($pagament ? $pagament->banc : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["banc1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["banc2"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["banc3"] . '</span></div>
                        <label for="ref_externa">Pagament</label>
                        <input type="text" id="ref_externa" name="ref_externa" placeholder="Escriu una referència externa..." value="' . ($pagament ? $pagament->ref_externa : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["ref_externa1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["ref_externa2"] . '</span></div>
                        <label for="pData">Data</label>
                        <input type="text" id="pData" name="pData" placeholder="Escriu una data..." value="' . ($pagament ? $pagament->data : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["data1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["data2"] . '</span></div>
                        <label for="estat">Estat</label>
                        <input type="text" id="estat" name="estat" placeholder="Escriu un estat..." value="' . ($pagament ? $pagament->estat : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["estat1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["estat2"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["estat3"] . '</span></div>
                        <div class="fe-sInputs">
                            <input type="submit" id="cancelar" name="cancelar" value="Cancelar">
                            <input type="submit" id="enviar" name="enviar" value="Enviar">
                        </div>
                    </div>
                </form>';

        $thead = '<table id="tEntrada"><thead><tr>';
        $th = array(
            "ID",
            "Banc",
            "Ref_Externa",
            "Data",
            "Estat",
            ""
        );
        foreach ($th as $titol) {
            $thead .= "<th> $titol </th>";
        }
        $thead .= "</tr></thead>";

        $tbody = "<tbody>";
        foreach ($pagaments as $p) {
            $tbody .= '<tr>
                        <td>' . $p->id . '</td>
                        <td>' . $p->banc . '</td>
                        <td>' . $p->ref_externa . '</td>
                        <td>' . $p->data . '</td>
                        <td>' . $p->estat . '</td>
                        <td class="mInputs">
                            <a href="?Pagament/show/'.$p->id.'"><img src="img/editar.png" alt="editar.img"/></a>
                            <a href="?Pagament/delete/'.$p->id.'"><img src="img/eliminar.png" alt="eliminar.img"/></a>
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

